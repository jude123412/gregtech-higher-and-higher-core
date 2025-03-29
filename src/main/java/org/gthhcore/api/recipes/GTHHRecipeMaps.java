package org.gthhcore.api.recipes;

import org.gthhcore.api.recipes.builder.FissionRecipeBuilder;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;

public class GTHHRecipeMaps {

    public static final RecipeMap<FissionRecipeBuilder> FISSION_RECIPES = new RecipeMap<>(
            "fission_reactor", 1, 1, 0, 0, new FissionRecipeBuilder(), false)
                    .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                    .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                    .setSound(GTSoundEvents.COOLING)
                    .allowEmptyOutput();

    public static final RecipeMap<SimpleRecipeBuilder> BREEDER_RECIPES = new RecipeMap<>(
            "breeder_reactor", 1, 1, 0, 0, new SimpleRecipeBuilder(), false)
                    .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                    .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                    .setSound(GTSoundEvents.COOLING)
                    .allowEmptyOutput();
}
