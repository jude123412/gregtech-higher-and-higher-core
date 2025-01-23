package org.gthhcore.common;

import net.minecraftforge.common.config.Config;
import org.gthhcore.Tags;

@Config(modid = Tags.MODID)
public class GTHHConfigHandler {

    @Config.Comment("Main Configuration file for GTHHCore")
    @Config.Name("GregTech Higher & Higher Config")

    public static LogisticsPipes logisticsPipes = new LogisticsPipes();
    public static class LogisticsPipes {

        @Config.Comment("Logistics Pipes Integration (DOESN'T REPLACE RECIPES)")
        public boolean logistics_pipes_integration = false;

        @Config.Comment("Thaumcraft Integration (DOES REPLACE RECIPES)")
        public boolean thaumcraft_integration = false;

    }
}
