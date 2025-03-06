package org.gthhcore.loaders.recipe.mod.gregtech.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;

public class GTHHSolarGradeSiliconRecipes {

    public static void init() {
        registerRecipes();
    }

    public static void registerRecipes() {
        ARC_FURNACE_RECIPES.recipeBuilder()
                .duration(100).EUt(VA[LV])
                .input(dust, Silicon, 1)
                .output(dust, SiliconDioxide, 3)
                .fluidInputs(Oxygen.getFluid(2000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(200).EUt(VA[LV])
                .input(dust, CertusQuartz, 3)
                .input(dust, Magnesium, 2)
                .output(dust, SolarGradeSilicon, 1)
                .output(dust, Magnesia, 4)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(200).EUt(VA[LV])
                .input(dust, NetherQuartz, 3)
                .input(dust, Magnesium, 2)
                .output(dust, SolarGradeSilicon, 1)
                .output(dust, Magnesia, 4)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(200).EUt(VA[LV])
                .input(dust, Quartzite, 3)
                .input(dust, Magnesium, 2)
                .output(dust, SolarGradeSilicon, 1)
                .output(dust, Magnesia, 4)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(200).EUt(VA[LV])
                .input(dust, SiliconDioxide, 3)
                .input(dust, Magnesium, 2)
                .output(dust, SolarGradeSilicon, 1)
                .output(dust, Magnesia, 4)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(200).EUt(VA[LV])
                .input(dust, Glass, 3)
                .input(dust, Magnesium, 2)
                .output(dust, SolarGradeSilicon, 1)
                .output(dust, Magnesia, 4)
                .buildAndRegister();
    }
}
