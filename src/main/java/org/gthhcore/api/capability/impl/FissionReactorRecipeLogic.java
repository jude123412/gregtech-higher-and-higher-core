package org.gthhcore.api.capability.impl;

import static gregtech.api.GTValues.*;
import static gregtech.api.capability.GregtechDataCodes.*;

import java.util.Collections;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

import org.gthhcore.api.recipes.GTHHRecipeMaps;
import org.gthhcore.api.recipes.properties.HeatUnitProperty;
import org.gthhcore.api.recipes.properties.SupercriticalProperty;
import org.gthhcore.api.recipes.properties.SuperheatedProperty;
import org.gthhcore.api.unification.materials.material.GTHHMaterials;
import org.gthhcore.api.util.GTHHLog;
import org.gthhcore.common.metatileentities.multi.nuclear.MetaTileEntityFissionReactor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.capability.IMultiblockController;
import gregtech.api.capability.impl.AbstractRecipeLogic;
import gregtech.api.recipes.Recipe;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTTransferUtils;
import gregtech.common.ConfigHolder;

public class FissionReactorRecipeLogic extends AbstractRecipeLogic {

    private int currentHeat;
    private int lastTickCoolantOutput;
    private int excessWater, excessFuel, excessProjectedEU;

    protected float recipeHUt = 0;
    protected boolean isSuperHeated = false, isSupercritical = false, isCoolantPresent = true;

    public FissionReactorRecipeLogic(MetaTileEntityFissionReactor tileEntity) {
        super(tileEntity, null);
        this.fluidOutputs = Collections.emptyList();
        this.itemOutputs = NonNullList.create();
    }

    @Override
    public void update() {
        if ((!isActive() || !canProgressRecipe() || !isWorkingEnabled() && currentHeat > 0)) {
            setHeat(currentHeat - 1);
            if (currentHeat <= 0) {
                setHeat(0);
            }
            setLastTickCoolant(0);
        }
        super.update();
    }

    @Override
    protected boolean canProgressRecipe() {
        return super.canProgressRecipe() && !(metaTileEntity instanceof IMultiblockController &&
                ((IMultiblockController) metaTileEntity).isStructureObstructed());
    }

    @Override
    protected void trySearchNewRecipe() {
        MetaTileEntityFissionReactor reactor = (MetaTileEntityFissionReactor) metaTileEntity;
        if (ConfigHolder.machines.enableMaintenance && reactor.hasMaintenanceMechanics() &&
                reactor.getNumMaintenanceProblems() > 5) {
            return;
        }
        List<FluidStack> dummyList = NonNullList.create();
        boolean didStartRecipe = false;

        float HUt = 0;

        if (!didStartRecipe) {
            IItemHandlerModifiable importItems = reactor.getImportItems();
            for (int i = 0; i < importItems.getSlots(); i++) {
                ItemStack stack = importItems.getStackInSlot(i);
                Recipe fissionRecipe = GTHHRecipeMaps.FISSION_RECIPES.findRecipe(V[MAX],
                        Collections.singletonList(stack), dummyList);
                if (fissionRecipe != null && stack.getCount() > 0) {
                    itemOutputs = fissionRecipe.getOutputs();
                    HUt = fissionRecipe.getProperty(HeatUnitProperty.getInstance(), 0);
                    isSuperHeated = fissionRecipe.getProperty(SuperheatedProperty.getInstance(), false);
                    isSupercritical = fissionRecipe.getProperty(SupercriticalProperty.getInstance(), false);
                    if (FluidUtil.getFluidHandler(stack) != null) continue;
                    setMaxProgress(fissionRecipe.getDuration());
                    stack.shrink(1);
                    didStartRecipe = true;
                    break;
                }
            }
        }
        if (didStartRecipe) {
            this.progressTime = 1;
            this.recipeHUt = HUt;

            if (wasActiveAndNeedsUpdate) {
                wasActiveAndNeedsUpdate = false;
            } else {
                setActive(true);
            }
        }
        metaTileEntity.getNotifiedItemInputList().clear();
        metaTileEntity.getNotifiedFluidInputList().clear();
    }

    @Override
    protected void updateRecipeProgress() {
        if (canRecipeProgress) {
            int HUt = (int) ((getMaximumMaintenanceProblems() == 0) ? this.recipeHUt : getMaximumMaintenanceProblems());

            FluidStack drainedCoolant = getCoolantInput(getInputTank(), HUt);

            // Consume Coolant and output Hot Coolant
            if (HUt > 0) {
                setLastTickCoolant(HUt);
                getCoolantInput(getInputTank(), HUt);
                getOutputTank().fill(getCoolantOutput(HUt), true);
            }

            // Begin Heating Reactor if there is no coolant present
            // Cool Reactor if coolant is present
            if (currentHeat < getMaximumHeat()) {
                if (HUt != 0 && (drainedCoolant == null || drainedCoolant.amount < HUt)) {
                    isCoolantPresent = false;
                    setHeat(currentHeat + HUt);
                } else {
                    if (currentHeat > HUt) {
                        setHeat(currentHeat - HUt);
                    } else {
                        setHeat(0);
                    }
                }
            }

            // Explode Reactor when Max Hull Heat is reached
            if (currentHeat > getMaximumHeat() - 1) {
                getMetaTileEntity().explodeMultiblock(32.0f);
            }

            if (++progressTime > maxProgressTime) {
                completeRecipe();
                GTHHLog.logger.info(itemOutputs.toString());
            }
        }
    }

    private int getMaximumMaintenanceProblems() {
        int maintenanceIssues = getMetaTileEntity().getNumMaintenanceProblems();
        if (ConfigHolder.machines.enableMaintenance && (maintenanceIssues >= 1 && maintenanceIssues <= 6)) {
            return (int) (this.recipeHUt * (1 - (maintenanceIssues * 0.1)));
        } else {
            return 0;
        }
    }

    private int getMaximumHeat() {
        return 128000;
    }

    public int getHeatScaled() {
        return (int) Math.round(currentHeat / (1.0 * getMaximumHeat()) * 100);
    }

    public void setHeat(int heat) {
        if (heat != this.currentHeat && !metaTileEntity.getWorld().isRemote) {
            writeCustomData(BOILER_HEAT, b -> b.writeVarInt(heat));
        }
        this.currentHeat = heat;
    }

    public int getLastTickCoolant() {
        return lastTickCoolantOutput;
    }

    public void setLastTickCoolant(int lastTickSteamOutput) {
        if (lastTickSteamOutput != this.lastTickCoolantOutput && !metaTileEntity.getWorld().isRemote) {
            writeCustomData(BOILER_LAST_TICK_STEAM, b -> b.writeVarInt(lastTickSteamOutput));
        }
        this.lastTickCoolantOutput = lastTickSteamOutput;
    }

    @Override
    public int getInfoProviderEUt() {
        return lastTickCoolantOutput;
    }

    @Override
    public boolean consumesEnergy() {
        return false;
    }

    public void invalidate() {
        progressTime = 0;
        maxProgressTime = 0;
        recipeHUt = 0;
        setActive(false);
        setLastTickCoolant(0);
    }

    @Override
    protected void completeRecipe() {
        outputRecipeOutputs();
        this.progressTime = 0;
        this.setMaxProgress(0);
        this.recipeHUt = 0;
        this.wasActiveAndNeedsUpdate = true;
    }

    @Override
    protected void outputRecipeOutputs() {
        GTTransferUtils.addItemsToItemHandler(getOutputInventory(), false, itemOutputs);
    }

    @NotNull
    @Override
    public MetaTileEntityFissionReactor getMetaTileEntity() {
        return (MetaTileEntityFissionReactor) super.getMetaTileEntity();
    }

    @NotNull
    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = super.serializeNBT();
        compound.setInteger("Heat", currentHeat);
        compound.setInteger("ExcessFuel", excessFuel);
        compound.setInteger("ExcessWater", excessWater);
        compound.setInteger("ExcessProjectedEU", excessProjectedEU);
        return compound;
    }

    @Override
    public void deserializeNBT(@NotNull NBTTagCompound compound) {
        super.deserializeNBT(compound);
        this.currentHeat = compound.getInteger("Heat");
        this.excessFuel = compound.getInteger("ExcessFuel");
        this.excessWater = compound.getInteger("ExcessWater");
        this.excessProjectedEU = compound.getInteger("ExcessProjectedEU");
    }

    @Override
    public void writeInitialSyncData(@NotNull PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeVarInt(currentHeat);
        buf.writeVarInt(lastTickCoolantOutput);
    }

    @Override
    public void receiveInitialSyncData(@NotNull PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.currentHeat = buf.readVarInt();
        this.lastTickCoolantOutput = buf.readVarInt();
    }

    @Override
    public void receiveCustomData(int dataId, @NotNull PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == BOILER_HEAT) {
            this.currentHeat = buf.readVarInt();
        } else if (dataId == BOILER_LAST_TICK_STEAM) {
            this.lastTickCoolantOutput = buf.readVarInt();
        }
    }

    @Override
    protected long getEnergyInputPerSecond() {
        return 0;
    }

    @Override
    protected long getEnergyStored() {
        return 0;
    }

    @Override
    protected long getEnergyCapacity() {
        return 0;
    }

    @Override
    protected boolean drawEnergy(int recipeEUt, boolean simulate) {
        return false;
    }

    @Override
    public long getMaxVoltage() {
        return 0;
    }

    @Nullable
    private FluidStack getCoolantInput(@NotNull IFluidHandler fluidHandler, int amount) {
        if (amount == 0) {
            return null;
        }
        FluidStack drainFluid = fluidHandler.drain(Materials.Water.getFluid(amount), true);

        if (!isSuperHeated && !isSupercritical) {
            drainFluid = fluidHandler.drain(GTHHMaterials.Coolant.getFluid(amount), true);
        }
        if (isSuperHeated) {
            drainFluid = fluidHandler.drain(Materials.SodiumPotassium.getFluid(amount), true);
        }
        if (isSupercritical) {
            drainFluid = fluidHandler.drain(GTHHMaterials.SpaceCoolant.getFluid(amount), true);
        }
        return drainFluid;
    }

    @Nullable
    private FluidStack getCoolantOutput(int amount) {
        if (amount == 0) {
            return null;
        }
        FluidStack fillFluid = Materials.Steam.getFluid(amount * 160);

        if (!isSuperHeated && !isSupercritical) {
            fillFluid = GTHHMaterials.HotCoolant.getFluid(amount);
        }
        if (isSuperHeated) {
            fillFluid = GTHHMaterials.HotSodiumPotassium.getFluid(amount);
        }
        if (isSupercritical) {
            fillFluid = GTHHMaterials.HotSpaceCoolant.getFluid(amount);
        }
        return fillFluid;
    }
}
