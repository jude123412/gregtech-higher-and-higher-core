package org.gthhcore.api.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;

public class GTHHRecipeMaps {

    public static final RecipeMap<FuelRecipeBuilder> FISSION_RECIPES = new RecipeMap<>(
            "fission_reactor", 1, 1, 0, 0, new FuelRecipeBuilder(), false)
                    .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
                    .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
                    .setSound(GTSoundEvents.COOLING)
                    .allowEmptyOutput();
}
