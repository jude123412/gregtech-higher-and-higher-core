package org.gthhcore.loaders.recipe.mod.gregtech;

import org.gthhcore.loaders.recipe.mod.gregtech.chains.*;
import org.gthhcore.loaders.recipe.mod.gregtech.material.ModIntegrationRecipes;

public class GTHHMachineRecipeLoader {

    private GTHHMachineRecipeLoader() {}

    public static void registerLate() {
        registerChains();
        registerRecipes();
        registerMaterialRecipes();
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
        GlassRecipes.init();
        GTHHFissionRecipes.init();
        GTHHFusionRecipes.init();
        GTHHHeatingCoilRecipes.init();
    }

    public static void registerMaterialRecipes() {
         ModIntegrationRecipes.init();
    }
}
