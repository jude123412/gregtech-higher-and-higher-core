package org.gthhcore.loaders.recipe.mod.gregtech.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;

public class GTHHPreciousMetalsRecipes {

    public static void init() {
        registerRecipes();
    }

    public static void registerRecipes() {
        CENTRIFUGE_RECIPES.recipeBuilder()
                .duration(80).EUt((int) V[ULV])
                .input(dust, PreciousMetals, 1)
                .chancedOutput(dust, Gold, 1, 1000, 100)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(80).EUt((int) V[LV])
                .input(dust, PreciousMetals, 1)
                .fluidInputs(AquaRegia.getFluid(1000))
                .fluidOutputs(DirtyPreciousMetalSolution.getFluid(1000))
                .buildAndRegister();

        THERMAL_CENTRIFUGE_RECIPES.recipeBuilder()
                .duration(160).EUt(VH[LV])
                .chancedOutput(dust, Gold, 1, 2500, 500)
                .chancedOutput(dust, Silver, 1, 1000, 250)
                .chancedOutput(dust, Copper, 1, 200, 50)
                .fluidInputs(DirtyPreciousMetalSolution.getFluid(3000))
                .fluidOutputs(HydrochloricAcid.getFluid(2000), NitricAcid.getFluid(1000))
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .duration(160).EUt(VA[MV])
                .fluidInputs(DirtyPreciousMetalSolution.getFluid(3000), Water.getFluid(3000))
                .fluidOutputs(DilutePreciousMetalSolution.getFluid(6000))
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .duration(80).EUt(VA[MV])
                .chancedOutput(dust, Gallium, 1, 200, 100)
                .fluidInputs(DilutePreciousMetalSolution.getFluid(1000))
                .fluidOutputs(CleanPreciousMetalSolution.getFluid(1000))
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .duration(320).EUt(VH[HV])
                .chancedOutput(dust, Zinc, 1, 200, 100)
                .fluidInputs(CleanPreciousMetalSolution.getFluid(6000))
                .fluidOutputs(ConcentratedPreciousMetalSolution.getFluid(3000), HydrochloricAcid.getFluid(2000),
                        NitricAcid.getFluid(1000))
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .duration(320).EUt(VA[MV])
                .output(dust, Gold, 1)
                .output(dust, Silver, 1)
                .output(dust, Copper, 1)
                .fluidInputs(ConcentratedPreciousMetalSolution.getFluid(1000))
                .buildAndRegister();
    }
}
