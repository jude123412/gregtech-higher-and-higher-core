package org.gthhcore.loaders.recipe.mod.gregtech;

import org.gthhcore.loaders.recipe.mod.advancedrocketry.GTHHPlanetaryStoneRecipes;

public class GTHHMachineRecipeLoader {
    private GTHHMachineRecipeLoader() {}
    public static void register() {
        GTHHCircuitRecipes.init();
        GTHHSlimeMediumRecipes.init();
        GTHHFusionRecipes.init();
        GTHHMicaRecipes.init();
        GTHHHeatingCoilRecipes.init();
        GTHHPlanetaryStoneRecipes.init();
    }
}
