package org.gthhcore.common.blocks.transparent;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.jetbrains.annotations.NotNull;

import gregtech.api.block.VariantActiveBlock;
import gregtech.api.items.toolitem.ToolClasses;

public class GlassCasing0 extends VariantActiveBlock<GlassCasing0.CasingType> {

    public GlassCasing0() {
        super(Material.GLASS);
        setTranslationKey("transparent_casing");
        setHardness(5.0F);
        setResistance(5.0F);
        setSoundType(SoundType.GLASS);
        setHarvestLevel(ToolClasses.PICKAXE, 1);
        setDefaultState(getState(CasingType.BRONZE_GLASS));
        this.useNeighborBrightness = true;
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @Override
    @NotNull
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean canRenderInLayer(@NotNull IBlockState state, @NotNull BlockRenderLayer layer) {
        return getState(state) == CasingType.STAINLESS_STEEL_GLASS || getState(state) == CasingType.TITANIUM_GLASS ||
                getState(state) == CasingType.TUNGSTENSTEEL_GLASS ||
                getState(state) == CasingType.RHODIUM_PLATED_PALLADIUM_GLASS ? layer == BlockRenderLayer.TRANSLUCENT :
                        super.canRenderInLayer(state, layer);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(@NotNull IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(@NotNull IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public boolean shouldSideBeRendered(@NotNull IBlockState state, IBlockAccess world, BlockPos pos,
                                        @NotNull EnumFacing side) {
        IBlockState sideState = world.getBlockState(pos.offset(side));

        return sideState.getBlock() == this ?
                getState(sideState) != getState(state) :
                super.shouldSideBeRendered(state, world, pos, side);
    }

    public enum CasingType implements IStringSerializable {

        BRONZE_GLASS("bronze_glass"),
        WROUGHT_IRON_GLASS("wrought_iron_glass"),
        STEEL_GLASS("steel_glass"),
        ALUMINIUM_GLASS("aluminium_glass"),
        STAINLESS_STEEL_GLASS("stainless_steel_glass"),
        TITANIUM_GLASS("titanium_glass"),
        TUNGSTENSTEEL_GLASS("tungstensteel_glass"),
        RHODIUM_PLATED_PALLADIUM_GLASS("rhodium_plated_palladium_glass");

        private final String name;

        CasingType(String name) {
            this.name = name;
        }

        @Override
        @NotNull
        public String getName() {
            return this.name;
        }
    }
}
