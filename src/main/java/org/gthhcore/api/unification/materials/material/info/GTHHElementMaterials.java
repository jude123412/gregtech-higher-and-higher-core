package org.gthhcore.api.unification.materials.material.info;


import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;
import gregtech.api.unification.material.properties.ToolProperty;
import gregtech.api.GTValues;
import org.gthhcore.api.unification.GTHHElements;
import org.gthhcore.api.unification.materials.info.GTHHMaterialIconSet;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.util.GTUtility.*;
import static gregtech.api.GTValues.*;

import static gregtech.integration.groovy.GroovyMaterialBuilderExpansion.iconSet;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;

public class GTHHElementMaterials {

    private static int startId = 9000;
    private static int endId = 9499;

        public static void register() {
            CosmicNeutronium = new Material.Builder(getMetaItemId(), gregtechId("cosmic_neutronium"))
                    .dust()
                    .ingot()
                    .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_FOIL, GENERATE_RING, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_ROTOR, GENERATE_ROUND, GENERATE_LENS)
                    .blast(b -> b
                            .temp(10000, GasTier.LOW)
                            .blastStats(VA[UEV], 8000)
                            .vacuumStats(VA[UHV]))
                    .iconSet(GTHHMaterialIconSet.COSMICNEUTRONIUM)
                    .element(GTHHElements.CosmicNeutronium)
                    .build();

            InfinityCatalyst = new Material.Builder(getMetaItemId(), gregtechId("infinity_catalyst"))
                    .dust()
                    .gem()
                    .ore()
                    .iconSet(GTHHMaterialIconSet.INFINITYCATALYST)
                    .element(GTHHElements.InfinityCatalyst)
                    .build();

            Infinity = new Material.Builder(getMetaItemId(), gregtechId("infinity"))
                    .dust()
                    .ingot()
                    .blast(b -> b
                            .temp(10000, GasTier.LOW)
                            .blastStats(VA[UIV], 16000)
                            .vacuumStats(VA[UEV]))
                    .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_FOIL, GENERATE_RING, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_ROTOR, GENERATE_ROUND, GENERATE_LENS)
                    .iconSet(GTHHMaterialIconSet.INFINITY)
                    .element(GTHHElements.Infinity)
                    .build();

            Multiversium = new Material.Builder(getMetaItemId(), gregtechId("multiversium"))
                    .dust()
                    .ingot()
                    .blast(b -> b
                            .temp(10000, GasTier.LOW)
                            .blastStats(VA[UXV], 32000)
                            .vacuumStats(VA[UIV]))
                    .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_FOIL, GENERATE_RING, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_ROTOR, GENERATE_ROUND, GENERATE_LENS)
                    .iconSet(GTHHMaterialIconSet.MULTIVERSIUM)
                    .element(GTHHElements.Multiversium)
                    .build();

            //Found on Mercury T3 (IV Tier)
            Infernorite = new Material.Builder(getMetaItemId(), gregtechId("infernorite"))
                    .dust()
                    .ingot()
                    .ore()
                    .liquid(new FluidBuilder().temperature(5299))
                    .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_FOIL, GENERATE_RING, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_ROTOR, GENERATE_ROUND, GENERATE_LENS)
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
                    .build();

            //Found on Asteroids T3 (IV Tier)
            Crynorium = new Material.Builder(getMetaItemId(), gregtechId("crynorium"))
                    .dust()
                    .ingot()
                    .ore()
                    .liquid(new FluidBuilder().temperature(103))
                    .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE, GENERATE_DENSE, GENERATE_ROD, GENERATE_BOLT_SCREW, GENERATE_FRAME, GENERATE_GEAR, GENERATE_LONG_ROD, GENERATE_FOIL, GENERATE_RING, GENERATE_SPRING, GENERATE_SPRING_SMALL, GENERATE_SMALL_GEAR, GENERATE_FINE_WIRE, GENERATE_ROTOR, GENERATE_ROUND, GENERATE_LENS)
                    .blast(b -> b
                            .temp(7015, GasTier.LOW)
                            .blastStats(VA[LuV], 2560)
                            .vacuumStats(VA[MV]))
                    .iconSet(GTHHMaterialIconSet.CRYNORIUM)
                    .element(GTHHElements.Crynorium)
                    .build();

        }

    private static int getMetaItemId() {
        if (startId < endId){
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
