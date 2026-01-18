package org.gthhcore.api.unification.ore;

import static org.gthhcore.api.util.GTHHMods.*;

import net.minecraft.block.SoundType;

import org.gthhcore.api.unification.materials.material.GTHHMaterials;

import galaxyspace.core.GSBlocks;
import galaxyspace.systems.SolarSystem.moons.callisto.blocks.CallistoBlocks;
import galaxyspace.systems.SolarSystem.moons.enceladus.blocks.EnceladusBlocks;
import galaxyspace.systems.SolarSystem.moons.europa.blocks.EuropaBlocks;
import galaxyspace.systems.SolarSystem.moons.ganymede.blocks.GanymedeBlocks;
import galaxyspace.systems.SolarSystem.moons.io.blocks.IoBlocks;
import galaxyspace.systems.SolarSystem.moons.miranda.blocks.MirandaBlocks;
import galaxyspace.systems.SolarSystem.moons.phobos.blocks.PhobosBlocks;
import galaxyspace.systems.SolarSystem.moons.titan.blocks.TitanBlocks;
import galaxyspace.systems.SolarSystem.moons.triton.blocks.TritonBlocks;
import galaxyspace.systems.SolarSystem.planets.ceres.blocks.CeresBlocks;
import galaxyspace.systems.SolarSystem.planets.haumea.blocks.HaumeaBlocks;
import galaxyspace.systems.SolarSystem.planets.mercury.blocks.MercuryBlocks;
import galaxyspace.systems.SolarSystem.planets.pluto.blocks.PlutoBlocks;
import gregtech.api.unification.ore.StoneType;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.blocks.BlockBasicMoon;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.*;
import micdoodle8.mods.galacticraft.planets.mars.blocks.*;
import micdoodle8.mods.galacticraft.planets.venus.VenusBlocks;
import micdoodle8.mods.galacticraft.planets.venus.blocks.BlockBasicVenus;

public class GTHHStoneTypes {

    private static int startId = 12;
    private static int endId = 512;

    public static void galacticraftOres() {
        // Galacticraft Stones
        if (GalacticraftCore.isModLoaded() || GalacticraftPlanets.isModLoaded()) {
            StoneType MOON = new StoneType(getMetaItemId(), "moon", SoundType.STONE, GTHHOrePrefix.oreMoon,
                    GTHHMaterials.MoonStone,
                    () -> GCBlocks.blockMoon.getDefaultState().withProperty(BlockBasicMoon.BASIC_TYPE_MOON,
                            BlockBasicMoon.EnumBlockBasicMoon.MOON_STONE),
                    state -> state.getBlock() instanceof BlockBasicMoon &&
                            state.getValue(BlockBasicMoon.BASIC_TYPE_MOON) ==
                                    BlockBasicMoon.EnumBlockBasicMoon.MOON_STONE,
                    true);

            StoneType MARS = new StoneType(getMetaItemId(), "mars", SoundType.STONE, GTHHOrePrefix.oreMars,
                    GTHHMaterials.MarsStone,
                    () -> MarsBlocks.marsBlock.getDefaultState().withProperty(BlockBasicMars.BASIC_TYPE,
                            BlockBasicMars.EnumBlockBasic.MARS_STONE),
                    state -> state.getBlock() instanceof BlockBasicMars &&
                            state.getValue(BlockBasicMars.BASIC_TYPE) == BlockBasicMars.EnumBlockBasic.MARS_STONE,
                    true);

            StoneType ASTEROID_1 = new StoneType(getMetaItemId(), "asteroid_1", SoundType.STONE,
                    GTHHOrePrefix.oreAsteroid, GTHHMaterials.AsteroidStone,
                    () -> AsteroidBlocks.blockBasic.getDefaultState().withProperty(BlockBasicAsteroids.BASIC_TYPE,
                            BlockBasicAsteroids.EnumBlockBasic.ASTEROID_0),
                    state -> state.getBlock() instanceof BlockBasicAsteroids &&
                            state.getValue(BlockBasicAsteroids.BASIC_TYPE) ==
                                    BlockBasicAsteroids.EnumBlockBasic.ASTEROID_0,
                    true);

            StoneType ASTEROID_2 = new StoneType(getMetaItemId(), "asteroid_2", SoundType.STONE,
                    GTHHOrePrefix.oreAsteroid, GTHHMaterials.AsteroidStone,
                    () -> AsteroidBlocks.blockBasic.getDefaultState().withProperty(BlockBasicAsteroids.BASIC_TYPE,
                            BlockBasicAsteroids.EnumBlockBasic.ASTEROID_1),
                    state -> state.getBlock() instanceof BlockBasicAsteroids &&
                            state.getValue(BlockBasicAsteroids.BASIC_TYPE) ==
                                    BlockBasicAsteroids.EnumBlockBasic.ASTEROID_1,
                    true);

            StoneType ASTEROID_3 = new StoneType(getMetaItemId(), "asteroid_3", SoundType.STONE,
                    GTHHOrePrefix.oreAsteroid, GTHHMaterials.AsteroidStone,
                    () -> AsteroidBlocks.blockBasic.getDefaultState().withProperty(BlockBasicAsteroids.BASIC_TYPE,
                            BlockBasicAsteroids.EnumBlockBasic.ASTEROID_2),
                    state -> state.getBlock() instanceof BlockBasicAsteroids &&
                            state.getValue(BlockBasicAsteroids.BASIC_TYPE) ==
                                    BlockBasicAsteroids.EnumBlockBasic.ASTEROID_2,
                    true);

            StoneType VENUS = new StoneType(getMetaItemId(), "venus", SoundType.STONE, GTHHOrePrefix.oreVenus,
                    GTHHMaterials.VenusStone,
                    () -> VenusBlocks.venusBlock.getDefaultState().withProperty(BlockBasicVenus.BASIC_TYPE_VENUS,
                            BlockBasicVenus.EnumBlockBasicVenus.ROCK_HARD),
                    state -> state.getBlock() instanceof BlockBasicVenus &&
                            state.getValue(BlockBasicVenus.BASIC_TYPE_VENUS) ==
                                    BlockBasicVenus.EnumBlockBasicVenus.ROCK_HARD,
                    true);
        }

        // Galaxy Space Stones
        // TODO, Properly Fix Ore Generation
        if (GalaxySpace.isModLoaded()) {
            StoneType MERCURY = new StoneType(getMetaItemId(), "mercury", SoundType.STONE, GTHHOrePrefix.oreMercury,
                    GTHHMaterials.MercuryStone,
                    () -> GSBlocks.MERCURY_BLOCKS.getDefaultState()
                            .withProperty(MercuryBlocks.BASIC_TYPE, MercuryBlocks.EnumBlockMercury.STONE),
                    state -> state.getBlock() instanceof MercuryBlocks &&
                            state.getValue(MercuryBlocks.BASIC_TYPE) == MercuryBlocks.EnumBlockMercury.STONE,
                    true);

            StoneType CERES = new StoneType(getMetaItemId(), "ceres", SoundType.STONE, GTHHOrePrefix.oreCeres,
                    GTHHMaterials.CeresStone,
                    () -> GSBlocks.CERES_BLOCKS.getDefaultState()
                            .withProperty(CeresBlocks.BASIC_TYPE, CeresBlocks.EnumCeresBlocks.CERES_SUBGRUNT),
                    state -> state.getBlock() instanceof MercuryBlocks &&
                            state.getValue(CeresBlocks.BASIC_TYPE) == CeresBlocks.EnumCeresBlocks.CERES_SUBGRUNT,
                    true);

            StoneType PLUTO = new StoneType(getMetaItemId(), "pluto", SoundType.STONE, GTHHOrePrefix.orePluto,
                    GTHHMaterials.PlutoStone,
                    () -> GSBlocks.PLUTO_BLOCKS.getDefaultState()
                            .withProperty(PlutoBlocks.BASIC_TYPE, PlutoBlocks.EnumPlutoBlocks.PLUTO_STONE),
                    state -> state.getBlock() instanceof PlutoBlocks &&
                            state.getValue(PlutoBlocks.BASIC_TYPE) == PlutoBlocks.EnumPlutoBlocks.PLUTO_STONE,
                    true);

            StoneType HAUMEA = new StoneType(getMetaItemId(), "haumea", SoundType.STONE, GTHHOrePrefix.oreHaumea,
                    GTHHMaterials.HaumeaStone,
                    () -> GSBlocks.HAUMEA_BLOCKS.getDefaultState()
                            .withProperty(HaumeaBlocks.BASIC_TYPE, HaumeaBlocks.EnumHaumeaBlocks.STONE),
                    state -> state.getBlock() instanceof HaumeaBlocks &&
                            state.getValue(HaumeaBlocks.BASIC_TYPE) == HaumeaBlocks.EnumHaumeaBlocks.STONE,
                    true);

            StoneType PHOBOS = new StoneType(getMetaItemId(), "phobos", SoundType.STONE, GTHHOrePrefix.orePhobos,
                    GTHHMaterials.PhobosStone,
                    () -> GSBlocks.PHOBOS_BLOCKS.getDefaultState()
                            .withProperty(PhobosBlocks.BASIC_TYPE, PhobosBlocks.EnumPhobosBlocks.PHOBOS_STONE),
                    state -> state.getBlock() instanceof PhobosBlocks &&
                            state.getValue(PhobosBlocks.BASIC_TYPE) == PhobosBlocks.EnumPhobosBlocks.PHOBOS_STONE,
                    true);

            StoneType IO = new StoneType(getMetaItemId(), "io", SoundType.STONE, GTHHOrePrefix.oreIo,
                    GTHHMaterials.IoStone,
                    () -> GSBlocks.IO_BLOCKS.getDefaultState()
                            .withProperty(IoBlocks.BASIC_TYPE, IoBlocks.EnumIoBlocks.IO_STONE),
                    state -> state.getBlock() instanceof IoBlocks &&
                            state.getValue(IoBlocks.BASIC_TYPE) == IoBlocks.EnumIoBlocks.IO_STONE,
                    true);

            StoneType EUROPA = new StoneType(getMetaItemId(), "europa", SoundType.STONE, GTHHOrePrefix.oreEuropa,
                    GTHHMaterials.EuropaStone,
                    () -> GSBlocks.EUROPA_BLOCKS.getDefaultState()
                            .withProperty(EuropaBlocks.BASIC_TYPE, EuropaBlocks.EnumEuropaBlocks.EUROPA_STONE),
                    state -> state.getBlock() instanceof EuropaBlocks &&
                            state.getValue(EuropaBlocks.BASIC_TYPE) == EuropaBlocks.EnumEuropaBlocks.EUROPA_STONE,
                    true);

            StoneType GANYMEDE = new StoneType(getMetaItemId(), "ganymede", SoundType.STONE, GTHHOrePrefix.oreGanymede,
                    GTHHMaterials.GanymedeStone,
                    () -> GSBlocks.GANYMEDE_BLOCKS.getDefaultState()
                            .withProperty(GanymedeBlocks.BASIC_TYPE, GanymedeBlocks.EnumGanymedeBlocks.GANYMEDE_STONE),
                    state -> state.getBlock() instanceof GanymedeBlocks &&
                            state.getValue(GanymedeBlocks.BASIC_TYPE) ==
                                    GanymedeBlocks.EnumGanymedeBlocks.GANYMEDE_STONE,
                    true);

            StoneType CALLISTO = new StoneType(getMetaItemId(), "callisto", SoundType.STONE, GTHHOrePrefix.oreCallisto,
                    GTHHMaterials.CallistoStone,
                    () -> GSBlocks.CALLISTO_BLOCKS.getDefaultState()
                            .withProperty(CallistoBlocks.BASIC_TYPE, CallistoBlocks.EnumCallistoBlocks.CALLISTO_STONE),
                    state -> state.getBlock() instanceof CallistoBlocks &&
                            state.getValue(CallistoBlocks.BASIC_TYPE) ==
                                    CallistoBlocks.EnumCallistoBlocks.CALLISTO_STONE,
                    true);

            StoneType ENCELADUS = new StoneType(getMetaItemId(), "enceladus", SoundType.STONE,
                    GTHHOrePrefix.oreEnceladus,
                    GTHHMaterials.EnceladusStone,
                    () -> GSBlocks.ENCELADUS_BLOCKS.getDefaultState()
                            .withProperty(EnceladusBlocks.BASIC_TYPE,
                                    EnceladusBlocks.EnumEnceladusBlocks.ENCELADUS_SNOW),
                    state -> state.getBlock() instanceof EnceladusBlocks &&
                            state.getValue(EnceladusBlocks.BASIC_TYPE) ==
                                    EnceladusBlocks.EnumEnceladusBlocks.ENCELADUS_SNOW,
                    true);

            StoneType TITAN = new StoneType(getMetaItemId(), "titan", SoundType.STONE, GTHHOrePrefix.oreTitan,
                    GTHHMaterials.TitanStone,
                    () -> GSBlocks.TITAN_BLOCKS.getDefaultState()
                            .withProperty(TitanBlocks.BASIC_TYPE, TitanBlocks.EnumTitanBlocks.TITAN_STONE),
                    state -> state.getBlock() instanceof TitanBlocks &&
                            state.getValue(TitanBlocks.BASIC_TYPE) == TitanBlocks.EnumTitanBlocks.TITAN_STONE,
                    true);

            StoneType MIRANDA = new StoneType(getMetaItemId(), "miranda", SoundType.STONE, GTHHOrePrefix.oreMiranda,
                    GTHHMaterials.MirandaStone,
                    () -> GSBlocks.MIRANDA_BLOCKS.getDefaultState()
                            .withProperty(MirandaBlocks.BASIC_TYPE, MirandaBlocks.EnumMirandaBlocks.MIRANDA_STONE),
                    state -> state.getBlock() instanceof MirandaBlocks &&
                            state.getValue(MirandaBlocks.BASIC_TYPE) == MirandaBlocks.EnumMirandaBlocks.MIRANDA_STONE,
                    true);

            StoneType TRITON = new StoneType(getMetaItemId(), "triton", SoundType.STONE, GTHHOrePrefix.oreTriton,
                    GTHHMaterials.TritonStone,
                    () -> GSBlocks.TRITON_BLOCKS.getDefaultState()
                            .withProperty(TritonBlocks.BASIC_TYPE, TritonBlocks.EnumTritonBlocks.TRITON_STONE),
                    state -> state.getBlock() instanceof TritonBlocks &&
                            state.getValue(TritonBlocks.BASIC_TYPE) == TritonBlocks.EnumTritonBlocks.TRITON_STONE,
                    true);
        }
    }

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
