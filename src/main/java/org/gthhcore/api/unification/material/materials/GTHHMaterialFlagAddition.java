package org.gthhcore.api.unification.material.materials;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static org.gthhcore.api.unification.material.info.GTHHMaterialFlags.*;
import static org.gthhcore.api.unification.material.materials.GTHHMaterialFlagHelper.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;

import org.gthhcore.api.util.GTHHLog;
import org.gthhcore.api.util.GTHHValues;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.*;

public class GTHHMaterialFlagAddition {

    public static void init() {
        GTHHLog.logger.info("Changing Recipe Map Inputs & Outputs");
        THERMAL_CENTRIFUGE_RECIPES.setMaxFluidInputs(3);
        THERMAL_CENTRIFUGE_RECIPES.setMaxFluidOutputs(3);
        SIFTER_RECIPES.setMaxFluidInputs(3);
        SIFTER_RECIPES.setMaxFluidOutputs(3);
        FLUID_HEATER_RECIPES.setMaxFluidOutputs(3);
        MIXER_RECIPES.setMaxInputs(9);
        FLUID_SOLIDFICATION_RECIPES.setMaxInputs(2);
        IMPLOSION_RECIPES.setMaxInputs(6);
        IMPLOSION_RECIPES.setMaxFluidInputs(3);
        CHEMICAL_RECIPES.setMaxInputs(3);

        GTHHLog.logger.info("adding Material Properties");
        // Fluid Registry For Existing Materials
        setupFluidType(Bismuth, FluidStorageKeys.PLASMA);
        setupFluidType(Oganesson, FluidStorageKeys.LIQUID, 765);
        setupFluidType(Iron, FluidStorageKeys.LIQUID, 1811);

        // Blast Property Registration
        setupBlastType(Neutronium, 6951, VA[UV], GTHHValues.offset(1200), VA[ZPM], GTHHValues.offset(600));

        // Ingot Property Registration
        setupIngotProperty(Mercury);
        setupIngotProperty(Carbon);
        setupIngotProperty(Magnesium);

        // New Ore Changes
        OreProperty orePropCopper = Copper.getProperty(PropertyKey.ORE);
        orePropCopper.getOreByProducts().clear();
        orePropCopper.setOreByProducts(Cobalt, PreciousMetals, Nickel, PreciousMetals);

        OreProperty orePropGold = Gold.getProperty(PropertyKey.ORE);
        orePropGold.getOreByProducts().clear();
        orePropGold.setOreByProducts(PreciousMetals, Nickel, PreciousMetals);

        OreProperty orePropIron = Iron.getProperty(PropertyKey.ORE);
        orePropIron.getOreByProducts().clear();
        orePropIron.setOreByProducts(Nickel, Tin, Tin, PreciousMetals);

        OreProperty orePropSilver = Silver.getProperty(PropertyKey.ORE);
        orePropSilver.getOreByProducts().clear();
        orePropSilver.setOreByProducts(Lead, Sulfur, Sulfur, PreciousMetals);

        OreProperty orePropChalcopyrite = Chalcopyrite.getProperty(PropertyKey.ORE);
        orePropChalcopyrite.getOreByProducts().clear();
        orePropChalcopyrite.setOreByProducts(Pyrite, Cobalt, Cadmium, PreciousMetals);

        // OreProperty orePropElectrum = Electrum.getProperty(PropertyKey.ORE);
        // orePropElectrum.getOreByProducts().clear();
        // orePropElectrum.setOreByProducts(PreciousMetals, PreciousMetals, PreciousMetals);

        OreProperty orePropMagnetite = Magnetite.getProperty(PropertyKey.ORE);
        orePropMagnetite.getOreByProducts().clear();
        orePropMagnetite.getSeparatedInto().clear();
        orePropMagnetite.setOreByProducts(Iron, PreciousMetals);

        OreProperty orePropBornite = Bornite.getProperty(PropertyKey.ORE);
        orePropBornite.getOreByProducts().clear();
        orePropBornite.setOreByProducts(Pyrite, Cobalt, Cadmium, PreciousMetals);

        OreProperty orePropVanadiumMagnetite = VanadiumMagnetite.getProperty(PropertyKey.ORE);
        orePropVanadiumMagnetite.getOreByProducts().clear();
        orePropVanadiumMagnetite.getSeparatedInto().clear();
        orePropVanadiumMagnetite.setOreByProducts(Magnetite, Magnetite, Vanadium);
        orePropVanadiumMagnetite.setSeparatedInto(PreciousMetals);

        OreProperty orePropGraniticMineralSand = GraniticMineralSand.getProperty(PropertyKey.ORE);
        orePropGraniticMineralSand.getOreByProducts().clear();
        orePropGraniticMineralSand.getSeparatedInto().clear();
        orePropGraniticMineralSand.setOreByProducts(GraniteBlack, Magnetite);
        orePropGraniticMineralSand.setSeparatedInto(PreciousMetals);

        OreProperty orePropBasalticMineralSand = BasalticMineralSand.getProperty(PropertyKey.ORE);
        orePropBasalticMineralSand.getOreByProducts().clear();
        orePropBasalticMineralSand.getSeparatedInto().clear();
        orePropBasalticMineralSand.setOreByProducts(Basalt, Magnetite);
        orePropBasalticMineralSand.setSeparatedInto(PreciousMetals);

        GTHHLog.logger.info("Changing Material Flags");
        // Material Flag Addition
        Aluminium.addFlags(GENERATE_RAW);
        Neutronium.addFlags(GENERATE_RAW);
        Oganesson.setMaterialIconSet(MaterialIconSet.FLUID);
        HSSS.setProperty(PropertyKey.WIRE, new WireProperties((int) V[ZPM], 4, 8));

        // Fuel Rod Flags
        Thorium.addFlags(GENERATE_ROD_FUEL);
        Naquadah.addFlags(GENERATE_ROD_FUEL);
        NaquadahEnriched.addFlags(GENERATE_ROD_FUEL);
        Naquadria.addFlags(GENERATE_ROD_FUEL);
        Americium.addFlags(GENERATE_ROD_FUEL);

        // Compressed Flags
        Copper.addFlags(GENERATE_COMPRESSED);
        Tin.addFlags(GENERATE_COMPRESSED);
        Aluminium.addFlags(GENERATE_COMPRESSED);
        Steel.addFlags(GENERATE_COMPRESSED);
        Bronze.addFlags(GENERATE_COMPRESSED);
        Iron.addFlags(GENERATE_COMPRESSED);
        Titanium.addFlags(GENERATE_COMPRESSED);
        Mercury.addFlags(GENERATE_COMPRESSED);
        Carbon.addFlags(GENERATE_COMPRESSED);
        Palladium.addFlags(GENERATE_COMPRESSED);
        Nickel.addFlags(GENERATE_COMPRESSED);
        Magnesium.addFlags(GENERATE_COMPRESSED);
        Zinc.addFlags(GENERATE_COMPRESSED);
        Tungsten.addFlags(GENERATE_COMPRESSED);
        Platinum.addFlags(GENERATE_COMPRESSED);
        StainlessSteel.addFlags(GENERATE_COMPRESSED);
        Titanium.addFlags(GENERATE_COMPRESSED);
        TungstenSteel.addFlags(GENERATE_COMPRESSED);
        RhodiumPlatedPalladium.addFlags(GENERATE_COMPRESSED);
        Europium.addFlags(GENERATE_COMPRESSED);
        Tritanium.addFlags(GENERATE_COMPRESSED);
        NaquadahAlloy.addFlags(GENERATE_COMPRESSED);
        Darmstadtium.addFlags(GENERATE_COMPRESSED);

        // Plate
        Iron.addFlags(GENERATE_DOUBLE_PLATE);
        Magnesium.addFlags(GENERATE_DOUBLE_PLATE);
        Palladium.addFlags(GENERATE_DOUBLE_PLATE);
        Zinc.addFlags(GENERATE_DOUBLE_PLATE);
        Mercury.addFlags(GENERATE_DOUBLE_PLATE);
        Carbon.addFlags(GENERATE_DOUBLE_PLATE);

        // No Smelting
        Mercury.addFlags(NO_SMELTING);

        // Fine Wire
        BlueAlloy.addFlags(GENERATE_FINE_WIRE);
        RoseGold.addFlags(GENERATE_FINE_WIRE);
    }
}
