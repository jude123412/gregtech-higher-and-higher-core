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

public class GTHHMetaBlocks {

    private GTHHMetaBlocks() {}

    public static GTHHMultiblockCasing GTHH_MULTIBLOCK_CASING;
    public static GTHHBlockWireCoil GTHH_BLOCK_WIRE_COIL;

    public static void init() {
        GTHH_MULTIBLOCK_CASING = new GTHHMultiblockCasing();
        GTHH_MULTIBLOCK_CASING.setRegistryName(Tags.MODID, "multiblock_casing_0");

        GTHH_BLOCK_WIRE_COIL = new GTHHBlockWireCoil();
        GTHH_BLOCK_WIRE_COIL.setRegistryName(Tags.MODID, "wire_coil_0");
    }

    public static void registerItemModels() {
        registerItemModel(GTHH_MULTIBLOCK_CASING);
        GTHH_BLOCK_WIRE_COIL.onModelRegister();
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
