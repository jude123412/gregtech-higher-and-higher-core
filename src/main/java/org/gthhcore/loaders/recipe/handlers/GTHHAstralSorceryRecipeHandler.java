package org.gthhcore.loaders.recipe.handlers;

import com.cleanroommc.groovyscript.helper.ingredient.IngredientHelper;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import org.apache.commons.lang3.tuple.Pair;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static org.gthhcore.api.unification.ore.GTHHOrePrefix.*;
import static org.gthhcore.api.util.GTHHMods.*;
import static org.gthhcore.loaders.recipe.helper.AstralSorceryRecipeHelper.*;

public class GTHHAstralSorceryRecipeHandler {

    public static void register() {
        fragment.addProcessingHandler(PropertyKey.ORE, GTHHAstralSorceryRecipeHandler::processFragment);
    }

    private static void processFragment(OrePrefix fragmentPrefix, Material material, OreProperty property) {


            if (Botania.isModLoaded()) {
                INFUSION_ALTER_RECIPES.recipeBuilder()
                        .consumption(1.0f)
                        .time(10)
                        .input(IngredientHelper.toIIngredient(OreDictUnifier.get(glob, material, 1)))
                        .output(OreDictUnifier.get(fragment, material, 2))
                        .register();
            }

        if (!Botania.isModLoaded()) {
            INFUSION_ALTER_RECIPES.recipeBuilder()
                    .consumption(1.0f)
                    .time(10)
                    .input(IngredientHelper.toIIngredient(OreDictUnifier.get(cluster, material, 1)))
                    .output(OreDictUnifier.get(fragment, material, 2))
                    .register();
        }
            INFUSION_ALTER_RECIPES.recipeBuilder()
                    .consumption(1.0f)
                    .time(10)
                    .input(IngredientHelper.toIIngredient(OreDictUnifier.get(crushed, material, 1)))
                    .output(OreDictUnifier.get(fragment, material, 2))
                    .register();

            MACERATOR_RECIPES.recipeBuilder()
                    .input(fragmentPrefix, material)
                    .outputs(OreDictUnifier.get(OrePrefix.dustImpure, material, 1))
                    .chancedOutput(OreDictUnifier.get(OrePrefix.dust, property.getOreByProduct(0, material), property.getByProductMultiplier()), 1400, 850)
                    .duration(400).EUt(2)
                    .buildAndRegister();

            ORE_WASHER_RECIPES.recipeBuilder()
                    .input(fragmentPrefix, material)
                    .outputs(OreDictUnifier.get(OrePrefix.crushedPurified, material, 1))
                    .fluidInputs(Materials.Water.getFluid(100))
                    .circuitMeta(2)
                    .duration(8).EUt(4)
                    .buildAndRegister();

            ORE_WASHER_RECIPES.recipeBuilder()
                    .input(fragmentPrefix, material)
                    .outputs(OreDictUnifier.get(OrePrefix.crushedPurified, material, 1), OreDictUnifier.get(OrePrefix.dust, Materials.Stone, 1))
                    .fluidInputs(Materials.Water.getFluid(1000))
                    .chancedOutput(OrePrefix.dust, property.getOreByProduct(0, material), 3333, 0)
                    .circuitMeta(1)
                    .duration(400).EUt(16)
                    .buildAndRegister();

            ORE_WASHER_RECIPES.recipeBuilder()
                    .input(fragmentPrefix, material)
                    .outputs(OreDictUnifier.get(OrePrefix.crushedPurified, material, 1), OreDictUnifier.get(OrePrefix.dust, Materials.Stone, 1))
                    .fluidInputs(Materials.DistilledWater.getFluid(100))
                    .chancedOutput(OrePrefix.dust, property.getOreByProduct(0, material), 3333, 0)
                    .duration(200).EUt(16)
                    .buildAndRegister();

            THERMAL_CENTRIFUGE_RECIPES.recipeBuilder()
                    .input(fragmentPrefix, material)
                    .outputs(OreDictUnifier.get(OrePrefix.crushedCentrifuged, material, 1), OreDictUnifier.get(OrePrefix.dust, Materials.Stone, 1))
                    .chancedOutput(OrePrefix.dust, property.getOreByProduct(1, material), property.getByProductMultiplier(), 3333, 0)
                    .buildAndRegister();

            if (property.getWashedIn().getKey() != null) {
                Pair<Material, Integer> washedInTuple = property.getWashedIn();
                CHEMICAL_BATH_RECIPES.recipeBuilder()
                        .input(fragmentPrefix, material)
                        .fluidInputs(washedInTuple.getKey().getFluid(washedInTuple.getValue()))
                        .outputs(OreDictUnifier.get(OrePrefix.crushedPurified, material, 2))
                        .chancedOutput(OreDictUnifier.get(OrePrefix.dust, property.getOreByProduct(3, material), property.getByProductMultiplier()), 7000, 580)
                        .chancedOutput(OreDictUnifier.get(OrePrefix.dust, Materials.Stone), 4000, 650)
                        .duration(200).EUt(30)
                        .buildAndRegister();

        }
    }
}
