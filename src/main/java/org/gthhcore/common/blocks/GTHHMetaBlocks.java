package org.gthhcore.common.blocks;

import static gregtech.common.blocks.MetaBlocks.statePropertiesToString;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.gthhcore.Tags;
import org.gthhcore.common.blocks.transparent.GlassCasing0;
import org.gthhcore.common.blocks.transparent.GlassCasing1;

public class GTHHMetaBlocks {

    private GTHHMetaBlocks() {}

    public static GTHHMultiblockCasing MULTIBLOCK_CASING_0;

    public static GlassCasing0 TRANSPARENT_CASING_0;
    public static GlassCasing1 TRANSPARENT_CASING_1;

    public static GTHHBlockWireCoil WIRE_COIL_0;

    public static void init() {
        MULTIBLOCK_CASING_0 = new GTHHMultiblockCasing();
        MULTIBLOCK_CASING_0.setRegistryName(Tags.MODID, "multiblock_casing_0");

        TRANSPARENT_CASING_0 = new GlassCasing0();
        TRANSPARENT_CASING_0.setRegistryName("transparent_casing_0");

        TRANSPARENT_CASING_1 = new GlassCasing1();
        TRANSPARENT_CASING_1.setRegistryName("transparent_casing_1");

        WIRE_COIL_0 = new GTHHBlockWireCoil();
        WIRE_COIL_0.setRegistryName(Tags.MODID, "wire_coil_0");
    }

    public static void registerItemModels() {
        registerItemModel(MULTIBLOCK_CASING_0);

        TRANSPARENT_CASING_0.onModelRegister();
        WIRE_COIL_0.onModelRegister();
    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            // noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            statePropertiesToString(state.getProperties())));
        }
    }
}
