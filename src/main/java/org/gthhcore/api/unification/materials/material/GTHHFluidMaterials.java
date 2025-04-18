package org.gthhcore.api.unification.materials.material;

import static gregtech.api.fluids.attribute.FluidAttributes.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.api.util.GTHHUtility.gthhId;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;

public class GTHHFluidMaterials {

    private static int startId = 7000;
    private static int endId = 7999;

    public static void register() {
        // Anything that is a fluid : Liquid, Plasma or gas Only

        RawSlimeGrowthMedium = new Material.Builder(getMetaItemId(), gthhId("raw_slime_growth_medium"))
                .liquid(new FluidBuilder())
                .color(0x56CE56)
                .iconSet(FLUID)
                .build();

        SterileSlimeGrowthMedium = new Material.Builder(getMetaItemId(), gthhId("sterile_slime_growth_medium"))
                .liquid(new FluidBuilder())
                .color(0x005500)
                .iconSet(FLUID)
                .build();

        SlimeCulture = new Material.Builder(getMetaItemId(), gthhId("slime_culture"))
                .liquid(new FluidBuilder())
                .color(0x81CC00)
                .iconSet(DULL)
                .build();

        SlimeSolder = new Material.Builder(getMetaItemId(), gthhId("slime_solder"))
                .liquid(new FluidBuilder())
                .color(0x5D995D)
                .components(MissingError, 72, InfinityCatalyst, 2, Crynorium, 64, Bismuth, 128, Tin, 128)
                .iconSet(DULL)
                .build();

        SaltsSolution = new Material.Builder(getMetaItemId(), gthhId("salts_solution"))
                .liquid(new FluidBuilder().temperature(1256))
                .color(0xFFDAC6)
                .iconSet(DULL)
                .components(SaltsCatalyst, 2, Polybenzimidazole, 1)
                .build();

        DirtyPreciousMetalSolution = new Material.Builder(getMetaItemId(), gthhId("dirty_precious_metal_solution"))
                .liquid(new FluidBuilder()
                        .attribute(ACID)
                        .temperature(293))
                .color(0xB29A00)
                .iconSet(FLUID)
                .build();

        DilutePreciousMetalSolution = new Material.Builder(getMetaItemId(), gthhId("dilute_precious_metal_solution"))
                .liquid(new FluidBuilder()
                        .attribute(ACID)
                        .temperature(293))
                .color(0xDDBC6C)
                .iconSet(FLUID)
                .build();

        CleanPreciousMetalSolution = new Material.Builder(getMetaItemId(), gthhId("clean_precious_metal_solution"))
                .liquid(new FluidBuilder()
                        .attribute(ACID)
                        .temperature(293))
                .color(0xFFD77C)
                .iconSet(FLUID)
                .build();

        ConcentratedPreciousMetalSolution = new Material.Builder(getMetaItemId(),
                gthhId("concentrated_precious_metal_solution"))
                        .liquid(new FluidBuilder()
                                .attribute(ACID)
                                .temperature(293))
                        .color(0xFFB619)
                        .iconSet(FLUID)
                        .build();

        CoalSlurry = new Material.Builder(getMetaItemId(), gthhId("coal_slurry"))
                .liquid(new FluidBuilder()
                        .temperature(293))
                .color(0x4F4F4F)
                .iconSet(FLUID)
                .build();

        Coolant = new Material.Builder(getMetaItemId(), gthhId("coolant"))
                .liquid(new FluidBuilder()
                        .temperature(293))
                .color(0x0F0FAD)
                .iconSet(FLUID)
                .build();

        SpaceCoolant = new Material.Builder(getMetaItemId(), gthhId("space_coolant"))
                .liquid(new FluidBuilder()
                        .temperature(293))
                .color(0x00FF00)
                .iconSet(FLUID)
                .build();

        HotCoolant = new Material.Builder(getMetaItemId(), gthhId("hot_coolant"))
                .liquid(new FluidBuilder()
                        .temperature(293))
                .color(0xE60FAD)
                .iconSet(FLUID)
                .build();

        HotSodiumPotassium = new Material.Builder(getMetaItemId(), gthhId("hot_sodium_potassium"))
                .liquid(new FluidBuilder()
                        .temperature(293))
                .color(0xFFBDAD)
                .iconSet(FLUID)
                .build();

        HotSpaceCoolant = new Material.Builder(getMetaItemId(), gthhId("hot_space_coolant"))
                .liquid(new FluidBuilder()
                        .temperature(293))
                .color(0xFFFF00)
                .iconSet(FLUID)
                .build();

        PhotovoltaicComposite = new Material.Builder(getMetaItemId(), gthhId("photovoltaic_composite"))
                .liquid(new FluidBuilder()
                        .temperature(1120))
                .color(0x313156)
                .iconSet(DULL)
                .build();
    }

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
