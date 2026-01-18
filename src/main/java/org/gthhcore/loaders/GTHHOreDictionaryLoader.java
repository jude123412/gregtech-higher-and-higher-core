package org.gthhcore.loaders;

import static org.gthhcore.api.util.GTHHMods.*;
import static org.gthhcore.common.items.GTHHMetaItems.*;

import net.minecraftforge.oredict.OreDictionary;

import org.gthhcore.api.util.GTHHLog;
import org.gthhcore.api.util.GTHHUtility;

import appeng.core.Api;
import appeng.items.materials.MaterialType;
import dev.beecube31.crazyae2.core.CrazyAE;

public class GTHHOreDictionaryLoader {

    public static void init() {
        GTHHLog.logger.info("Registering OreDict Entries.");
        OreDictionary.registerOre("plateMicaBased", MICA_BASED_SHEET.getStackForm());
        OreDictionary.registerOre("plateMicaInsulator", MICA_INSULATOR_SHEET.getStackForm());
        OreDictionary.registerOre("foilCoilInsulator", MICA_INSULATOR_FOIL.getStackForm());

        if (Ae2.isModLoaded()) {
            OreDictionary.registerOre("gemCertusQuartz", MaterialType.CERTUS_QUARTZ_CRYSTAL.stack(1));
            OreDictionary.registerOre("gemChargedCertusQuartz", MaterialType.CERTUS_QUARTZ_CRYSTAL_CHARGED.stack(1));
            OreDictionary.registerOre("gemFluix", MaterialType.FLUIX_CRYSTAL.stack(1));
            OreDictionary.registerOre("gemFluixPearl", MaterialType.FLUIX_PEARL.stack(1));
            OreDictionary.registerOre("dustSkystone", MaterialType.SKY_DUST.stack(1));
            OreDictionary.registerOre("blockCertusQuartz",
                    Api.INSTANCE.definitions().blocks().quartzBlock().maybeBlock().get());
            OreDictionary.registerOre("blockFluix",
                    Api.INSTANCE.definitions().blocks().fluixBlock().maybeBlock().get());
            OreDictionary.registerOre("blockSkystone",
                    Api.INSTANCE.definitions().blocks().skyStoneBlock().maybeBlock().get());
        }

        if (CrazyAe.isModLoaded()) {
            OreDictionary.registerOre("blockFluixilized",
                    CrazyAE.definitions().blocks().fluixilizedBlock().maybeBlock().get());
        }

        if (Botania.isModLoaded()) {
            OreDictionary.registerOre("gemManaDiamond",
                    GTHHUtility.getItemStackFromString("botania", "manaresource", 2));
            OreDictionary.registerOre("gemManaPearl", GTHHUtility.getItemStackFromString("botania", "manaresource", 1));
            OreDictionary.registerOre("ingotGaiaSpirit",
                    GTHHUtility.getItemStackFromString("botania", "manaresource", 14));
        }

        if (EnderIo.isModLoaded()) {
            OreDictionary.registerOre("dustPrescientCrystal",
                    GTHHUtility.getItemStackFromString("enderio", "item_material", 34));
            OreDictionary.registerOre("dustVibrantCrystal",
                    GTHHUtility.getItemStackFromString("enderio", "item_material", 35));
            OreDictionary.registerOre("dustPulsatingCrystal",
                    GTHHUtility.getItemStackFromString("enderio", "item_material", 36));
            OreDictionary.registerOre("dustEnderCrystal",
                    GTHHUtility.getItemStackFromString("enderio", "item_material", 37));

            OreDictionary.registerOre("gemPulsatingCrystal",
                    GTHHUtility.getItemStackFromString("enderio", "item_material", 14));
            OreDictionary.registerOre("gemVibrantCrystal",
                    GTHHUtility.getItemStackFromString("enderio", "item_material", 15));
            OreDictionary.registerOre("gemEnderCrystal",
                    GTHHUtility.getItemStackFromString("enderio", "item_material", 16));
            OreDictionary.registerOre("gemAttractorCrystal",
                    GTHHUtility.getItemStackFromString("enderio", "item_material", 17));
            OreDictionary.registerOre("gemWeatherCrystal",
                    GTHHUtility.getItemStackFromString("enderio", "item_material", 18));
            OreDictionary.registerOre("gemPrescientCrystal",
                    GTHHUtility.getItemStackFromString("enderio", "item_material", 19));
        }

        if (GalacticraftCore.isModLoaded() || GalacticraftPlanets.isModLoaded()) {
            OreDictionary.registerOre("blockMeteoricIron",
                    GTHHUtility.getItemStackFromString("galacticraftcore", "basic_block_core", 12));
            OreDictionary.registerOre("stickDesh",
                    GTHHUtility.getItemStackFromString("galacticraftplanets", "item_basic_mars", 1));
        }
    }
}
