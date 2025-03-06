package org.gthhcore.loaders.recipe.mod.gregtech.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.metatileentity.multiblock.CleanroomType.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static net.minecraft.init.Items.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.common.items.GTHHMetaItems.*;

public class GTHHSlimeMediumRecipes {

    public static void init() {
        // Raw Slime Growth Medium
        MIXER_RECIPES.recipeBuilder().duration(1200).EUt(VA[LuV])
                .input(dust, Meat, 4)
                .input(dust, RockSalt, 4)
                .input(dust, Saltpeter, 4)
                .input(dust, Boron, 4)
                .input(dust, Sodium, 4)
                .input(dust, Agar, 4)
                .fluidInputs(RawGrowthMedium.getFluid(4000))
                .fluidOutputs(RawSlimeGrowthMedium.getFluid(4000))
                .cleanroom(STERILE_CLEANROOM)
                .buildAndRegister();

        // Sterile Slime Growth Medium
        FLUID_HEATER_RECIPES.recipeBuilder().duration(40).EUt(VA[LuV])
                .fluidInputs(RawSlimeGrowthMedium.getFluid(100))
                .fluidOutputs(SterileSlimeGrowthMedium.getFluid(100))
                .circuitMeta(1)
                .cleanroom(STERILE_CLEANROOM)
                .buildAndRegister();

        // Slime Culture
        DISTILLERY_RECIPES.recipeBuilder().duration(600).EUt(VA[LuV])
                .input(SLIME_BALL, 16)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(SlimeCulture.getFluid(1000))
                .cleanroom(STERILE_CLEANROOM)
                .buildAndRegister();

        // Slime Cells
        CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(VA[ZPM])
                .input(dust, Naquadah)
                .output(SLIME_CELL, 16)
                .fluidInputs(SlimeCulture.getFluid(250))
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(250))
                .fluidOutputs(BacterialSludge.getFluid(250))
                .cleanroom(STERILE_CLEANROOM)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(VA[ZPM])
                .input(dust, NaquadahEnriched)
                .output(SLIME_CELL, 32)
                .fluidInputs(SlimeCulture.getFluid(500))
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(500))
                .fluidOutputs(BacterialSludge.getFluid(500))
                .cleanroom(STERILE_CLEANROOM)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder().duration(600).EUt(VA[ZPM])
                .input(dust, Naquadria)
                .output(SLIME_CELL, 64)
                .fluidInputs(SlimeCulture.getFluid(1000))
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(1000))
                .fluidOutputs(BacterialSludge.getFluid(1000))
                .cleanroom(STERILE_CLEANROOM)
                .buildAndRegister();
    }
}
