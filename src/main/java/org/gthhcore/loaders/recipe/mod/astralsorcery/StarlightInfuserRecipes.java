package org.gthhcore.loaders.recipe.mod.astralsorcery;

import static org.gthhcore.api.util.GTHHMods.*;
import static org.gthhcore.loaders.recipe.helper.AstralSorceryRecipeHelper.*;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class StarlightInfuserRecipes {

    public static void init() {
        if (AstralSorcery.isModLoaded()) {
            INFUSION_ALTER_RECIPES.removeByInput(new ItemStack(Blocks.IRON_ORE));
            INFUSION_ALTER_RECIPES.removeByInput(new ItemStack(Blocks.GOLD_ORE));
            INFUSION_ALTER_RECIPES.removeByInput(new ItemStack(Blocks.LAPIS_ORE));
            INFUSION_ALTER_RECIPES.removeByInput(new ItemStack(Blocks.REDSTONE_ORE));
            INFUSION_ALTER_RECIPES.removeByInput(new ItemStack(Blocks.DIAMOND_ORE));
            INFUSION_ALTER_RECIPES.removeByInput(new ItemStack(Blocks.EMERALD_ORE));
        }
    }
}
