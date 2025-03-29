package org.gthhcore.api.unification.materials.material;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.util.GTUtility.gregtechId;
import static org.gthhcore.api.unification.material.info.GTHHMaterialFlags.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;

public class GTHHNuclearMaterials {

    private static int startId = 12500;
    private static int endId = 12999;

    public static void register() {
        EnrichedProtactinium = new Material.Builder(getMetaItemId(), gregtechId("enriched_protactinium"))
                .dust()
                .color(0x5E3F1F)
                .flags(GENERATE_ROD_FUEL)
                .iconSet(MaterialIconSet.SHINY)
                .components(Protactinium226, 5, Protactinium231, 3)
                .build();

        EnrichedUranium = new Material.Builder(getMetaItemId(), gregtechId("enriched_uranium"))
                .dust()
                .color(0x007501)
                .flags(GENERATE_ROD_FUEL)
                .iconSet(MaterialIconSet.SHINY)
                .components(Uranium238, 5, Uranium235, 3)
                .build();

        EnrichedNeptunium = new Material.Builder(getMetaItemId(), gregtechId("enriched_neptunium"))
                .dust()
                .color(0x032142)
                .flags(GENERATE_ROD_FUEL)
                .iconSet(MaterialIconSet.SHINY)
                .components(Neptunium237, 5, Neptunium228, 3)
                .build();

        EnrichedPlutonium = new Material.Builder(getMetaItemId(), gregtechId("enriched_plutonium"))
                .dust()
                .color(0x960F0F)
                .flags(GENERATE_ROD_FUEL)
                .iconSet(MaterialIconSet.SHINY)
                .components(Plutonium239, 5, Plutonium241, 3)
                .build();
    }

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
