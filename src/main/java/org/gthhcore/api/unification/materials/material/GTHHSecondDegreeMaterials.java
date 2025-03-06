package org.gthhcore.api.unification.materials.material;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;

public class GTHHSecondDegreeMaterials {

    private static int startId = 10999;
    private static int endId = 11499;

    public static void register() {
        // IV -> UV Materials
        SaltsCatalyst = new Material.Builder(getMetaItemId(), gregtechId("salts_catalyst"))
                .dust()
                .iconSet(FINE)
                .components(Salt, 1, RockSalt, 1, HSSS, 2)
                .color(0xFFAFAF)
                .build();

        // Found on Mercury T3
        Mytryl = new Material.Builder(getMetaItemId(), gregtechId("mytryl"))
                .dust()
                .ingot()
                .ore()
                .liquid(new FluidBuilder().temperature(2105))
                .flags(EXT2_METAL, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_BOLT_SCREW, GENERATE_RING)

                .blast(b -> b
                        .temp(2987, BlastProperty.GasTier.LOW)
                        .blastStats(VA[LuV], L * 12))
                .components(Carbon, 9, Copper, 4, Silver, 3, Gallium, 1)
                .color(0x8DAA42)
                .iconSet(DULL)
                .build();

        Tetrapech = new Material.Builder(getMetaItemId(), gregtechId("tetrapech"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(2000))
                .flags(EXT2_METAL, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_BOLT_SCREW, GENERATE_RING)
                .blast(b -> b
                        .temp(2000, BlastProperty.GasTier.LOW)
                        .blastStats(VA[LuV], L * 13))
                .components(UraniumTriplatinum, 7, Ruridit, 3)
                .color(0x39EF67)
                .iconSet(DULL)
                .build();

        // Found on Venus T3
        CosmicCarbon = new Material.Builder(getMetaItemId(), gregtechId("cosmic_carbon"))
                .dust()
                .ingot()
                .ore()
                .liquid(new FluidBuilder().temperature(1985))
                .flags(EXT2_METAL, GENERATE_FOIL, GENERATE_FINE_WIRE, GENERATE_BOLT_SCREW, GENERATE_RING)
                .blast(b -> b
                        .temp(1985, BlastProperty.GasTier.LOW)
                        .blastStats(VA[LuV], L * 10))
                .color(0x000000)
                .iconSet(SHINY)
                .build();
    }

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
