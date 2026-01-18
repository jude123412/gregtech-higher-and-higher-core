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
    public static Material NeutroniumSteel;

    // Forth Degree Materials
    public static Material TemporallyConstrainedStarMatter;
    public static Material FluxedElectrum;
    public static Material PrismaticVoidMatter;
    public static Material FluxedAwakenedDraconium;

    // Mod Integration Materials
    // Logistics Pipes
    public static Material SandCompound;

    // Stone Type Stones
    public static Material MoonStone;
    public static Material MarsStone;
    public static Material AsteroidStone;
    public static Material VenusStone;
    public static Material MercuryStone;
    public static Material CeresStone;
    public static Material PlutoStone;
    public static Material HaumeaStone;
    public static Material PhobosStone;
    public static Material IoStone;
    public static Material EuropaStone;
    public static Material GanymedeStone;
    public static Material CallistoStone;
    public static Material EnceladusStone;
    public static Material TitanStone;
    public static Material MirandaStone;
    public static Material TritonStone;

    // Nuclear Materials

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
