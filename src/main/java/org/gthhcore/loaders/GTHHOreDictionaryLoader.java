package org.gthhcore.loaders;

import appeng.core.Api;
import appeng.items.materials.MaterialType;
import dev.beecube31.crazyae2.core.CrazyAE;
import net.minecraftforge.oredict.OreDictionary;
import org.gthhcore.api.util.GTHHLog;

import static org.gthhcore.api.util.GTHHMods.*;

public class GTHHOreDictionaryLoader {

    public static void init() {
        GTHHLog.logger.info("Registering OreDict Entries.");

        if (Ae2.isModLoaded()) {
            OreDictionary.registerOre("gemCertusQuartz", MaterialType.CERTUS_QUARTZ_CRYSTAL.stack(1));
            OreDictionary.registerOre("gemChargedCertusQuartz", MaterialType.CERTUS_QUARTZ_CRYSTAL_CHARGED.stack(1));
            OreDictionary.registerOre("gemFluix", MaterialType.FLUIX_CRYSTAL.stack(1));
            OreDictionary.registerOre("gemFluixPearl", MaterialType.FLUIX_PEARL.stack(1));
            OreDictionary.registerOre("blockCertusQuartz", Api.INSTANCE.definitions().blocks().quartzBlock().maybeBlock().get());
            OreDictionary.registerOre("blockFluix", Api.INSTANCE.definitions().blocks().fluixBlock().maybeBlock().get());
        }
        if (CrazyAe.isModLoaded()) {
            OreDictionary.registerOre("blockFluixilized", CrazyAE.definitions().blocks().fluixilizedBlock().maybeBlock().get());
        }
    }
}
