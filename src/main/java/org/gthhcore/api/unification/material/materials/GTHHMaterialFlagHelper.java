package org.gthhcore.api.unification.material.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.store.FluidStorageKey;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.FluidProperty;
import gregtech.api.unification.material.properties.PropertyKey;

import static gregtech.api.unification.material.info.MaterialFlags.NO_SMELTING;
import static org.gthhcore.api.unification.material.info.GTHHMaterialFlags.GENERATE_HOT;

public class GTHHMaterialFlagHelper {
    public static void setupFluidType(Material mat, FluidStorageKey key, int temp) {
        if (mat.getProperty(PropertyKey.FLUID) == null) {
            FluidProperty property = new FluidProperty();
            property.enqueueRegistration(key, new FluidBuilder().temperature(temp));
            mat.setProperty(PropertyKey.FLUID, property);
        } else {
            FluidProperty property = mat.getProperty(PropertyKey.FLUID);
            if (property.getQueuedBuilder(key) != null) {
                property.getQueuedBuilder(key).temperature(temp).block();
            } else {
                property.enqueueRegistration(key, new FluidBuilder().temperature(temp));
            }
        }
    }

    public static void setupFluidType(Material mat, FluidStorageKey key) {
        if (mat.getProperty(PropertyKey.FLUID) == null) {
            FluidProperty property = new FluidProperty();
            property.enqueueRegistration(key, new FluidBuilder());
            mat.setProperty(PropertyKey.FLUID, property);
        } else {
            FluidProperty property = mat.getProperty(PropertyKey.FLUID);
            property.enqueueRegistration(key, new FluidBuilder());
        }
    }

    public static void setupBlastType(Material material, int blastTemperature) {
        if (material.getProperty(PropertyKey.BLAST) == null && blastTemperature <= 1750) {
            material.addFlags(NO_SMELTING);
            material.setProperty(PropertyKey.BLAST, new BlastProperty.Builder()
                    .temp(blastTemperature, BlastProperty.GasTier.LOW)
                    .build()
            );
        } else if (material.getProperty(PropertyKey.BLAST) == null && blastTemperature > 1750) {
            material.addFlags(NO_SMELTING, GENERATE_HOT);
            material.setProperty(PropertyKey.BLAST, new BlastProperty.Builder()
                    .temp(blastTemperature, BlastProperty.GasTier.LOW)
                    .build()
            );
        }
    }

    public static void setupBlastType(Material material, int blastTemperature, int blastEut, int blastDuration) {
        if (material.getProperty(PropertyKey.BLAST) == null && blastTemperature <= 1750) {
            material.addFlags(NO_SMELTING);
            material.setProperty(PropertyKey.BLAST, new BlastProperty.Builder()
                    .temp(blastTemperature, BlastProperty.GasTier.LOW)
                    .build()
            );
        } else if (material.getProperty(PropertyKey.BLAST) == null && blastTemperature > 1750) {
            material.addFlags(NO_SMELTING, GENERATE_HOT);
            material.setProperty(PropertyKey.BLAST, new BlastProperty.Builder()
                    .temp(blastTemperature, BlastProperty.GasTier.LOW)
                    .blastStats(blastEut,blastDuration)
                    .build()
            );
        }
    }

    public static void setupBlastType(Material material, int blastTemperature, int blastEut, int blastDuration, int vacuumEut, int vacuumDuration) {
        if (material.getProperty(PropertyKey.BLAST) == null && blastTemperature <= 1750) {
            material.addFlags(NO_SMELTING);
            material.setProperty(PropertyKey.BLAST, new BlastProperty.Builder()
                    .temp(blastTemperature)
                    .build()
            );
        } else if (material.getProperty(PropertyKey.BLAST) == null && blastTemperature > 1750) {
            material.addFlags(NO_SMELTING, GENERATE_HOT);
            material.setProperty(PropertyKey.BLAST, new BlastProperty.Builder()
                    .temp(blastTemperature, BlastProperty.GasTier.LOW)
                    .blastStats(blastEut,blastDuration)
                    .vacuumStats(vacuumEut, vacuumDuration)
                    .build()
            );
        }
    }
}
