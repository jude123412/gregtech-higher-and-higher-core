package org.gthhcore.api.unification.materials.material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;

import org.gthhcore.api.unification.materials.info.GTHHMaterialIconSet;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;

public class GTHHFirstDegreeMaterials {

    private static int startId = 10000;
    private static int endId = 10499;

    public static void register() {
        // LV -> EV Materials
        Cryotheum = new Material.Builder(getMetaItemId(), gregtechId("cryotheum"))
                .dust()
                .liquid(new FluidBuilder().temperature(393))
                .components(Blaze, 2, Redstone, 1, Saltpeter, 1)
                .color(0x00AEFF)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        Pyrotheum = new Material.Builder(getMetaItemId(), gregtechId("pyrotheum"))
                .dust()
                .liquid(new FluidBuilder().temperature(1473))
                .components(Blaze, 2, Redstone, 1, Sulfur, 1)
                .color(0xFF9000)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        MicaInsulator = new Material.Builder(getMetaItemId(), gregtechId("mica_insulator"))
                .polymer()
                .dust()
                .iconSet(FINE)
                .components(Mica, 3, Asbestos, 2, RawRubber, 3)
                .color(0xCC9B28)
                .build();

        Albite = new Material.Builder(getMetaItemId(), gregtechId("albite"))
                .dust()
                .gem()
                .ore()
                .components(Sodium, 1, Aluminium, 1, Silicon, 3, Oxygen, 8)
                .color(0xFDFFD1)
                .iconSet(GTHHMaterialIconSet.ALBITE)
                .build();

        Anorthite = new Material.Builder(getMetaItemId(), gregtechId("Anorthite"))
                .dust()
                .gem()
                .ore()
                .components(Calcium, 1, Aluminium, 2, Silicon, 2, Oxygen, 8)
                .color(0xC8C9A5)
                .iconSet(MaterialIconSet.RUBY)
                .build();

        Plagioclase = new Material.Builder(getMetaItemId(), gregtechId("plagioclase"))
                .dust()
                .gem()
                .ore()
                .components(Calcium, 1, Sodium, 1, Aluminium, 3, Silicon, 5, Oxygen, 16)
                .color(0x535B4C)
                .iconSet(GTHHMaterialIconSet.PLAGIOCLASE)
                .build();

        Pyroxene = new Material.Builder(getMetaItemId(), gregtechId("pyroxene"))
                .dust()
                .gem()
                .ore()
                .components(Magnesium, 1, Lithium, 1, Silicon, 2, Oxygen, 6)
                .color(0x334225)
                .iconSet(MaterialIconSet.EMERALD)
                .build();

        Carbonate = new Material.Builder(getMetaItemId(), gregtechId("carbonate"))
                .dust()
                .ore()
                .components(Hydrogen, 2, Carbon, 1, Oxygen, 3)
                .color(0xE8DADA)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        AmmoniatedSilicate = new Material.Builder(getMetaItemId(), gregtechId("ammoniated_silicate"))
                .dust()
                .gem()
                .ore()
                .components(Nitrogen, 1, Hydrogen, 3, Silicon, 1, Oxygen, 4)
                .color(0x9B70C1)
                .iconSet(MaterialIconSet.QUARTZ)
                .build();

        PreciousMetals = new Material.Builder(getMetaItemId(), gregtechId("precious_metals"))
                .dust()
                .ingot()
                .ore()
                .liquid(new FluidBuilder().temperature(1263))
                .color(0xE09D00)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        Cryolite = new Material.Builder(getMetaItemId(), gregtechId("cryolite"))
                .dust()
                .ore()
                .addOreByproducts(Sodium, Aluminium, PreciousMetals)
                .components(Sodium, 3, Aluminium, 1, Fluorine, 6)
                .color(0x7FD8FF)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        SolarGradeSilicon = new Material.Builder(getMetaItemId(), gregtechId("solar_grade_silicon"))
                .dust()
                .ingot()
                .ore()
                .flags(EXT2_METAL, GENERATE_FRAME, GENERATE_DENSE, GENERATE_FOIL, GENERATE_DOUBLE_PLATE)
                .liquid(new FluidBuilder().temperature(2273))
                .blast(b -> b
                        .temp(2273, BlastProperty.GasTier.LOW)
                        .blastStats(VA[MV], 1568))
                .color(0x3C3C50)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        SilverGallium = new Material.Builder(getMetaItemId(), gregtechId("silver_gallium"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2105))
                .flags(EXT2_METAL, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_BOLT_SCREW, GENERATE_RING)
                .blast(b -> b
                        .temp(2105, BlastProperty.GasTier.LOW)
                        .blastStats(VA[MV], 1200))
                .components(Silver, 2, Gallium, 1)
                .color(0xBCFCFF)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        Tantaloper = new Material.Builder(getMetaItemId(), gregtechId("tantaloper"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(1990))
                .flags(EXT2_METAL, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_BOLT_SCREW, GENERATE_RING)
                .blast(b -> b
                        .temp(1990, BlastProperty.GasTier.LOW)
                        .blastStats(VA[EV], L * 4))
                .components(Tantalum, 5, Copper, 2, Gold, 1)
                .color(0xc3b058)
                .iconSet(MaterialIconSet.SHINY)
                .build();
        Zinvar = new Material.Builder(getMetaItemId(), gregtechId("zinvar"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(1985))
                .flags(EXT2_METAL, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_BOLT_SCREW, GENERATE_RING)
                .blast(b -> b
                        .temp(1985, BlastProperty.GasTier.LOW)
                        .blastStats(VA[EV], L * 5))
                .components(Invar, 3, Zinc, 1)
                .color(0xA9C130)
                .iconSet(MaterialIconSet.DULL)
                .build();

        SterlingPlatinum = new Material.Builder(getMetaItemId(), gregtechId("sterling_platinum"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2234))
                .flags(EXT2_METAL, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_BOLT_SCREW, GENERATE_RING)
                .blast(b -> b
                        .temp(2234, BlastProperty.GasTier.LOW)
                        .blastStats(VA[EV], L * 7))
                .components(Silver, 1, Platinum, 4)
                .color(0xFFF9C6)
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
