package org.gthhcore.api.unification.materials.material;

import static gregtech.api.unification.material.info.MaterialFlags.NO_SMELTING;
import static gregtech.api.util.GTUtility.gregtechId;
import static org.gthhcore.api.unification.material.info.GTHHMaterialFlags.GENERATE_COMPRESSED;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;

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
    }

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
