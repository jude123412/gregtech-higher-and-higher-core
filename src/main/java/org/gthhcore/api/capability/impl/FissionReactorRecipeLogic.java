package org.gthhcore.api.capability.impl;

import static gregtech.api.GTValues.*;
import static gregtech.api.capability.GregtechDataCodes.*;

import java.util.Collections;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.*;
import net.minecraftforge.items.IItemHandlerModifiable;

import org.gthhcore.api.recipes.GTHHRecipeMaps;
import org.gthhcore.api.recipes.properties.HeatUnitProperty;
import org.gthhcore.api.recipes.properties.SupercriticalProperty;
import org.gthhcore.api.recipes.properties.SuperheatedProperty;
import org.gthhcore.api.unification.materials.material.GTHHMaterials;
import org.gthhcore.common.metatileentities.multi.nuclear.MetaTileEntityFissionReactor;
import org.jetbrains.annotations.NotNull;

import gregtech.api.capability.IMultiblockController;
import gregtech.api.capability.impl.AbstractRecipeLogic;
import gregtech.api.recipes.Recipe;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTTransferUtils;
import gregtech.common.ConfigHolder;

public class FissionReactorRecipeLogic extends AbstractRecipeLogic {

    private int currentHullHeat, excessCoolant;

    protected float recipeHUt = 0;
    protected boolean isSuperHeated = false, isSupercritical = false;

    public FissionReactorRecipeLogic(MetaTileEntityFissionReactor tileEntity) {
        super(tileEntity, null);
        this.fluidOutputs = Collections.emptyList();
        this.itemOutputs = NonNullList.create();
    }

    @Override
    public void update() {
        if ((!isActive() || !isWorkingEnabled())) {
            if (currentHullHeat > recipeHUt) {
                setHeat(currentHullHeat - 1);
            }

            if (currentHullHeat <= 0) {
                setHeat(0);
            }
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
            int coolantAmount = (int) this.recipeHUt;

            // Consume Coolant, output Hot Coolant and Heat reactor if coolant isn't present
            if (coolantAmount > 0) {
                if (currentHullHeat < getMaximumHeat()) {
                    FluidStack coolantStack;
                    FluidStack hotCoolantStack;

                    if (isSupercritical) {
                        coolantStack = getCoolantStack(GTHHMaterials.SpaceCoolant, coolantAmount);
                        hotCoolantStack = getHotCoolantStack(GTHHMaterials.HotSpaceCoolant, coolantAmount);
                    } else if (isSuperHeated) {
                        coolantStack = getCoolantStack(Materials.SodiumPotassium, coolantAmount);
                        hotCoolantStack = getHotCoolantStack(GTHHMaterials.HotSodiumPotassium, coolantAmount);
                    } else {
                        coolantStack = getCoolantStack(GTHHMaterials.Coolant, coolantAmount);
                        hotCoolantStack = getHotCoolantStack(GTHHMaterials.HotCoolant, coolantAmount);
                    }

                    if (getInputTank().drain(coolantStack, false) == null) {
                        setHeat(currentHullHeat + coolantAmount);
                    } else {
                        getInputTank().drain(coolantStack, true);
                        getOutputTank().fill(hotCoolantStack, true);
                        if (currentHullHeat > recipeHUt) {
                            setHeat((int) (currentHullHeat - recipeHUt));
                        } else {
                            setHeat(0);
                        }
                    }
                }
            }

            // Explode Reactor when Max Hull Heat is reached
            if (currentHullHeat > getMaximumHeat() - 1) {
                getMetaTileEntity().explodeMultiblock(32.0f);
            }

            if (++progressTime > maxProgressTime) {
                completeRecipe();
            }
        }
    }

    private int getMaximumMaintenanceProblems() {
        int maintenanceIssues = getMetaTileEntity().getNumMaintenanceProblems();
        if (ConfigHolder.machines.enableMaintenance && (maintenanceIssues >= 1 && maintenanceIssues <= 5)) {
            return (int) (this.recipeHUt * (1 - (maintenanceIssues * 0.1)));
        } else if (ConfigHolder.machines.enableMaintenance && maintenanceIssues > 5) {
            getMetaTileEntity().explodeMultiblock(32.0f);
            return 6;
        } else {
            return 0;
        }
    }

    private int getMaximumHeat() {
        return 128000;
    }

    public int getHeatScaled() {
        return (int) Math.round(currentHullHeat / (1.0 * getMaximumHeat()) * 100);
    }

    public void setHeat(int heat) {
        if (heat != this.currentHullHeat && !metaTileEntity.getWorld().isRemote) {
            writeCustomData(BOILER_HEAT, b -> b.writeVarInt(heat));
        }
        this.currentHullHeat = heat;
    }

    public int getRecipeHUt() {
        return (int) recipeHUt;
    }

    @Override
    public int getInfoProviderEUt() {
        return (int) recipeHUt;
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

    public FluidStack getCoolantStack(Material coolant, int amount) {
        return new FluidStack(coolant.getFluid(), amount);
    }

    public FluidStack getHotCoolantStack(Material hotCoolant, int amount) {
        return new FluidStack(hotCoolant.getFluid(), amount);
    }
}
