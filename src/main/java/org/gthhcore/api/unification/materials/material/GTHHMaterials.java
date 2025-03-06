package org.gthhcore.api.unification.materials.material;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.gthhcore.api.unification.material.materials.GTHHMaterialFlagAddition;
import org.gthhcore.api.unification.materials.material.info.GTHHElementMaterials;
import org.gthhcore.api.unification.ore.GTHHOrePrefix;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlag;

public class GTHHMaterials {

    public static final List<MaterialFlag> GENERATE_ALL_GEM = new ArrayList<>();
    public static final List<MaterialFlag> GENERATE_ALL_METAL = new ArrayList<>();

    static {
        // Update These if new Material Items are added
        GENERATE_ALL_METAL.addAll(
                EXT2_METAL);
        GENERATE_ALL_METAL.addAll(Arrays.asList(
                EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES,
                GENERATE_SPRING,
                GENERATE_SPRING_SMALL,
                GENERATE_RING,
                GENERATE_ROTOR,
                GENERATE_SMALL_GEAR,
                GENERATE_FRAME,
                GENERATE_DENSE,
                GENERATE_FOIL,
                GENERATE_GEAR,
                GENERATE_DOUBLE_PLATE,
                GENERATE_FINE_WIRE));

        GENERATE_ALL_GEM.addAll(Arrays.asList(
                NO_SMASHING,
                NO_WORKING,
                EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES,
                EXCLUDE_BLOCK_CRAFTING_RECIPES,
                GENERATE_BOLT_SCREW,
                GENERATE_SMALL_GEAR,
                GENERATE_FRAME,
                GENERATE_GEAR));
    }

    // Element Materials
    public static Material Multiversium;
    public static Material Infernorite;
    public static Material Crynorium;
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

    // First Degree Materials
    public static Material Pyrotheum;
    public static Material Cryotheum;

    // Second Degree Materials
    public static Material SaltsCatalyst;
    public static Material MicaInsulator;

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

    // AE2
    public static Material ChargedCertusQuartz;
    public static Material Fluix;
    public static Material Fluixilized;
    public static Material FluixPearl;
    public static Material SkyStone;

    // Avaritia
    public static Material CrystalMatrix;
    public static Material CosmicNeutronium;
    public static Material InfinityCatalyst;
    public static Material Infinity;

    // Draconic Evolution
    public static Material Draconium;
    public static Material AwakenedDraconium;

    // Ender Io
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
    public static Material PulsatingCrystal;
    public static Material VibrantCrystal;
    public static Material EnderCrystal;
    public static Material EnticingCrystal;
    public static Material WeatherCrystal;
    public static Material PrescientCrystal;

    // Logistics Pipes
    public static Material SandCompound;

    // Advanced Rocketry
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

    // Astral Sorcery
    public static Material Starmetal;
    public static Material Aquamarine;

    // Botania
    public static Material ManaSteel;
    public static Material TerraSteel;
    public static Material Elementium;
    public static Material ManaDiamond;
    public static Material ManaPearl;
    public static Material GaiaSpirit;

    public static void init() {
        GTHHElementMaterials.register();
        GTHHModIntegrationMaterials.register();
        GTHHFantasyMaterials.register();
        GTHHFirstDegreeMaterials.register();
        GTHHSecondDegreeMaterials.register();
        GTHHThirdDegreeMaterials.register();
        GTHHFluidMaterials.register();
        GTHHMaterialFlagAddition.init();
        GTHHOrePrefix.init();
    }
}
