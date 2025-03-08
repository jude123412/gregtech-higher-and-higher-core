package org.gthhcore.api.capability.impl;

import static gregtech.api.capability.GregtechDataCodes.BOILER_HEAT;
import static gregtech.api.capability.GregtechDataCodes.BOILER_LAST_TICK_STEAM;

import java.util.Collections;
import java.util.List;

import gregtech.api.util.GTTransferUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

import org.gthhcore.api.recipes.GTHHRecipeMaps;
import org.gthhcore.api.util.GTHHLog;
import org.gthhcore.common.metatileentities.multi.nuclear.MetaTileEntityFissionReactor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.capability.IMultiblockController;
import gregtech.api.capability.impl.AbstractRecipeLogic;
import gregtech.api.recipes.Recipe;
import gregtech.api.unification.material.Materials;
import gregtech.common.ConfigHolder;

public class FissionReactorRecipeLogic extends AbstractRecipeLogic {

    private static final long STEAM_PER_WATER = 160;

    private int currentHeat;
    private int lastTickSteamOutput;
    private int excessWater, excessFuel, excessProjectedEU;

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
            setLastTickSteam(0);
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

        int recipeEUt = 0;

        if (!didStartRecipe) {
            IItemHandlerModifiable importItems = reactor.getImportItems();
            for (int i = 0; i < importItems.getSlots(); i++) {
                ItemStack stack = importItems.getStackInSlot(i);
                Recipe fissionRecipe = GTHHRecipeMaps.FISSION_RECIPES.findRecipe(GTValues.V[GTValues.MAX], Collections.singletonList(stack), dummyList);
                if (fissionRecipe != null && stack.getCount() > 0) {
                    recipeEUt = fissionRecipe.getEUt() * 4;
                    itemOutputs = fissionRecipe.getOutputs();
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
            this.recipeEUt = recipeEUt;
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
            int generatedSteam = this.recipeEUt * getMaximumHeatFromMaintenance() / getMaximumHeat();
            if (generatedSteam > 0) {
                long amount = (generatedSteam + STEAM_PER_WATER) / STEAM_PER_WATER;
                excessWater += (int) (amount * STEAM_PER_WATER - generatedSteam);
                amount -= excessWater / STEAM_PER_WATER;
                excessWater %= (int) STEAM_PER_WATER;

                FluidStack drainedWater = getBoilerFluidFromContainer(getInputTank(), (int) amount);
                if (amount != 0 && (drainedWater == null || drainedWater.amount < amount)) {
                    getMetaTileEntity().explodeMultiblock((1.0f * currentHeat / getMaximumHeat()) * 8.0f);
                } else {
                    setLastTickSteam(generatedSteam);
                    getOutputTank().fill(Materials.Steam.getFluid(generatedSteam), true);
                }
            }
            if (currentHeat < getMaximumHeat()) {
                if (currentHeat >= 0 && currentHeat < 1000) {
                    setHeat(currentHeat + 1);
                } else if(currentHeat >= 1000 && currentHeat < 2000) {
                    setHeat(currentHeat + 2);
                } else if (currentHeat >= 2000 && currentHeat < 3000) {
                    setHeat(currentHeat + 4);
                } else if (currentHeat >= 3000) {
                    setHeat(currentHeat + 8);
                }
            }
            if (++progressTime > maxProgressTime) {
                completeRecipe();
                GTHHLog.logger.info(itemOutputs.toString());
            }
        }
    }

    private int getMaximumHeatFromMaintenance() {
        if (ConfigHolder.machines.enableMaintenance) {
            return (int) Math.min(currentHeat,
                    (1 - 0.1 * getMetaTileEntity().getNumMaintenanceProblems()) * getMaximumHeat());
        } else return currentHeat;
    }

    private int getMaximumHeat() {
        return 4000;
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

    public int getLastTickSteam() {
        return lastTickSteamOutput / 2;
    }

    public void setLastTickSteam(int lastTickSteamOutput) {
        if (lastTickSteamOutput != this.lastTickSteamOutput && !metaTileEntity.getWorld().isRemote) {
            writeCustomData(BOILER_LAST_TICK_STEAM, b -> b.writeVarInt(lastTickSteamOutput));
        }
        this.lastTickSteamOutput = lastTickSteamOutput;
    }

    @Override
    public int getInfoProviderEUt() {
        return this.lastTickSteamOutput / 2;
    }

    @Override
    public boolean consumesEnergy() {
        return false;
    }

    public void invalidate() {
        progressTime = 0;
        maxProgressTime = 0;
        recipeEUt = 0;
        setActive(false);
        setLastTickSteam(0);
    }

    @Override
    protected void completeRecipe() {
        outputRecipeOutputs();
        this.progressTime = 0;
        this.setMaxProgress(0);
        this.recipeEUt = 0;
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
        buf.writeVarInt(lastTickSteamOutput);
    }

    @Override
    public void receiveInitialSyncData(@NotNull PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.currentHeat = buf.readVarInt();
        this.lastTickSteamOutput = buf.readVarInt();
    }

    @Override
    public void receiveCustomData(int dataId, @NotNull PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == BOILER_HEAT) {
            this.currentHeat = buf.readVarInt();
        } else if (dataId == BOILER_LAST_TICK_STEAM) {
            this.lastTickSteamOutput = buf.readVarInt();
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
    private static FluidStack getBoilerFluidFromContainer(@NotNull IFluidHandler fluidHandler, int amount) {
        if (amount == 0) return null;
        FluidStack drainedWater = fluidHandler.drain(Materials.Water.getFluid(amount), true);
        if (drainedWater == null || drainedWater.amount == 0) {
            drainedWater = fluidHandler.drain(Materials.DistilledWater.getFluid(amount), true);
        }
        if (drainedWater == null || drainedWater.amount == 0) {
            for (String fluidName : ConfigHolder.machines.boilerFluids) {
                Fluid fluid = FluidRegistry.getFluid(fluidName);
                if (fluid != null) {
                    drainedWater = fluidHandler.drain(new FluidStack(fluid, amount), true);
                    if (drainedWater != null && drainedWater.amount > 0) {
                        break;
                    }
                }
            }
        }
        return drainedWater;
    }
}
