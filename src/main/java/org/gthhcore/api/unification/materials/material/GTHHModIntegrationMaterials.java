package org.gthhcore.api.unification.materials.material;

import com.typesafe.config.ConfigException;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;
import org.gthhcore.api.unification.materials.info.GTHHMaterialIconSet;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.ROUGH;
import static gregtech.api.util.GTUtility.gregtechId;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.api.util.GTHHMods.*;

public class GTHHModIntegrationMaterials {

    private static int startId = 12000;
    private static int endId = 12499;

    public static void register() {
        if(Ae2.isModLoaded()) {
            ChargedCertusQuartz = new Material.Builder(getMetaItemId(), gregtechId("charged_certus_quartz"))
                    .dust()
                    .gem(2)
                    .ore(true)
                    .flags(NO_SMASHING, NO_SMELTING)
                    .components(Silicon, 1, Oxygen, 2, MissingError, 1)
                    .color(0x7697A6)
                    .iconSet(MaterialIconSet.CERTUS)
                    .build();

            Fluix = new Material.Builder(getMetaItemId(), gregtechId("fluix"))
                    .dust()
                    .gem(2)
                    .ore(true)
                    .flags(NO_SMASHING, NO_SMELTING)
                    .components(ChargedCertusQuartz, 1, CertusQuartz, 1, Redstone, 1)
                    .color(0x832FBA)
                    .iconSet(MaterialIconSet.CERTUS)
                    .build();

            FluixPearl = new Material.Builder(getMetaItemId(), gregtechId("fluix_pearl"))
                    .dust()
                    .gem(2)
                    .flags(NO_SMASHING, NO_SMELTING, GENERATE_PLATE)
                    .components(Fluix, 8, EnderPearl, 1)
                    .color(0x832FBA)
                    .build();

//            SkyStone = new Material.Builder(getMetaItemId(), gregtechId("stone_sky"))
//                    .dust(2)
//                    .flags(NO_SMASHING, NO_SMELTING, MORTAR_GRINDABLE)
//                    .color(0x23343A)
//                    .iconSet(MaterialIconSet.ROUGH)
//                    .build();

            if(CrazyAe.isModLoaded()) {
                Fluixilized = new Material.Builder(getMetaItemId(), gregtechId("fluixilized"))
                        .dust()
                        .gem(2)
                        .ore(true)
                        .flags(NO_SMASHING, NO_SMELTING)
                        .components(FluixPearl, 4, CertusQuartz, 4, Fluix, 4)
                        .color(0xFF007F)
                        .iconSet(MaterialIconSet.CERTUS)
                        .build();
            }

            ElectricalSteel = new Material.Builder(getMetaItemId(), gregtechId("electrical_steel"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(1688))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .blast(b -> b
                            .temp(1688, BlastProperty.GasTier.LOW)
                            .blastStats(VA[MV], 1100))
                    .components(Steel, 1, Silicon, 1)
                    .color(0x999999)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .cableProperties(32, 4, 1, false)
                    .build();

            EnergeticAlloy = new Material.Builder(getMetaItemId(), gregtechId("energetic_alloy"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(2100))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .blast(b -> b
                            .temp(2100, BlastProperty.GasTier.LOW)
                            .blastStats(VA[MV], 1680))
                    .components(Gold, 1, Redstone, 1, Glowstone, 1)
                    .color(0xFF7402)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .cableProperties(2048, 16, 6, false)
                    .build();

            VibrantAlloy = new Material.Builder(getMetaItemId(), gregtechId("vibrant_alloy"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(2950))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .blast(b -> b
                            .temp(2950, BlastProperty.GasTier.LOW)
                            .blastStats(VA[HV], 2052))
                    .components(EnergeticAlloy, 1, EnderPearl, 1)
                    .color(0xBEFF1C)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .cableProperties(8192, 20, 8, false)
                    .build();

            RedstoneAlloy = new Material.Builder(getMetaItemId(), gregtechId("redstone_alloy"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(1750))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .blast(b -> b
                            .temp(1750, BlastProperty.GasTier.LOW)
                            .blastStats(VA[MV], 860))
                    .components(ElectricalSteel, 4, Redstone, 1, Silicon, 1)
                    .color(0xCC3030)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .cableProperties(128, 8, 2, false)
                    .build();

            ConductiveIron = new Material.Builder(getMetaItemId(), gregtechId("conductive_iron"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(1555))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .blast(b -> b
                            .temp(1555, BlastProperty.GasTier.LOW)
                            .blastStats(VA[MV], 900))
                    .components(RedstoneAlloy, 4, Steel, 1, Redstone, 1)
                    .color(0xFFB4A5)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .cableProperties(512, 12, 4, false)
                    .build();

            PulsatingIron = new Material.Builder(getMetaItemId(), gregtechId("pulsating_iron"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(1720))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .blast(b -> b
                            .temp(1720, BlastProperty.GasTier.LOW)
                            .blastStats(VA[MV], 625))
                    .components(Steel, 1, EnderPearl, 1)
                    .color(0x9AFFB1)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .cableProperties(8, 1, 1, false)
                    .build();

            DarkSteel = new Material.Builder(getMetaItemId(), gregtechId("dark_steel"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(1690))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE, GENERATE_ROUND)
                    .blast(b -> b
                            .temp(1690, BlastProperty.GasTier.LOW)
                            .blastStats(VA[MV], 1200))
                    .components(Steel, 1, Obsidian, 1)
                    .color(0x4C4C4C)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .build();

            Soularium = new Material.Builder(getMetaItemId(), gregtechId("soularium"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(2280))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE, GENERATE_ROUND)
                    .blast(b -> b
                            .temp(2280, BlastProperty.GasTier.LOW)
                            .blastStats(VA[MV], 1100))
                    .color(0x7A502E)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .build();

            EndSteel = new Material.Builder(getMetaItemId(), gregtechId("end_steel"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(3000))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .components(DarkSteel, 1, Obsidian, 1)
                    .blast(b -> b
                            .temp(3000, BlastProperty.GasTier.LOW)
                            .blastStats(VA[HV], 1100))
                    .color(0xE5DB8B)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .build();

            CrudeSteel = new Material.Builder(getMetaItemId(), gregtechId("crude_steel"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(1300))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .blast(b -> b
                            .temp(1300, BlastProperty.GasTier.LOW)
                            .blastStats(VA[LV], 651))
                    .color(0xCCC3B1)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .build();

            CrystallineAlloy = new Material.Builder(getMetaItemId(), gregtechId("crystalline_alloy"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(3820))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .blast(b -> b
                            .temp(3820, BlastProperty.GasTier.LOW)
                            .blastStats(VA[EV], 2872))
                    .color(0x91FFFF)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .cableProperties(32768, 24, 4, false)
                    .build();

            MelodicAlloy = new Material.Builder(getMetaItemId(), gregtechId("melodic_alloy"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(3290))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .blast(b -> b
                            .temp(3290, BlastProperty.GasTier.LOW)
                            .blastStats(VA[HV], 2490))
                    .color(0xB26EB2)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .cableProperties(131072, 28, 16, false)
                    .build();

            CrystallinePinkSlime = new Material.Builder(getMetaItemId(), gregtechId("crystalline_pink_slime"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(3890))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .blast(b -> b
                            .temp(4890, BlastProperty.GasTier.LOW)
                            .blastStats(VA[EV], 1100))
                    .color(0xFF99EF)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .cableProperties(524288, 32, 64, false)
                    .build();

            EnergeticSilver = new Material.Builder(getMetaItemId(), gregtechId("energetic_silver"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(2085))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .blast(b -> b
                            .temp(2085, BlastProperty.GasTier.LOW)
                            .blastStats(VA[MV], 1680))
                    .components(Silver, 1, Redstone, 1, Glowstone, 1)
                    .color(0x639ECC)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .build();

            VividAlloy = new Material.Builder(getMetaItemId(), gregtechId("vivid_alloy"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(2925))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .blast(b -> b
                            .temp(2925, BlastProperty.GasTier.LOW)
                            .blastStats(VA[HV], 2052))
                    .components(EnergeticSilver, 1, EnderPearl, 1)
                    .color(0x7AE6FF)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .build();

            StellarAlloy = new Material.Builder(getMetaItemId(), gregtechId("stellar_alloy"))
                    .dust()
                    .ingot()
                    .liquid(new FluidBuilder().temperature(5480))
                    .flags(EXT2_METAL, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_RING, GENERATE_ROTOR, GENERATE_SMALL_GEAR, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_GEAR, GENERATE_DOUBLE_PLATE, GENERATE_FINE_WIRE)
                    .blast(b -> b
                            .temp(5480, BlastProperty.GasTier.LOW)
                            .blastStats(VA[IV], 9950)
                            .vacuumStats(VA[EV] * 2, 2400))
                    .components(VividAlloy, 1, VibrantAlloy, 1, EndSteel, 1, ConductiveIron, 1, NaquadahAlloy, 1, CrystallinePinkSlime, 6)
                    .color(0xDBFFFF)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .cableProperties(2097152, 36, 256, false)
                    .build();

            WeatherCrystal = new Material.Builder(getMetaItemId(), gregtechId("weather_crystal"))
                    .dust()
                    .color(0x793BAB)
                    .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                    .build();

            MoonStone = new Material.Builder(getMetaItemId(), gregtechId("moon_stone"))
                    .dust()
                    .color(0x6D6D6D)
                    .iconSet(ROUGH)
                    .build();

            MarsStone = new Material.Builder(getMetaItemId(), gregtechId("mars_stone"))
                    .dust()
                    .color(0x841C02)
                    .iconSet(ROUGH)
                    .build();

            AsteroidStone = new Material.Builder(getMetaItemId(), gregtechId("asteroid_stone"))
                    .dust()
                    .color(0x2D2C27)
                    .iconSet(ROUGH)
                    .build();

            VenusStone = new Material.Builder(getMetaItemId(), gregtechId("venus_stone"))
                    .dust()
                    .color(0x634B44)
                    .iconSet(ROUGH)
                    .build();

            MercuryStone = new Material.Builder(getMetaItemId(), gregtechId("mercury_stone"))
                    .dust()
                    .color(0x4E4D6B)
                    .iconSet(ROUGH)
                    .build();

            CeresStone = new Material.Builder(getMetaItemId(), gregtechId("ceres_stone"))
                    .dust()
                    .color(0x65647F)
                    .iconSet(ROUGH)
                    .build();

            JupiterStone = new Material.Builder(getMetaItemId(), gregtechId("jupiter_stone"))
                    .dust()
                    .color(0xDD9B68)
                    .iconSet(ROUGH)
                    .build();

            SaturnStone = new Material.Builder(getMetaItemId(), gregtechId("saturn_stone"))
                    .dust()
                    .color(0xA5744F)
                    .iconSet(ROUGH)
                    .build();

            UranusStone = new Material.Builder(getMetaItemId(), gregtechId("uranus_stone"))
                    .dust()
                    .color(0x88B4FC)
                    .iconSet(ROUGH)
                    .build();

            NeptuneStone = new Material.Builder(getMetaItemId(), gregtechId("neptune_stone"))
                    .dust()
                    .color(0x166DF9)
                    .iconSet(ROUGH)
                    .build();

            PlutoStone = new Material.Builder(getMetaItemId(), gregtechId("pluto_stone"))
                    .dust()
                    .color(0x5B5B5B)
                    .iconSet(ROUGH)
                    .build();

            ErisStone = new Material.Builder(getMetaItemId(), gregtechId("eris_stone"))
                    .dust()
                    .color(0x979E91)
                    .iconSet(ROUGH)
                    .build();

            Kepler22bStone = new Material.Builder(getMetaItemId(), gregtechId("kepler_twotwob_stone"))
                    .dust()
                    .color(0xA58359)
                    .iconSet(ROUGH)
                    .build();

            EuropaStone = new Material.Builder(getMetaItemId(), gregtechId("europa_stone"))
                    .dust()
                    .color(0x847670)
                    .iconSet(ROUGH)
                    .build();

            IoStone = new Material.Builder(getMetaItemId(), gregtechId("io_stone"))
                    .dust()
                    .color(0xD18F3E)
                    .iconSet(ROUGH)
                    .build();

            DeimosStone = new Material.Builder(getMetaItemId(), gregtechId("deimos_stone"))
                    .dust()
                    .color(0xC1A58D)
                    .iconSet(ROUGH)
                    .build();

            PhobosStone = new Material.Builder(getMetaItemId(), gregtechId("phobos_stone"))
                    .dust()
                    .color(0x846B57)
                    .iconSet(ROUGH)
                    .build();

            TritonStone = new Material.Builder(getMetaItemId(), gregtechId("triton_stone"))
                    .dust()
                    .color(0x7C797C)
                    .iconSet(ROUGH)
                    .build();

            CallistoStone = new Material.Builder(getMetaItemId(), gregtechId("callisto_stone"))
                    .dust()
                    .color(0x543A28)
                    .iconSet(ROUGH)
                    .build();

            GanymedeStone = new Material.Builder(getMetaItemId(), gregtechId("ganymede_stone"))
                    .dust()
                    .color(0x4F4943)
                    .iconSet(ROUGH)
                    .build();

            RheaStone = new Material.Builder(getMetaItemId(), gregtechId("rhea_stone"))
                    .dust()
                    .color(0x333333)
                    .iconSet(ROUGH)
                    .build();

            TitanStone = new Material.Builder(getMetaItemId(), gregtechId("titan_stone"))
                    .dust()
                    .color(0x332B1F)
                    .iconSet(ROUGH)
                    .build();

            OberonStone = new Material.Builder(getMetaItemId(), gregtechId("oberon_stone"))
                    .dust()
                    .color(0x897A88)
                    .iconSet(ROUGH)
                    .build();

            TitaniaStone = new Material.Builder(getMetaItemId(), gregtechId("titania_stone"))
                    .dust()
                    .color(0x8B8F93)
                    .iconSet(ROUGH)
                    .build();

            IapetusStone = new Material.Builder(getMetaItemId(), gregtechId("iapetus_stone"))
                    .dust()
                    .color(0x35230E)
                    .iconSet(ROUGH)
                    .build();

            if (LogisticsPipes.isModLoaded()) {
                SandCompound = new Material.Builder(getMetaItemId(), gregtechId("sand_compound"))
                        .dust()
                        .color(0xB4B394)
                        .iconSet(GTHHMaterialIconSet.SANDCOMPOUND)
                        .build();
            }
        }
    }

    private static int getMetaItemId() {
        if (startId < endId){
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}