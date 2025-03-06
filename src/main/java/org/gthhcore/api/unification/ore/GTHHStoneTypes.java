package org.gthhcore.api.unification.ore;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;

import org.gthhcore.api.unification.materials.material.GTHHMaterials;
import org.gthhcore.common.blocks.GTHHMetaBlocks;
import org.gthhcore.common.blocks.GTHHPlanetaryBlocks;

import gregtech.api.unification.ore.StoneType;

public class GTHHStoneTypes {

    private static int startId = 12;
    private static int endId = 512;

    public static void advancedRocketryOres() {
        final StoneType MOON = new StoneType(getMetaItemId(), "moon", SoundType.STONE, GTHHOrePrefix.oreMoon,
                GTHHMaterials.MoonStone,
                () -> gtStoneState(GTHHPlanetaryBlocks.GTHHPlanetaryType.MOON),
                state -> gtStonePredicate(state, GTHHPlanetaryBlocks.GTHHPlanetaryType.MOON), true);

        final StoneType MERCURY = new StoneType(getMetaItemId(), "mercury", SoundType.STONE, GTHHOrePrefix.oreMercury,
                GTHHMaterials.MercuryStone,
                () -> gtStoneState(GTHHPlanetaryBlocks.GTHHPlanetaryType.MERCURY),
                state -> gtStonePredicate(state, GTHHPlanetaryBlocks.GTHHPlanetaryType.MERCURY), true);

        final StoneType VENUS = new StoneType(getMetaItemId(), "venus", SoundType.STONE, GTHHOrePrefix.oreVenus,
                GTHHMaterials.VenusStone,
                () -> gtStoneState(GTHHPlanetaryBlocks.GTHHPlanetaryType.VENUS),
                state -> gtStonePredicate(state, GTHHPlanetaryBlocks.GTHHPlanetaryType.VENUS), true);

        final StoneType MARS = new StoneType(getMetaItemId(), "mars", SoundType.STONE, GTHHOrePrefix.oreMars,
                GTHHMaterials.MarsStone,
                () -> gtStoneState(GTHHPlanetaryBlocks.GTHHPlanetaryType.MARS),
                state -> gtStonePredicate(state, GTHHPlanetaryBlocks.GTHHPlanetaryType.MARS), true);

        final StoneType DEIMOS = new StoneType(getMetaItemId(), "deimos", SoundType.STONE, GTHHOrePrefix.oreDeimos,
                GTHHMaterials.DeimosStone,
                () -> gtStoneState(GTHHPlanetaryBlocks.GTHHPlanetaryType.DEIMOS),
                state -> gtStonePredicate(state, GTHHPlanetaryBlocks.GTHHPlanetaryType.DEIMOS), true);

        final StoneType PHOBOS = new StoneType(getMetaItemId(), "phobos", SoundType.STONE, GTHHOrePrefix.orePhobos,
                GTHHMaterials.PhobosStone,
                () -> gtStoneState(GTHHPlanetaryBlocks.GTHHPlanetaryType.PHOBOS),
                state -> gtStonePredicate(state, GTHHPlanetaryBlocks.GTHHPlanetaryType.PHOBOS), true);
    }

    private static IBlockState gtStoneState(GTHHPlanetaryBlocks.GTHHPlanetaryType stoneType) {
        return GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS.get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_ROCK)
                .getState(stoneType);
    }

    private static boolean gtStonePredicate(IBlockState state, GTHHPlanetaryBlocks.GTHHPlanetaryType stoneType) {
        GTHHPlanetaryBlocks block = GTHHMetaBlocks.GTHH_PLANETARY_BLOCKS
                .get(GTHHPlanetaryBlocks.GTHHPlanetaryVariant.SUB_SURFACE_ROCK);
        return state.getBlock() == block && block.getState(state) == stoneType;
    }

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
