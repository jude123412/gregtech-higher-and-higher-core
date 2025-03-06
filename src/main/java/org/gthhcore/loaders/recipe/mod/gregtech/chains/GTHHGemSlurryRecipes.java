package org.gthhcore.loaders.recipe.mod.gregtech.chains;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.unification.OreDictUnifier;

public class GTHHGemSlurryRecipes {

    public static void init() {
        registerRemovals();
        registerRecipes();
    }

    public static void registerRemovals() {
        // Ruby Slurry
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(crushed, Ruby, 2)
        }, new FluidStack[] {
                AquaRegia.getFluid(3000)
        });

        removeRecipesByInputs(CENTRIFUGE_RECIPES, new ItemStack[] {
        }, new FluidStack[] {
                RubySlurry.getFluid(3000)
        });

        // Sapphire Slurry
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(crushed, Sapphire, 2)
        }, new FluidStack[] {
                AquaRegia.getFluid(3000)
        });

        removeRecipesByInputs(CENTRIFUGE_RECIPES, new ItemStack[] {
        }, new FluidStack[] {
                SapphireSlurry.getFluid(3000)
        });

        // Green Sapphire Slurry
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(crushed, GreenSapphire, 2)
        }, new FluidStack[] {
                AquaRegia.getFluid(3000)
        });

        removeRecipesByInputs(CENTRIFUGE_RECIPES, new ItemStack[] {
        }, new FluidStack[] {
                GreenSapphireSlurry.getFluid(3000)
        });
    }

    public static void registerRecipes() {
        // Coal Slurry
        MIXER_RECIPES.recipeBuilder()
                .duration(250).EUt(VA[LV])
                .input(crushed, Coal, 2)
                .fluidInputs(AquaRegia.getFluid(3000))
                .fluidOutputs(CoalSlurry.getFluid(3000))
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .duration(500).EUt(VA[ULV])
                .output(dust, Coal, 1)
                .chancedOutput(dust, Graphite, 1, 200, 0)
                .chancedOutput(dust, PreciousMetals, 1, 200, 0)
                .chancedOutput(dust, Gallium, 1, 200, 0)
                .fluidInputs(CoalSlurry.getFluid(3000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000), NitricAcid.getFluid(500))
                .buildAndRegister();

        // Ruby Slurry
        MIXER_RECIPES.recipeBuilder()
                .duration(250).EUt(VA[HV])
                .input(crushed, Ruby, 2)
                .fluidInputs(AquaRegia.getFluid(3000))
                .fluidOutputs(RubySlurry.getFluid(3000))
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .duration(500).EUt(VA[MV])
                .output(dust, Chrome, 1)
                .output(dust, Aluminium, 1)
                .chancedOutput(dust, Iron, 1, 200, 0)
                .chancedOutput(dust, Vanadium, 1, 500, 0)
                .fluidInputs(RubySlurry.getFluid(3000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000), NitricAcid.getFluid(500))
                .buildAndRegister();

        // Sapphire Slurry
        MIXER_RECIPES.recipeBuilder()
                .duration(250).EUt(VA[MV])
                .input(crushed, Sapphire, 2)
                .fluidInputs(AquaRegia.getFluid(3000))
                .fluidOutputs(SapphireSlurry.getFluid(3000))
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .duration(500).EUt(VA[LV])
                .output(dust, Aluminium, 2)
                .chancedOutput(dust, Iron, 1, 200, 0)
                .chancedOutput(dust, Vanadium, 1, 200, 0)
                .fluidInputs(SapphireSlurry.getFluid(3000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000), NitricAcid.getFluid(500))
                .buildAndRegister();

        // Green Sapphire Slurry
        MIXER_RECIPES.recipeBuilder()
                .duration(250).EUt(VA[MV])
                .input(crushed, GreenSapphire, 2)
                .fluidInputs(AquaRegia.getFluid(3000))
                .fluidOutputs(GreenSapphireSlurry.getFluid(3000))
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .duration(500).EUt(VA[LV])
                .output(dust, Aluminium, 2)
                .chancedOutput(dust, Iron, 1, 200, 0)
                .chancedOutput(dust, Vanadium, 1, 200, 0)
                .chancedOutput(dust, Beryllium, 1, 200, 0)
                .fluidInputs(GreenSapphireSlurry.getFluid(3000))
                .fluidOutputs(HydrochloricAcid.getFluid(1000), NitricAcid.getFluid(500))
                .buildAndRegister();
    }
}
