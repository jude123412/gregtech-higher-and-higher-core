package org.gthhcore.loaders.recipe.mod.gregtech;

import static gregtech.api.GTValues.*;
import static org.gthhcore.api.recipes.GTHHRecipeMaps.FISSION_RECIPES;
import static org.gthhcore.api.util.GTHHValues.S;
import static org.gthhcore.common.items.GTHHMetaItems.*;

public class GTHHFissionRecipes {

    public static void init() {
        thoriumFissionRecipes();
    }

    public static void thoriumFissionRecipes() {
        FISSION_RECIPES.recipeBuilder()
                .duration(S * 20000).EUt(VA[LV])
                .input(FUEL_ROD_SINGLE_THORIUM, 1)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 20000).EUt(VA[MV])
                .input(FUEL_ROD_DUAL_THORIUM, 1)
                .buildAndRegister();

        FISSION_RECIPES.recipeBuilder()
                .duration(S * 20000).EUt(VA[HV])
                .input(FUEL_ROD_QUAD_THORIUM, 1)
                .buildAndRegister();
    }
}
