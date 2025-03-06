package org.gthhcore.loaders.recipe.mod.gregtech;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.GTRecipeHandler.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.common.items.GTHHMetaItems.*;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.MarkerMaterials.Component;
import gregtech.api.unification.material.MarkerMaterials.Tier;

public class GTHHCircuitRecipes {

    public static void init() {
        waferRecipes();
        componentRecipes();
        boardRecipes();
        circuitRecipes();
    }

    private static void waferRecipes() {}

    private static void componentRecipes() {
        // Wetware CPU
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(600).EUt(VA[IV])
                .input(STEM_CELLS, 16)
                .input(ENGRAVED_SALT_CRYSTAL_CHIP, 16)
                .fluidInputs(SterileGrowthMedium.getFluid(1000))
                .output(WETWARE_CENTRAL_PROCESSING_UNIT, 16)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        // Wetware SMD Transistor
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(600).EUt(VA[ZPM])
                .input(STEM_CELLS, 16)
                .input(SALT_CRYSTAL_SMD_TRANSISTOR, 16)
                .fluidInputs(SterileGrowthMedium.getFluid(1000))
                .output(ADVANCED_SMD_TRANSISTOR, 16)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        // Wetware SMD Resistor
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(600).EUt(VA[ZPM])
                .input(STEM_CELLS, 16)
                .input(SALT_CRYSTAL_SMD_RESISTOR, 16)
                .fluidInputs(SterileGrowthMedium.getFluid(1000))
                .output(ADVANCED_SMD_RESISTOR, 16)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        // Wetware SMD Capacitor
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(600).EUt(VA[ZPM])
                .input(STEM_CELLS, 16)
                .input(SALT_CRYSTAL_SMD_CAPACITOR, 16)
                .fluidInputs(SterileGrowthMedium.getFluid(1000))
                .output(ADVANCED_SMD_CAPACITOR, 16)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        // Wetware SMD Diode
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(600).EUt(VA[ZPM])
                .input(STEM_CELLS, 16)
                .input(SALT_CRYSTAL_SMD_DIODE, 64)
                .fluidInputs(SterileGrowthMedium.getFluid(1000))
                .output(ADVANCED_SMD_DIODE, 64)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        // Wetware SMD Inductor
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(600).EUt(VA[ZPM])
                .input(STEM_CELLS, 16)
                .input(SALT_CRYSTAL_SMD_INDUCTOR, 16)
                .fluidInputs(SterileGrowthMedium.getFluid(1000))
                .output(ADVANCED_SMD_INDUCTOR, 16)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        // Slimeware CPU
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(600).EUt(VA[UV])
                .input(SLIME_CELL, 16)
                .input(ENGRAVED_SALT_CRYSTAL_CHIP, 16)
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(2000))
                .output(SLIMEWARE_CENTRAL_PROCESSING_UNIT, 16)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        // Slimeware SMD Transistor
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(600).EUt(VA[UV])
                .input(SLIME_CELL, 16)
                .input(SALT_CRYSTAL_SMD_TRANSISTOR, 16)
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(1000))
                .output(SLIMEWARE_SMD_TRANSISTOR, 16)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        // Slimeware SMD Resistor
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(600).EUt(VA[UV])
                .input(SLIME_CELL, 16)
                .input(SALT_CRYSTAL_SMD_RESISTOR, 16)
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(1000))
                .output(SLIMEWARE_SMD_RESISTOR, 16)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        // Slimeware SMD Capacitor
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(600).EUt(VA[UV])
                .input(SLIME_CELL, 16)
                .input(SALT_CRYSTAL_SMD_CAPACITOR, 16)
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(1000))
                .output(SLIMEWARE_SMD_CAPACITOR, 16)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        // Slimeware SMD Diode
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(600).EUt(VA[UV])
                .input(SLIME_CELL, 16)
                .input(SALT_CRYSTAL_SMD_DIODE, 64)
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(1000))
                .output(SLIMEWARE_SMD_DIODE, 64)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        // Slimeware SMD Inductor
        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(600).EUt(VA[UV])
                .input(SLIME_CELL, 16)
                .input(SALT_CRYSTAL_SMD_INDUCTOR, 16)
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(1000))
                .output(SLIMEWARE_SMD_INDUCTOR, 16)
                .cleanroom(CleanroomType.STERILE_CLEANROOM)
                .buildAndRegister();

        // Salt Crystal Circuit Components
        // Raw Salt Crystal Chip
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(gemExquisite, Salt)
                .fluidInputs(Americium.getFluid(L / 9))
                .chancedOutput(RAW_SALT_CRYSTAL_CHIP, 1000, 2000)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(12000).EUt(1280).buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(gemExquisite, RockSalt)
                .fluidInputs(Americium.getFluid(L / 9))
                .chancedOutput(RAW_SALT_CRYSTAL_CHIP, 1000, 2000)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(12000).EUt(1280).buildAndRegister();

        FORGE_HAMMER_RECIPES.recipeBuilder()
                .input(RAW_SALT_CRYSTAL_CHIP)
                .output(RAW_SALT_CRYSTAL_CHIP_PART, 9)
                .EUt(VA[IV]).duration(100).buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(RAW_SALT_CRYSTAL_CHIP_PART)
                .fluidInputs(Americium.getFluid(L / 9))
                .output(RAW_SALT_CRYSTAL_CHIP)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(12000).EUt(VA[IV]).buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(RAW_SALT_CRYSTAL_CHIP_PART)
                .fluidInputs(Mutagen.getFluid(250))
                .chancedOutput(RAW_SALT_CRYSTAL_CHIP, 9000, 250)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(12000).EUt(VA[IV]).buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(RAW_SALT_CRYSTAL_CHIP_PART)
                .fluidInputs(BacterialSludge.getFluid(250))
                .chancedOutput(RAW_SALT_CRYSTAL_CHIP, 8000, 250)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(12000).EUt(VA[IV]).buildAndRegister();

        // Engraved Salt Crystal Chip
        BLAST_RECIPES.recipeBuilder()
                .input(gem, Salt)
                .input(RAW_SALT_CRYSTAL_CHIP)
                .fluidInputs(Chlorine.getFluid(1000))
                .output(ENGRAVED_SALT_CRYSTAL_CHIP)
                .blastFurnaceTemp(5000)
                .duration(900).EUt(VA[IV]).buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(gem, RockSalt)
                .input(RAW_SALT_CRYSTAL_CHIP)
                .fluidInputs(Chlorine.getFluid(1000))
                .output(ENGRAVED_SALT_CRYSTAL_CHIP)
                .blastFurnaceTemp(5000)
                .duration(900).EUt(VA[IV]).buildAndRegister();

        // Salt Crystal Resistor
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(dust, Graphene),
                OreDictUnifier.get(wireFine, Platinum, 4)
        }, new FluidStack[] {
                Polybenzimidazole.getFluid(L * 2)
        });

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, Graphene)
                .input(wireFine, Platinum, 4)
                .fluidInputs(SaltsSolution.getFluid(L * 2))
                .output(SALT_CRYSTAL_SMD_RESISTOR, 16)
                .EUt(3840).duration(160).buildAndRegister();

        // Salt Crystal Diode
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(dust, IndiumGalliumPhosphide),
                OreDictUnifier.get(wireFine, NiobiumTitanium, 16)
        }, new FluidStack[] {
                Polybenzimidazole.getFluid(L * 2)
        });

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(dust, IndiumGalliumPhosphide)
                .input(wireFine, NiobiumTitanium, 16)
                .fluidInputs(SaltsSolution.getFluid(L * 2))
                .output(SALT_CRYSTAL_SMD_DIODE, 64)
                .EUt(3840).duration(640).buildAndRegister();

        // Salt Crystal Transistor
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(foil, VanadiumGallium),
                OreDictUnifier.get(wireFine, HSSG, 8)
        }, new FluidStack[] {
                Polybenzimidazole.getFluid(L)
        });

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(foil, VanadiumGallium)
                .input(wireFine, HSSG, 8)
                .fluidInputs(SaltsSolution.getFluid(L))
                .output(SALT_CRYSTAL_SMD_TRANSISTOR, 16)
                .EUt(3840).duration(160).buildAndRegister();

        // Salt Crystal Capacitor
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(foil, Polybenzimidazole, 2),
                OreDictUnifier.get(foil, HSSS)
        }, new FluidStack[] {
                Polybenzimidazole.getFluid(L / 4)
        });

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(foil, Polybenzimidazole, 2)
                .input(foil, HSSS)
                .fluidInputs(SaltsSolution.getFluid(L / 4))
                .output(SALT_CRYSTAL_SMD_CAPACITOR, 16)
                .EUt(3840).duration(80).buildAndRegister();

        // Salt Crystal SMD Inductor
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(ring, HSSE),
                OreDictUnifier.get(wireFine, Palladium, 4)
        }, new FluidStack[] {
                Polybenzimidazole.getFluid(L)
        });

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ring, HSSE)
                .input(wireFine, Palladium, 4)
                .fluidInputs(SaltsSolution.getFluid(L))
                .output(SALT_CRYSTAL_SMD_INDUCTOR, 16)
                .EUt(3840).duration(160).buildAndRegister();

        // Salts Catalyst
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Salt, 1)
                .input(dust, RockSalt, 1)
                .input(dust, HSSS, 2)
                .output(dust, SaltsCatalyst, 4)
                .duration(1800).EUt(VA[LuV] / 2).buildAndRegister();

        // Salts Solution
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SaltsCatalyst, 2)
                .fluidInputs(Oxygen.getFluid(L))
                .fluidInputs(Polybenzimidazole.getFluid(L * 1))
                .fluidOutputs(SaltsSolution.getFluid((int) (L * 1.5)))
                .duration(1800).EUt(VA[LuV] / 2).buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SaltsCatalyst, 2)
                .fluidInputs(Air.getFluid((int) (L * 1.5)))
                .fluidInputs(Polybenzimidazole.getFluid(L))
                .fluidOutputs(SaltsSolution.getFluid(L))
                .duration(1800).EUt(VA[LuV] / 2).buildAndRegister();

        // Slime Solder
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(SLIME_CELL, 64)
                .input(GRAVI_STAR, 8)
                .input(dust, InfinityCatalyst, 2)
                .fluidInputs(Tin.getPlasma(L * 128))
                .fluidInputs(Bismuth.getPlasma(L * 128))
                .fluidInputs(Crynorium.getFluid(L * 64))
                .fluidOutputs(SlimeSolder.getFluid(L * 320))
                .duration(1800).EUt(VA[UEV] / 2).buildAndRegister();
    }

    private static void boardRecipes() {
        // SLIMEWARE BOARD

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .duration(1200).EUt(VA[ZPM])
                .input(WETWARE_BOARD, 16)
                .input(PETRI_DISH)
                .input(ELECTRIC_PUMP_ZPM)
                .input(SENSOR_LuV)
                .input(circuit, MarkerMaterials.Tier.LuV)
                .input(foil, CosmicNeutronium, 16)
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(4000))
                .output(SLIMEWARE_BOARD, 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder().duration(1800).EUt(VA[EV])
                .input(SLIMEWARE_BOARD)
                .input(foil, CosmicNeutronium, 32)
                .fluidInputs(SodiumPersulfate.getFluid(16000))
                .output(SLIMEWARE_CIRCUIT_BOARD)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder().duration(1800).EUt(VA[EV])
                .input(SLIMEWARE_BOARD)
                .input(foil, CosmicNeutronium, 32)
                .fluidInputs(Iron3Chloride.getFluid(8000))
                .output(SLIMEWARE_CIRCUIT_BOARD)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
    }

    private static void circuitRecipes() {
        // T1: Electronic ==============================================================================================

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                BASIC_CIRCUIT_BOARD.getStackForm(1),
                OreDictUnifier.get(component, Component.Resistor, 2),
                OreDictUnifier.get(wireGtSingle, RedAlloy, 8),
                OreDictUnifier.get(circuit, Tier.ULV, 2)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                BASIC_CIRCUIT_BOARD.getStackForm(1),
                OreDictUnifier.get(component, Component.Resistor, 2),
                OreDictUnifier.get(wireGtSingle, RedAlloy, 8),
                OreDictUnifier.get(circuit, Tier.ULV, 2)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });
        // LV

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(16).duration(200)
                .input(BASIC_CIRCUIT_BOARD, 1)
                .input(component, Component.Resistor, 2)
                .input(wireGtSingle, RedAlloy, 2)
                .input(circuit, Tier.ULV, 2)
                .output(ELECTRONIC_CIRCUIT_LV, 1)
                .buildAndRegister();

        // T2: Integrated ==============================================================================================

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                BASIC_CIRCUIT_BOARD.getStackForm(1),
                INTEGRATED_LOGIC_CIRCUIT.getStackForm(1),
                OreDictUnifier.get(component, Component.Resistor, 2),
                OreDictUnifier.get(component, Component.Diode, 2),
                OreDictUnifier.get(wireFine, Copper, 2),
                OreDictUnifier.get(bolt, Tin, 2)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                BASIC_CIRCUIT_BOARD.getStackForm(1),
                INTEGRATED_LOGIC_CIRCUIT.getStackForm(1),
                OreDictUnifier.get(component, Component.Resistor, 2),
                OreDictUnifier.get(component, Component.Diode, 2),
                OreDictUnifier.get(wireFine, Copper, 2),
                OreDictUnifier.get(bolt, Tin, 2)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                GOOD_CIRCUIT_BOARD.getStackForm(1),
                INTEGRATED_CIRCUIT_LV.getStackForm(2),
                OreDictUnifier.get(component, Component.Resistor, 2),
                OreDictUnifier.get(component, Component.Diode, 2),
                OreDictUnifier.get(wireFine, Gold, 4),
                OreDictUnifier.get(bolt, Silver, 4)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                GOOD_CIRCUIT_BOARD.getStackForm(1),
                INTEGRATED_CIRCUIT_LV.getStackForm(2),
                OreDictUnifier.get(component, Component.Resistor, 2),
                OreDictUnifier.get(component, Component.Diode, 2),
                OreDictUnifier.get(wireFine, Gold, 4),
                OreDictUnifier.get(bolt, Silver, 4)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        // LV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(16).duration(200)
                .input(BASIC_CIRCUIT_BOARD, 1)
                .input(INTEGRATED_LOGIC_CIRCUIT, 1)
                .input(component, Component.Resistor, 2)
                .input(component, Component.Diode, 2)
                .input(wireFine, Copper, 2)
                .input(bolt, Tin, 2)
                .output(INTEGRATED_CIRCUIT_LV, 1)
                .buildAndRegister();

        // MV
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(24).duration(400)
                .input(GOOD_CIRCUIT_BOARD, 1)
                .input(INTEGRATED_CIRCUIT_LV, 2)
                .input(component, Component.Resistor, 2)
                .input(component, Component.Diode, 2)
                .input(wireFine, Gold, 4)
                .input(bolt, Silver, 4)
                .output(INTEGRATED_CIRCUIT_MV, 1)
                .buildAndRegister();

        // T2.5: Misc ==================================================================================================

        // NAND Chip ULV

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                GOOD_CIRCUIT_BOARD.getStackForm(1),
                SIMPLE_SYSTEM_ON_CHIP.getStackForm(2),
                OreDictUnifier.get(bolt, RedAlloy, 2),
                OreDictUnifier.get(wireFine, Tin, 2)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                GOOD_CIRCUIT_BOARD.getStackForm(1),
                SIMPLE_SYSTEM_ON_CHIP.getStackForm(2),
                OreDictUnifier.get(bolt, RedAlloy, 2),
                OreDictUnifier.get(wireFine, Tin, 2)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                PLASTIC_CIRCUIT_BOARD.getStackForm(1),
                SIMPLE_SYSTEM_ON_CHIP.getStackForm(2),
                OreDictUnifier.get(bolt, RedAlloy, 2),
                OreDictUnifier.get(wireFine, Tin, 2)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                PLASTIC_CIRCUIT_BOARD.getStackForm(1),
                SIMPLE_SYSTEM_ON_CHIP.getStackForm(2),
                OreDictUnifier.get(bolt, RedAlloy, 2),
                OreDictUnifier.get(wireFine, Tin, 2)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[MV]).duration(300)
                .input(GOOD_CIRCUIT_BOARD, 1)
                .input(SIMPLE_SYSTEM_ON_CHIP, 1)
                .input(bolt, RedAlloy, 2)
                .input(wireFine, Tin, 2)
                .output(NAND_CHIP_ULV, 2)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[MV]).duration(300)
                .input(PLASTIC_CIRCUIT_BOARD, 1)
                .input(SIMPLE_SYSTEM_ON_CHIP, 1)
                .input(bolt, RedAlloy, 2)
                .input(wireFine, Tin, 2)
                .output(NAND_CHIP_ULV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[MV]).duration(300)
                .input(ADVANCED_CIRCUIT_BOARD, 1)
                .input(SIMPLE_SYSTEM_ON_CHIP, 1)
                .input(bolt, RedAlloy, 2)
                .input(wireFine, Tin, 2)
                .output(NAND_CHIP_ULV, 6)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[MV]).duration(300)
                .input(EXTREME_CIRCUIT_BOARD, 1)
                .input(SIMPLE_SYSTEM_ON_CHIP, 1)
                .input(bolt, RedAlloy, 2)
                .input(wireFine, Tin, 2)
                .output(NAND_CHIP_ULV, 8)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[MV]).duration(300)
                .input(ELITE_CIRCUIT_BOARD, 1)
                .input(SIMPLE_SYSTEM_ON_CHIP, 1)
                .input(bolt, RedAlloy, 2)
                .input(wireFine, Tin, 2)
                .output(NAND_CHIP_ULV, 16)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[MV]).duration(300)
                .input(WETWARE_CIRCUIT_BOARD, 1)
                .input(SIMPLE_SYSTEM_ON_CHIP, 1)
                .input(bolt, RedAlloy, 2)
                .input(wireFine, Tin, 2)
                .output(NAND_CHIP_ULV, 24)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[MV]).duration(300)
                .input(SLIMEWARE_CIRCUIT_BOARD, 1)
                .input(SIMPLE_SYSTEM_ON_CHIP, 1)
                .input(bolt, RedAlloy, 2)
                .input(wireFine, Tin, 2)
                .output(NAND_CHIP_ULV, 32)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[MV]).duration(300)
                .input(LASERTRONIC_CIRCUIT_BOARD, 1)
                .input(SIMPLE_SYSTEM_ON_CHIP, 1)
                .input(bolt, RedAlloy, 2)
                .input(wireFine, Tin, 2)
                .output(NAND_CHIP_ULV, 40)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[MV]).duration(300)
                .input(BOHEMIAN_CIRCUIT_BOARD, 1)
                .input(SIMPLE_SYSTEM_ON_CHIP, 1)
                .input(bolt, RedAlloy, 2)
                .input(wireFine, Tin, 2)
                .output(NAND_CHIP_ULV, 48)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[MV]).duration(300)
                .input(ANTIMATTER_CIRCUIT_BOARD, 1)
                .input(SIMPLE_SYSTEM_ON_CHIP, 1)
                .input(bolt, RedAlloy, 2)
                .input(wireFine, Tin, 2)
                .output(NAND_CHIP_ULV, 56)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[MV]).duration(300)
                .input(TEMPORAL_CIRCUIT_BOARD, 1)
                .input(SIMPLE_SYSTEM_ON_CHIP, 1)
                .input(bolt, RedAlloy, 2)
                .input(wireFine, Tin, 2)
                .output(NAND_CHIP_ULV, 64)
                .buildAndRegister();

        // Microprocessor LV

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                PLASTIC_CIRCUIT_BOARD.getStackForm(1),
                CENTRAL_PROCESSING_UNIT.getStackForm(2),
                OreDictUnifier.get(component, Component.Resistor, 2),
                OreDictUnifier.get(component, Component.Capacitor, 2),
                OreDictUnifier.get(component, Component.Transistor, 2),
                OreDictUnifier.get(wireFine, Copper, 2)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                PLASTIC_CIRCUIT_BOARD.getStackForm(1),
                CENTRAL_PROCESSING_UNIT.getStackForm(2),
                OreDictUnifier.get(component, Component.Resistor, 2),
                OreDictUnifier.get(component, Component.Capacitor, 2),
                OreDictUnifier.get(component, Component.Transistor, 2),
                OreDictUnifier.get(wireFine, Copper, 2)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(60).duration(200)
                .input(PLASTIC_CIRCUIT_BOARD, 1)
                .input(CENTRAL_PROCESSING_UNIT, 1)
                .input(component, Component.Resistor, 2)
                .input(component, Component.Capacitor, 2)
                .input(component, Component.Transistor, 2)
                .input(wireFine, Copper, 2)
                .output(MICROPROCESSOR_LV, 1)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(60).duration(200)
                .input(EXTREME_CIRCUIT_BOARD, 1)
                .input(CENTRAL_PROCESSING_UNIT, 1)
                .input(component, Component.Resistor, 2)
                .input(component, Component.Capacitor, 2)
                .input(component, Component.Transistor, 2)
                .input(wireFine, Copper, 2)
                .output(MICROPROCESSOR_LV, 2)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(60).duration(200)
                .input(ELITE_CIRCUIT_BOARD, 1)
                .input(CENTRAL_PROCESSING_UNIT, 1)
                .input(component, Component.Resistor, 2)
                .input(component, Component.Capacitor, 2)
                .input(component, Component.Transistor, 2)
                .input(wireFine, Copper, 2)
                .output(MICROPROCESSOR_LV, 4)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(60).duration(200)
                .input(WETWARE_CIRCUIT_BOARD, 1)
                .input(CENTRAL_PROCESSING_UNIT, 1)
                .input(component, Component.Resistor, 2)
                .input(component, Component.Capacitor, 2)
                .input(component, Component.Transistor, 2)
                .input(wireFine, Copper, 2)
                .output(MICROPROCESSOR_LV, 8)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(60).duration(200)
                .input(SLIMEWARE_CIRCUIT_BOARD, 1)
                .input(CENTRAL_PROCESSING_UNIT, 1)
                .input(component, Component.Resistor, 2)
                .input(component, Component.Capacitor, 2)
                .input(component, Component.Transistor, 2)
                .input(wireFine, Copper, 2)
                .output(MICROPROCESSOR_LV, 16)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(60).duration(200)
                .input(LASERTRONIC_CIRCUIT_BOARD, 1)
                .input(CENTRAL_PROCESSING_UNIT, 1)
                .input(component, Component.Resistor, 2)
                .input(component, Component.Capacitor, 2)
                .input(component, Component.Transistor, 2)
                .input(wireFine, Copper, 2)
                .output(MICROPROCESSOR_LV, 32)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(60).duration(200)
                .input(BOHEMIAN_CIRCUIT_BOARD, 1)
                .input(CENTRAL_PROCESSING_UNIT, 1)
                .input(component, Component.Resistor, 2)
                .input(component, Component.Capacitor, 2)
                .input(component, Component.Transistor, 2)
                .input(wireFine, Copper, 2)
                .output(MICROPROCESSOR_LV, 48)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(60).duration(200)
                .input(ANTIMATTER_CIRCUIT_BOARD, 1)
                .input(CENTRAL_PROCESSING_UNIT, 1)
                .input(component, Component.Resistor, 2)
                .input(component, Component.Capacitor, 2)
                .input(component, Component.Transistor, 2)
                .input(wireFine, Copper, 2)
                .output(MICROPROCESSOR_LV, 56)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(60).duration(200)
                .input(TEMPORAL_CIRCUIT_BOARD, 1)
                .input(CENTRAL_PROCESSING_UNIT, 1)
                .input(component, Component.Resistor, 2)
                .input(component, Component.Capacitor, 2)
                .input(component, Component.Transistor, 2)
                .input(wireFine, Copper, 2)
                .output(MICROPROCESSOR_LV, 64)
                .buildAndRegister();

        // Microprocessor LV SoC

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                PLASTIC_CIRCUIT_BOARD.getStackForm(1),
                SYSTEM_ON_CHIP.getStackForm(1),
                OreDictUnifier.get(wireFine, Copper, 2),
                OreDictUnifier.get(bolt, Tin, 2)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                PLASTIC_CIRCUIT_BOARD.getStackForm(1),
                SYSTEM_ON_CHIP.getStackForm(1),
                OreDictUnifier.get(wireFine, Copper, 2),
                OreDictUnifier.get(bolt, Tin, 2)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(50)
                .input(PLASTIC_CIRCUIT_BOARD, 1)
                .input(SYSTEM_ON_CHIP, 1)
                .input(wireFine, Copper, 2)
                .input(bolt, Tin, 2)
                .output(MICROPROCESSOR_LV, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(50)
                .input(EXTREME_CIRCUIT_BOARD, 1)
                .input(SYSTEM_ON_CHIP, 1)
                .input(wireFine, Copper, 2)
                .input(bolt, Tin, 2)
                .output(MICROPROCESSOR_LV, 2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(50)
                .input(ELITE_CIRCUIT_BOARD, 1)
                .input(SYSTEM_ON_CHIP, 1)
                .input(wireFine, Copper, 2)
                .input(bolt, Tin, 2)
                .output(MICROPROCESSOR_LV, 4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(50)
                .input(WETWARE_CIRCUIT_BOARD, 1)
                .input(SYSTEM_ON_CHIP, 1)
                .input(wireFine, Copper, 2)
                .input(bolt, Tin, 2)
                .output(MICROPROCESSOR_LV, 8)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(50)
                .input(SLIMEWARE_CIRCUIT_BOARD, 1)
                .input(SYSTEM_ON_CHIP, 1)
                .input(wireFine, Copper, 2)
                .input(bolt, Tin, 2)
                .output(MICROPROCESSOR_LV, 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(50)
                .input(LASERTRONIC_CIRCUIT_BOARD, 1)
                .input(SYSTEM_ON_CHIP, 1)
                .input(wireFine, Copper, 2)
                .input(bolt, Tin, 2)
                .output(MICROPROCESSOR_LV, 32)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(50)
                .input(BOHEMIAN_CIRCUIT_BOARD, 1)
                .input(SYSTEM_ON_CHIP, 1)
                .input(wireFine, Copper, 2)
                .input(bolt, Tin, 2)
                .output(MICROPROCESSOR_LV, 48)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(50)
                .input(ANTIMATTER_CIRCUIT_BOARD, 1)
                .input(SYSTEM_ON_CHIP, 1)
                .input(wireFine, Copper, 2)
                .input(bolt, Tin, 2)
                .output(MICROPROCESSOR_LV, 56)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(50)
                .input(TEMPORAL_CIRCUIT_BOARD, 1)
                .input(SYSTEM_ON_CHIP, 1)
                .input(wireFine, Copper, 2)
                .input(bolt, Tin, 2)
                .output(MICROPROCESSOR_LV, 64)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // T3: Processor ===============================================================================================

        // MV

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                PLASTIC_CIRCUIT_BOARD.getStackForm(),
                CENTRAL_PROCESSING_UNIT.getStackForm(),
                OreDictUnifier.get(component, Component.Resistor, 4),
                OreDictUnifier.get(component, Component.Capacitor, 4),
                OreDictUnifier.get(component, Component.Transistor, 4),
                OreDictUnifier.get(wireFine, RedAlloy, 4),
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                PLASTIC_CIRCUIT_BOARD.getStackForm(),
                CENTRAL_PROCESSING_UNIT.getStackForm(),
                OreDictUnifier.get(component, Component.Resistor, 4),
                OreDictUnifier.get(component, Component.Capacitor, 4),
                OreDictUnifier.get(component, Component.Transistor, 4),
                OreDictUnifier.get(wireFine, RedAlloy, 4),
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(60).duration(200)
                .input(PLASTIC_CIRCUIT_BOARD)
                .input(CENTRAL_PROCESSING_UNIT)
                .input(component, Component.Resistor, 4)
                .input(component, Component.Capacitor, 4)
                .input(component, Component.Transistor, 4)
                .input(wireFine, RedAlloy, 4)
                .output(PROCESSOR_MV, 1)
                .buildAndRegister();

        // MV SoC

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                PLASTIC_CIRCUIT_BOARD.getStackForm(1),
                SYSTEM_ON_CHIP.getStackForm(1),
                OreDictUnifier.get(wireFine, RedAlloy, 4),
                OreDictUnifier.get(bolt, AnnealedCopper, 4)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                PLASTIC_CIRCUIT_BOARD.getStackForm(1),
                SYSTEM_ON_CHIP.getStackForm(1),
                OreDictUnifier.get(wireFine, RedAlloy, 4),
                OreDictUnifier.get(bolt, AnnealedCopper, 4)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(2400).duration(50)
                .input(PLASTIC_CIRCUIT_BOARD)
                .input(SYSTEM_ON_CHIP)
                .input(wireFine, RedAlloy, 4)
                .input(bolt, AnnealedCopper, 4)
                .output(PROCESSOR_MV, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // IV

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(frameGt, Aluminium, 2),
                WORKSTATION_EV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(2),
                ADVANCED_SMD_CAPACITOR.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireGtSingle, AnnealedCopper, 16)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(288)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(frameGt, Aluminium, 2),
                WORKSTATION_EV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(2),
                ADVANCED_SMD_CAPACITOR.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireGtSingle, AnnealedCopper, 16)
        }, new FluidStack[] {
                Tin.getFluid(576)
        });

        // T4: Nano ====================================================================================================

        // HV
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(1),
                SMD_RESISTOR.getStackForm(8),
                SMD_CAPACITOR.getStackForm(8),
                SMD_TRANSISTOR.getStackForm(8),
                OreDictUnifier.get(wireFine, Electrum, 8)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(1),
                SMD_RESISTOR.getStackForm(8),
                SMD_CAPACITOR.getStackForm(8),
                SMD_TRANSISTOR.getStackForm(8),
                OreDictUnifier.get(wireFine, Electrum, 8)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(1),
                ADVANCED_SMD_RESISTOR.getStackForm(2),
                ADVANCED_SMD_CAPACITOR.getStackForm(2),
                ADVANCED_SMD_TRANSISTOR.getStackForm(2),
                OreDictUnifier.get(wireFine, Electrum, 8)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(1),
                ADVANCED_SMD_RESISTOR.getStackForm(2),
                ADVANCED_SMD_CAPACITOR.getStackForm(2),
                ADVANCED_SMD_TRANSISTOR.getStackForm(2),
                OreDictUnifier.get(wireFine, Electrum, 8)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(200)
                .input(ADVANCED_CIRCUIT_BOARD, 1)
                .input(NANO_CENTRAL_PROCESSING_UNIT, 1)
                .input(SMD_RESISTOR, 8)
                .input(SMD_CAPACITOR, 8)
                .input(SMD_TRANSISTOR, 8)
                .input(wireFine, Electrum, 8)
                .output(NANO_PROCESSOR_HV, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(100)
                .input(ADVANCED_CIRCUIT_BOARD, 1)
                .input(NANO_CENTRAL_PROCESSING_UNIT, 1)
                .input(NANO_SMD_RESISTOR, 2)
                .input(NANO_SMD_CAPACITOR, 2)
                .input(NANO_SMD_TRANSISTOR, 2)
                .input(wireFine, Electrum, 8)
                .output(NANO_PROCESSOR_HV, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // HV SoC

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                ADVANCED_SYSTEM_ON_CHIP.getStackForm(1),
                OreDictUnifier.get(wireFine, Electrum, 4),
                OreDictUnifier.get(bolt, Platinum, 4)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                ADVANCED_SYSTEM_ON_CHIP.getStackForm(1),
                OreDictUnifier.get(wireFine, Electrum, 4),
                OreDictUnifier.get(bolt, Platinum, 4)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(9600).duration(50)
                .input(ADVANCED_CIRCUIT_BOARD)
                .input(ADVANCED_SYSTEM_ON_CHIP)
                .input(wireFine, Electrum, 4)
                .input(bolt, Platinum, 4)
                .output(NANO_PROCESSOR_HV, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
        // EV
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                NANO_PROCESSOR_HV.getStackForm(2),
                SMD_INDUCTOR.getStackForm(4),
                SMD_CAPACITOR.getStackForm(8),
                RANDOM_ACCESS_MEMORY.getStackForm(8),
                OreDictUnifier.get(wireFine, Electrum, 16)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(144)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                NANO_PROCESSOR_HV.getStackForm(2),
                SMD_INDUCTOR.getStackForm(4),
                SMD_CAPACITOR.getStackForm(8),
                RANDOM_ACCESS_MEMORY.getStackForm(8),
                OreDictUnifier.get(wireFine, Electrum, 16)
        }, new FluidStack[] {
                Tin.getFluid(288)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                NANO_PROCESSOR_HV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(1),
                ADVANCED_SMD_CAPACITOR.getStackForm(2),
                RANDOM_ACCESS_MEMORY.getStackForm(8),
                OreDictUnifier.get(wireFine, Electrum, 16)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(144)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                NANO_PROCESSOR_HV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(1),
                ADVANCED_SMD_CAPACITOR.getStackForm(2),
                RANDOM_ACCESS_MEMORY.getStackForm(8),
                OreDictUnifier.get(wireFine, Electrum, 16)
        }, new FluidStack[] {
                Tin.getFluid(288)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(400)
                .input(ADVANCED_CIRCUIT_BOARD)
                .input(NANO_PROCESSOR_HV, 2)
                .input(SMD_INDUCTOR, 8)
                .input(SMD_CAPACITOR, 16)
                .input(RANDOM_ACCESS_MEMORY, 8)
                .input(wireFine, Electrum, 16)
                .output(NANO_PROCESSOR_ASSEMBLY_EV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(200)
                .input(ADVANCED_CIRCUIT_BOARD)
                .input(NANO_PROCESSOR_HV, 2)
                .input(NANO_SMD_INDUCTOR, 2)
                .input(NANO_SMD_CAPACITOR, 4)
                .input(RANDOM_ACCESS_MEMORY, 8)
                .input(wireFine, Electrum, 16)
                .output(NANO_PROCESSOR_ASSEMBLY_EV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // IV
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                NANO_PROCESSOR_ASSEMBLY_EV.getStackForm(2),
                SMD_DIODE.getStackForm(8),
                NOR_MEMORY_CHIP.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireFine, Electrum, 16)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(144)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                NANO_PROCESSOR_ASSEMBLY_EV.getStackForm(2),
                SMD_DIODE.getStackForm(8),
                NOR_MEMORY_CHIP.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireFine, Electrum, 16)
        }, new FluidStack[] {
                Tin.getFluid(288)
        });
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                NANO_PROCESSOR_ASSEMBLY_EV.getStackForm(2),
                ADVANCED_SMD_DIODE.getStackForm(2),
                NOR_MEMORY_CHIP.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireFine, Electrum, 16)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(144)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ADVANCED_CIRCUIT_BOARD.getStackForm(1),
                NANO_PROCESSOR_ASSEMBLY_EV.getStackForm(2),
                ADVANCED_SMD_DIODE.getStackForm(2),
                NOR_MEMORY_CHIP.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireFine, Electrum, 16)
        }, new FluidStack[] {
                Tin.getFluid(288)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(400)
                .input(ADVANCED_CIRCUIT_BOARD)
                .input(NANO_PROCESSOR_ASSEMBLY_EV, 2)
                .input(SMD_DIODE, 8)
                .input(NOR_MEMORY_CHIP, 4)
                .input(RANDOM_ACCESS_MEMORY, 8)
                .input(wireFine, Electrum, 16)
                .output(NANO_COMPUTER_IV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(600).duration(200)
                .input(ADVANCED_CIRCUIT_BOARD)
                .input(NANO_PROCESSOR_ASSEMBLY_EV, 2)
                .input(NANO_SMD_DIODE, 2)
                .input(NOR_MEMORY_CHIP, 4)
                .input(RANDOM_ACCESS_MEMORY, 8)
                .input(wireFine, Electrum, 16)
                .output(NANO_COMPUTER_IV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // LuV
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(frameGt, Aluminium, 2),
                NANO_COMPUTER_IV.getStackForm(2),
                SMD_INDUCTOR.getStackForm(16),
                SMD_CAPACITOR.getStackForm(32),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireGtSingle, AnnealedCopper, 32)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(288)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(frameGt, Aluminium, 2),
                NANO_COMPUTER_IV.getStackForm(2),
                SMD_INDUCTOR.getStackForm(16),
                SMD_CAPACITOR.getStackForm(32),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireGtSingle, AnnealedCopper, 32)
        }, new FluidStack[] {
                Tin.getFluid(576)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(frameGt, Aluminium, 2),
                NANO_COMPUTER_IV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(4),
                ADVANCED_SMD_CAPACITOR.getStackForm(8),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireGtSingle, AnnealedCopper, 32)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(288)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(frameGt, Aluminium, 2),
                NANO_COMPUTER_IV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(4),
                ADVANCED_SMD_CAPACITOR.getStackForm(8),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireGtSingle, AnnealedCopper, 32)
        }, new FluidStack[] {
                Tin.getFluid(576)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[EV]).duration(800)
                .input(frameGt, Aluminium, 2)
                .input(NANO_COMPUTER_IV, 2)
                .input(SMD_INDUCTOR, 16)
                .input(SMD_CAPACITOR, 32)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireGtSingle, AnnealedCopper, 32)
                .output(NANO_MAINFRAME_LUV)
                .solderMultiplier(4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[EV]).duration(400)
                .input(frameGt, Aluminium, 2)
                .input(NANO_COMPUTER_IV, 2)
                .input(NANO_SMD_INDUCTOR, 4)
                .input(NANO_SMD_CAPACITOR, 8)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireGtSingle, AnnealedCopper, 32)
                .output(NANO_MAINFRAME_LUV)
                .solderMultiplier(4)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // T5: Quantum =================================================================================================

        // EV
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                QUBIT_CENTRAL_PROCESSING_UNIT.getStackForm(),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(),
                SMD_CAPACITOR.getStackForm(12),
                SMD_TRANSISTOR.getStackForm(12),
                OreDictUnifier.get(wireFine, Platinum, 12)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                QUBIT_CENTRAL_PROCESSING_UNIT.getStackForm(),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(),
                SMD_CAPACITOR.getStackForm(12),
                SMD_TRANSISTOR.getStackForm(12),
                OreDictUnifier.get(wireFine, Platinum, 12)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                QUBIT_CENTRAL_PROCESSING_UNIT.getStackForm(),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(),
                ADVANCED_SMD_CAPACITOR.getStackForm(12),
                ADVANCED_SMD_TRANSISTOR.getStackForm(12),
                OreDictUnifier.get(wireFine, Platinum, 12)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                QUBIT_CENTRAL_PROCESSING_UNIT.getStackForm(),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(),
                ADVANCED_SMD_CAPACITOR.getStackForm(12),
                ADVANCED_SMD_TRANSISTOR.getStackForm(12),
                OreDictUnifier.get(wireFine, Platinum, 12)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(2400).duration(200)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(QUBIT_CENTRAL_PROCESSING_UNIT)
                .input(NANO_SMD_RESISTOR, 12)
                .input(NANO_SMD_CAPACITOR, 12)
                .input(NANO_SMD_TRANSISTOR, 12)
                .input(wireFine, Platinum, 12)
                .output(QUANTUM_PROCESSOR_EV)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(2400).duration(100)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(QUBIT_CENTRAL_PROCESSING_UNIT)
                .input(QUANTUM_SMD_RESISTOR, 3)
                .input(QUANTUM_SMD_CAPACITOR, 3)
                .input(QUANTUM_SMD_TRANSISTOR, 3)
                .input(wireFine, Platinum, 12)
                .output(QUANTUM_PROCESSOR_EV)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // EV SoC
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                ADVANCED_SYSTEM_ON_CHIP.getStackForm(),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(),
                OreDictUnifier.get(wireFine, Platinum, 12),
                OreDictUnifier.get(bolt, NiobiumTitanium, 8)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                ADVANCED_SYSTEM_ON_CHIP.getStackForm(),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(),
                OreDictUnifier.get(wireFine, Platinum, 12),
                OreDictUnifier.get(bolt, NiobiumTitanium, 8)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(38400).duration(50)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(ADVANCED_SYSTEM_ON_CHIP)
                .input(wireFine, Platinum, 12)
                .input(bolt, NiobiumTitanium, 8)
                .output(QUANTUM_PROCESSOR_EV)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // IV
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                QUANTUM_PROCESSOR_EV.getStackForm(2),
                SMD_INDUCTOR.getStackForm(8),
                SMD_CAPACITOR.getStackForm(16),
                RANDOM_ACCESS_MEMORY.getStackForm(4),
                OreDictUnifier.get(wireFine, Platinum, 16)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(144)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                QUANTUM_PROCESSOR_EV.getStackForm(2),
                SMD_INDUCTOR.getStackForm(8),
                SMD_CAPACITOR.getStackForm(16),
                RANDOM_ACCESS_MEMORY.getStackForm(4),
                OreDictUnifier.get(wireFine, Platinum, 16)
        }, new FluidStack[] {
                Tin.getFluid(288)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                QUANTUM_PROCESSOR_EV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(2),
                ADVANCED_SMD_CAPACITOR.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(4),
                OreDictUnifier.get(wireFine, Platinum, 16)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(144)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                QUANTUM_PROCESSOR_EV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(2),
                ADVANCED_SMD_CAPACITOR.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(4),
                OreDictUnifier.get(wireFine, Platinum, 16)
        }, new FluidStack[] {
                Tin.getFluid(288)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(2400).duration(400)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(QUANTUM_PROCESSOR_EV, 2)
                .input(NANO_SMD_INDUCTOR, 16)
                .input(NANO_SMD_CAPACITOR, 32)
                .input(RANDOM_ACCESS_MEMORY, 4)
                .input(wireFine, Platinum, 16)
                .output(QUANTUM_ASSEMBLY_IV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(2400).duration(200)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(QUANTUM_PROCESSOR_EV, 2)
                .input(QUANTUM_SMD_INDUCTOR, 4)
                .input(QUANTUM_SMD_CAPACITOR, 8)
                .input(RANDOM_ACCESS_MEMORY, 4)
                .input(wireFine, Platinum, 16)
                .output(QUANTUM_ASSEMBLY_IV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // LuV
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                QUANTUM_ASSEMBLY_IV.getStackForm(2),
                SMD_DIODE.getStackForm(8),
                NOR_MEMORY_CHIP.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireFine, Platinum, 32)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(144)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                QUANTUM_ASSEMBLY_IV.getStackForm(2),
                SMD_DIODE.getStackForm(8),
                NOR_MEMORY_CHIP.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireFine, Platinum, 32)
        }, new FluidStack[] {
                Tin.getFluid(288)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                QUANTUM_ASSEMBLY_IV.getStackForm(2),
                ADVANCED_SMD_DIODE.getStackForm(2),
                NOR_MEMORY_CHIP.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireFine, Platinum, 32)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(144)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                EXTREME_CIRCUIT_BOARD.getStackForm(),
                QUANTUM_ASSEMBLY_IV.getStackForm(2),
                ADVANCED_SMD_DIODE.getStackForm(2),
                NOR_MEMORY_CHIP.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(16),
                OreDictUnifier.get(wireFine, Platinum, 32)
        }, new FluidStack[] {
                Tin.getFluid(288)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(2400).duration(400)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(QUANTUM_ASSEMBLY_IV, 2)
                .input(NANO_SMD_DIODE, 12)
                .input(NOR_MEMORY_CHIP, 4)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(wireFine, Platinum, 32)
                .output(QUANTUM_COMPUTER_LUV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(2400).duration(200)
                .input(EXTREME_CIRCUIT_BOARD)
                .input(QUANTUM_ASSEMBLY_IV, 2)
                .input(QUANTUM_SMD_DIODE, 2)
                .input(NOR_MEMORY_CHIP, 4)
                .input(RANDOM_ACCESS_MEMORY, 16)
                .input(wireFine, Platinum, 32)
                .output(QUANTUM_COMPUTER_LUV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // ZPM
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(frameGt, HSSG, 2),
                QUANTUM_COMPUTER_LUV.getStackForm(2),
                SMD_INDUCTOR.getStackForm(24),
                SMD_CAPACITOR.getStackForm(48),
                RANDOM_ACCESS_MEMORY.getStackForm(24),
                OreDictUnifier.get(wireGtSingle, AnnealedCopper, 48)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(288)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(frameGt, HSSG, 2),
                QUANTUM_COMPUTER_LUV.getStackForm(2),
                SMD_INDUCTOR.getStackForm(24),
                SMD_CAPACITOR.getStackForm(48),
                RANDOM_ACCESS_MEMORY.getStackForm(24),
                OreDictUnifier.get(wireGtSingle, AnnealedCopper, 48)
        }, new FluidStack[] {
                Tin.getFluid(576)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(frameGt, HSSG, 2),
                QUANTUM_COMPUTER_LUV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(6),
                ADVANCED_SMD_CAPACITOR.getStackForm(12),
                RANDOM_ACCESS_MEMORY.getStackForm(24),
                OreDictUnifier.get(wireGtSingle, AnnealedCopper, 48)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(288)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                OreDictUnifier.get(frameGt, HSSG, 2),
                QUANTUM_COMPUTER_LUV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(6),
                ADVANCED_SMD_CAPACITOR.getStackForm(12),
                RANDOM_ACCESS_MEMORY.getStackForm(24),
                OreDictUnifier.get(wireGtSingle, AnnealedCopper, 48)
        }, new FluidStack[] {
                Tin.getFluid(576)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[IV]).duration(800)
                .input(frameGt, HSSG, 2)
                .input(QUANTUM_COMPUTER_LUV, 2)
                .input(NANO_SMD_INDUCTOR, 24)
                .input(NANO_SMD_CAPACITOR, 48)
                .input(RANDOM_ACCESS_MEMORY, 48)
                .input(wireGtSingle, AnnealedCopper, 48)
                .solderMultiplier(4)
                .output(QUANTUM_MAINFRAME_ZPM)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(VA[IV]).duration(400)
                .input(frameGt, HSSG, 2)
                .input(QUANTUM_COMPUTER_LUV, 2)
                .input(QUANTUM_SMD_INDUCTOR, 6)
                .input(QUANTUM_SMD_CAPACITOR, 12)
                .input(RANDOM_ACCESS_MEMORY, 48)
                .input(wireGtSingle, AnnealedCopper, 48)
                .solderMultiplier(4)
                .output(QUANTUM_MAINFRAME_ZPM)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // T6: Crystal =================================================================================================

        // IV
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ELITE_CIRCUIT_BOARD.getStackForm(1),
                CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm(1),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(2),
                ADVANCED_SMD_CAPACITOR.getStackForm(6),
                ADVANCED_SMD_TRANSISTOR.getStackForm(6),
                OreDictUnifier.get(wireFine, NiobiumTitanium, 8)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ELITE_CIRCUIT_BOARD.getStackForm(1),
                CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm(1),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(2),
                ADVANCED_SMD_CAPACITOR.getStackForm(6),
                ADVANCED_SMD_TRANSISTOR.getStackForm(6),
                OreDictUnifier.get(wireFine, NiobiumTitanium, 8)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(9600).duration(200)
                .input(ELITE_CIRCUIT_BOARD, 1)
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT, 1)
                .input(QUANTUM_SMD_RESISTOR, 16)
                .input(QUANTUM_SMD_CAPACITOR, 16)
                .input(QUANTUM_SMD_TRANSISTOR, 16)
                .input(wireFine, NiobiumTitanium, 16)
                .output(CRYSTAL_PROCESSOR_IV, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(9600).duration(200)
                .input(ELITE_CIRCUIT_BOARD, 1)
                .input(CRYSTAL_CENTRAL_PROCESSING_UNIT, 1)
                .input(CRYSTAL_SMD_RESISTOR, 4)
                .input(CRYSTAL_SMD_CAPACITOR, 4)
                .input(CRYSTAL_SMD_TRANSISTOR, 4)
                .input(wireFine, NiobiumTitanium, 16)
                .output(CRYSTAL_PROCESSOR_IV, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // IV SoC
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ELITE_CIRCUIT_BOARD.getStackForm(1),
                CRYSTAL_SYSTEM_ON_CHIP.getStackForm(1),
                OreDictUnifier.get(wireFine, NiobiumTitanium, 8),
                OreDictUnifier.get(bolt, YttriumBariumCuprate, 8)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ELITE_CIRCUIT_BOARD.getStackForm(1),
                CRYSTAL_SYSTEM_ON_CHIP.getStackForm(1),
                OreDictUnifier.get(wireFine, NiobiumTitanium, 8),
                OreDictUnifier.get(bolt, YttriumBariumCuprate, 8)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(86000).duration(100)
                .input(ELITE_CIRCUIT_BOARD, 1)
                .input(CRYSTAL_SYSTEM_ON_CHIP, 1)
                .input(wireFine, NiobiumTitanium, 8)
                .input(bolt, YttriumBariumCuprate, 8)
                .output(CRYSTAL_PROCESSOR_IV, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // LuV
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ELITE_CIRCUIT_BOARD.getStackForm(),
                CRYSTAL_PROCESSOR_IV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(4),
                ADVANCED_SMD_CAPACITOR.getStackForm(8),
                RANDOM_ACCESS_MEMORY.getStackForm(24),
                OreDictUnifier.get(wireFine, NiobiumTitanium, 16)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(144)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ELITE_CIRCUIT_BOARD.getStackForm(),
                CRYSTAL_PROCESSOR_IV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(4),
                ADVANCED_SMD_CAPACITOR.getStackForm(8),
                RANDOM_ACCESS_MEMORY.getStackForm(24),
                OreDictUnifier.get(wireFine, NiobiumTitanium, 16)
        }, new FluidStack[] {
                Tin.getFluid(288)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(9600).duration(400)
                .input(ELITE_CIRCUIT_BOARD)
                .input(CRYSTAL_PROCESSOR_IV, 2)
                .input(QUANTUM_SMD_INDUCTOR, 24)
                .input(QUANTUM_SMD_CAPACITOR, 48)
                .input(RANDOM_ACCESS_MEMORY, 24)
                .input(wireFine, NiobiumTitanium, 16)
                .output(CRYSTAL_ASSEMBLY_LUV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(9600).duration(200)
                .input(ELITE_CIRCUIT_BOARD)
                .input(CRYSTAL_PROCESSOR_IV, 2)
                .input(CRYSTAL_SMD_INDUCTOR, 6)
                .input(CRYSTAL_SMD_CAPACITOR, 12)
                .input(RANDOM_ACCESS_MEMORY, 24)
                .input(wireFine, NiobiumTitanium, 16)
                .output(CRYSTAL_ASSEMBLY_LUV)
                .solderMultiplier(2)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // ZPM
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ELITE_CIRCUIT_BOARD.getStackForm(),
                CRYSTAL_ASSEMBLY_LUV.getStackForm(2),
                RANDOM_ACCESS_MEMORY.getStackForm(4),
                NOR_MEMORY_CHIP.getStackForm(32),
                NAND_MEMORY_CHIP.getStackForm(64),
                OreDictUnifier.get(wireFine, NiobiumTitanium, 32)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(144)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                ELITE_CIRCUIT_BOARD.getStackForm(),
                CRYSTAL_ASSEMBLY_LUV.getStackForm(2),
                RANDOM_ACCESS_MEMORY.getStackForm(4),
                NOR_MEMORY_CHIP.getStackForm(32),
                NAND_MEMORY_CHIP.getStackForm(64),
                OreDictUnifier.get(wireFine, NiobiumTitanium, 32)
        }, new FluidStack[] {
                Tin.getFluid(288)
        });
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(9600).duration(400)
                .input(ELITE_CIRCUIT_BOARD)
                .input(CRYSTAL_ASSEMBLY_LUV, 2)
                .input(QUANTUM_SMD_DIODE, 16)
                .input(NOR_MEMORY_CHIP, 32)
                .input(NAND_MEMORY_CHIP, 64)
                .input(wireFine, NiobiumTitanium, 32)
                .solderMultiplier(2)
                .output(CRYSTAL_COMPUTER_ZPM)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(9600).duration(200)
                .input(ELITE_CIRCUIT_BOARD)
                .input(CRYSTAL_ASSEMBLY_LUV, 2)
                .input(CRYSTAL_SMD_DIODE, 4)
                .input(NOR_MEMORY_CHIP, 32)
                .input(NAND_MEMORY_CHIP, 64)
                .input(wireFine, NiobiumTitanium, 32)
                .solderMultiplier(2)
                .output(CRYSTAL_COMPUTER_ZPM)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();
        // UV
        removeRecipesByInputs(ASSEMBLY_LINE_RECIPES, new ItemStack[] {
                OreDictUnifier.get(frameGt, HSSE, 2),
                CRYSTAL_COMPUTER_ZPM.getStackForm(2),
                RANDOM_ACCESS_MEMORY.getStackForm(32),
                HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(2),
                OreDictUnifier.get(wireGtSingle, NiobiumTitanium, 8),
                ADVANCED_SMD_INDUCTOR.getStackForm(8),
                ADVANCED_SMD_CAPACITOR.getStackForm(16),
                ADVANCED_SMD_DIODE.getStackForm(8)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(L * 10)
        });

        ASSEMBLY_LINE_RECIPES.recipeBuilder().EUt(VA[LuV]).duration(800)
                .input(frameGt, HSSE, 2)
                .input(CRYSTAL_COMPUTER_ZPM, 2)
                .input(RANDOM_ACCESS_MEMORY, 64)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(wireGtSingle, NiobiumTitanium, 8)
                .input(QUANTUM_SMD_INDUCTOR, 32)
                .input(QUANTUM_SMD_CAPACITOR, 64)
                .input(QUANTUM_SMD_DIODE, 32)
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .output(CRYSTAL_MAINFRAME_UV)
                .stationResearch(b -> b
                        .researchStack(CRYSTAL_COMPUTER_ZPM.getStackForm())
                        .CWUt(16))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().EUt(VA[LuV]).duration(400)
                .input(frameGt, HSSE, 2)
                .input(CRYSTAL_COMPUTER_ZPM, 2)
                .input(RANDOM_ACCESS_MEMORY, 64)
                .input(HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .input(wireGtSingle, NiobiumTitanium, 8)
                .input(CRYSTAL_SMD_INDUCTOR, 8)
                .input(CRYSTAL_SMD_CAPACITOR, 16)
                .input(CRYSTAL_SMD_DIODE, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 10))
                .output(CRYSTAL_MAINFRAME_UV)
                .stationResearch(b -> b
                        .researchStack(CRYSTAL_COMPUTER_ZPM.getStackForm())
                        .CWUt(16))
                .buildAndRegister();

        // T7: Wetware =================================================================================================

        // LuV
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                NEURO_PROCESSOR.getStackForm(1),
                CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm(1),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(1),
                ADVANCED_SMD_CAPACITOR.getStackForm(8),
                ADVANCED_SMD_TRANSISTOR.getStackForm(8),
                OreDictUnifier.get(wireFine, YttriumBariumCuprate, 8)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                NEURO_PROCESSOR.getStackForm(1),
                CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm(1),
                NANO_CENTRAL_PROCESSING_UNIT.getStackForm(1),
                ADVANCED_SMD_CAPACITOR.getStackForm(8),
                ADVANCED_SMD_TRANSISTOR.getStackForm(8),
                OreDictUnifier.get(wireFine, YttriumBariumCuprate, 8)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(38400).duration(200)
                .input(NEURO_PROCESSOR, 1)
                .input(WETWARE_CENTRAL_PROCESSING_UNIT, 1)
                .input(CRYSTAL_SMD_RESISTOR, 20)
                .input(CRYSTAL_SMD_CAPACITOR, 20)
                .input(CRYSTAL_SMD_TRANSISTOR, 20)
                .input(wireFine, YttriumBariumCuprate, 20)
                .output(WETWARE_PROCESSOR_LUV, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(38400).duration(100)
                .input(NEURO_PROCESSOR)
                .input(WETWARE_CENTRAL_PROCESSING_UNIT)
                .input(ADVANCED_SMD_RESISTOR, 5)
                .input(ADVANCED_SMD_CAPACITOR, 5)
                .input(ADVANCED_SMD_TRANSISTOR, 5)
                .input(wireFine, YttriumBariumCuprate, 20)
                .output(WETWARE_PROCESSOR_LUV, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // SoC LuV
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                NEURO_PROCESSOR.getStackForm(1),
                HIGHLY_ADVANCED_SOC.getStackForm(1),
                OreDictUnifier.get(wireFine, YttriumBariumCuprate, 8),
                OreDictUnifier.get(bolt, Naquadah, 8)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(72)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                NEURO_PROCESSOR.getStackForm(1),
                HIGHLY_ADVANCED_SOC.getStackForm(1),
                OreDictUnifier.get(wireFine, YttriumBariumCuprate, 8),
                OreDictUnifier.get(bolt, Naquadah, 8)
        }, new FluidStack[] {
                Tin.getFluid(144)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(150000).duration(100)
                .input(NEURO_PROCESSOR, 1)
                .input(HIGHLY_ADVANCED_SOC, 1)
                .input(wireFine, YttriumBariumCuprate, 8)
                .input(bolt, Naquadah, 8)
                .output(WETWARE_PROCESSOR_LUV, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // ZPM
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                WETWARE_CIRCUIT_BOARD.getStackForm(1),
                WETWARE_PROCESSOR_LUV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(6),
                ADVANCED_SMD_CAPACITOR.getStackForm(12),
                RANDOM_ACCESS_MEMORY.getStackForm(24),
                OreDictUnifier.get(wireFine, YttriumBariumCuprate, 16),
        }, new FluidStack[] {
                SolderingAlloy.getFluid(144)
        });

        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[] {
                WETWARE_CIRCUIT_BOARD.getStackForm(1),
                WETWARE_PROCESSOR_LUV.getStackForm(2),
                ADVANCED_SMD_INDUCTOR.getStackForm(6),
                ADVANCED_SMD_CAPACITOR.getStackForm(12),
                RANDOM_ACCESS_MEMORY.getStackForm(24),
                OreDictUnifier.get(wireFine, YttriumBariumCuprate, 16),
        }, new FluidStack[] {
                Tin.getFluid(288)
        });

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(38400).duration(400)
                .input(WETWARE_CIRCUIT_BOARD)
                .input(WETWARE_PROCESSOR_LUV, 2)
                .input(CRYSTAL_SMD_INDUCTOR, 32)
                .input(CRYSTAL_SMD_CAPACITOR, 64)
                .input(RANDOM_ACCESS_MEMORY, 24)
                .input(wireFine, YttriumBariumCuprate, 16)
                .solderMultiplier(2)
                .output(WETWARE_PROCESSOR_ASSEMBLY_ZPM)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(38400).duration(400)
                .input(WETWARE_CIRCUIT_BOARD)
                .input(WETWARE_PROCESSOR_LUV, 2)
                .input(ADVANCED_SMD_INDUCTOR, 8)
                .input(ADVANCED_SMD_CAPACITOR, 16)
                .input(RANDOM_ACCESS_MEMORY, 24)
                .input(wireFine, YttriumBariumCuprate, 16)
                .solderMultiplier(2)
                .output(WETWARE_PROCESSOR_ASSEMBLY_ZPM)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // UV
        removeRecipesByInputs(ASSEMBLY_LINE_RECIPES, new ItemStack[] {
                WETWARE_CIRCUIT_BOARD.getStackForm(1),
                WETWARE_PROCESSOR_ASSEMBLY_ZPM.getStackForm(2),
                ADVANCED_SMD_DIODE.getStackForm(8),
                NOR_MEMORY_CHIP.getStackForm(16),
                RANDOM_ACCESS_MEMORY.getStackForm(32),
                OreDictUnifier.get(wireFine, YttriumBariumCuprate, 24),
                OreDictUnifier.get(foil, Polybenzimidazole, 32),
                OreDictUnifier.get(plate, Europium, 4)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(1152)
        });

        ASSEMBLY_LINE_RECIPES.recipeBuilder().EUt(38400).duration(400)
                .input(WETWARE_CIRCUIT_BOARD)
                .input(WETWARE_PROCESSOR_ASSEMBLY_ZPM, 2)
                .input(CRYSTAL_SMD_DIODE, 32)
                .input(NOR_MEMORY_CHIP, 32)
                .input(RANDOM_ACCESS_MEMORY, 64)
                .input(wireFine, YttriumBariumCuprate, 24)
                .input(foil, Polybenzimidazole, 32)
                .input(plate, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1152))
                .fluidInputs(SterileGrowthMedium.getFluid(2000))
                .output(WETWARE_SUPER_COMPUTER_UV)
                .stationResearch(b -> b
                        .researchStack(WETWARE_PROCESSOR_ASSEMBLY_ZPM.getStackForm())
                        .CWUt(16))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().EUt(38400).duration(200)
                .input(WETWARE_CIRCUIT_BOARD)
                .input(WETWARE_PROCESSOR_ASSEMBLY_ZPM, 2)
                .input(ADVANCED_SMD_DIODE, 8)
                .input(NOR_MEMORY_CHIP, 32)
                .input(RANDOM_ACCESS_MEMORY, 64)
                .input(wireFine, YttriumBariumCuprate, 24)
                .input(foil, Polybenzimidazole, 32)
                .input(plate, Europium, 4)
                .fluidInputs(SolderingAlloy.getFluid(1152))
                .fluidInputs(SterileGrowthMedium.getFluid(2000))
                .output(WETWARE_SUPER_COMPUTER_UV)
                .stationResearch(b -> b
                        .researchStack(WETWARE_PROCESSOR_ASSEMBLY_ZPM.getStackForm())
                        .CWUt(16))
                .buildAndRegister();

        // UHV
        removeRecipesByInputs(ASSEMBLY_LINE_RECIPES, new ItemStack[] {
                OreDictUnifier.get(frameGt, Tritanium, 2),
                WETWARE_SUPER_COMPUTER_UV.getStackForm(2),
                ADVANCED_SMD_DIODE.getStackForm(32),
                ADVANCED_SMD_CAPACITOR.getStackForm(32),
                ADVANCED_SMD_TRANSISTOR.getStackForm(32),
                ADVANCED_SMD_RESISTOR.getStackForm(32),
                ADVANCED_SMD_INDUCTOR.getStackForm(32),
                OreDictUnifier.get(foil, Polybenzimidazole, 64),
                RANDOM_ACCESS_MEMORY.getStackForm(32),
                OreDictUnifier.get(wireGtDouble, EnrichedNaquadahTriniumEuropiumDuranide, 16),
                OreDictUnifier.get(plate, Europium, 8)
        }, new FluidStack[] {
                SolderingAlloy.getFluid(L * 20),
                Polybenzimidazole.getFluid(L * 8)
        });

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Tritanium, 2)
                .input(WETWARE_SUPER_COMPUTER_UV, 2)
                .input(CRYSTAL_SMD_DIODE, 48)
                .input(CRYSTAL_SMD_CAPACITOR, 48)
                .input(CRYSTAL_SMD_CAPACITOR, 48)
                .input(CRYSTAL_SMD_TRANSISTOR, 48)
                .input(CRYSTAL_SMD_RESISTOR, 48)
                .input(CRYSTAL_SMD_INDUCTOR, 48)
                .input(foil, Polybenzimidazole, 64)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireGtDouble, EnrichedNaquadahTriniumEuropiumDuranide, 16)
                .input(plate, Europium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(Polybenzimidazole.getFluid(L * 8))
                .fluidInputs(SterileGrowthMedium.getFluid(4000))
                .output(WETWARE_MAINFRAME_UHV)
                .stationResearch(b -> b
                        .researchStack(WETWARE_SUPER_COMPUTER_UV.getStackForm())
                        .CWUt(96)
                        .EUt(VA[UV]))
                .EUt(300000).duration(2000).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, Tritanium, 2)
                .input(WETWARE_SUPER_COMPUTER_UV, 2)
                .input(ADVANCED_SMD_DIODE, 12)
                .input(ADVANCED_SMD_CAPACITOR, 12)
                .input(ADVANCED_SMD_CAPACITOR, 12)
                .input(ADVANCED_SMD_TRANSISTOR, 12)
                .input(ADVANCED_SMD_RESISTOR, 12)
                .input(ADVANCED_SMD_INDUCTOR, 12)
                .input(foil, Polybenzimidazole, 64)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireGtDouble, EnrichedNaquadahTriniumEuropiumDuranide, 16)
                .input(plate, Europium, 8)
                .fluidInputs(SolderingAlloy.getFluid(L * 20))
                .fluidInputs(Polybenzimidazole.getFluid(L * 8))
                .fluidInputs(SterileGrowthMedium.getFluid(4000))
                .output(WETWARE_MAINFRAME_UHV)
                .researchWithoutRecipe("wetware_super_computer_uv")
                .EUt(300000).duration(2000).buildAndRegister();

        // T8: Slimeware
        // =================================================================================================

        // Slime Processing Unit
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(32000).duration(800)
                .input(SLIMEWARE_CIRCUIT_BOARD, 1)
                .input(SLIME_CELL, 16)
                .input(pipeNormalFluid, Polybenzimidazole, 8)
                .input(plate, BlueSteel, 8)
                .input(foil, SiliconeRubber, 16)
                .input(bolt, HSSS, 8)
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(250))
                .output(SLIME_PROCESSOR, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // ZPM
        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(153600).duration(200)
                .input(SLIME_PROCESSOR, 1)
                .input(SLIMEWARE_CENTRAL_PROCESSING_UNIT, 1)
                .input(ADVANCED_SMD_RESISTOR, 24)
                .input(ADVANCED_SMD_CAPACITOR, 24)
                .input(ADVANCED_SMD_TRANSISTOR, 24)
                .input(wireFine, Europium, 24)
                .output(SLIMEWARE_PROCESSOR_ZPM, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().EUt(153600).duration(200)
                .input(SLIME_PROCESSOR, 1)
                .input(SLIMEWARE_CENTRAL_PROCESSING_UNIT, 1)
                .input(SLIMEWARE_SMD_RESISTOR, 6)
                .input(SLIMEWARE_SMD_CAPACITOR, 6)
                .input(SLIMEWARE_SMD_TRANSISTOR, 6)
                .input(wireFine, Europium, 24)
                .output(SLIMEWARE_PROCESSOR_ZPM, 1)
                .cleanroom(CleanroomType.CLEANROOM)
                .buildAndRegister();

        // UV
        ASSEMBLY_LINE_RECIPES.recipeBuilder().EUt(38400).duration(400)
                .input(SLIMEWARE_CIRCUIT_BOARD, 1)
                .input(SLIMEWARE_PROCESSOR_ZPM, 2)
                .input(ADVANCED_SMD_INDUCTOR, 48)
                .input(ADVANCED_SMD_CAPACITOR, 48)
                .input(ADVANCED_SMD_CAPACITOR, 48)
                .input(ADVANCED_SMD_DIODE, 32)
                .input(RANDOM_ACCESS_MEMORY, 24)
                .input(wireFine, CosmicNeutronium, 24)
                .fluidInputs(SlimeSolder.getFluid(L * 8))
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(500))
                .output(SLIMEWARE_ASSEMBLY_UV, 1)
                .stationResearch(b -> b
                        .researchStack(SLIMEWARE_PROCESSOR_ZPM.getStackForm())
                        .CWUt(16))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().EUt(38400).duration(400)
                .input(SLIMEWARE_CIRCUIT_BOARD, 1)
                .input(SLIMEWARE_PROCESSOR_ZPM, 2)
                .input(SLIMEWARE_SMD_INDUCTOR, 12)
                .input(SLIMEWARE_SMD_CAPACITOR, 12)
                .input(SLIMEWARE_SMD_CAPACITOR, 12)
                .input(SLIMEWARE_SMD_DIODE, 4)
                .input(RANDOM_ACCESS_MEMORY, 24)
                .input(wireFine, CosmicNeutronium, 24)
                .fluidInputs(SlimeSolder.getFluid(L * 8))
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(500))
                .output(SLIMEWARE_ASSEMBLY_UV, 1)
                .researchWithoutRecipe("slimeware_processor_zpm")
                .buildAndRegister();

        // UHV
        ASSEMBLY_LINE_RECIPES.recipeBuilder().EUt(38400).duration(400)
                .input(SLIMEWARE_CIRCUIT_BOARD, 1)
                .input(SLIMEWARE_ASSEMBLY_UV, 2)
                .input(ADVANCED_SMD_DIODE, 48)
                .input(NOR_MEMORY_CHIP, 16)
                .input(NAND_MEMORY_CHIP, 32)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireFine, CosmicNeutronium, 24)
                .input(foil, SiliconeRubber, 16)
                .input(foil, Polybenzimidazole, 32)
                .input(plate, Europium, 4)
                .fluidInputs(SlimeSolder.getFluid(L * 8))
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(1000))
                .output(SLIMEWARE_COMPUTER_UHV, 1)
                .stationResearch(b -> b
                        .researchStack(SLIMEWARE_ASSEMBLY_UV.getStackForm())
                        .CWUt(16))
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder().EUt(38400).duration(400)
                .input(SLIMEWARE_CIRCUIT_BOARD, 1)
                .input(SLIMEWARE_ASSEMBLY_UV, 2)
                .input(SLIMEWARE_SMD_DIODE, 12)
                .input(NOR_MEMORY_CHIP, 16)
                .input(NAND_MEMORY_CHIP, 32)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireFine, CosmicNeutronium, 24)
                .input(foil, SiliconeRubber, 16)
                .input(foil, Polybenzimidazole, 32)
                .input(plate, Europium, 4)
                .fluidInputs(SlimeSolder.getFluid(L * 8))
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(1000))
                .output(SLIMEWARE_COMPUTER_UHV, 1)
                .researchWithoutRecipe("slimeware_assembly_uv")
                .buildAndRegister();

        // UEV
        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium, 2)
                .input(SLIMEWARE_COMPUTER_UHV, 2)
                .input(ADVANCED_SMD_DIODE, 64)
                .input(ADVANCED_SMD_CAPACITOR, 64)
                .input(ADVANCED_SMD_CAPACITOR, 64)
                .input(ADVANCED_SMD_TRANSISTOR, 64)
                .input(ADVANCED_SMD_RESISTOR, 64)
                .input(ADVANCED_SMD_INDUCTOR, 64)
                .input(foil, Polybenzimidazole, 64)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 16)
                .input(plate, Europium, 8)
                .fluidInputs(SlimeSolder.getFluid(L * 20))
                .fluidInputs(Polybenzimidazole.getFluid(L * 8))
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(2000))
                .output(SLIMEWARE_MAINFRAME_UEV, 1)
                .stationResearch(b -> b
                        .researchStack(SLIMEWARE_COMPUTER_UHV.getStackForm())
                        .CWUt(96)
                        .EUt(VA[UV]))
                .EUt(300000).duration(2000).buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(frameGt, CosmicNeutronium, 2)
                .input(SLIMEWARE_COMPUTER_UHV, 2)
                .input(SLIMEWARE_SMD_DIODE, 16)
                .input(SLIMEWARE_SMD_CAPACITOR, 16)
                .input(SLIMEWARE_SMD_CAPACITOR, 16)
                .input(SLIMEWARE_SMD_TRANSISTOR, 16)
                .input(SLIMEWARE_SMD_RESISTOR, 16)
                .input(SLIMEWARE_SMD_INDUCTOR, 16)
                .input(foil, Polybenzimidazole, 64)
                .input(RANDOM_ACCESS_MEMORY, 32)
                .input(wireGtDouble, RutheniumTriniumAmericiumNeutronate, 16)
                .input(plate, Europium, 8)
                .fluidInputs(SlimeSolder.getFluid(L * 20))
                .fluidInputs(Polybenzimidazole.getFluid(L * 8))
                .fluidInputs(SterileSlimeGrowthMedium.getFluid(2000))
                .output(SLIMEWARE_MAINFRAME_UEV, 1)
                .researchWithoutRecipe("slimeware_computer_uhv")
                .EUt(300000).duration(2000).buildAndRegister();
    }
}
