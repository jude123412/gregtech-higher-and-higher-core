package org.gthhcore;

import static org.gthhcore.Tags.MODID;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.gthhcore.api.util.GTHHLog;
import org.gthhcore.common.CommonProxy;

@Mod(modid = MODID,
     version = Tags.VERSION,
     name = Tags.MODNAME,
     acceptedMinecraftVersions = "[1.12.2]")
public class GTHHCore {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        GTHHLog.logger.info("I am " + Tags.MODNAME + " + at version " + Tags.VERSION);

        CommonProxy.onPreInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        CommonProxy.onInit();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        CommonProxy.onPostInit();
    }
}
