package org.gthhcore.loaders.recipe.mod.advancedrocketry;

import gregtech.api.recipes.category.RecipeCategories;
import net.minecraft.init.Blocks;
import org.gthhcore.common.blocks.GTHHMetaBlocks;
import org.gthhcore.common.blocks.GTHHPlanetaryBlocks;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;


public class GTHHPlanetaryStoneRecipes {

    public static void init() {
        surfaceSoilMaceration();
        subSurfaceSoilMaceration();
        subSurfaceRockMaceration();
    }

    public static void surfaceSoilMaceration() {
        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SURFACE_SOIL)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.MERCURY))
                .output(dust, MercuryStone)
                .chancedOutput(dust, MercuryStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SURFACE_SOIL)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.VENUS))
                .output(dust, VenusStone)
                .chancedOutput(dust, VenusStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SURFACE_SOIL)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.MOON))
                .output(dust, MoonStone)
                .chancedOutput(dust, MoonStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SURFACE_SOIL)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.MARS))
                .output(dust, MarsStone)
                .chancedOutput(dust, MarsStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SURFACE_SOIL)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.DEIMOS))
                .output(dust, DeimosStone)
                .chancedOutput(dust, DeimosStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SURFACE_SOIL)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.PHOBOS))
                .output(dust, PhobosStone)
                .chancedOutput(dust, PhobosStone, 1000, 380)
                .buildAndRegister();
    }

    public static void subSurfaceSoilMaceration() {
        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_SOIL)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.MERCURY))
                .output(dust, MercuryStone)
                .chancedOutput(dust, MercuryStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_SOIL)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.VENUS))
                .output(dust, VenusStone)
                .chancedOutput(dust, VenusStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_SOIL)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.MOON))
                .output(dust, MoonStone)
                .chancedOutput(dust, MoonStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_SOIL)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.MARS))
                .output(dust, MarsStone)
                .chancedOutput(dust, MarsStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_SOIL)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.DEIMOS))
                .output(dust, DeimosStone)
                .chancedOutput(dust, DeimosStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_SOIL)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.PHOBOS))
                .output(dust, PhobosStone)
                .chancedOutput(dust, PhobosStone, 1000, 380)
                .buildAndRegister();
    }

    public static void subSurfaceRockMaceration() {
        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_ROCK)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.MERCURY))
                .output(dust, MercuryStone)
                .chancedOutput(dust, MercuryStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_ROCK)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.VENUS))
                .output(dust, VenusStone)
                .chancedOutput(dust, VenusStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_ROCK)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.MOON))
                .output(dust, MoonStone)
                .chancedOutput(dust, MoonStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_ROCK)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.MARS))
                .output(dust, MarsStone)
                .chancedOutput(dust, MarsStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_ROCK)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.DEIMOS))
                .output(dust, DeimosStone)
                .chancedOutput(dust, DeimosStone, 1000, 380)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .duration(400).EUt(8)
                .inputs(GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_ROCK)
                        .getItemVariant(GTHHPlanetaryBlocks.GTHHPlanetaryType.PHOBOS))
                .output(dust, PhobosStone)
                .chancedOutput(dust, PhobosStone, 1000, 380)
                .buildAndRegister();
    }
}
