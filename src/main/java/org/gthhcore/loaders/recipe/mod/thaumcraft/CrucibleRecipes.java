package org.gthhcore.loaders.recipe.mod.thaumcraft;

import static org.gthhcore.api.util.GTHHMods.*;
import static org.gthhcore.loaders.recipe.helper.ThaumcraftRecipeHelper.*;

import net.minecraft.item.ItemStack;

import com.cleanroommc.groovyscript.helper.ingredient.IngredientHelper;

import thaumcraft.api.items.ItemsTC;

public class CrucibleRecipes {

    public static void init() {
        // Remove Extra Cluster Recipes
        if (Thaumcraft.isModLoaded()) {
            CRUCIBLE_RECIPES.removeByOutput(IngredientHelper.toIIngredient(new ItemStack(ItemsTC.clusters, 1, 0)));
            CRUCIBLE_RECIPES.removeByOutput(IngredientHelper.toIIngredient(new ItemStack(ItemsTC.clusters, 1, 1)));
            CRUCIBLE_RECIPES.removeByOutput(IngredientHelper.toIIngredient(new ItemStack(ItemsTC.clusters, 1, 2)));
            CRUCIBLE_RECIPES.removeByOutput(IngredientHelper.toIIngredient(new ItemStack(ItemsTC.clusters, 1, 3)));
            CRUCIBLE_RECIPES.removeByOutput(IngredientHelper.toIIngredient(new ItemStack(ItemsTC.clusters, 1, 4)));
            CRUCIBLE_RECIPES.removeByOutput(IngredientHelper.toIIngredient(new ItemStack(ItemsTC.clusters, 1, 5)));
            CRUCIBLE_RECIPES.removeByOutput(IngredientHelper.toIIngredient(new ItemStack(ItemsTC.clusters, 1, 6)));
        }
    }
}
