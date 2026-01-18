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

            if (GalaxySpace.isModLoaded()) {
                oreMercury.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
                oreCeres.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
                orePluto.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
                oreHaumea.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
                orePhobos.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
                oreIo.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
                oreEuropa.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
                oreGanymede.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
                oreCallisto.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
                oreEnceladus.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
                oreTitan.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
                oreMiranda.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
                oreTriton.addProcessingHandler(PropertyKey.ORE, OreRecipeHandler::processOre);
            }
        }
    }
}
