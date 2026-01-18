package org.gthhcore.api.unification.material.materials;

import static gregtech.api.unification.material.info.MaterialFlags.NO_SMELTING;
import static org.gthhcore.api.unification.material.info.GTHHMaterialFlags.GENERATE_HOT;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.store.FluidStorageKey;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.properties.*;

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

    public static void setupBlastType(Material material, int blastTemperature, int blastEut, int blastDuration,
                                      int vacuumEut, int vacuumDuration) {
        if (material.getProperty(PropertyKey.BLAST) == null && blastTemperature <= 1750) {
            material.addFlags(NO_SMELTING);
            material.setProperty(PropertyKey.BLAST, new BlastProperty.Builder()
                    .temp(blastTemperature)
                    .build());
        } else if (material.getProperty(PropertyKey.BLAST) == null && blastTemperature > 1750) {
            material.addFlags(NO_SMELTING, GENERATE_HOT);
            material.setProperty(PropertyKey.BLAST, new BlastProperty.Builder()
                    .temp(blastTemperature, BlastProperty.GasTier.LOW)
                    .blastStats(blastEut, blastDuration)
                    .vacuumStats(vacuumEut, vacuumDuration)
                    .build());
        }
    }

    public static void setupBlastType(Material material, int blastTemperature, int blastEut, int blastDuration) {
        if (material.getProperty(PropertyKey.BLAST) == null && blastTemperature <= 1750) {
            material.addFlags(NO_SMELTING);
            material.setProperty(PropertyKey.BLAST, new BlastProperty.Builder()
                    .temp(blastTemperature, BlastProperty.GasTier.LOW)
                    .build());
        } else if (material.getProperty(PropertyKey.BLAST) == null && blastTemperature > 1750) {
            material.addFlags(NO_SMELTING, GENERATE_HOT);
            material.setProperty(PropertyKey.BLAST, new BlastProperty.Builder()
                    .temp(blastTemperature, BlastProperty.GasTier.LOW)
                    .blastStats(blastEut, blastDuration)
                    .build());
        }
    }

    public static void setupBlastType(Material material, int blastTemperature) {
        if (material.getProperty(PropertyKey.BLAST) == null && blastTemperature <= 1750) {
            material.addFlags(NO_SMELTING);
            material.setProperty(PropertyKey.BLAST, new BlastProperty.Builder()
                    .temp(blastTemperature, BlastProperty.GasTier.LOW)
                    .build());
        } else if (material.getProperty(PropertyKey.BLAST) == null && blastTemperature > 1750) {
            material.addFlags(NO_SMELTING, GENERATE_HOT);
            material.setProperty(PropertyKey.BLAST, new BlastProperty.Builder()
                    .temp(blastTemperature, BlastProperty.GasTier.LOW)
                    .build());
        }
    }

    public static void setupDustProperty(Material material, int harvestLevel, int burnTime) {
        if (material.getProperty(PropertyKey.DUST) == null) {
            material.setProperty(PropertyKey.DUST, new DustProperty(harvestLevel, burnTime));
        }
    }

    public static void setupIngotProperty(Material material) {
        if (material.getProperty(PropertyKey.INGOT) == null) {
            material.setProperty(PropertyKey.INGOT, new IngotProperty());
        }
    }

    public static void setupMaterialFlag(Material[] materialArray, MaterialFlag flag) {
        for (Material material : materialArray) {
            material.addFlags(flag);
        }
    }
}
