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
    public static final List<MaterialFlag> GENERATE_ALL_STONE = new ArrayList<>();

    static {
        // Update These if new Material Items are added
        GENERATE_ALL_METAL.addAll(
                EXT2_METAL);
        GENERATE_ALL_METAL.addAll(Arrays.asList(
                EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES,
                GENERATE_PLATE,
                GENERATE_SPRING,
                GENERATE_SPRING_SMALL,
                GENERATE_RING,
                GENERATE_ROUND,
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
                GENERATE_PLATE,
                GENERATE_BOLT_SCREW,
                GENERATE_FRAME,
                GENERATE_GEAR));

        GENERATE_ALL_STONE.addAll(Arrays.asList(
                NO_SMASHING,
                NO_WORKING,
                EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES,
                EXCLUDE_BLOCK_CRAFTING_RECIPES,
                GENERATE_PLATE,
                GENERATE_DENSE));
    }

    // Element Materials
    public static Material Multiversium;
    public static Material Infernorite;
    public static Material Crynorium;
    public static Material ElectroMatter;
    public static Material MissingError;
    public static Material Protactinium226;
    public static Material Protactinium231;
    public static Material Neptunium228;
    public static Material Neptunium237;

    // Fluid Materials
    public static Material DirtyPreciousMetalSolution;
    public static Material DilutePreciousMetalSolution;
    public static Material CleanPreciousMetalSolution;
    public static Material ConcentratedPreciousMetalSolution;
    public static Material CoalSlurry;
    public static Material Coolant;
    public static Material SpaceCoolant;
    public static Material HotCoolant;
    public static Material HotSodiumPotassium;
    public static Material HotSpaceCoolant;
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
    public static Material MicaInsulator;
    public static Material SilverGallium;
    public static Material Tantaloper;
    public static Material Zinvar;
    public static Material SterlingPlatinum;

    // Second Degree Materials
    public static Material SaltsCatalyst;
    public static Material Mytryl;
    public static Material Tetrapech;
    public static Material CosmicCarbon;
    public static Material Oriharukon;
    public static Material OriharukonArgentinium;

    // Third Degree Materials
    public static Material Chronarium;
    public static Material BlackPlutonium;
    public static Material Bedrockium;
    public static Material Quaintum;
    public static Material ChronosSteel;

    // Forth Degree Materials
    public static Material TemporallyConstrainedStarMatter;
    public static Material FluxedElectrum;
    public static Material PrismaticVoidMatter;
    public static Material FluxedAwakenedDraconium;

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

    // Galacticraft
    public static Material MeteoricIron;
    public static Material Desh;
    public static Material Crystal;
    public static Material ReinforcedCrystal;
    public static Material WhiteGem;
    public static Material BlueGem;
    public static Material BlueDiamond;
    public static Material RedDiamond;
    public static Material PurpleDiamond;
    public static Material YellowDiamond;
    public static Material GreenDiamond;
    public static Material DarkIron;

    // Nuclear Materials
    public static Material EnrichedProtactinium;
    public static Material EnrichedUranium;
    public static Material EnrichedNeptunium;
    public static Material EnrichedPlutonium;
    public static Material EnrichedAmericium;
    public static Material EnrichedCurium;
    public static Material EnrichedBerkelium;
    public static Material EnrichedCalifornium;
    public static Material EnrichedEinsteinium;
    public static Material EnrichedFermium;
    public static Material EnrichedMendelevium;
    public static Material EnrichedNobelium;
    public static Material EnrichedLawrencium;

    public static void init() {
        /*
         * GT: Higher & Higher Material Registry
         */

        /*
         * Ranges 0-999
         * Any Material That is an Element Goes Here
         */
        GTHHElementMaterials.register();

        /*
         * Ranges 1000-1999
         * All Mod Integration Materials Go Here
         */
        GTHHModIntegrationMaterials.register();

        /*
         * Ranges 2000-2999
         * NOT USED YET
         */
        GTHHFantasyMaterials.register();

        /*
         * Ranges 3000-3999
         * LV -> EV Materials
         */
        GTHHFirstDegreeMaterials.register();

        /*
         * Ranges 4000-4999
         * IV -> UV Materials
         */
        GTHHSecondDegreeMaterials.register();

        /*
         * Ranges 5000-5999
         * UHV -> UXV Materials
         */
        GTHHThirdDegreeMaterials.register();

        /*
         * Ranges 6000-6999
         * UXV -> MAX Materials
         */
        GTHHForthDegreeMaterials.register();

        /*
         * Ranges 7000-7999
         * Any Single Fluid Materials Go Here
         */
        GTHHFluidMaterials.register();

        /*
         * Ranges 8000-8999
         * Nuclear Based Materials Go Here
         */
        GTHHNuclearMaterials.register();

        /*
         * GT: Higher & Higher MaterialFlagAddition Registry
         */
        GTHHMaterialFlagAddition.init();

        /*
         * GT: Higher & Higher OrePrefix Registry
         */
        GTHHOrePrefix.init();
    }
}
