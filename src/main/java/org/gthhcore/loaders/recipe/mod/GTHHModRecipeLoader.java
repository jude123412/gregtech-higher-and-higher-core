package org.gthhcore.loaders.recipe.mod;

import org.gthhcore.loaders.recipe.mod.astralsorcery.StarlightInfuserRecipes;
import org.gthhcore.loaders.recipe.mod.thaumcraft.CrucibleRecipes;

public class GTHHModRecipeLoader {

    public static void registerLate() {
        // Thaumcraft Recipes
        CrucibleRecipes.init();

        // Astral Sorcery Recipes
        StarlightInfuserRecipes.init();
    }

    public static void register() {}
}
