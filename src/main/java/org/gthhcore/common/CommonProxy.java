package org.gthhcore.common;

import gregtech.api.GregTechAPI;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.unification.material.event.MaterialEvent;
import gregtech.api.unification.material.event.PostMaterialEvent;
import gregtech.api.unification.stack.ItemMaterialInfo;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import org.gthhcore.Tags;
import org.gthhcore.api.unification.materials.material.GTHHMaterials;
import org.gthhcore.api.unification.ore.GTHHStoneTypes;
import org.gthhcore.api.util.GTHHLog;
import org.gthhcore.common.blocks.GTHHBlockWireCoil;
import org.gthhcore.common.blocks.GTHHMetaBlocks;
import org.gthhcore.common.blocks.GTHHPlanetaryBlocks;
import org.gthhcore.common.items.GTHHMetaItems;
import org.gthhcore.loaders.GTHHOreDictionaryLoader;
import org.gthhcore.loaders.recipe.mod.gregtech.GTHHRecipeManager;

import java.util.Objects;
import java.util.function.Function;

import static gregtech.api.GregTechAPI.HEATING_COILS;
import static org.gthhcore.common.blocks.GTHHMetaBlocks.*;

@Mod.EventBusSubscriber(modid = Tags.MODID)
public class CommonProxy {
    public void preLoad() {}

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        GTHHLog.logger.info("Registering Blocks...");
        IForgeRegistry<Block> registry = event.getRegistry();
        GTHHMetaBlocks.init();

        registry.register(GTHH_MULTIBLOCK_CASING);
        registry.register(GTHH_BLOCK_WIRE_COIL);

        for (GTHHPlanetaryBlocks block : GTHH_PLANETARY_BLOCKS.values()) registry.register(block);

        for (GTHHBlockWireCoil.GTHHCoilType type : GTHHBlockWireCoil.GTHHCoilType.values()) {
            HEATING_COILS.put(GTHHMetaBlocks.GTHH_BLOCK_WIRE_COIL.getState(type), type);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        GTHHLog.logger.info("Registering Items...");
        IForgeRegistry<Item> registry = event.getRegistry();

        registry.register(createItemBlock(GTHH_MULTIBLOCK_CASING, VariantItemBlock::new));
        registry.register(createItemBlock(GTHH_BLOCK_WIRE_COIL, VariantItemBlock::new));

        for (GTHHPlanetaryBlocks block : GTHH_PLANETARY_BLOCKS.values()) {
            registry.register(createItemBlock(block, VariantItemBlock::new));
        }

    }

    private static <T extends Block> ItemBlock createItemBlock(T block, Function<T, ItemBlock> producer) {
        ItemBlock itemBlock = producer.apply(block);
        itemBlock.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
        return itemBlock;
    }

    @SubscribeEvent
    public void preInit(FMLPreInitializationEvent event) {

    }

    @SubscribeEvent
    public void init(FMLInitializationEvent event) {

    }

    @SubscribeEvent
    public void postInit(FMLPostInitializationEvent event) {

    }
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerMaterials(MaterialEvent event) {
        GTHHLog.logger.info("Registering Materials...");
        GTHHMaterials.init();
    }

    @SubscribeEvent
    public static void registerPostMaterials(PostMaterialEvent event) {
        GTHHLog.logger.info("Registering Stone Types...");
        GTHHStoneTypes.advancedRocketryOres();
    }


    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerRecipesLow(RegistryEvent.Register<IRecipe> event) {
        GTHHLog.logger.info("Registering ore dictionary...");
        GTHHOreDictionaryLoader.init();

        GTHHLog.logger.info("Registering early recipes...");
        MinecraftForge.EVENT_BUS.post(new GregTechAPI.RegisterEvent<>(null, ItemMaterialInfo.class));

        GTHHRecipeManager.preLoad();
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        GTHHLog.logger.info("Registering recipes...");
        MinecraftForge.EVENT_BUS.post(new GregTechAPI.RegisterEvent<>(null, ItemMaterialInfo.class));

        GTHHRecipeManager.load();
    }


    // Some Pre-Init Registry needs to happen Here
    public static void onPreInit() {
        GTHHLog.logger.info("Registering MetaItems...");
        GTHHMetaItems.init();
    }

    public static void onInit() {

    }
    public void onPreLoad() {}

    public void onLoad() {}

    public void onPostLoad() {}

    public void onLoadComplete() {}
}