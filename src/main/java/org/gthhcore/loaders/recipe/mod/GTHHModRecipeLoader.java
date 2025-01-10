package org.gthhcore.loaders.recipe.mod;

import org.gthhcore.loaders.recipe.mod.astralsorcery.StarlightInfuserRecipes;
import org.gthhcore.loaders.recipe.mod.thaumcraft.CrucibleRecipes;

public class GTHHModRecipeLoader {

    public static void register() {

        // Thaumcraft Recipes
        CrucibleRecipes.init();

        // Astral Sorcery Recipes
        StarlightInfuserRecipes.init();

    }
}
