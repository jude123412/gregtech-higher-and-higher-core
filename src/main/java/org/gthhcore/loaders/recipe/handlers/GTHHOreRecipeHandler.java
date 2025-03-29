package org.gthhcore.loaders.recipe.handlers;

import static org.gthhcore.api.unification.ore.GTHHOrePrefix.*;
import static org.gthhcore.api.util.GTHHMods.*;

import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.loaders.recipe.handlers.OreRecipeHandler;

public class GTHHOreRecipeHandler {

    public static void register() {
        // Galacticraft Ores
        if (GalacticraftCore.isModLoaded() || GalacticraftPlanets.isModLoaded()) {
            oreMoon.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreMars.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreAsteroid.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreVenus.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
        }

        // Extra Planets Ores
        if (ExtraPlanets.isModLoaded()) {
            oreMercury.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreCeres.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreJupiter.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreSaturn.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreUranus.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreNeptune.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            orePluto.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreEris.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreKepler22B.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreEuropa.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreIo.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreDeimos.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            orePhobos.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreTriton.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreCallisto.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreGanymede.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreRhea.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreTitan.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreOberon.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreTitania.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            oreIapetus.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
        }
    }
}
