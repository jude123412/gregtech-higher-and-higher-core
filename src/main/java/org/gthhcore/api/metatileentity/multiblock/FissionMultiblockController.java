package org.gthhcore.api.metatileentity.multiblock;

import gregtech.api.GTValues;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.EnergyContainerList;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.MultiblockDisplayText;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.recipes.RecipeMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.gthhcore.api.capability.impl.MultiblockFissionRecipeLogic;

import java.util.List;

public abstract class FissionMultiblockController extends RecipeMapMultiblockController {

    public FissionMultiblockController(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap) {
        super(metaTileEntityId, recipeMap);
        this.recipeMapWorkable = new MultiblockFissionRecipeLogic(this);
    }
    @Override
    protected void initializeAbilities() {
        super.initializeAbilities();
        this.energyContainer = new EnergyContainerList(getAbilities(MultiblockAbility.OUTPUT_ENERGY));
    }

    @Override
    protected void addDisplayText(List<ITextComponent> textList) {
        MultiblockFissionRecipeLogic recipeLogic = (MultiblockFissionRecipeLogic) recipeMapWorkable;
        MultiblockDisplayText.builder(textList, isStructureFormed())
                .setWorkingStatus(recipeLogic.isWorkingEnabled(), recipeLogic.isActive())
                .addEnergyProductionLine(getMaxVoltage(), recipeLogic.getRecipeEUt())
                .addWorkingStatusLine();
    }

    protected long getMaxVoltage() {
        IEnergyContainer energyContainer = recipeMapWorkable.getEnergyContainer();
        if (energyContainer != null && energyContainer.getEnergyCapacity() > 0) {
            return Math.max(energyContainer.getInputVoltage(), energyContainer.getOutputVoltage());
        } else {
            return 0L;
        }
    }

}
