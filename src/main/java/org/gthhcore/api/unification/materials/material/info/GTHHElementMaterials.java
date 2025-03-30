package org.gthhcore.api.unification.materials.material.info;

import static gregtech.api.GTValues.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.util.GTUtility.*;
import static org.gthhcore.api.unification.material.info.GTHHMaterialFlags.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;

import org.gthhcore.api.unification.GTHHElements;
import org.gthhcore.api.unification.materials.info.GTHHMaterialIconSet;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;
import gregtech.api.unification.material.properties.ToolProperty;

public class GTHHElementMaterials {

    private static int startId = 9000;
    private static int endId = 9499;

    public static void register() {
        Multiversium = new Material.Builder(getMetaItemId(), gregtechId("multiversium"))
                .dust()
                .ingot()
                .blast(b -> b
                        .temp(10000, GasTier.LOW)
                        .blastStats(VA[UXV], 32000)
                        .vacuumStats(VA[UIV]))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_BOLT_SCREW,
                        GENERATE_FRAME, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_FOIL, GENERATE_RING, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_ROTOR, GENERATE_ROUND)
                .element(GTHHElements.Multiversium)
                .color(0x000084)
                .build();

        // Found on Mercury T3 (IV Tier)
        Infernorite = new Material.Builder(getMetaItemId(), gregtechId("infernorite"))
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
        Crynorium = new Material.Builder(getMetaItemId(), gregtechId("crynorium"))
                .dust()
                .ingot()
                .ore(true)
                .liquid(new FluidBuilder().temperature(103))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_BOLT_SCREW,
                        GENERATE_FRAME, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_FOIL, GENERATE_RING, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_ROTOR, GENERATE_ROUND)
                .blast(b -> b
                        .temp(7015, GasTier.LOW)
                        .blastStats(VA[LuV], 2560)
                        .vacuumStats(VA[MV]))
                .iconSet(GTHHMaterialIconSet.INFERNORITE)
                .element(GTHHElements.Crynorium)
                .color(0x0046FF)
                .build();

        ElectroMatter = new Material.Builder(getMetaItemId(), gregtechId("electro_matter"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(8000))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_BOLT_SCREW,
                        GENERATE_FRAME, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_FOIL, GENERATE_RING, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_ROTOR, GENERATE_ROUND)
                .blast(b -> b
                        .temp(11550, GasTier.LOW)
                        .blastStats(VA[UEV], 9950)
                        .vacuumStats(VA[UHV]))
                .iconSet(GTHHMaterialIconSet.INFERNORITE)
                .element(GTHHElements.ElectroMatter)
                .cableProperties(V[UXV], 4, (int) V[ZPM])
                .color(0xFF99F6)
                .build();

        MissingError = new Material.Builder(getMetaItemId(), gregtechId("missing_error"))
                .dust()
                .ingot()
                .liquid(new FluidBuilder().temperature(8751))
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_BOLT_SCREW,
                        GENERATE_FRAME, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_FOIL, GENERATE_RING, GENERATE_SPRING,
                        GENERATE_SPRING_SMALL, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_ROTOR, GENERATE_ROUND)
                .blast(b -> b
                        .temp(8751, GasTier.LOW)
                        .blastStats(VA[UEV], 9950)
                        .vacuumStats(VA[UHV]))
                .iconSet(GTHHMaterialIconSet.MISSINGERROR)
                .element(GTHHElements.MissingError)
                .cableProperties(V[UXV], 4, (int) V[ZPM])
                .color(0xFF00C7)
                .build();

        Protactinium226 = new Material.Builder(getMetaItemId(), gregtechId("protactinium_226"))
                .dust()
                .color(0xA78B6D)
                .iconSet(MaterialIconSet.METALLIC)
                .element(GTHHElements.Pa226)
                .build();

        Protactinium231 = new Material.Builder(getMetaItemId(), gregtechId("protactinium_231"))
                .dust()
                .color(0xA57036)
                .iconSet(MaterialIconSet.METALLIC)
                .element(GTHHElements.Pa231)
                .build();

        Neptunium228 = new Material.Builder(getMetaItemId(), gregtechId("neptunium_228"))
                .dust()
                .color(0x284D7B)
                .iconSet(MaterialIconSet.METALLIC)
                .element(GTHHElements.Np226)
                .build();

        Neptunium237 = new Material.Builder(getMetaItemId(), gregtechId("neptunium_237"))
                .dust()
                .color(0x073B7A)
                .iconSet(MaterialIconSet.METALLIC)
                .element(GTHHElements.Np237)
                .build();
    }

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
