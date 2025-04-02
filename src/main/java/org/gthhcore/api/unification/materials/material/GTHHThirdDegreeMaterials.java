package org.gthhcore.api.unification.materials.material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.NO_SMELTING;
import static gregtech.api.util.GTUtility.gregtechId;
import static org.gthhcore.api.unification.material.info.GTHHMaterialFlags.GENERATE_COMPRESSED;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;

import org.gthhcore.api.util.GTHHValues;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;

public class GTHHThirdDegreeMaterials {

    private static int startId = 11500;
    private static int endId = 11999;

    public static void register() {
        // UHV -> UXV Materials
        Chronarium = new Material.Builder(getMetaItemId(), gregtechId("chronarium"))
                .dust()
                .ore()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING, GENERATE_COMPRESSED)
                .color(0x00417F)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        BlackPlutonium = new Material.Builder(getMetaItemId(), gregtechId("black_plutonium"))
                .dust()
                .ore()
                .ingot()
                .liquid(new FluidBuilder())
                .flags(GENERATE_ALL_METAL, NO_SMELTING, GENERATE_COMPRESSED)
                .color(0x300505)
                .blast(b -> b
                        .temp(9000, BlastProperty.GasTier.LOW)
                        .blastStats(VA[UEV], GTHHValues.offset(1200))
                        .vacuumStats(VA[UHV]))
                .iconSet(MaterialIconSet.DULL)
                .build();

        Bedrockium = new Material.Builder(getMetaItemId(), gregtechId("bedrockium"))
                .dust()
                .ore()
                .ingot()
                .liquid(new FluidBuilder())
                .flags(GENERATE_ALL_METAL, NO_SMELTING, GENERATE_COMPRESSED)
                .color(0x191919)
                .blast(b -> b
                        .temp(9000, BlastProperty.GasTier.LOW)
                        .blastStats(VA[UEV], GTHHValues.offset(1800))
                        .vacuumStats(VA[UHV]))
                .iconSet(MaterialIconSet.SHINY)
                .build();

        Quaintum = new Material.Builder(getMetaItemId(), gregtechId("quaintum"))
                .dust()
                .ore()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING, GENERATE_COMPRESSED)
                .color(0x194119)
                .iconSet(MaterialIconSet.SHINY)
                .build();

        ChronosSteel = new Material.Builder(getMetaItemId(), gregtechId("chronos_steel"))
                .dust()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING, GENERATE_COMPRESSED)
                .color(0x5B3F5B)
                .iconSet(MaterialIconSet.METALLIC)
                .build();
    }

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
