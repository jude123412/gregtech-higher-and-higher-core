package org.gthhcore.api.unification.materials.material;

import gregtech.api.unification.material.Material;
import net.minecraft.block.BlockEndPortal;
import net.minecraft.client.renderer.tileentity.TileEntityEndPortalRenderer;
import org.gthhcore.api.unification.material.materials.GTHHMaterialFlagAddition;
import org.gthhcore.api.unification.materials.material.info.GTHHElementMaterials;
import org.gthhcore.api.unification.ore.GTHHOrePrefix;

public class GTHHMaterials {


    // Element Materials
    public static Material CosmicNeutronium;
    public static Material InfinityCatalyst;
    public static Material Infinity;
    public static Material Multiversium;
    public static Material Infernorite;
    public static Material Crynorium;
    public static Material Draconium;
    public static Material AwakenedDraconium;
    public static Material ElectroMatter;
    public static Material MissingError;

    // Fluid Materials
    public static Material DirtyPreciousMetalSolution;
    public static Material DilutePreciousMetalSolution;
    public static Material CleanPreciousMetalSolution;
    public static Material ConcentratedPreciousMetalSolution;
    public static Material CoalSlurry;
    public static Material Coolant;
    public static Material SpaceCoolant;
    public static Material PhotovoltaicComposite;
    public static Material RawSlimeGrowthMedium;
    public static Material SterileSlimeGrowthMedium;
    public static Material SlimeCulture;
    public static Material SlimeSolder;
    public static Material SaltsSolution;

    // Ore Materials
    public static Material Albite;
    public static Material Anorthite;
    public static Material Plagioclase;
    public static Material Pyroxene;
    public static Material Carbonate;
    public static Material AmmoniatedSilicate;
    public static Material PreciousMetals;
    public static Material Cryolite;
    public static Material SolarGradeSilicon;

    // Second Degree Materials
    public static Material SaltsCatalyst;
    public static Material MicaInsulator;
    public static Material VividAlloy;
    public static Material VibrantAlloy;
    public static Material StellarAlloy;
    public static Material Soularium;
    public static Material RedstoneAlloy;
    public static Material PulsatingIron;
    public static Material MelodicAlloy;
    public static Material EnergeticSilver;
    public static Material EnergeticAlloy;
    public static Material EndSteel;
    public static Material ElectricalSteel;
    public static Material DarkSteel;
    public static Material CrystallinePinkSlime;
    public static Material CrystallineAlloy;
    public static Material CrudeSteel;
    public static Material ConductiveIron;
    public static Material WeatherCrystal;
    public static Material SandCompound;
    public static Material Pyrotheum;
    public static Material Cryotheum;
    public static Material MoonStone;
    public static Material MarsStone;
    public static Material AsteroidStone;
    public static Material VenusStone;
    public static Material MercuryStone;
    public static Material CeresStone;
    public static Material JupiterStone;
    public static Material SaturnStone;
    public static Material UranusStone;
    public static Material NeptuneStone;
    public static Material PlutoStone;
    public static Material ErisStone;
    public static Material Kepler22bStone;
    public static Material EuropaStone;
    public static Material IoStone;
    public static Material DeimosStone;
    public static Material PhobosStone;
    public static Material TritonStone;
    public static Material CallistoStone;
    public static Material GanymedeStone;
    public static Material RheaStone;
    public static Material TitanStone;
    public static Material OberonStone;
    public static Material TitaniaStone;
    public static Material IapetusStone;

    // Third Degree Materials
    public static Material Sand;
    public static Material SilverGallium;
    public static Material Tantaloper;
    public static Material Zinvar;
    public static Material SterlingPlatinum;
    public static Material Mytryl;
    public static Material CosmicCarbon;
    public static Material Tetrapech;

    // Mod Integration Materials
    public static Material ChargedCertusQuartz;
    public static Material Fluix;
    public static Material Fluixilized;
    public static Material FluixPearl;
    public static Material SkyStone;


    public static void init() {
        GTHHElementMaterials.register();
        GTHHFantasyMaterials.register();
        GTHHFirstDegreeMaterials.register();
        GTHHSecondDegreeMaterials.register();
        GTHHThirdDegreeMaterials.register();
        GTHHFluidMaterials.register();
        GTHHModIntegrationMaterials.register();
        GTHHMaterialFlagAddition.init();
        GTHHOrePrefix.init();
    }
}
