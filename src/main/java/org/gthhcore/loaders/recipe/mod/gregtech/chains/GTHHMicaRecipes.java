package org.gthhcore.loaders.recipe.mod.gregtech.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.common.items.GTHHMetaItems.*;

public class GTHHMicaRecipes {

    public static void init() {
        MIXER_RECIPES.recipeBuilder()
                .duration(100).EUt(VA[LV])
                .input(dust, Mica, 3)
                .input(dust, Asbestos, 2)
                .input(dust, RawRubber, 3)
                .output(dust, MicaInsulator, 8)
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .duration(25).EUt(VA[LV])
                .input(dust, MicaInsulator, 1)
                .input(SHAPE_MOLD_PLATE, 1)
                .output(MICA_BASED_SHEET, 1)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(200).EUt(VA[LV])
                .input(MICA_BASED_SHEET, 1)
                .input(dust, CertusQuartz, 3)
                .output(MICA_INSULATOR_SHEET, 1)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(200).EUt(VA[LV])
                .input(MICA_BASED_SHEET, 1)
                .input(dust, NetherQuartz, 3)
                .output(MICA_INSULATOR_SHEET, 1)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(200).EUt(VA[LV])
                .input(MICA_BASED_SHEET, 1)
                .input(dust, Quartzite, 3)
                .output(MICA_INSULATOR_SHEET, 1)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(200).EUt(VA[LV])
                .input(MICA_BASED_SHEET, 1)
                .input(dust, SiliconDioxide, 3)
                .output(MICA_INSULATOR_SHEET, 1)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .duration(200).EUt(VA[LV])
                .input(MICA_BASED_SHEET, 1)
                .input(dust, Glass, 3)
                .output(MICA_INSULATOR_SHEET, 1)
                .buildAndRegister();

        BENDER_RECIPES.recipeBuilder()
                .duration(80).EUt(VA[LV])
                .input(MICA_INSULATOR_SHEET, 1)
                .output(MICA_INSULATOR_FOIL, 4)
                .circuitMeta(1)
                .buildAndRegister();
    }
}
