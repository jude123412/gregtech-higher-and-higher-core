package org.gthhcore.common.blocks;

import gregtech.api.block.VariantBlock;
import gregtech.api.items.toolitem.ToolClasses;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.blocks.MetaBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class GTHHPlanetaryBlocks extends VariantBlock<GTHHPlanetaryBlocks.GTHHPlanetaryType> {

    // shared property instance
    private static final PropertyEnum<GTHHPlanetaryType> PROPERTY = PropertyEnum.create("variant", GTHHPlanetaryType.class);

    public GTHHPlanetaryBlocks(@NotNull GTHHPlanetaryVariant planetaryStoneVariant) {
        super(net.minecraft.block.material.Material.ROCK);
        setRegistryName(planetaryStoneVariant.id);
        setTranslationKey(planetaryStoneVariant.translationKey);
        setHardness(planetaryStoneVariant.hardness);
        setResistance(planetaryStoneVariant.resistance);
        setSoundType(SoundType.STONE);
        setHarvestLevel(ToolClasses.PICKAXE, 0);
        setDefaultState(getState(GTHHPlanetaryType.MERCURY));
    }

    @NotNull
    @Override
    protected BlockStateContainer createBlockState() {
        this.VARIANT = PROPERTY;
        this.VALUES = GTHHPlanetaryType.values();
        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    public boolean canCreatureSpawn(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos,
                                    @NotNull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    public enum GTHHPlanetaryType implements IStringSerializable {

        MERCURY("mercury", MapColor.BLACK),
        VENUS("venus", MapColor.GRAY),
        MOON("moon",MapColor.SNOW),
        MARS("mars", MapColor.RED),
        DEIMOS("deimos", MapColor.GOLD),
        PHOBOS("phobos", MapColor.BROWN);

        private final String name;
        public final MapColor mapColor;

        GTHHPlanetaryType(@NotNull String name, @NotNull MapColor mapColor) {
            this.name = name;
            this.mapColor = mapColor;
        }

        @NotNull
        @Override
        public String getName() {
            return this.name;
        }
    }

    public enum GTHHPlanetaryVariant {

        SURFACE_SOIL("surface_soil"),
        SUB_SURFACE_SOIL("sub_surface_soil", 2.0f, 10.0f),
        SUB_SURFACE_ROCK("sub_surface_rock", 2.0f, 10.0f);

        public final String id;
        public final String translationKey;
        public final float hardness;
        public final float resistance;

        GTHHPlanetaryVariant(@NotNull String id) {
            this(id, id);
        }

        GTHHPlanetaryVariant(@NotNull String id, @NotNull String translationKey) {
            this(id, translationKey, 1.5f, 10.0f); // vanilla stone stats
        }

        GTHHPlanetaryVariant(@NotNull String id, float hardness, float resistance) {
            this(id, id, hardness, resistance);
        }

        GTHHPlanetaryVariant(@NotNull String id, @NotNull String translationKey, float hardness, float resistance) {
            this.id = id;
            this.translationKey = translationKey;
            this.hardness = hardness;
            this.resistance = resistance;
        }
    }
}