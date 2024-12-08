package org.gthhcore.common;


import gregtech.api.unification.material.event.MaterialEvent;
import gregtech.api.util.GTLog;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import org.gthhcore.Tags;
import org.gthhcore.api.unification.materials.material.GTHHMaterials;

import org.gthhcore.common.items.GTHHMetaItems;
import org.gthhcore.common.items.metaitem.GTHHMetaItem;

@Mod.EventBusSubscriber(modid = Tags.MODID)
public class GTHHCommonProxy {
    public void preInit(FMLPreInitializationEvent event) {

    }
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterials(MaterialEvent event) {
        GTHHMaterials.init();
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        GTLog.logger.info("Registering GTHH Items...");
        IForgeRegistry<Item> registry = event.getRegistry();

        for (GTHHMetaItem<?> item : GTHHMetaItems.ITEMS) {
            registry.register(item);
            item.registerSubItems();
        }
    }
}
