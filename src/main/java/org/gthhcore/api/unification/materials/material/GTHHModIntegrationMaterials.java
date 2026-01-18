package org.gthhcore.api.unification.materials.material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static org.gthhcore.api.unification.material.info.GTHHMaterialFlags.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.api.util.GTHHUtility.gthhId;

import org.gthhcore.api.unification.GTHHElements;
import org.gthhcore.api.unification.materials.info.GTHHMaterialIconSet;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;

public class GTHHModIntegrationMaterials {

    private static int startId = 1000;
    private static int endId = 1999;

    public static void register() {
        // Planetary Stones
        MoonStone = new Material.Builder(getMetaItemId(), gthhId("moon_stone"))
                .dust()
                .color(0x6D6D6D)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        MarsStone = new Material.Builder(getMetaItemId(), gthhId("mars_stone"))
                .dust()
                .color(0x841C02)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        AsteroidStone = new Material.Builder(getMetaItemId(), gthhId("asteroid_stone"))
                .dust()
                .color(0x2D2C27)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        VenusStone = new Material.Builder(getMetaItemId(), gthhId("venus_stone"))
                .dust()
                .color(0x634B44)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        MercuryStone = new Material.Builder(getMetaItemId(), gthhId("mercury_stone"))
                .dust()
                .color(0x4E4D6B)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        CeresStone = new Material.Builder(getMetaItemId(), gthhId("ceres_stone"))
                .dust()
                .color(0x65647F)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        PlutoStone = new Material.Builder(getMetaItemId(), gthhId("pluto_stone"))
                .dust()
                .color(0x5B5B5B)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        HaumeaStone = new Material.Builder(getMetaItemId(), gthhId("haumea_stone"))
                .dust()
                .color(0x5B5B5B)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        PhobosStone = new Material.Builder(getMetaItemId(), gthhId("phobos_stone"))
                .dust()
                .color(0x846B57)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        IoStone = new Material.Builder(getMetaItemId(), gthhId("io_stone"))
                .dust()
                .color(0xD18F3E)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        EuropaStone = new Material.Builder(getMetaItemId(), gthhId("europa_stone"))
                .dust()
                .color(0x847670)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        GanymedeStone = new Material.Builder(getMetaItemId(), gthhId("ganymede_stone"))
                .dust()
                .color(0x4F4943)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        CallistoStone = new Material.Builder(getMetaItemId(), gthhId("callisto_stone"))
                .dust()
                .color(0x543A28)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        EnceladusStone = new Material.Builder(getMetaItemId(), gthhId("enceladus_stone"))
                .dust()
                .color(0x7C797C)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        TitanStone = new Material.Builder(getMetaItemId(), gthhId("titan_stone"))
                .dust()
                .color(0x332B1F)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        MirandaStone = new Material.Builder(getMetaItemId(), gthhId("miranda_stone"))
                .dust()
                .color(0x7C797C)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        TritonStone = new Material.Builder(getMetaItemId(), gthhId("triton_stone"))
                .dust()
                .color(0x7C797C)
                .iconSet(MaterialIconSet.ROUGH)
                .build();

        // Logistics Pipes
        SandCompound = new Material.Builder(getMetaItemId(), gthhId("sand_compound"))
                .dust()
                .color(0xB4B394)
                .iconSet(GTHHMaterialIconSet.SANDCOMPOUND)
                .components(Stone, 4, QuartzSand, 3, Clay, 2)
                .build();
    }

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
