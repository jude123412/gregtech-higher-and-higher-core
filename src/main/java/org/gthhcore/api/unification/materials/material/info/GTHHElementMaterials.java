package org.gthhcore.api.unification.materials.material.info;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static org.gthhcore.api.unification.material.info.GTHHMaterialFlags.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.api.util.GTHHUtility.*;

import org.gthhcore.api.unification.GTHHElements;
import org.gthhcore.api.unification.materials.info.GTHHMaterialIconSet;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;
import gregtech.api.unification.material.properties.ToolProperty;

public class GTHHElementMaterials {

    private static int startId = 0;
    private static int endId = 999;

    public static void register() {
        Multiversium = new Material.Builder(getMetaItemId(), gthhId("multiversium"))
                .dust()
                .ingot()
                .blast(b -> b
                        .temp(10000, GasTier.LOW)
                        .blastStats(VA[UXV], 32000)
                        .vacuumStats(VA[UIV]))
                .flags(GENERATE_ALL_METAL)
                .element(GTHHElements.Multiversium)
                .color(0x000084)
                .build();

        // Found on Mercury T3 (IV Tier)
        Infernorite = new Material.Builder(getMetaItemId(), gthhId("infernorite"))
                .dust()
                .ingot()
                .ore(true)
                .liquid(new FluidBuilder().temperature(5299))
                .flags(GENERATE_ALL_METAL, NO_SMELTING, GENERATE_COMPRESSED)
                .blast(b -> b
                        .temp(5299, GasTier.LOW)
                        .blastStats(VA[IV], 3320)
                        .vacuumStats(VA[MV]))
                .toolStats(ToolProperty.Builder.of(24, 11, 3678, 4)
                        .attackSpeed(1).enchantability(33)
                        .magnetic()
                        .durabilityMultiplier(1).build())
                .iconSet(GTHHMaterialIconSet.INFERNORITE)
                .element(GTHHElements.Infernorite)
                .color(0xFF9100)
                .build();

        // Found on Asteroids T3 (IV Tier)
        Crynorium = new Material.Builder(getMetaItemId(), gthhId("crynorium"))
                .dust()
                .ingot()
                .ore(true)
                .liquid(new FluidBuilder().temperature(103))
                .flags(GENERATE_ALL_METAL)
                .blast(b -> b
                        .temp(7015, GasTier.LOW)
                        .blastStats(VA[LuV], 2560)
                        .vacuumStats(VA[MV]))
                .iconSet(GTHHMaterialIconSet.INFERNORITE)
                .element(GTHHElements.Crynorium)
                .color(0x0046FF)
                .build();

        ElectroMatter = new Material.Builder(getMetaItemId(), gthhId("electro_matter"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(8000))
                .flags(GENERATE_ALL_METAL)
                .blast(b -> b
                        .temp(11550, GasTier.LOW)
                        .blastStats(VA[UEV], 9950)
                        .vacuumStats(VA[UHV]))
                .iconSet(GTHHMaterialIconSet.INFERNORITE)
                .element(GTHHElements.ElectroMatter)
                .cableProperties(V[UXV], 4, (int) V[ZPM])
                .color(0xFF99F6)
                .build();

        MissingError = new Material.Builder(getMetaItemId(), gthhId("missing_error"))
                .element(GTHHElements.MissingError)
                .build();
    }

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
