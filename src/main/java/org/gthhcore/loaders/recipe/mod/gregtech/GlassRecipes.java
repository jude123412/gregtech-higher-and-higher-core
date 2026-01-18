package org.gthhcore.loaders.recipe.mod.gregtech;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static org.gthhcore.api.util.GTHHValues.second;
import static org.gthhcore.common.blocks.GTHHMetaBlocks.*;
import static org.gthhcore.common.blocks.transparent.GlassCasing0.CasingType.*;

public class GlassRecipes {

    public static void init() {
        registerGlassTierRecipes();
    }

    private static void registerGlassTierRecipes() {
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(second(10)).EUt(VA[ULV])
                .input(frameGt, Bronze)
                .input(dust, Glass)
                .outputs(TRANSPARENT_CASING_0.getItemVariant(BRONZE_GLASS))
                .buildAndRegister();
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(second(10)).EUt(VA[ULV])
                .input(frameGt, WroughtIron)
                .input("blockGlassST")
                .outputs(TRANSPARENT_CASING_0.getItemVariant(WROUGHT_IRON_GLASS))
                .buildAndRegister();
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(second(10)).EUt(VA[LV])
                .input(frameGt, Steel)
                .input("blockGlassULV")
                .outputs(TRANSPARENT_CASING_0.getItemVariant(STEEL_GLASS))
                .buildAndRegister();
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(second(10)).EUt(VA[MV])
                .input(frameGt, Aluminium)
                .input("blockGlassLV")
                .outputs(TRANSPARENT_CASING_0.getItemVariant(ALUMINIUM_GLASS))
                .buildAndRegister();
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(second(10)).EUt(VA[HV])
                .input(frameGt, StainlessSteel)
                .input("blockGlassMV")
                .outputs(TRANSPARENT_CASING_0.getItemVariant(STAINLESS_STEEL_GLASS))
                .buildAndRegister();
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(second(10)).EUt(VA[EV])
                .input(frameGt, Titanium)
                .input("blockGlassHV")
                .outputs(TRANSPARENT_CASING_0.getItemVariant(TITANIUM_GLASS))
                .buildAndRegister();
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(second(10)).EUt(VA[IV])
                .input(frameGt, TungstenSteel)
                .input("blockGlassEV")
                .outputs(TRANSPARENT_CASING_0.getItemVariant(TUNGSTENSTEEL_GLASS))
                .buildAndRegister();
        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(second(10)).EUt(VA[LuV])
                .input(frameGt, RhodiumPlatedPalladium)
                .input("blockGlassIV")
                .outputs(TRANSPARENT_CASING_0.getItemVariant(RHODIUM_PLATED_PALLADIUM_GLASS))
                .buildAndRegister();
    }
}
