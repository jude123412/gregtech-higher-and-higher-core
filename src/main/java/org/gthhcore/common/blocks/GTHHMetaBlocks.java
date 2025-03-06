package org.gthhcore.common.blocks;

import static gregtech.common.blocks.MetaBlocks.statePropertiesToString;

import java.util.EnumMap;

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

    public static final EnumMap<GTHHPlanetaryBlocks.GTHHPlanetaryVariant, GTHHPlanetaryBlocks> GTHH_PLANETARY_BLOCKS = new EnumMap<>(
            GTHHPlanetaryBlocks.GTHHPlanetaryVariant.class);

    public static void init() {
        GTHH_MULTIBLOCK_CASING = new GTHHMultiblockCasing();
        GTHH_MULTIBLOCK_CASING.setRegistryName(Tags.MODID, "multiblock_casing_0");

        GTHH_BLOCK_WIRE_COIL = new GTHHBlockWireCoil();
        GTHH_BLOCK_WIRE_COIL.setRegistryName(Tags.MODID, "wire_coil_0");

        for (GTHHPlanetaryBlocks.GTHHPlanetaryVariant shape : GTHHPlanetaryBlocks.GTHHPlanetaryVariant.values()) {
            GTHH_PLANETARY_BLOCKS.put(shape, new GTHHPlanetaryBlocks(shape));
        }
    }

    public static void registerItemModels() {
        registerItemModel(GTHH_MULTIBLOCK_CASING);
        GTHH_BLOCK_WIRE_COIL.onModelRegister();

        for (GTHHPlanetaryBlocks block : GTHH_PLANETARY_BLOCKS.values())
            registerItemModel(block);
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
