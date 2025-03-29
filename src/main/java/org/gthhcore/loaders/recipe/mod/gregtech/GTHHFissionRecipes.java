package org.gthhcore.loaders.recipe.mod.gregtech;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static org.gthhcore.api.recipes.GTHHRecipeMaps.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.api.unification.ore.GTHHOrePrefix.*;
import static org.gthhcore.api.util.GTHHValues.*;
import static org.gthhcore.common.items.GTHHMetaItems.*;

public class GTHHFissionRecipes {

    public static void init() {
        fuelProcessingRecipes();
        fissionRecipes();
        breederRecipes();
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

    public static void fissionRecipes() {
        // Naquadah Fission
        FISSION_RECIPES.recipeBuilder()
                .duration(S * 100000).HUt(256).isSuperHeated()
                .input(rodFuelSingle, Naquadah)
                .output(rodDepletedSingle, Naquadah)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 100000).HUt(512).isSuperHeated()
                .input(rodFuelDual, Naquadah)
                .output(rodDepletedDual, Naquadah)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 100000).HUt(1024).isSuperHeated()
                .input(rodFuelQuad, Naquadah)
                .output(rodDepletedQuad, Naquadah)
                .buildAndRegister();

        // Naquadria Fission
        FISSION_RECIPES.recipeBuilder()
                .duration(S * 100000).HUt(512).isSupercritical()
                .input(rodFuelSingle, Naquadria)
                .output(rodDepletedSingle, Naquadria)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 100000).HUt(1024).isSupercritical()
                .input(rodFuelDual, Naquadria)
                .output(rodDepletedDual, Naquadria)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 100000).HUt(2048).isSupercritical()
                .input(rodFuelQuad, Naquadria)
                .output(rodDepletedQuad, Naquadria)
                .buildAndRegister();
    }

    public static void breederRecipes() {
        // Thorium Fission
        FISSION_RECIPES.recipeBuilder()
                .duration(S * 50000).HUt(32)
                .input(rodFuelSingle, Thorium)
                .output(rodDepletedSingle, Thorium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 50000).HUt(64)
                .input(rodFuelDual, Thorium)
                .output(rodDepletedDual, Thorium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 50000).HUt(128)
                .input(rodFuelQuad, Thorium)
                .output(rodDepletedQuad, Thorium)
                .buildAndRegister();

        // Protactinium Fission
        FISSION_RECIPES.recipeBuilder()
                .duration(S * 25000).HUt(40)
                .input(rodFuelSingle, EnrichedProtactinium)
                .output(rodDepletedSingle, EnrichedProtactinium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 25000).HUt(80)
                .input(rodFuelDual, EnrichedProtactinium)
                .output(rodDepletedDual, EnrichedProtactinium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 25000).HUt(160)
                .input(rodFuelQuad, EnrichedProtactinium)
                .output(rodDepletedQuad, EnrichedProtactinium)
                .buildAndRegister();

        // Uranium Fission
        FISSION_RECIPES.recipeBuilder()
                .duration(S * 20000).HUt(64)
                .input(rodFuelSingle, EnrichedUranium)
                .output(rodDepletedSingle, EnrichedUranium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 20000).HUt(128)
                .input(rodFuelDual, EnrichedUranium)
                .output(rodDepletedDual, EnrichedUranium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 20000).HUt(256)
                .input(rodFuelQuad, EnrichedUranium)
                .output(rodDepletedQuad, EnrichedUranium)
                .buildAndRegister();

        // Neptunium Fission
        FISSION_RECIPES.recipeBuilder()
                .duration(S * 22000).HUt(48)
                .input(rodFuelSingle, EnrichedNeptunium)
                .output(rodDepletedSingle, EnrichedNeptunium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 22000).HUt(96)
                .input(rodFuelDual, EnrichedNeptunium)
                .output(rodDepletedDual, EnrichedNeptunium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 22000).HUt(192)
                .input(rodFuelQuad, EnrichedNeptunium)
                .output(rodDepletedQuad, EnrichedNeptunium)
                .buildAndRegister();

        // Plutonium Fission
        FISSION_RECIPES.recipeBuilder()
                .duration(S * 18000).HUt(128)
                .input(rodFuelSingle, EnrichedPlutonium)
                .output(rodDepletedSingle, EnrichedPlutonium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 18000).HUt(256)
                .input(rodFuelDual, EnrichedPlutonium)
                .output(rodDepletedDual, EnrichedPlutonium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 18000).HUt(512)
                .input(rodFuelQuad, EnrichedPlutonium)
                .output(rodDepletedQuad, EnrichedPlutonium)
                .buildAndRegister();

        // Next 5 Groups are Superheated
        // Americium Fission
        FISSION_RECIPES.recipeBuilder()
                .duration(S * 19000).HUt(64).isSuperHeated()
                .input(rodFuelSingle, Americium)
                .output(rodDepletedSingle, Americium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 19000).HUt(128).isSuperHeated()
                .input(rodFuelDual, Americium)
                .output(rodDepletedDual, Americium)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 19000).HUt(256).isSuperHeated()
                .input(rodFuelQuad, Americium)
                .output(rodDepletedQuad, Americium)
                .buildAndRegister();
    }
}
