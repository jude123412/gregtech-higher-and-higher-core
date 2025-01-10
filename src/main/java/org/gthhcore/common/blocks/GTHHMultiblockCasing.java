package org.gthhcore.common.blocks;

import gregtech.api.block.IStateHarvestLevel;
import gregtech.api.block.VariantBlock;
import gregtech.api.items.toolitem.ToolClasses;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;

public class GTHHMultiblockCasing extends VariantBlock<GTHHMultiblockCasing.GTHHMetalCasingType> {
    public GTHHMultiblockCasing() {
        super(Material.IRON);
        setTranslationKey("multiblock_casing_0");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setDefaultState(getState(GTHHMultiblockCasing.GTHHMetalCasingType.MACERATION_STACK_CASING));
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }
    public enum GTHHMetalCasingType implements IStringSerializable, IStateHarvestLevel {

        MACERATION_STACK_CASING("maceration_stack", 1);


        private final String name;
        private final int harvestLevel;

        GTHHMetalCasingType(String name, int harvestLevel) {
            this.name = name;
            this.harvestLevel = harvestLevel;
        }

        @NotNull
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public int getHarvestLevel(IBlockState state) {
            return harvestLevel;
        }

        @Override
        public String getHarvestTool(IBlockState state) {
            return ToolClasses.WRENCH;
        }
    }
}

