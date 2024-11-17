package org.gthhcore.common.items;

import static gregtech.api.util.DyeUtil.getOredictColorName;
import static org.gthhcore.common.items.GTHHMetaItems.*;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.ElectricStats;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import org.gthhcore.common.items.metaitem.StandardMetaItem;


public class GTHHMetaItem1 extends StandardMetaItem {
    public GTHHMetaItem1() {
        super();
    }
    public void registerSubItems() {
        //Id 0-999 Components
        MicaBasedPulp = addItem(0, "component.mica_based_pulp");
        MicaBasedSheet = addItem(1, "component.mica_based_sheet");
        MicaInsulatorSheet = addItem(2, "component.mica_insulator_sheet");
        MicaInsulatorFoil = addItem(3, "component.mica_insulator_foil");
        CoolantCellTenK = addItem(4, "component.10k_coolant_cell").setMaxStackSize(1);
        CoolantCellTenKNaK = addItem(5, "component.10k_nak_coolant_cell").setMaxStackSize(1);
        CoolantCellTenKSpace = addItem(6, "component.10k_space_coolant_cell").setMaxStackSize(1);
        CoolantCellThirtyK = addItem(7, "component.30k_coolant_cell").setMaxStackSize(1);
        CoolantCellThirtyKNaK = addItem(8, "component.30k_nak_coolant_cell").setMaxStackSize(1);
        CoolantCellThirtyKSpace = addItem(9, "component.30k_space_coolant_cell").setMaxStackSize(1);
        CoolantCellSixtyK = addItem(10, "component.60k_coolant_cell").setMaxStackSize(1);
        CoolantCellSixtyKNaK = addItem(11, "component.60k_nak_coolant_cell").setMaxStackSize(1);
        CoolantCellSixtyKSpace = addItem(12, "component.60k_space_coolant_cell").setMaxStackSize(1);
        CoolantCellEmptyTenK = addItem(13, "component.empty_10k_coolant_cell");
        CoolantCellEmptyThirtyK = addItem(14, "component.empty_30k_coolant_cell");
        CoolantCellEmptySixtyK = addItem(15, "component.empty_60k_coolant_cell");
        BorosilicateGlassTube = addItem(16, "component.borosilicate_glass.tube");

        //Mod Integration ID's 1000-1999
        UnfiredJuicer = addItem(1000, "unfired.juicer");
        UnfiredBakeware = addItem(1001, "unfired.bakeware");
        SandCompoundWafer = addItem(1002, "wafer.sand_compound");
        BasicChipWafer = addItem(1003, "wafer.basic_chip");
        AdvancedChipWafer = addItem(1004, "wafer.advanced_chip");
        FpgaWafer = addItem(1005, "wafer.fpga");
        SandCompoundBoule = addItem(1006, "boule.sand_compound");
        QuickAndDirtyPortalGenerator = addItem(1007, "component.quick_and_dirty_portal_generator");

        //GregTech Circuit Components ID's 2000-2999
        SlimewareProcessorZPM = addItem(2000, "circuit.slimeware_processor");
        SlimewareAssemblyUV = addItem(2001, "circuit.slimeware_assembly");
        SlimewareComputerUHV = addItem(2002, "circuit.slimeware_computer");
        SlimewareMainframeUEV = addItem(2003, "circuit.slimeware_mainframe");
        LasertronicProcessorUV = addItem(2004, "circuit.lasertronic_processor");
        LasertronicAssemblyUHV = addItem(2005, "circuit.lasertronic_assembly");
        LasertronicComputerUEV = addItem(2006, "circuit.lasertronic_computer");
        LasertronicMainframeUIV = addItem(2007, "circuit.lasertronic_mainframe");
        BohemianProcessorUHV = addItem(2008, "circuit.bohemian_processor");
        BohemianAssemblyUEV = addItem(2009, "circuit.bohemian_assembly");
        BohemianComputerUIV = addItem(2010, "circuit.bohemian_computer");
        BohemianMainframeUXV = addItem(2011, "circuit.bohemian_mainframe");
        AntimatterProcessorUEV = addItem(2012, "circuit.antimatter_processor").cosmicProperties(true, 2, -1711276033, 10, false);
        AntimatterProcessorUEV = addItem(2013, "circuit.antimatter_assembly").cosmicProperties(true, 2, -1711276033, 10, false);
        AntimatterProcessorUEV = addItem(2014, "circuit.antimatter_computer").cosmicProperties(true, 2, -1711276033, 10, false);
        AntimatterProcessorUEV = addItem(2015, "circuit.antimatter_mainframe").cosmicProperties(true, 2, -1711276033, 10, false);
        AntimatterProcessorUEV = addItem(2016, "circuit.temporal_processor").cosmicProperties(true, 1, -16777216, 10, true, 1, 1.0f);
        AntimatterProcessorUEV = addItem(2017, "circuit.temporal_assembly").cosmicProperties(true, 1, -16777216, 10, true, 2, 1.0f);
        AntimatterProcessorUEV = addItem(2018, "circuit.temporal_computer").cosmicProperties(true, 1, -16777216, 10, true, 3, 1.0f);
        AntimatterProcessorUEV = addItem(2019, "circuit.temporal_mainframe").cosmicProperties(true, 1, -16777216, 10, true, 4, 1.0f);
        SlimewareBoard = addItem(2020, "board.slimeware");
        LasertronicBoard = addItem(2021, "board.lasertronic");
        BohemianBoard = addItem(2022, "board.bohemian");
        AntimatterBoard = addItem(2023, "board.antimatter").cosmicProperties(true, 2, -1711276033, 10, false);
        TemporalBoard = addItem(2024, "board.temporal").cosmicProperties(true, 1, -16777216, 10, true, 5, 1.0f);
        SlimewareCircuitBoard = addItem(2025, "circuit_board.slimeware");
        LasertronicCircuitBoard = addItem(2026, "circuit_board.lasertronic");
        BohemianCircuitBoard = addItem(2027, "circuit_board.bohemian");
        AntimatterCircuitBoard = addItem(2028, "circuit_board.antimatter").cosmicProperties(true, 2, -1711276033, 10, false);
        TemporalCircuitBoard = addItem(2029, "circuit_board.temporal").cosmicProperties(true, 1, -16777216, 10, true, 6, 1.0f);
        NanoSmdTransistor = addItem(2030, "component.nano.smd.transistor");
        NanoSmdResistor = addItem(2031, "component.nano.smd.resistor");
        NanoSmdCapacitor = addItem(2032, "component.nano.smd.capacitor");
        NanoSmdDiode = addItem(2033, "component.nano.smd.diode");
        NanoSmdInductor = addItem(2034, "component.nano.smd.inductor");
        QuantumSmdTransistor = addItem(2035, "component.quantum.smd.transistor");
        QuantumSmdResistor = addItem(2036, "component.quantum.smd.resistor");
        QuantumSmdCapacitor = addItem(2037, "component.quantum.smd.capacitor");
        QuantumSmdDiode = addItem(2038, "component.quantum.smd.diode");
        QuantumSmdInductor = addItem(2039, "component.quantum.smd.inductor");
        CrystalSmdTransistor = addItem(2040, "component.crystalline.smd.transistor");
        CrystalSmdResistor = addItem(2041, "component.crystalline.smd.resistor");
        CrystalSmdCapacitor = addItem(2042, "component.crystalline.smd.capacitor");
        CrystalSmdDiode = addItem(2043, "component.crystalline.smd.diode");
        CrystalSmdInductor = addItem(2044, "component.crystalline.smd.inductor");
        SlimewareSmdTransistor = addItem(2045, "component.slimeware.smd.transistor");
        SlimewareSmdResistor = addItem(2046, "component.slimeware.smd.resistor");
        SlimewareSmdCapacitor = addItem(2047, "component.slimeware.smd.capacitor");
        SlimewareSmdDiode = addItem(2048, "component.slimeware.smd.diode");
        SlimewareSmdInductor = addItem(2049, "component.slimeware.smd.inductor");
        LasertronicSmdTransistor = addItem(2050, "component.lasertronic.smd.transistor");
        LasertronicSmdResistor = addItem(2051, "component.lasertronic.smd.resistor");
        LasertronicSmdCapacitor = addItem(2052, "component.lasertronic.smd.capacitor");
        LasertronicSmdDiode = addItem(2053, "component.lasertronic.smd.diode");
        LasertronicSmdInductor = addItem(2054, "component.lasertronic.smd.inductor");
        BohemianSmdTransistor = addItem(2055, "component.bohemian.smd.transistor");
        BohemianSmdResistor = addItem(2056, "component.bohemian.smd.resistor");
        BohemianSmdCapacitor = addItem(2057, "component.bohemian.smd.capacitor");
        BohemianSmdDiode = addItem(2058, "component.bohemian.smd.diode");
        BohemianSmdInductor = addItem(2059, "component.bohemian.smd.inductor");
        AntimatterSmdTransistor = addItem(2060, "component.antimatter.smd.transistor").cosmicProperties(true, 2, -1711276033, 10, false);
        AntimatterSmdResistor = addItem(2061, "component.antimatter.smd.resistor").cosmicProperties(true, 2, -1711276033, 10, false);
        AntimatterSmdCapacitor = addItem(2062, "component.antimatter.smd.capacitor").cosmicProperties(true, 2, -1711276033, 10, false);
        AntimatterSmdDiode = addItem(2063, "component.antimatter.smd.diode").cosmicProperties(true, 2, -1711276033, 10, false);
        AntimatterSmdInductor = addItem(2064, "component.antimatter.smd.inductor").cosmicProperties(true, 2, -1711276033, 10, false);
        TemporalSmdTransistor = addItem(2065, "component.temporal.smd.transistor").cosmicProperties(true, 1, -16777216, 10, true, 7, 1.0f);
        TemporalSmdResistor = addItem(2066, "component.temporal.smd.resistor").cosmicProperties(true, 1, -16777216, 10, true, 7, 1.0f);
        TemporalSmdCapacitor = addItem(2067, "component.temporal.smd.capacitor").cosmicProperties(true, 1, -16777216, 10, true, 7, 1.0f);
        TemporalSmdDiode = addItem(2068, "component.temporal.smd.diode").cosmicProperties(true, 1, -16777216, 10, true, 7, 1.0f);
        TemporalSmdInductor = addItem(2069, "component.temporal.smd.inductor").cosmicProperties(true, 1, -16777216, 10, true, 7, 1.0f);

        //Superconductor Bases ID's 3000-3199
        ManganesePhosphideBase = addItem(3000, "base.manganese_phosphide");

        //Higher Tier Batteries ID's 3200-3399
        BatteryHullSmallNaqudria = addItem(3200, "hull.battery.zpm");
        BatteryHullMediumNaqudria = addItem(3201, "hull.battery.uv");
        BatteryHullLargeNaqudria = addItem(3202, "hull.battery.uhv");
        BatteryHullSmallCosmicNeutronium = addItem(3203, "hull.battery.uev");
        BatteryHullMediumCosmicNeutronium = addItem(3204, "hull.battery.uiv");
        BatteryHullLargeCosmicNeutronium = addItem(3205, "hull.battery.uxv");
        BatteryHullSmallMultiversium = addItem(3206, "hull.battery.opv");
        BatteryHullMediumMultiversium = addItem(3207, "hull.battery.max");
        BatteryHullLargeMultiversium = addItem(3208, "hull.battery.maximum");
        BatteryHullZPMNaquadria = addItem(3209, "battery.zpm.naquadria")
                .addComponents(ElectricStats.createRechargeableBattery(655360000L , GTValues.ZPM))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.ZPM).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        BatteryHullUVNaquadria = addItem(3210, "battery.uv.naquadria")
                .addComponents(ElectricStats.createRechargeableBattery(2621440000L, GTValues.UV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        BatteryHullUHVNaquadria = addItem(3211, "battery.uhv.naquadria")
                .addComponents(ElectricStats.createRechargeableBattery(10066329600L, GTValues.UHV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UHV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        BatteryHullUEVCosmicNeutronium = addItem(3212, "battery.uev.cosmic_neutronium")
                .addComponents(ElectricStats.createRechargeableBattery(40265318400L, GTValues.UEV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UEV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
                .cosmicProperties(true, 2, -1711276033, 10, false);
        BatteryHullUIVCosmicNeutronium = addItem(3213, "battery.uiv.cosmic_neutronium")
                .addComponents(ElectricStats.createRechargeableBattery(161061273600L, GTValues.UIV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UIV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
                .cosmicProperties(true, 2, -1711276033, 10, false);
        BatteryHullUXVCosmicNeutronium = addItem(3214, "battery.uxv.cosmic_neutronium")
                .addComponents(ElectricStats.createRechargeableBattery(644245094400L, GTValues.UXV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UXV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
                .cosmicProperties(true, 2, -1711276033, 10, false);
        BatteryHullOPVMultiversium = addItem(3215, "battery.opv.multiversium")
                .addComponents(ElectricStats.createRechargeableBattery(2576980377600L, GTValues.OpV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.OpV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
                .cosmicProperties(true, 1, -16777216, 10, true, 8, 1.0f);
        BatteryHullMAX0Multiversium = addItem(3216, "battery.max.multiversium")
                .addComponents(ElectricStats.createRechargeableBattery(10307921510400L, GTValues.MAX))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MAX).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
                .cosmicProperties(true, 1, -16777216, 10, true, 9, 1.0f);
        BatteryHullMAX1Multiversium = addItem(3217, "battery.maximum.multiversium")
                .addComponents(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.MAX))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MAX).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
                .cosmicProperties(true, 1, -16777216, 10, true, 10, 1.0f);


    }

}
