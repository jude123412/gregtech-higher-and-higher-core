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
    }
}
