package org.gthhcore.api.unification.materials.material;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;
import org.gthhcore.api.unification.materials.info.GTHHMaterialIconSet;
import org.gthhcore.api.util.GTHHValues;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.NO_SMELTING;
import static gregtech.api.util.GTUtility.gregtechId;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;

public class GTHHForthDegreeMaterials {

    private static int startId = 13000;
    private static int endId = 13499;

    public static void register() {
        // UXV -> MAX Materials

        // OPV
        FluxedElectrum = new Material.Builder(getMetaItemId(), gregtechId("fluxed_electrum"))
                .dust()
                .ore()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING)
                .color(0xFFE554)
                .blast(b -> b
                        .temp(10000, BlastProperty.GasTier.LOW)
                        .blastStats(VA[OpV], GTHHValues.offset(8000))
                        .vacuumStats(VA[UXV]))
                .cableProperties(V[OpV], 32, 8192)
                .iconSet(GTHHMaterialIconSet.FLUXED)
                .build();
    }

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
