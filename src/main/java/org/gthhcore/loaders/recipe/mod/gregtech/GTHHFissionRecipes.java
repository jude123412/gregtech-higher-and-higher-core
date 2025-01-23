package org.gthhcore.loaders.recipe.mod.gregtech;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static org.gthhcore.api.recipes.GTHHRecipeMaps.*;
import static org.gthhcore.api.util.GTHHValues.S;
import static org.gthhcore.common.items.GTHHMetaItems.*;

public class GTHHFissionRecipes {

    public static void init() {
        fuelProcessingRecipes();
        thoriumFissionRecipes();
    }

    public static void fuelProcessingRecipes() {

        // Empty Fuel Rods
        BENDER_RECIPES.recipeBuilder()
                .duration(S * 5).EUt(VA[LV])
                .input(plateDouble, Steel, 1)
                .output(FUEL_ROD)
                .circuitMeta(12)
                .buildAndRegister();

        // Fuel Rod Filling
        CANNER_RECIPES.recipeBuilder()
                .duration(S * 4).EUt(VA[LV])
                .input(FUEL_ROD)
                .input(dust, Thorium, 8)
                .output(FUEL_ROD_SINGLE_THORIUM)
                .buildAndRegister();

        // Fuel Rod | Single | Dual | Quad
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(S * 4).EUt(VA[LV])
                .input(FUEL_ROD_SINGLE_THORIUM, 2)
                .input(stickLong, Steel, 2)
                .output(FUEL_ROD_DUAL_THORIUM)
                .circuitMeta(2)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(S * 4).EUt(VA[LV])
                .input(FUEL_ROD_SINGLE_THORIUM, 4)
                .input(stickLong, Steel, 4)
                .output(FUEL_ROD_QUAD_THORIUM)
                .circuitMeta(4)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(S * 4).EUt(VA[LV])
                .input(FUEL_ROD_DUAL_THORIUM, 2)
                .input(stickLong, Steel, 2)
                .output(FUEL_ROD_QUAD_THORIUM)
                .circuitMeta(4)
                .buildAndRegister();

        // Fuel Rod Reprocessing
        THERMAL_CENTRIFUGE_RECIPES.recipeBuilder()
                .duration(S * 60).EUt(VA[LV])
                .input(FUEL_ROD_DEPLETED_SINGLE_THORIUM, 1)
                .output(dust, Steel, 2)
                .output(dust, Thorium, 4)
                .output(dust, Lutetium, 1)
                .fluidOutputs(Neon.getFluid(100))
                .buildAndRegister();

        THERMAL_CENTRIFUGE_RECIPES.recipeBuilder()
                .duration(S * 120).EUt(VA[LV])
                .input(FUEL_ROD_DEPLETED_DUAL_THORIUM, 1)
                .output(dust, Steel, 4)
                .output(dust, Thorium, 8)
                .output(dust, Lutetium, 2)
                .fluidOutputs(Neon.getFluid(200))
                .buildAndRegister();

        THERMAL_CENTRIFUGE_RECIPES.recipeBuilder()
                .duration(S * 120).EUt(VA[LV])
                .input(FUEL_ROD_DEPLETED_QUAD_THORIUM, 1)
                .output(dust, Steel, 8)
                .output(dust, Thorium, 16)
                .output(dust, Lutetium, 4)
                .fluidOutputs(Neon.getFluid(400))
                .buildAndRegister();
    }
    public static void thoriumFissionRecipes() {

        // Thorium Fission
        FISSION_RECIPES.recipeBuilder()
                .duration(S * 50000).EUt(VA[LV])
                .input(FUEL_ROD_SINGLE_THORIUM)
                .output(FUEL_ROD_DEPLETED_SINGLE_THORIUM)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 50000).EUt(VA[MV])
                .input(FUEL_ROD_DUAL_THORIUM)
                .output(FUEL_ROD_DEPLETED_DUAL_THORIUM)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 50000).EUt(VA[HV])
                .input(FUEL_ROD_QUAD_THORIUM)
                .output(FUEL_ROD_DEPLETED_QUAD_THORIUM)
                .buildAndRegister();
    }
}
