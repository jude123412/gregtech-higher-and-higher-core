package org.gthhcore.common.blocks;

import gregtech.api.block.IHeatingCoilBlockStats;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.block.VariantItemBlock;
import gregtech.api.items.toolitem.ToolClasses;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.client.utils.TooltipHelper;
import gregtech.common.ConfigHolder;

import gregtech.common.metatileentities.multi.electric.MetaTileEntityMultiSmelter;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.gthhcore.api.unification.materials.material.GTHHMaterials;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraft.block.material.Material.IRON;

public class GTHHBlockWireCoil extends VariantActiveBlock<GTHHBlockWireCoil.GTHHCoilType> {
    public GTHHBlockWireCoil() {
        super(IRON);
        setTranslationKey("wire_coil");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel(ToolClasses.WRENCH, 2);
        setDefaultState(getState(GTHHCoilType.HSS_S));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(VARIANT).ordinal();
    }

    @NotNull
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.SOLID;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@NotNull ItemStack itemStack, @Nullable World worldIn, @NotNull List<String> lines,
                               @NotNull ITooltipFlag tooltipFlag) {
        super.addInformation(itemStack, worldIn, lines, tooltipFlag);

        // noinspection rawtypes, unchecked
        VariantItemBlock itemBlock = (VariantItemBlock<GTHHCoilType, GTHHBlockWireCoil>) itemStack.getItem();
        IBlockState stackState = itemBlock.getBlockState(itemStack);
        GTHHCoilType coilType = getState(stackState);

        lines.add(I18n.format("tile.wire_coil.tooltip_heat", coilType.coilTemperature));

        if (TooltipHelper.isShiftDown()) {
            int coilTier = coilType.tier;
            lines.add(I18n.format("tile.wire_coil.tooltip_smelter"));
            lines.add(I18n.format("tile.wire_coil.tooltip_parallel_smelter", coilType.level * 32));
            int EUt = MetaTileEntityMultiSmelter.getEUtForParallel(
                    MetaTileEntityMultiSmelter.getMaxParallel(coilType.getLevel()), coilType.getEnergyDiscount());
            lines.add(I18n.format("tile.wire_coil.tooltip_energy_smelter", EUt));
            lines.add(I18n.format("tile.wire_coil.tooltip_pyro"));
            lines.add(I18n.format("tile.wire_coil.tooltip_speed_pyro", coilTier == 0 ? 75 : 50 * (coilTier + 1)));
            lines.add(I18n.format("tile.wire_coil.tooltip_cracking"));
            lines.add(I18n.format("tile.wire_coil.tooltip_energy_cracking", 100 - 10 * coilTier));
        } else {
            lines.add(I18n.format("tile.wire_coil.tooltip_extended_info"));
        }
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @Override
    protected boolean isBloomEnabled(GTHHCoilType value) {
        return ConfigHolder.client.coilsActiveEmissiveTextures;
    }

    public enum GTHHCoilType implements IStringSerializable, IHeatingCoilBlockStats {

        HSS_S("hss_s", 6300, 6, 4, 4, Materials.HSSS),
        NAQUADAH_ALLOY("naquadah_alloy", 8100, 8, 6, 6, Materials.NaquadahAlloy),
        AWAKENED_DRACONIUM("awakened_draconium", 9900, 12, 8, 7, GTHHMaterials.AwakenedDraconium),
        INFINITY("infinity", 11700, 24, 32, 8, GTHHMaterials.Infinity),
        ETERNAL("eternal", 12600, 32, 64, 9, GTHHMaterials.Multiversium),
        TEMPORAL("temporal", 13500, 64, 128, 10, GTHHMaterials.Multiversium);

        private final String name;
        // electric blast furnace properties
        private final int coilTemperature;
        // multi smelter properties
        private final int level;
        private final int energyDiscount;
        private final int tier;
        private final Material material;

        GTHHCoilType(String name, int coilTemperature, int level, int energyDiscount, int tier, Material material) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.tier = tier;
            this.material = material;
        }

        @NotNull
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public int getCoilTemperature() {
            return coilTemperature;
        }

        @Override
        public int getLevel() {
            return level;
        }

        @Override
        public int getEnergyDiscount() {
            return energyDiscount;
        }

        @Override
        public int getTier() {
            return tier;
        }

        @Nullable
        @Override
        public Material getMaterial() {
            return material;
        }

        @NotNull
        @Override
        public String toString() {
            return getName();
        }
    }
}
