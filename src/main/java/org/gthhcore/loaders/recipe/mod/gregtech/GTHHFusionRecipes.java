package org.gthhcore.loaders.recipe.mod.gregtech;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;

public class GTHHFusionRecipes {

    public static void init() {
        FUSION_RECIPES.recipeBuilder()
                .fluidInputs(Tantalum.getFluid(125))
                .fluidInputs(Neon.getFluid(125))
                .fluidOutputs(Bismuth.getPlasma(125))
                .duration(40)
                .EUt(VA[ZPM])
                .EUToStart(300_000_000)
                .buildAndRegister();
    }
}
