package org.gthhcore.loaders.recipe.mod.gregtech;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static org.gthhcore.api.recipes.GTHHRecipeMaps.*;
import static org.gthhcore.api.unification.ore.GTHHOrePrefix.*;
import static org.gthhcore.api.util.GTHHValues.*;
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

        // Fuel Rod Reprocessing
        THERMAL_CENTRIFUGE_RECIPES.recipeBuilder()
                .duration(S * 60).EUt(VA[LV])
                .input(rodDepletedSingle, Thorium, 1)
                .output(dust, Steel, 2)
                .output(dust, Thorium, 4)
                .output(dust, Lutetium, 1)
                .fluidOutputs(Neon.getFluid(100))
                .buildAndRegister();

        THERMAL_CENTRIFUGE_RECIPES.recipeBuilder()
                .duration(S * 120).EUt(VA[LV])
                .input(rodDepletedDual, Thorium, 1)
                .output(dust, Steel, 4)
                .output(dust, Thorium, 8)
                .output(dust, Lutetium, 2)
                .fluidOutputs(Neon.getFluid(200))
                .buildAndRegister();

        THERMAL_CENTRIFUGE_RECIPES.recipeBuilder()
                .duration(S * 120).EUt(VA[LV])
                .input(rodDepletedQuad, Thorium, 1)
                .output(dust, Steel, 8)
                .output(dust, Thorium, 16)
                .output(dust, Lutetium, 4)
                .fluidOutputs(Neon.getFluid(400))
                .buildAndRegister();
    }

    public static void thoriumFissionRecipes() {
        // Thorium Fission
        FISSION_RECIPES.recipeBuilder()
                .duration(S * 50000).EUt((int) V[LV])
                .input(rodFuelSingle, Thorium)
                .output(rodDepletedSingle, Thorium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 50000).EUt((int) V[MV])
                .input(rodFuelDual, Thorium)
                .output(rodDepletedDual, Thorium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 50000).EUt((int) V[HV])
                .input(rodFuelQuad, Thorium)
                .output(rodDepletedQuad, Thorium)
                .buildAndRegister();
    }
}
