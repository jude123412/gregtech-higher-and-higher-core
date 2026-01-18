package org.gthhcore.loaders.recipe.mod.gregtech;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.common.items.GTHHMetaItems.*;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import org.gthhcore.api.util.GTHHUtility;
import org.gthhcore.common.blocks.GTHHBlockWireCoil.GTHHCoilType;
import org.gthhcore.common.blocks.GTHHMetaBlocks;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.common.blocks.BlockWireCoil.CoilType;
import gregtech.common.blocks.MetaBlocks;

public class GTHHHeatingCoilRecipes {

    public static void init() {
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(wireGtDouble, Cupronickel, 8),
                OreDictUnifier.get(foil, Bronze, 8)
        }, new FluidStack[] {
                TinAlloy.getFluid(L)
        });

        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(wireGtDouble, Kanthal, 8),
                OreDictUnifier.get(foil, Aluminium, 8)
        }, new FluidStack[] {
                Copper.getFluid(L)
        });

        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(wireGtDouble, Nichrome, 8),
                OreDictUnifier.get(foil, StainlessSteel, 8)
        }, new FluidStack[] {
                Aluminium.getFluid(L)
        });

        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(wireGtDouble, RTMAlloy, 8),
                OreDictUnifier.get(foil, VanadiumSteel, 8)
        }, new FluidStack[] {
                Nichrome.getFluid(L)
        });

        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(wireGtDouble, HSSG, 8),
                OreDictUnifier.get(foil, TungstenCarbide, 8)
        }, new FluidStack[] {
                Tungsten.getFluid(L)
        });

        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(wireGtDouble, Naquadah, 8),
                OreDictUnifier.get(foil, Osmium, 8)
        }, new FluidStack[] {
                TungstenSteel.getFluid(L)
        });

        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(wireGtDouble, Trinium, 8),
                OreDictUnifier.get(foil, NaquadahEnriched, 8)
        }, new FluidStack[] {
                Naquadah.getFluid(L)
        });

        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(wireGtDouble, Tritanium, 8),
                OreDictUnifier.get(foil, Naquadria, 8)
        }, new FluidStack[] {
                Trinium.getFluid(L)
        });

        // LV Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(200).EUt(VA[LV])
                .input(wireGtDouble, Cupronickel, 8)
                .input(MICA_INSULATOR_FOIL, 8)
                .fluidInputs(TinAlloy.getFluid(L))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(CoilType.CUPRONICKEL))
                .buildAndRegister();

        // MV Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(300).EUt(VA[MV])
                .input(wireGtDouble, Kanthal, 8)
                .input(MICA_INSULATOR_FOIL, 16)
                .fluidInputs(Cupronickel.getFluid(L))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(CoilType.KANTHAL))
                .buildAndRegister();

        // HV Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(400).EUt(VA[HV])
                .input(wireGtDouble, Nichrome, 8)
                .input(MICA_INSULATOR_FOIL, 24)
                .fluidInputs(Kanthal.getFluid(L))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(CoilType.NICHROME))
                .buildAndRegister();

        // EV Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(500).EUt(VA[EV])
                .input(wireGtDouble, RTMAlloy, 8)
                .input(MICA_INSULATOR_FOIL, 32)
                .fluidInputs(Nichrome.getFluid(L))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(CoilType.RTM_ALLOY))
                .buildAndRegister();

        // IV Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(600).EUt(VA[IV])
                .input(wireGtDouble, HSSG, 8)
                .input(MICA_INSULATOR_FOIL, 40)
                .fluidInputs(RTMAlloy.getFluid(L))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(CoilType.HSS_G))
                .buildAndRegister();

        // IV Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(700).EUt(VA[IV])
                .input(wireGtDouble, HSSS, 8)
                .input(MICA_INSULATOR_FOIL, 48)
                .fluidInputs(HSSG.getFluid(L))
                .outputs(GTHHMetaBlocks.WIRE_COIL_0.getItemVariant(GTHHCoilType.HSS_S))
                .buildAndRegister();

        // LuV
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(800).EUt(VA[LuV])
                .input(wireGtDouble, Naquadah, 8)
                .input(MICA_INSULATOR_FOIL, 56)
                .fluidInputs(HSSS.getFluid(L))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(CoilType.NAQUADAH))
                .buildAndRegister();

        // LuV Optional Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(900).EUt(VA[LuV])
                .input(wireGtDouble, NaquadahAlloy, 8)
                .input(MICA_INSULATOR_FOIL, 64)
                .fluidInputs(Naquadah.getFluid(L))
                .outputs(GTHHMetaBlocks.WIRE_COIL_0.getItemVariant(GTHHCoilType.NAQUADAH_ALLOY))
                .buildAndRegister();

        // ZPM Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(1000).EUt(VA[ZPM])
                .input(wireGtDouble, Trinium, 8)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 16)
                .fluidInputs(NaquadahAlloy.getFluid(L))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(CoilType.TRINIUM))
                .buildAndRegister();

        // ZPM Optional Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(1100).EUt(VA[ZPM])
                .input(wireGtDouble, AwakenedDraconium, 8)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 32)
                .fluidInputs(Trinium.getFluid(L))
                .outputs(GTHHMetaBlocks.WIRE_COIL_0.getItemVariant(GTHHCoilType.AWAKENED_DRACONIUM))
                .buildAndRegister();

        // UV Coil
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(1200).EUt(VA[UV])
                .input(wireGtDouble, Tritanium, 8)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 48)
                .fluidInputs(Trinium.getFluid(L))
                .outputs(MetaBlocks.WIRE_COIL.getItemVariant(CoilType.TRITANIUM))
                .buildAndRegister();

        // UHV Coil
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.UHV, 1)
                .input(wireGtDouble, Infinity, 8)
                .input(screw, Infinity, 8)
                .input(plateDouble, Infinity, 8)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 64)
                .fluidInputs(Neutronium.getFluid(L * 32))
                .fluidInputs(SolderingAlloy.getFluid(L * 32))
                .fluidInputs(SlimeSolder.getFluid(L * 16))
                .fluidInputs(Polybenzimidazole.getFluid(L * 8))
                .outputs(GTHHMetaBlocks.WIRE_COIL_0.getItemVariant(GTHHCoilType.INFINITY))
                .stationResearch(b -> b
                        .researchStack(MetaBlocks.WIRE_COIL.getItemVariant(CoilType.TRITANIUM))
                        .CWUt(2048)
                        .EUt(VA[UV]))
                .EUt(VA[UHV]).duration(2000).buildAndRegister();

        // UEV Coil
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.UEV, 1)
                .input(wireGtDouble, Infinity, 8)
                .input(screw, Infinity, 8)
                .input(plateDouble, Infinity, 8)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(GTHHUtility.getItemFromString("eternalsingularity", "eternal_singularity"), 1)
                .fluidInputs(Neutronium.getFluid(L * 64))
                .fluidInputs(ElectroMatter.getFluid(L * 16))
                .fluidInputs(Polybenzimidazole.getFluid(L * 16))
                .outputs(GTHHMetaBlocks.WIRE_COIL_0.getItemVariant(GTHHCoilType.ETERNAL))
                .stationResearch(b -> b
                        .researchStack(GTHHMetaBlocks.WIRE_COIL_0.getItemVariant(GTHHCoilType.INFINITY))
                        .CWUt(2048)
                        .EUt(VA[UV]))
                .EUt(VA[UHV]).duration(2000).buildAndRegister();

        // UIV Coil
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(circuit, MarkerMaterials.Tier.UIV, 1)
                .input(wireGtDouble, Infinity, 8)
                .input(screw, Infinity, 8)
                .input(plateDouble, Infinity, 8)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(MICA_INSULATOR_FOIL, 64)
                .input(GTHHUtility.getItemFromString("eternalsingularity", "eternal_singularity"), 4)
                .input(GTHHUtility.getItemFromString("eternalsingularity", "eternal_singularity"), 4)
                .input(GTHHUtility.getItemFromString("eternalsingularity", "eternal_singularity"), 4)
                .input(GTHHUtility.getItemFromString("eternalsingularity", "eternal_singularity"), 4)
                .fluidInputs(Neutronium.getFluid(L * 128))
                .fluidInputs(SolderingAlloy.getFluid(L * 64))
                .fluidInputs(ElectroMatter.getFluid(L * 32))
                .fluidInputs(Polybenzimidazole.getFluid(L * 32))
                .outputs(GTHHMetaBlocks.WIRE_COIL_0.getItemVariant(GTHHCoilType.TEMPORAL))
                .stationResearch(b -> b
                        .researchStack(GTHHMetaBlocks.WIRE_COIL_0.getItemVariant(GTHHCoilType.ETERNAL))
                        .CWUt(2048)
                        .EUt(VA[UV]))
                .EUt(VA[UHV]).duration(2000).buildAndRegister();
    }
}
