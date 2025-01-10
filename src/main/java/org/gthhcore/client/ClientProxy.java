package org.gthhcore.client;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.gthhcore.common.CommonProxy;
import org.gthhcore.common.blocks.GTHHMetaBlocks;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public void preLoad() {
        super.preLoad();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        GTHHMetaBlocks.registerItemModels();
    }
}
