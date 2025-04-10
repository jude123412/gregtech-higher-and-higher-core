package org.gthhcore.api.unification.materials.material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.NO_SMELTING;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.api.util.GTHHUtility.gthhId;

import org.gthhcore.api.unification.materials.info.GTHHMaterialIconSet;
import org.gthhcore.api.util.GTHHValues;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;

public class GTHHForthDegreeMaterials {

    private static int startId = 6000;
    private static int endId = 6999;

    public static void register() {
        TemporallyConstrainedStarMatter = new Material.Builder(getMetaItemId(),
                gthhId("temporally_constrained_star_matter"))
                        .dust()
                        .ore()
                        .ingot()
                        .liquid(new FluidBuilder())
                        .flags(GENERATE_ALL_METAL, NO_SMELTING)
                        .color(0xFFE554)
                        .blast(b -> b
                                .temp(10000, BlastProperty.GasTier.LOW)
                                .blastStats(VA[OpV], GTHHValues.offset(8000))
                                .vacuumStats(VA[UXV]))
                        .iconSet(GTHHMaterialIconSet.TEMPORALLYCONSTRAINEDSTARMATTER)
                        .build();

        FluxedElectrum = new Material.Builder(getMetaItemId(), gthhId("fluxed_electrum"))
                .dust()
                .ore()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING)
                .color(0xFFE554)
                .blast(b -> b
                        .temp(10000, BlastProperty.GasTier.LOW)
                        .blastStats(VA[OpV], GTHHValues.offset(8000))
                        .vacuumStats(VA[UXV]))
                .cableProperties(V[OpV], 32, 0)
                .iconSet(GTHHMaterialIconSet.FLUXED)
                .build();

        PrismaticVoidMatter = new Material.Builder(getMetaItemId(), gthhId("prismatic_void_matter"))
                .dust()
                .ore()
                .ingot()
                .liquid(new FluidBuilder())
                .flags(GENERATE_ALL_METAL, NO_SMELTING)
                .color(0xFFE554)
                .blast(b -> b
                        .temp(10000, BlastProperty.GasTier.LOW)
                        .blastStats(VA[MAX], GTHHValues.offset(8000))
                        .vacuumStats(VA[OpV]))
                .iconSet(GTHHMaterialIconSet.PRISMATIC)
                .build();

        FluxedAwakenedDraconium = new Material.Builder(getMetaItemId(), gthhId("fluxed_awakened_draconium"))
                .dust()
                .ore()
                .ingot()
                .flags(GENERATE_ALL_METAL, NO_SMELTING)
                .color(0xFF5D00)
                .blast(b -> b
                        .temp(10000, BlastProperty.GasTier.LOW)
                        .blastStats(VA[MAX], GTHHValues.offset(8000))
                        .vacuumStats(VA[UXV]))
                .cableProperties(V[MAX], 32, 0)
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
