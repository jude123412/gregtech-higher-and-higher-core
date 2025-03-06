package org.gthhcore.api.capability.impl;

import net.minecraft.util.Tuple;

import org.jetbrains.annotations.NotNull;

import gregtech.api.capability.impl.MultiblockRecipeLogic;
import gregtech.api.metatileentity.multiblock.ParallelLogicType;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;

public class MultiblockFissionRecipeLogic extends MultiblockRecipeLogic {

    protected long totalContinuousRunningTime;

    public MultiblockFissionRecipeLogic(RecipeMapMultiblockController tileEntity) {
        super(tileEntity);
    }

    @Override
    protected void modifyOverclockPre(@NotNull int[] values, @NotNull IRecipePropertyStorage storage) {
        // apply maintenance bonuses
        Tuple<Integer, Double> maintenanceValues = getMaintenanceValues();

        // duration bonus
        if (maintenanceValues.getSecond() != 1.0) {
            values[1] = (int) Math.round(values[1] / maintenanceValues.getSecond());
        }
    }

    @Override
    protected void modifyOverclockPost(int[] overclockResults, @NotNull IRecipePropertyStorage storage) {
        // apply maintenance penalties
        Tuple<Integer, Double> maintenanceValues = getMaintenanceValues();

        // duration penalty
        if (maintenanceValues.getFirst() > 0) {
            overclockResults[1] = (int) (overclockResults[1] * (1 - 0.1 * maintenanceValues.getFirst()));
        }

        // make EUt negative so it is consumed
        overclockResults[0] = -overclockResults[0];
    }

    @NotNull
    @Override
    public ParallelLogicType getParallelLogicType() {
        return ParallelLogicType.MULTIPLY; // TODO APPEND_FLUIDS
    }

    @Override
    protected boolean hasEnoughPower(@NotNull int[] resultOverclock) {
        // generators always have enough power to run recipes
        return true;
    }

    @Override
    public void update() {
        super.update();
        if (workingEnabled && isActive && progressTime > 0) {
            totalContinuousRunningTime++;
        } else {
            totalContinuousRunningTime = 0;
        }
    }

    @Override
    public int getParallelLimit() {
        return 4;
    }

    @Override
    protected long getMaxParallelVoltage() {
        return getMaxVoltage();
    }

    @Override
    public boolean consumesEnergy() {
        // This generator doesn't need energy to run
        return false;
    }

    @Override
    public void invalidate() {
        super.invalidate();
        totalContinuousRunningTime = 0;
    }

    @Override
    public boolean isAllowOverclocking() {
        return false;
    }

    protected long boostProduction(long production) {
        return production;
    }

    @Override
    protected boolean drawEnergy(int recipeEUt, boolean simulate) {
        long euToDraw = boostProduction(recipeEUt);
        long resultEnergy = getEnergyStored() - euToDraw;
        if (resultEnergy >= 0L && resultEnergy <= getEnergyCapacity()) {
            if (!simulate) getEnergyContainer().changeEnergy(-euToDraw);
            return true;
        } else return false;
    }
}
