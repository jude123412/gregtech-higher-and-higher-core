package org.gthhcore.loaders.recipe.handlers;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static org.gthhcore.api.recipes.GTHHRecipeMaps.*;
import static org.gthhcore.api.unification.ore.GTHHOrePrefix.*;
import static org.gthhcore.common.items.GTHHMetaItems.*;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import org.gthhcore.api.unification.material.info.GTHHMaterialFlags;
import org.gthhcore.api.util.GTHHValues;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.DustProperty;
import gregtech.api.unification.material.properties.IngotProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;

public class GTHHMaterialRecipeHandler {

    static void register() {
        dust.addProcessingHandler(PropertyKey.BLAST, GTHHMaterialRecipeHandler::processEBFRecipe);
        dust.addProcessingHandler(PropertyKey.BLAST, GTHHMaterialRecipeHandler::processRawMaterial);
        dust.addProcessingHandler(PropertyKey.DUST, GTHHMaterialRecipeHandler::processFuelRod);

        plate.addProcessingHandler(PropertyKey.DUST, GTHHMaterialRecipeHandler::processCompressed);
    }

    static void processEBFRecipe(OrePrefix dustPrefix, Material material, BlastProperty property) {
        boolean hasHotIngot = OrePrefix.ingotHot.doGenerateItem(material);
        ItemStack ingotStack = OreDictUnifier.get(hasHotIngot ? OrePrefix.ingotHot : OrePrefix.ingot, material);

        int blastTemp = property.getBlastTemperature();
        int duration = property.getDurationOverride();
        int energy = property.getEUtOverride();
        int vacuumEnergy = property.getVacuumEUtOverride() != -1 ? property.getVacuumEUtOverride() : VA[MV];
        int vacuumDuration = property.getVacuumDurationOverride() != -1 ? property.getVacuumDurationOverride() :
                (int) material.getMass() * 3;

        IngotProperty ingotProperty = material.getProperty(PropertyKey.INGOT);

        if (duration <= 0) {
            duration = Math.max(1, (int) (material.getMass() * blastTemp / 50L));
        }

        if (energy <= 0) {
            energy = VA[MV];
        }

        // Recipe Removal to solve Conflicts in Electric Blast Furnace
        // Must Be run Before Processing Handler Recipes are made!
        // Removes all Recipes that produce an Ingot or Hot Ingot With either Programmed Circuit 1 or 2

        if (blastTemp > 0) {

            removeRecipesByInputs(BLAST_RECIPES, new ItemStack[] {
                    OreDictUnifier.get(dust, material),
                    IntCircuitIngredient.getIntegratedCircuit(1)
            });

            removeRecipesByInputs(BLAST_RECIPES, new ItemStack[] {
                    OreDictUnifier.get(dust, material),
                    IntCircuitIngredient.getIntegratedCircuit(2)
            }, new FluidStack[] {
                    Nitrogen.getFluid(1000)
            });

            removeRecipesByInputs(BLAST_RECIPES, new ItemStack[] {
                    OreDictUnifier.get(dust, material),
                    IntCircuitIngredient.getIntegratedCircuit(2)
            }, new FluidStack[] {
                    Helium.getFluid(100)
            });

            removeRecipesByInputs(BLAST_RECIPES, new ItemStack[] {
                    OreDictUnifier.get(dust, material),
                    IntCircuitIngredient.getIntegratedCircuit(2)
            }, new FluidStack[] {
                    Argon.getFluid(50)
            });

            removeRecipesByInputs(BLAST_RECIPES, new ItemStack[] {
                    OreDictUnifier.get(dust, material),
                    IntCircuitIngredient.getIntegratedCircuit(2)
            }, new FluidStack[] {
                    Neon.getFluid(25)
            });

            removeRecipesByInputs(BLAST_RECIPES, new ItemStack[] {
                    OreDictUnifier.get(dust, material),
                    IntCircuitIngredient.getIntegratedCircuit(2)
            }, new FluidStack[] {
                    Krypton.getFluid(10)
            });

            removeRecipesByInputs(VACUUM_RECIPES, new ItemStack[] {
                    OreDictUnifier.get(ingotHot, material),
            }, new FluidStack[] {
                    Helium.getFluid(FluidStorageKeys.LIQUID, 500)
            });

            if (ingotProperty.getMagneticMaterial() != null) {
                removeRecipesByInputs(BLAST_RECIPES, new ItemStack[] {
                        OreDictUnifier.get(dust, ingotProperty.getMagneticMaterial()),
                        IntCircuitIngredient.getIntegratedCircuit(1)
                });

                removeRecipesByInputs(BLAST_RECIPES, new ItemStack[] {
                        OreDictUnifier.get(dust, ingotProperty.getMagneticMaterial()),
                        IntCircuitIngredient.getIntegratedCircuit(2)
                }, new FluidStack[] {
                        Nitrogen.getFluid(1000)
                });

                removeRecipesByInputs(BLAST_RECIPES, new ItemStack[] {
                        OreDictUnifier.get(dust, ingotProperty.getMagneticMaterial()),
                        IntCircuitIngredient.getIntegratedCircuit(2)
                }, new FluidStack[] {
                        Helium.getFluid(100)
                });

                removeRecipesByInputs(BLAST_RECIPES, new ItemStack[] {
                        OreDictUnifier.get(dust, ingotProperty.getMagneticMaterial()),
                        IntCircuitIngredient.getIntegratedCircuit(2)
                }, new FluidStack[] {
                        Argon.getFluid(50)
                });

                removeRecipesByInputs(BLAST_RECIPES, new ItemStack[] {
                        OreDictUnifier.get(dust, ingotProperty.getMagneticMaterial()),
                        IntCircuitIngredient.getIntegratedCircuit(2)
                }, new FluidStack[] {
                        Neon.getFluid(25)
                });

                removeRecipesByInputs(BLAST_RECIPES, new ItemStack[] {
                        OreDictUnifier.get(dust, ingotProperty.getMagneticMaterial()),
                        IntCircuitIngredient.getIntegratedCircuit(2)
                }, new FluidStack[] {
                        Krypton.getFluid(10)
                });
            }
        }

        // New Magnetic Material Smelting
        if (blastTemp > 0 && ingotProperty.getMagneticMaterial() != null) {
            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, ingotProperty.getMagneticMaterial(), 1)
                    .outputs(ingotStack)
                    .circuitMeta(1)
                    .blastFurnaceTemp(blastTemp)
                    .duration(duration).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, ingotProperty.getMagneticMaterial(), 1)
                    .outputs(ingotStack)
                    .fluidInputs(Nitrogen.getFluid(1000))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.90)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, ingotProperty.getMagneticMaterial(), 1)
                    .outputs(ingotStack)
                    .fluidInputs(Helium.getFluid(900))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.80)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, ingotProperty.getMagneticMaterial(), 1)
                    .outputs(ingotStack)
                    .fluidInputs(Neon.getFluid(800))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.70)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, ingotProperty.getMagneticMaterial(), 1)
                    .outputs(ingotStack)
                    .fluidInputs(Argon.getFluid(700))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.60)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, ingotProperty.getMagneticMaterial(), 1)
                    .outputs(ingotStack)
                    .fluidInputs(Krypton.getFluid(600))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.50)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, ingotProperty.getMagneticMaterial(), 1)
                    .outputs(ingotStack)
                    .fluidInputs(Xenon.getFluid(500))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.40)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, ingotProperty.getMagneticMaterial(), 1)
                    .outputs(ingotStack)
                    .fluidInputs(Oganesson.getFluid(250))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.25)).EUt(energy)
                    .buildAndRegister();
        }

        if (blastTemp > 0 && material.hasFlag(GTHHMaterialFlags.GENERATE_RAW)) {
            BLAST_RECIPES.recipeBuilder()
                    .input(raw, material)
                    .outputs(ingotStack)
                    .circuitMeta(1)
                    .blastFurnaceTemp(blastTemp)
                    .duration(duration).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(raw, material)
                    .outputs(ingotStack)
                    .fluidInputs(Nitrogen.getFluid(1000))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.90)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(raw, material)
                    .outputs(ingotStack)
                    .fluidInputs(Helium.getFluid(900))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.80)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(raw, material)
                    .outputs(ingotStack)
                    .fluidInputs(Neon.getFluid(800))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.70)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(raw, material)
                    .outputs(ingotStack)
                    .fluidInputs(Argon.getFluid(700))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.60)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(raw, material)
                    .outputs(ingotStack)
                    .fluidInputs(Krypton.getFluid(600))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.50)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(raw, material)
                    .outputs(ingotStack)
                    .fluidInputs(Xenon.getFluid(500))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.40)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(raw, material)
                    .outputs(ingotStack)
                    .fluidInputs(Oganesson.getFluid(250))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.25)).EUt(energy)
                    .buildAndRegister();

            VACUUM_RECIPES.recipeBuilder()
                    .input(ingotHot, material, 1)
                    .output(ingot, material, 1)
                    .duration(vacuumDuration)
                    .EUt(vacuumEnergy)
                    .buildAndRegister();
        }

        if (blastTemp > 0 && !material.hasFlag(GTHHMaterialFlags.GENERATE_RAW)) {
            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 1)
                    .outputs(ingotStack)
                    .circuitMeta(1)
                    .blastFurnaceTemp(blastTemp)
                    .duration(duration).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 1)
                    .outputs(ingotStack)
                    .fluidInputs(Nitrogen.getFluid(1000))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.90)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 1)
                    .outputs(ingotStack)
                    .fluidInputs(Helium.getFluid(900))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.80)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 1)
                    .outputs(ingotStack)
                    .fluidInputs(Neon.getFluid(800))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.70)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 1)
                    .outputs(ingotStack)
                    .fluidInputs(Argon.getFluid(700))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.60)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 1)
                    .outputs(ingotStack)
                    .fluidInputs(Krypton.getFluid(600))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.50)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 1)
                    .outputs(ingotStack)
                    .fluidInputs(Xenon.getFluid(500))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.40)).EUt(energy)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 1)
                    .outputs(ingotStack)
                    .fluidInputs(Oganesson.getFluid(250))
                    .circuitMeta(2)
                    .blastFurnaceTemp(blastTemp)
                    .duration((int) (duration * 0.25)).EUt(energy)
                    .buildAndRegister();

            VACUUM_RECIPES.recipeBuilder()
                    .input(ingotHot, material, 1)
                    .output(ingot, material, 1)
                    .duration(vacuumDuration)
                    .EUt(vacuumEnergy)
                    .buildAndRegister();

        }
    }

    static void processRawMaterial(OrePrefix dustPrefix, Material material, BlastProperty property) {
        int blastTemp = property.getBlastTemperature();
        int energy = property.getEUtOverride();
        int duration = property.getDurationOverride();

        if (energy <= 0) {
            energy = VA[MV];
        }

        if (duration <= 0) {
            duration = Math.max(1, (int) (material.getMass() * blastTemp / 50L));
        }

        if (material.hasFlag(GTHHMaterialFlags.GENERATE_RAW) && blastTemp <= 1750) {

            COMPRESSOR_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 1)
                    .output(raw, material)
                    .duration(400)
                    .EUt(2)
                    .buildAndRegister();

        } else if (material.hasFlag(GTHHMaterialFlags.GENERATE_RAW) && blastTemp > 1750) {

            IMPLOSION_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 1)
                    .output(raw, material)
                    .fluidInputs(Helium.getPlasma(125))
                    .explosivesType(new ItemStack(MetaBlocks.POWDERBARREL, 64))
                    .duration((int) (duration * 0.25))
                    .EUt(energy)
                    .buildAndRegister();

            IMPLOSION_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 1)
                    .output(raw, material)
                    .fluidInputs(Helium.getPlasma(125))
                    .explosivesAmount(32)
                    .duration((int) (duration * 0.25))
                    .EUt(energy)
                    .buildAndRegister();

            IMPLOSION_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 1)
                    .output(raw, material)
                    .fluidInputs(Helium.getPlasma(125))
                    .explosivesType(MetaItems.DYNAMITE.getStackForm(16))
                    .duration((int) (duration * 0.25))
                    .EUt(energy)
                    .buildAndRegister();

            IMPLOSION_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 1)
                    .output(raw, material)
                    .fluidInputs(Helium.getPlasma(125))
                    .explosivesType(new ItemStack(MetaBlocks.ITNT, 8))
                    .duration((int) (duration * 0.25))
                    .EUt(energy)
                    .buildAndRegister();

        }
    }

    static void processFuelRod(OrePrefix dustPrefix, Material material, DustProperty property) {
        if (material.hasFlag(GTHHMaterialFlags.GENERATE_ROD_FUEL)) {
            CANNER_RECIPES.recipeBuilder()
                    .input(dustPrefix, material, 4)
                    .input(FUEL_ROD)
                    .output(rodFuelSingle, material)
                    .duration(GTHHValues.second * 20)
                    .EUt(VA[LV])
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .duration(GTHHValues.second * 4).EUt(VA[LV])
                    .input(rodFuelSingle, material, 2)
                    .input(stickLong, Steel, 2)
                    .output(rodFuelDual, material)
                    .circuitMeta(2)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .duration(GTHHValues.second * 4).EUt(VA[LV])
                    .input(rodFuelSingle, material, 2)
                    .input(stickLong, Steel, 4)
                    .output(rodFuelQuad, material)
                    .circuitMeta(4)
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder()
                    .duration(GTHHValues.second * 4).EUt(VA[LV])
                    .input(rodFuelDual, material, 2)
                    .input(stickLong, Steel, 2)
                    .output(rodFuelQuad, material)
                    .circuitMeta(4)
                    .buildAndRegister();

            // Auto-generated Breeder Recipes
            BREEDER_RECIPES.recipeBuilder()
                    .duration(GTHHValues.second * 600).EUt(VA[LuV])
                    .input(rodFuelSingle, material)
                    .output(rodDepletedSingle, material)
                    .buildAndRegister();

            BREEDER_RECIPES.recipeBuilder()
                    .duration(GTHHValues.second * 1200).EUt(VA[LuV])
                    .input(rodFuelDual, material)
                    .output(rodDepletedDual, material)
                    .buildAndRegister();

            BREEDER_RECIPES.recipeBuilder()
                    .duration(GTHHValues.second * 2400).EUt(VA[LuV])
                    .input(rodFuelQuad, material)
                    .output(rodDepletedQuad, material)
                    .buildAndRegister();
        }
    }

    static void processCompressed(OrePrefix platePrefix, Material material, DustProperty property) {
        if (material.hasFlag(GTHHMaterialFlags.GENERATE_COMPRESSED) && material.hasProperty(PropertyKey.DUST)) {
            IMPLOSION_RECIPES.recipeBuilder()
                    .duration(GTHHValues.second * 60).EUt(VA[LV])
                    .circuitMeta(3)
                    .input(platePrefix, material, 3)
                    .output(compressed, material)
                    .chancedOutput(dust, DarkAsh, 2500, 0)
                    .explosivesType(new ItemStack(MetaBlocks.POWDERBARREL, 16))
                    .buildAndRegister();

            IMPLOSION_RECIPES.recipeBuilder()
                    .duration(GTHHValues.second * 60).EUt(VA[LV])
                    .circuitMeta(3)
                    .input(platePrefix, material, 3)
                    .output(compressed, material)
                    .chancedOutput(dust, DarkAsh, 2500, 0)
                    .explosivesAmount(8)
                    .buildAndRegister();

            IMPLOSION_RECIPES.recipeBuilder()
                    .duration(GTHHValues.second * 60).EUt(VA[LV])
                    .circuitMeta(3)
                    .input(platePrefix, material, 3)
                    .output(compressed, material)
                    .chancedOutput(dust, DarkAsh, 2500, 0)
                    .explosivesType(MetaItems.DYNAMITE.getStackForm(4))
                    .buildAndRegister();

            IMPLOSION_RECIPES.recipeBuilder()
                    .duration(GTHHValues.second * 60).EUt(VA[LV])
                    .circuitMeta(3)
                    .input(platePrefix, material, 3)
                    .output(compressed, material)
                    .chancedOutput(dust, DarkAsh, 2500, 0)
                    .explosivesType(new ItemStack(MetaBlocks.ITNT))
                    .buildAndRegister();
        }
    }
}
