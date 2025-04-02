package org.gthhcore.api.unification.materials.material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static org.gthhcore.api.unification.material.info.GTHHMaterialFlags.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.api.util.GTHHMods.*;

import org.gthhcore.api.unification.GTHHElements;
import org.gthhcore.api.unification.materials.info.GTHHMaterialIconSet;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;

public class GTHHModIntegrationMaterials {

    private static int startId = 12000;
    private static int endId = 12499;

    public static void register() {
        // Applied Energistics 2
        ChargedCertusQuartz = new Material.Builder(getMetaItemId(), gregtechId("charged_certus_quartz"))
                .dust()
                .gem(2)
                .ore(true)
                .flags(GENERATE_ALL_GEM, DISABLE_DECOMPOSITION)
                .components(Silicon, 1, Oxygen, 2)
                .color(0x7697A6)
                .iconSet(MaterialIconSet.CERTUS)
                .build();

        Fluix = new Material.Builder(getMetaItemId(), gregtechId("fluix"))
                .dust()
                .gem(2)
                .ore(true)
                .flags(GENERATE_ALL_GEM)
                .components(ChargedCertusQuartz, 1, CertusQuartz, 1, Redstone, 1)
                .color(0x832FBA)
                .iconSet(MaterialIconSet.CERTUS)
                .build();

        FluixPearl = new Material.Builder(getMetaItemId(), gregtechId("fluix_pearl"))
                .dust()
                .gem(2)
                .flags(GENERATE_ALL_GEM)
                .components(Fluix, 1, EnderPearl, 1)
                .iconSet(GTHHMaterialIconSet.PEARL)
                .color(0x832FBA)
                .build();

        SkyStone = new Material.Builder(getMetaItemId(), gregtechId("skystone"))
                .dust(2)
                .flags(GENERATE_ALL_STONE, DISABLE_DECOMPOSITION)
                .color(0x001C1C)
                .iconSet(MaterialIconSet.CERTUS)
                .build();

        Fluixilized = new Material.Builder(getMetaItemId(), gregtechId("fluixilized"))
                .dust()
                .gem(2)
                .ore(true)
                .flags(GENERATE_ALL_GEM)
                .components(FluixPearl, 1, CertusQuartz, 1, Fluix, 1)
                .color(0xFF007F)
                .iconSet(MaterialIconSet.CERTUS)
                .build();

        // Avaritia
        CrystalMatrix = new Material.Builder(getMetaItemId(), gregtechId("crystal_matrix"))
                .dust()
                .ingot()
                .ore()
                .flags(GENERATE_ALL_METAL)
                .color(0x2BA8A2)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        CosmicNeutronium = new Material.Builder(getMetaItemId(), gregtechId("cosmic_neutronium"))
                .dust()
                .ingot()
                .ore()
                .flags(GENERATE_ALL_METAL)
                .blast(b -> b
                        .temp(10000, BlastProperty.GasTier.LOW)
                        .blastStats(VA[UEV], 8000)
                        .vacuumStats(VA[UHV]))
                .iconSet(GTHHMaterialIconSet.COSMICNEUTRONIUM)
                .element(GTHHElements.CosmicNeutronium)
                .build();

        InfinityCatalyst = new Material.Builder(getMetaItemId(), gregtechId("infinity_catalyst"))
                .dust()
                .gem()
                .ore()
                .flags(GENERATE_ALL_GEM)
                .iconSet(GTHHMaterialIconSet.INFINITYCATALYST)
                .element(GTHHElements.InfinityCatalyst)
                .build();

        Infinity = new Material.Builder(getMetaItemId(), gregtechId("infinity"))
                .dust()
                .ingot()
                .blast(b -> b
                        .temp(10000, BlastProperty.GasTier.LOW)
                        .blastStats(VA[UIV], 16000)
                        .vacuumStats(VA[UEV]))
                .flags(GENERATE_ALL_METAL)
                .iconSet(GTHHMaterialIconSet.INFINITY)
                .element(GTHHElements.Infinity)
                .cableProperties(V[MAX], 8192, (int) V[ZPM])
                .build();

        // Draconic Evolution
        Draconium = new Material.Builder(getMetaItemId(), gregtechId("draconium"))
                .dust()
                .ingot()
                .ore()
                .liquid(new FluidBuilder().temperature(5555))
                .flags(GENERATE_ALL_METAL)
                .blast(b -> b
                        .temp(5555, BlastProperty.GasTier.LOW)
                        .blastStats(VA[LuV], 2560)
                        .vacuumStats(VA[MV]))
                .iconSet(MaterialIconSet.SHINY)
                .element(GTHHElements.Draconium)
                .cableProperties(V[UEV], 4, (int) V[IV])
                .color(0x9500D6)
                .build();

        AwakenedDraconium = new Material.Builder(getMetaItemId(), gregtechId("awakened_draconium"))
                .dust()
                .ingot()
                .ore()
                .liquid(new FluidBuilder().temperature(7777))
                .flags(GENERATE_ALL_METAL)
                .blast(b -> b
                        .temp(7777, BlastProperty.GasTier.LOW)
                        .blastStats(VA[LuV], 2560)
                        .vacuumStats(VA[MV]))
                .iconSet(MaterialIconSet.SHINY)
                .element(GTHHElements.AwakenedDraconium)
                .cableProperties(V[UIV], 4, (int) V[LuV])
                .color(0xFF5D00)
                .build();

        // Ender Io
        ElectricalSteel = new Material.Builder(getMetaItemId(), gregtechId("electrical_steel"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(1688))
                .flags(GENERATE_ALL_METAL)
                .blast(b -> b
                        .temp(1688, BlastProperty.GasTier.LOW)
                        .blastStats(VA[MV], 1100))
                .components(Steel, 1, Silicon, 1)
                .color(0x999999)
                .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                .build();

        EnergeticAlloy = new Material.Builder(getMetaItemId(), gregtechId("energetic_alloy"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2100))
                .flags(GENERATE_ALL_METAL)
                .blast(b -> b
                        .temp(2100, BlastProperty.GasTier.LOW)
                        .blastStats(VA[MV], 1680))
                .components(Gold, 1, Redstone, 1, Glowstone, 1)
                .color(0xFF7402)
                .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                .cableProperties(V[MV], 4, 2, false)
                .build();

        VibrantAlloy = new Material.Builder(getMetaItemId(), gregtechId("vibrant_alloy"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2950))
                .flags(GENERATE_ALL_METAL)
                .blast(b -> b
                        .temp(2950, BlastProperty.GasTier.LOW)
                        .blastStats(VA[HV], 2052))
                .components(EnergeticAlloy, 1, EnderPearl, 1)
                .color(0xBEFF1C)
                .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                .cableProperties(V[EV], 8, 8, false)
                .build();

        RedstoneAlloy = new Material.Builder(getMetaItemId(), gregtechId("redstone_alloy"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(1750))
                .flags(GENERATE_ALL_METAL)
                .blast(b -> b
                        .temp(1750, BlastProperty.GasTier.LOW)
                        .blastStats(VA[MV], 860))
                .components(ElectricalSteel, 1, Redstone, 1, Silicon, 1)
                .color(0xCC3030)
                .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                .cableProperties(32, 1, 0, false)
                .build();

        ConductiveIron = new Material.Builder(getMetaItemId(), gregtechId("conductive_iron"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(1555))
                .flags(GENERATE_ALL_METAL)
                .blast(b -> b
                        .temp(1555, BlastProperty.GasTier.LOW)
                        .blastStats(VA[MV], 900))
                .components(RedstoneAlloy, 1, Steel, 1, Redstone, 1)
                .color(0xFFB4A5)
                .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                .cableProperties(32, 2, 1)
                .build();

        PulsatingIron = new Material.Builder(getMetaItemId(), gregtechId("pulsating_iron"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(1720))
                .flags(GENERATE_ALL_METAL)
                .blast(b -> b
                        .temp(1720, BlastProperty.GasTier.LOW)
                        .blastStats(VA[MV], 625))
                .components(EnderPearl, 1, Steel, 1)
                .color(0x9AFFB1)
                .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                .cableProperties(8, 1, 0, false)
                .build();

        PulsatingCrystal = new Material.Builder(getMetaItemId(), gregtechId("pulsating_crystal"))
                .dust()
                .gem(2)
                .color(0x3DFF9E)
                .flags(GENERATE_ALL_GEM)
                .components(Diamond, 1, PulsatingIron, 1)
                .iconSet(MaterialIconSet.EMERALD)
                .build();

        DarkSteel = new Material.Builder(getMetaItemId(), gregtechId("dark_steel"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(1690))
                .flags(GENERATE_ALL_METAL)
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
                .flags(GENERATE_ALL_METAL, DISABLE_DECOMPOSITION)
                .components(Gold, 1, Ash, 1)
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
                .flags(GENERATE_ALL_METAL)
                .components(DarkSteel, 1, Endstone, 1)
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
                .flags(GENERATE_ALL_METAL, DISABLE_DECOMPOSITION)
                .components(Clay, 1, QuartzSand, 1, Tin, 1)
                .blast(b -> b
                        .temp(1300, BlastProperty.GasTier.LOW)
                        .blastStats(VA[LV], 651))
                .color(0xCCC3B1)
                .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                .cableProperties(V[ULV], 1, 1, false)
                .build();

        CrystallineAlloy = new Material.Builder(getMetaItemId(), gregtechId("crystalline_alloy"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(3820))
                .flags(GENERATE_ALL_METAL)
                .components(Gold, 1, PulsatingCrystal, 1)
                .blast(b -> b
                        .temp(3820, BlastProperty.GasTier.LOW)
                        .blastStats(VA[EV], 2872))
                .color(0x91FFFF)
                .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                .cableProperties(V[IV], 16, 32, false)
                .build();

        MelodicAlloy = new Material.Builder(getMetaItemId(), gregtechId("melodic_alloy"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(3290))
                .flags(GENERATE_ALL_METAL, DISABLE_DECOMPOSITION)
                .components(EndSteel, 1)
                .blast(b -> b
                        .temp(3290, BlastProperty.GasTier.LOW)
                        .blastStats(VA[HV], 2490))
                .color(0xB26EB2)
                .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                .cableProperties(131072, 32, 128, false)
                .build();

        CrystallinePinkSlime = new Material.Builder(getMetaItemId(), gregtechId("crystalline_pink_slime"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(3890))
                .flags(GENERATE_ALL_METAL)
                .components(MelodicAlloy, 1, CrystallineAlloy, 1)
                .blast(b -> b
                        .temp(4890, BlastProperty.GasTier.LOW)
                        .blastStats(VA[EV], 1100))
                .color(0xFF99EF)
                .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                .cableProperties(V[LuV], 24, 64, false)
                .build();

        EnergeticSilver = new Material.Builder(getMetaItemId(), gregtechId("energetic_silver"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2085))
                .flags(GENERATE_ALL_METAL)
                .blast(b -> b
                        .temp(2085, BlastProperty.GasTier.LOW)
                        .blastStats(VA[MV], 1680))
                .components(Silver, 1, Redstone, 1, Glowstone, 1)
                .color(0x639ECC)
                .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                .cableProperties(V[HV], 4, 8, false)
                .build();

        VividAlloy = new Material.Builder(getMetaItemId(), gregtechId("vivid_alloy"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2925))
                .flags(GENERATE_ALL_METAL)
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
                .flags(GENERATE_ALL_METAL, DISABLE_DECOMPOSITION)
                .components(VividAlloy, 1, VibrantAlloy, 1, CrystallinePinkSlime, 1, NetherStar, 1)
                .blast(b -> b
                        .temp(5480, BlastProperty.GasTier.LOW)
                        .blastStats(VA[IV], 9950)
                        .vacuumStats(VA[EV] * 2, 2400))
                .color(0xDBFFFF)
                .iconSet(GTHHMaterialIconSet.ENDERIOINGOT)
                .cableProperties(V[MAX], 4, 0, false)
                .build();

        VibrantCrystal = new Material.Builder(getMetaItemId(), gregtechId("vibrant_crystal"))
                .dust()
                .gem(2)
                .color(0x4FA045)
                .flags(GENERATE_ALL_GEM)
                .components(Emerald, 1, VibrantAlloy, 1)
                .iconSet(MaterialIconSet.EMERALD)
                .build();

        EnderCrystal = new Material.Builder(getMetaItemId(), gregtechId("ender_crystal"))
                .dust()
                .gem(2)
                .color(0x3A7C27)
                .flags(GENERATE_ALL_GEM)
                .components(VibrantCrystal, 1)
                .iconSet(MaterialIconSet.EMERALD)
                .build();

        EnticingCrystal = new Material.Builder(getMetaItemId(), gregtechId("attractor_crystal"))
                .dust()
                .gem(2)
                .color(0x509375)
                .flags(GENERATE_ALL_GEM, DISABLE_DECOMPOSITION)
                .components(Emerald, 1)
                .iconSet(MaterialIconSet.EMERALD)
                .build();

        WeatherCrystal = new Material.Builder(getMetaItemId(), gregtechId("weather_crystal"))
                .dust()
                .gem(2)
                .color(0x4F1F60)
                .flags(GENERATE_ALL_GEM)
                .components(PulsatingCrystal, 2, VibrantCrystal, 2, EnderCrystal, 1)
                .iconSet(MaterialIconSet.EMERALD)
                .build();

        PrescientCrystal = new Material.Builder(getMetaItemId(), gregtechId("prescient_crystal"))
                .dust()
                .gem(2)
                .color(0x49A562)
                .flags(GENERATE_ALL_GEM, DISABLE_DECOMPOSITION)
                .components(VibrantCrystal, 1)
                .iconSet(MaterialIconSet.EMERALD)
                .build();

        // Planetary Stones
        MoonStone = new Material.Builder(getMetaItemId(), gregtechId("moon_stone"))
                .dust()
                .color(0x6D6D6D)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        MarsStone = new Material.Builder(getMetaItemId(), gregtechId("mars_stone"))
                .dust()
                .color(0x841C02)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        AsteroidStone = new Material.Builder(getMetaItemId(), gregtechId("asteroid_stone"))
                .dust()
                .color(0x2D2C27)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        VenusStone = new Material.Builder(getMetaItemId(), gregtechId("venus_stone"))
                .dust()
                .color(0x634B44)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        MercuryStone = new Material.Builder(getMetaItemId(), gregtechId("mercury_stone"))
                .dust()
                .color(0x4E4D6B)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        CeresStone = new Material.Builder(getMetaItemId(), gregtechId("ceres_stone"))
                .dust()
                .color(0x65647F)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        JupiterStone = new Material.Builder(getMetaItemId(), gregtechId("jupiter_stone"))
                .dust()
                .color(0xDD9B68)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        SaturnStone = new Material.Builder(getMetaItemId(), gregtechId("saturn_stone"))
                .dust()
                .color(0xA5744F)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        UranusStone = new Material.Builder(getMetaItemId(), gregtechId("uranus_stone"))
                .dust()
                .color(0x88B4FC)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        NeptuneStone = new Material.Builder(getMetaItemId(), gregtechId("neptune_stone"))
                .dust()
                .color(0x166DF9)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        PlutoStone = new Material.Builder(getMetaItemId(), gregtechId("pluto_stone"))
                .dust()
                .color(0x5B5B5B)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        ErisStone = new Material.Builder(getMetaItemId(), gregtechId("eris_stone"))
                .dust()
                .color(0x979E91)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        Kepler22bStone = new Material.Builder(getMetaItemId(), gregtechId("kepler_twotwob_stone"))
                .dust()
                .color(0xA58359)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        EuropaStone = new Material.Builder(getMetaItemId(), gregtechId("europa_stone"))
                .dust()
                .color(0x847670)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        IoStone = new Material.Builder(getMetaItemId(), gregtechId("io_stone"))
                .dust()
                .color(0xD18F3E)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        DeimosStone = new Material.Builder(getMetaItemId(), gregtechId("deimos_stone"))
                .dust()
                .color(0xC1A58D)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        PhobosStone = new Material.Builder(getMetaItemId(), gregtechId("phobos_stone"))
                .dust()
                .color(0x846B57)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        TritonStone = new Material.Builder(getMetaItemId(), gregtechId("triton_stone"))
                .dust()
                .color(0x7C797C)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        CallistoStone = new Material.Builder(getMetaItemId(), gregtechId("callisto_stone"))
                .dust()
                .color(0x543A28)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        GanymedeStone = new Material.Builder(getMetaItemId(), gregtechId("ganymede_stone"))
                .dust()
                .color(0x4F4943)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        RheaStone = new Material.Builder(getMetaItemId(), gregtechId("rhea_stone"))
                .dust()
                .color(0x333333)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        TitanStone = new Material.Builder(getMetaItemId(), gregtechId("titan_stone"))
                .dust()
                .color(0x332B1F)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        OberonStone = new Material.Builder(getMetaItemId(), gregtechId("oberon_stone"))
                .dust()
                .color(0x897A88)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        TitaniaStone = new Material.Builder(getMetaItemId(), gregtechId("titania_stone"))
                .dust()
                .color(0x8B8F93)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        IapetusStone = new Material.Builder(getMetaItemId(), gregtechId("iapetus_stone"))
                .dust()
                .color(0x35230E)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        // Logistics Pipes
        SandCompound = new Material.Builder(getMetaItemId(), gregtechId("sand_compound"))
                .dust()
                .color(0xB4B394)
                .iconSet(GTHHMaterialIconSet.SANDCOMPOUND)
                .components(Stone, 4, QuartzSand, 3, Clay, 2)
                .build();

        // Astral Sorcery
        Starmetal = new Material.Builder(getMetaItemId(), gregtechId("astral_starmetal"))
                .dust()
                .ore()
                .ingot()
                .liquid(new FluidBuilder().temperature(1))
                .flags(GENERATE_ALL_METAL)
                .color(0x2500D1)
                .iconSet(GTHHMaterialIconSet.STARMETAL)
                .build();

        Aquamarine = new Material.Builder(getMetaItemId(), gregtechId("aquamarine"))
                .dust()
                .ore()
                .gem(2)
                .flags(GENERATE_ALL_GEM)
                .components(Beryllium, 3, Aluminium, 2, Silicon, 6, Oxygen, 18)
                .color(0x008EFF)
                .iconSet(MaterialIconSet.DIAMOND)
                .build();

        // Botania
        ManaSteel = new Material.Builder(getMetaItemId(), gregtechId("manasteel"))
                .dust()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING)
                .color(0x008EFF)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        TerraSteel = new Material.Builder(getMetaItemId(), gregtechId("terrasteel"))
                .dust()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING)
                .color(0x2DFF4C)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        Elementium = new Material.Builder(getMetaItemId(), gregtechId("elementium"))
                .dust()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING)
                .color(0xFF2DEA)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        GaiaSpirit = new Material.Builder(getMetaItemId(), gregtechId("gaia_spirit"))
                .dust()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING)
                .color(0xFFFFFF)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        ManaDiamond = new Material.Builder(getMetaItemId(), gregtechId("mana_diamond"))
                .dust()
                .gem(2)
                .flags(GENERATE_ALL_GEM)
                .color(0x009FB0)
                .iconSet(MaterialIconSet.DIAMOND)
                .build();

        ManaPearl = new Material.Builder(getMetaItemId(), gregtechId("mana_pearl"))
                .dust()
                .gem(2)
                .flags(GENERATE_ALL_GEM)
                .color(0x007EA5)
                .iconSet(GTHHMaterialIconSet.PEARL)
                .build();

        // Galacticraft
        MeteoricIron = new Material.Builder(getMetaItemId(), gregtechId("meteoric_iron"))
                .dust()
                .ore()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING, GENERATE_COMPRESSED)
                .color(0x9B7753)
                .iconSet(MaterialIconSet.DULL)
                .build();

        Desh = new Material.Builder(getMetaItemId(), gregtechId("desh"))
                .dust()
                .ore()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING, GENERATE_COMPRESSED)
                .color(0x231D1D)
                .iconSet(MaterialIconSet.DULL)
                .build();

        // Extra Planets
        Crystal = new Material.Builder(getMetaItemId(), gregtechId("crystal"))
                .dust()
                .ore()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING, GENERATE_COMPRESSED)
                .color(0xE5E5E5)
                .iconSet(MaterialIconSet.DULL)
                .build();

        ReinforcedCrystal = new Material.Builder(getMetaItemId(), gregtechId("reinforced_crystal"))
                .dust()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING, GENERATE_COMPRESSED)
                .color(0xC9EFFF)
                .iconSet(MaterialIconSet.SHINY)
                .components(Crystal, 15, Neutronium, 3, NetherStar, 2)
                .build();

        WhiteGem = new Material.Builder(getMetaItemId(), gregtechId("white_gem"))
                .dust()
                .gem(2)
                .ore()
                .flags(GENERATE_ALL_GEM, NO_SMELTING, GENERATE_COMPRESSED)
                .color(0xE5E5E5)
                .iconSet(MaterialIconSet.DIAMOND)
                .build();

        BlueGem = new Material.Builder(getMetaItemId(), gregtechId("blue_gem"))
                .dust()
                .gem(2)
                .ore()
                .flags(GENERATE_ALL_GEM, NO_SMELTING, GENERATE_COMPRESSED)
                .color(0x0CD0FF)
                .iconSet(MaterialIconSet.DIAMOND)
                .build();

        BlueDiamond = new Material.Builder(getMetaItemId(), gregtechId("blue_diamond"))
                .dust()
                .gem(2)
                .ore()
                .flags(GENERATE_ALL_GEM, NO_SMELTING)
                .color(0x0C7BFF)
                .iconSet(MaterialIconSet.DIAMOND)
                .build();

        RedDiamond = new Material.Builder(getMetaItemId(), gregtechId("red_diamond"))
                .dust()
                .gem(2)
                .ore()
                .flags(GENERATE_ALL_GEM, NO_SMELTING)
                .color(0xFF1F0C)
                .iconSet(MaterialIconSet.DIAMOND)
                .build();

        PurpleDiamond = new Material.Builder(getMetaItemId(), gregtechId("purple_diamond"))
                .dust()
                .gem(2)
                .ore()
                .flags(GENERATE_ALL_GEM, NO_SMELTING)
                .color(0x770CFF)
                .iconSet(MaterialIconSet.DIAMOND)
                .build();

        YellowDiamond = new Material.Builder(getMetaItemId(), gregtechId("yellow_diamond"))
                .dust()
                .gem(2)
                .ore()
                .flags(GENERATE_ALL_GEM, NO_SMELTING)
                .color(0xFFF10C)
                .iconSet(MaterialIconSet.DIAMOND)
                .build();

        GreenDiamond = new Material.Builder(getMetaItemId(), gregtechId("green_diamond"))
                .dust()
                .gem(2)
                .ore()
                .flags(GENERATE_ALL_GEM, NO_SMELTING)
                .color(0x2DFF0C)
                .iconSet(MaterialIconSet.DIAMOND)
                .build();

        DarkIron = new Material.Builder(getMetaItemId(), gregtechId("dark_iron"))
                .dust()
                .ore()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING, GENERATE_COMPRESSED)
                .color(0x191919)
                .iconSet(MaterialIconSet.SHINY)
                .build();
    }

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
