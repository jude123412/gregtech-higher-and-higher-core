package org.gthhcore.loaders.recipe.mod.gregtech;

import org.gthhcore.loaders.recipe.mod.gregtech.chains.*;

public class GTHHMachineRecipeLoader {

    private GTHHMachineRecipeLoader() {}

    public static void registerEarly() {
        registerChains();
        registerRecipes();
    }

    public static void registerChains() {
        GTHHCircuitRecipes.init();
        GTHHSlimeMediumRecipes.init();
        GTHHMicaRecipes.init();
        GTHHGemSlurryRecipes.init();
        GTHHSolarGradeSiliconRecipes.init();
        GTHHPreciousMetalsRecipes.init();
    }

    public static void registerRecipes() {
        GTHHFissionRecipes.init();
        GTHHFusionRecipes.init();
        GTHHHeatingCoilRecipes.init();
    }
}
