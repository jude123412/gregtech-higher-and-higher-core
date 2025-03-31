package org.gthhcore.common.items;

import static org.gthhcore.api.util.GTHHMods.*;
import static org.gthhcore.common.items.GTHHMetaItems.*;

import org.gthhcore.api.GTHHApi;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.ElectricStats;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;

public class GTHHMetaItem2 extends StandardMetaItem {

    public GTHHMetaItem2() {
        super();
    }

    public void registerSubItems() {
        // Components: ID 0-899
        MICA_BASED_SHEET = addItem(1, "component.mica_based_sheet");
        MICA_INSULATOR_SHEET = addItem(2, "component.mica_insulator_sheet");
        MICA_INSULATOR_FOIL = addItem(3, "component.mica_insulator_foil");
        COOLANT_CELL_TEN_K = addItem(4, "component.10k_coolant_cell").setMaxStackSize(1);
        COOLANT_CELL_TEN_K_NAK = addItem(5, "component.10k_nak_coolant_cell").setMaxStackSize(1);
        COOLANT_CELL_TEN_K_SPACE = addItem(6, "component.10k_space_coolant_cell").setMaxStackSize(1);
        COOLANT_CELL_THIRTY_K = addItem(7, "component.30k_coolant_cell").setMaxStackSize(1);
        COOLANT_CELL_THIRTY_K_NAK = addItem(8, "component.30k_nak_coolant_cell").setMaxStackSize(1);
        COOLANT_CELL_THIRTY_KSPACE = addItem(9, "component.30k_space_coolant_cell").setMaxStackSize(1);
        COOLANT_CELL_SIXTY_K = addItem(10, "component.60k_coolant_cell").setMaxStackSize(1);
        COOLANT_CELL_SIXTY_K_NAK = addItem(11, "component.60k_nak_coolant_cell").setMaxStackSize(1);
        COOLANT_CELL_SIXTY_KSPACE = addItem(12, "component.60k_space_coolant_cell").setMaxStackSize(1);
        COOLANT_CELL_EMPTY_TEN_K = addItem(13, "component.empty_10k_coolant_cell");
        COOLANT_CELL_EMPTY_THIRTY_K = addItem(14, "component.empty_30k_coolant_cell");
        COOLANT_CELL_EMPTY_SIXTY_K = addItem(15, "component.empty_60k_coolant_cell");

        // Fission Fuel Rods: ID 900-999
        FUEL_ROD = addItem(999, "fuel_rod.empty");

        // Pam's Integration: ID 1000-1049
        UNFIRED_JUICER = addItem(1000, "unfired.juicer");
        UNFIRED_BAKEWARE = addItem(1001, "unfired.bakeware");

        // Twilight Integration: ID 1050-1099
        QUICK_AND_DIRTY_PORTAL_GENERATOR = addItem(1050, "component.quick_and_dirty_portal_generator");

        // Boule: ID 2000-2049
        SAND_COMPOUND_BOULE = addItem(2000, "boule.sand_compound");

        // Boule-Direct Wafer: ID 2050-2099
        WAFER_SAND_COMPOUND = addItem(2050, "wafer.sand_compound");

        // Unfinished Circuit Boards: ID 2100-2124
        SLIMEWARE_BOARD = addItem(2100, "board.slimeware");
        LASERTRONIC_BOARD = addItem(2101, "board.lasertronic");
        BOHEMIAN_BOARD = addItem(2102, "board.bohemian");
        ANTIMATTER_BOARD = addItem(2103, "board.antimatter")/* .cosmicProperties(true, 2, -1711276033, 10, false) */;
        TEMPORAL_BOARD = addItem(2104, "board.temporal")/* .cosmicProperties(true, 1, -16777216, 10, true, 5, 1.0f) */;

        // Finished Circuit Boards: ID 2125-2149
        SLIMEWARE_CIRCUIT_BOARD = addItem(2125, "circuit_board.slimeware");
        LASERTRONIC_CIRCUIT_BOARD = addItem(2126, "circuit_board.lasertronic");
        BOHEMIAN_CIRCUIT_BOARD = addItem(2127, "circuit_board.bohemian");
        ANTIMATTER_CIRCUIT_BOARD = addItem(2128, "circuit_board.antimatter")/*
                                                                             * .cosmicProperties(true, 2, -1711276033,
                                                                             * 10, false)
                                                                             */;
        TEMPORAL_CIRCUIT_BOARD = addItem(2129, "circuit_board.temporal")/*
                                                                         * .cosmicProperties(true, 1, -16777216, 10,
                                                                         * true, 6, 1.0f)
                                                                         */;

        // Circuit Components ID's 2150-2299
        NANO_SMD_TRANSISTOR = addItem(2150, "component.nano.smd.transistor");
        NANO_SMD_RESISTOR = addItem(2151, "component.nano.smd.resistor");
        NANO_SMD_CAPACITOR = addItem(2152, "component.nano.smd.capacitor");
        NANO_SMD_DIODE = addItem(2153, "component.nano.smd.diode");
        NANO_SMD_INDUCTOR = addItem(2154, "component.nano.smd.inductor");
        QUANTUM_SMD_TRANSISTOR = addItem(2155, "component.quantum.smd.transistor");
        QUANTUM_SMD_RESISTOR = addItem(2156, "component.quantum.smd.resistor");
        QUANTUM_SMD_CAPACITOR = addItem(2157, "component.quantum.smd.capacitor");
        QUANTUM_SMD_DIODE = addItem(2158, "component.quantum.smd.diode");
        QUANTUM_SMD_INDUCTOR = addItem(2159, "component.quantum.smd.inductor");
        CRYSTAL_SMD_TRANSISTOR = addItem(2160, "component.crystalline.smd.transistor");
        CRYSTAL_SMD_RESISTOR = addItem(2161, "component.crystalline.smd.resistor");
        CRYSTAL_SMD_CAPACITOR = addItem(2162, "component.crystalline.smd.capacitor");
        CRYSTAL_SMD_DIODE = addItem(2163, "component.crystalline.smd.diode");
        CRYSTAL_SMD_INDUCTOR = addItem(2164, "component.crystalline.smd.inductor");
        SLIMEWARE_SMD_TRANSISTOR = addItem(2165, "component.slimeware.smd.transistor");
        SLIMEWARE_SMD_RESISTOR = addItem(2166, "component.slimeware.smd.resistor");
        SLIMEWARE_SMD_CAPACITOR = addItem(2167, "component.slimeware.smd.capacitor");
        SLIMEWARE_SMD_DIODE = addItem(2168, "component.slimeware.smd.diode");
        SLIMEWARE_SMD_INDUCTOR = addItem(2169, "component.slimeware.smd.inductor");
        LASERTRONIC_SMD_TRANSISTOR = addItem(2170, "component.lasertronic.smd.transistor");
        LASERTRONIC_SMD_RESISTOR = addItem(2171, "component.lasertronic.smd.resistor");
        LASERTRONIC_SMD_CAPACITOR = addItem(2172, "component.lasertronic.smd.capacitor");
        LASERTRONIC_SMD_DIODE = addItem(2173, "component.lasertronic.smd.diode");
        LASERTRONIC_SMD_INDUCTOR = addItem(2174, "component.lasertronic.smd.inductor");
        BOHEMIAN_SMD_TRANSISTOR = addItem(2175, "component.bohemian.smd.transistor");
        BOHEMIAN_SMD_RESISTOR = addItem(2176, "component.bohemian.smd.resistor");
        BOHEMIAN_SMD_CAPACITOR = addItem(2177, "component.bohemian.smd.capacitor");
        BOHEMIAN_SMD_DIODE = addItem(2178, "component.bohemian.smd.diode");
        BOHEMIAN_SMD_INDUCTOR = addItem(2179, "component.bohemian.smd.inductor");
        ANTIMATTER_SMD_TRANSISTOR = addItem(2180, "component.antimatter.smd.transistor")/*
                                                                                         * .cosmicProperties(true, 2,
                                                                                         * -1711276033, 10, false)
                                                                                         */;
        ANTIMATTER_SMD_RESISTOR = addItem(2181, "component.antimatter.smd.resistor")/*
                                                                                     * .cosmicProperties(true, 2,
                                                                                     * -1711276033, 10, false)
                                                                                     */;
        ANTIMATTER_SMD_CAPACITOR = addItem(2182, "component.antimatter.smd.capacitor")/*
                                                                                       * .cosmicProperties(true, 2,
                                                                                       * -1711276033, 10, false)
                                                                                       */;
        ANTIMATTER_SMD_DIODE = addItem(2183, "component.antimatter.smd.diode")/*
                                                                               * .cosmicProperties(true, 2, -1711276033,
                                                                               * 10, false)
                                                                               */;
        ANTIMATTER_SMD_INDUCTOR = addItem(2184, "component.antimatter.smd.inductor")/*
                                                                                     * .cosmicProperties(true, 2,
                                                                                     * -1711276033, 10, false)
                                                                                     */;
        TEMPORAL_SMD_TRANSISTOR = addItem(2185, "component.temporal.smd.transistor")/*
                                                                                     * .cosmicProperties(true, 1,
                                                                                     * -16777216, 10, true, 7, 1.0f)
                                                                                     */;
        TEMPORAL_SMD_RESISTOR = addItem(2186, "component.temporal.smd.resistor")/*
                                                                                 * .cosmicProperties(true, 1, -16777216,
                                                                                 * 10, true, 7, 1.0f)
                                                                                 */;
        TEMPORAL_SMD_CAPACITOR = addItem(2187, "component.temporal.smd.capacitor")/*
                                                                                   * .cosmicProperties(true, 1,
                                                                                   * -16777216, 10, true, 7, 1.0f)
                                                                                   */;
        TEMPORAL_SMD_DIODE = addItem(2188, "component.temporal.smd.diode")/*
                                                                           * .cosmicProperties(true, 1, -16777216, 10,
                                                                           * true, 7, 1.0f)
                                                                           */;
        TEMPORAL_SMD_INDUCTOR = addItem(2189, "component.temporal.smd.inductor")/*
                                                                                 * .cosmicProperties(true, 1, -16777216,
                                                                                 * 10, true, 7, 1.0f)
                                                                                 */;
        BOROSILICATE_GLASS_TUBE = addItem(2190, "component.borosilicate_glass.tube");
        SALT_CRYSTAL_SMD_TRANSISTOR = addItem(2191, "component.salt_crystal.smd.transistor");
        SALT_CRYSTAL_SMD_RESISTOR = addItem(2192, "component.salt_crystal.smd.resistor");
        SALT_CRYSTAL_SMD_CAPACITOR = addItem(2193, "component.salt_crystal.smd.capacitor");
        SALT_CRYSTAL_SMD_DIODE = addItem(2194, "component.salt_crystal.smd.diode");
        SALT_CRYSTAL_SMD_INDUCTOR = addItem(2195, "component.salt_crystal.smd.inductor");

        // Complex Wafers: ID 2300-22349
        WAFER_BASIC_CHIP = addItem(2200, "wafer.basic_chip");
        WAFER_ADVANCED_CHIP = addItem(2201, "wafer.advanced_chip");
        WAFER_FPGA = addItem(2202, "wafer.fpga");

        // Complex Cut Wafers ID 2350-2399

        // Circuits: ID 2400-2449

        // T8: Slimeware
        SLIMEWARE_PROCESSOR_ZPM = addItem(2400, "circuit.slimeware_processor")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        SLIMEWARE_ASSEMBLY_UV = addItem(2401, "circuit.slimeware_assembly")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        SLIMEWARE_COMPUTER_UHV = addItem(2402, "circuit.slimeware_computer")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        SLIMEWARE_MAINFRAME_UEV = addItem(2403, "circuit.slimeware_mainframe")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);

        // T9: Lasertronic
        LASERTRONIC_PROCESSOR_UV = addItem(2404, "circuit.lasertronic_processor")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        LASERTRONIC_ASSEMBLY_UHV = addItem(2405, "circuit.lasertronic_assembly")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        LASERTRONIC_COMPUTER_UEV = addItem(2406, "circuit.lasertronic_computer")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        LASERTRONIC_MAINFRAME_UIV = addItem(2407, "circuit.lasertronic_mainframe")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);

        // T10: Bohemian
        BOHEMIAN_PROCESSOR_UHV = addItem(2408, "circuit.bohemian_processor")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        BOHEMIAN_ASSEMBLY_UEV = addItem(2409, "circuit.bohemian_assembly")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        BOHEMIAN_COMPUTER_UIV = addItem(2410, "circuit.bohemian_computer")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        BOHEMIAN_MAINFRAME_UXV = addItem(2411, "circuit.bohemian_mainframe")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);

        // T11: Antimatter
        ANTIMATTER_PROCESSOR_UEV = addItem(2412, "circuit.antimatter_processor")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV)
        /* .cosmicProperties(true, 2, "FFFFFF", 10, false) */;
        ANTIMATTER_ASSEMBLY_UIV = addItem(2413, "circuit.antimatter_assembly")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV)
        /* .cosmicProperties(true, 2, "FFFFFF", 10, false) */;
        ANTIMATTER_COMPUTER_UXV = addItem(2414, "circuit.antimatter_computer")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV)
        /* .cosmicProperties(true, 2, "FFFFFF", 10, false) */;
        ANTIMATTER_MAINFRAME_OPV = addItem(2415, "circuit.antimatter_mainframe")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV)
        /* .cosmicProperties(true, 2, "FFFFFF", 10, false) */;

        // T12: Temporal
        TEMPORAL_PROCESSOR_UIV = addItem(2416, "circuit.temporal_processor")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV)
        /* .cosmicProperties(true, 1, "000000", 10, true, 1, 1.0f) */;
        TEMPORAL_ASSEMBLY_UXV = addItem(2417, "circuit.temporal_assembly")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV)
        /* .cosmicProperties(true, 1, "000000", 10, true, 2, 1.0f) */;
        TEMPORAL_COMPUTER_OPV = addItem(2418, "circuit.temporal_computer")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV)
        /* .cosmicProperties(true, 1, "000000", 10, true, 3, 1.0f) */;
        TEMPORAL_MAINFRAME_MAX = addItem(2419, "circuit.temporal_mainframe")
                .setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX)
        /* .cosmicProperties(true, 1, "000000", 10, true, 4, 1.0f) */;

        // T13: ???

        // Misc Circuit Components: ID 2440-2449
        WETWARE_CENTRAL_PROCESSING_UNIT = addItem(2440, "wetware.central_processing_unit");

        // Slimeware Circuit Components: ID 2450-2474
        SLIME_PROCESSOR = addItem(2450, "processor.slime");
        SLIME_CELL = addItem(2451, "slime_cell");
        RAW_SALT_CRYSTAL_CHIP = addItem(2452, "crystal.raw_salt");
        RAW_SALT_CRYSTAL_CHIP_PART = addItem(2453, "crystal.raw_salt_chip");
        ENGRAVED_SALT_CRYSTAL_CHIP = addItem(2454, "engraved.salt_crystal_chip");
        SLIMEWARE_CENTRAL_PROCESSING_UNIT = addItem(2455, "slimeware.central_processing_unit");

        // Lasertronic Circuit ComponentsL ID 2475-2499

        // Bohemian Circuit ComponentsL ID 2500-2524

        // Antimatter Circuit ComponentsL ID 2525-2549

        // Temporal Circuit ComponentsL ID 2550-2599

        // Battery Hulls: ID 3000-3049
        BATTERY_HULL_ZPM_SMALL = addItem(3200, "hull.battery.zpm");
        BATTERY_HULL_UV_MEDIUM = addItem(3201, "hull.battery.uv");
        BATTERY_HULL_UHV_LARGE = addItem(3202, "hull.battery.uhv");
        BATTERY_HULL_UEV_SMALL = addItem(3203, "hull.battery.uev");
        BATTERY_HULL_UIV_MEDIUM = addItem(3204, "hull.battery.uiv");
        BATTERY_HULL_UXV_LARGE = addItem(3205, "hull.battery.uxv");
        BATTERY_HULL_OPV_SMALL = addItem(3206, "hull.battery.opv");
        BATTERY_HULL_MAX_MEDIUM = addItem(3207, "hull.battery.max");

        // Batteries: ID 3050-3099
        BATTERY_EV_SUNNARIUM = addItem(3050, "battery.ev.sunnarium")
                .addComponents(ElectricStats.createRechargeableBattery(12288000L, GTValues.EV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.EV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_IV_SUNNARIUM = addItem(3051, "battery.iv.sunnarium")
                .addComponents(ElectricStats.createRechargeableBattery(49152000L, GTValues.IV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.IV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_LUV_SUNNARIUM = addItem(3052, "battery.luv.sunnarium")
                .addComponents(ElectricStats.createRechargeableBattery(196608000L, GTValues.LuV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.LuV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_EV_ENRICHED_SUNNARIUM = addItem(3053, "battery.ev.enriched_sunnarium")
                .addComponents(ElectricStats.createRechargeableBattery(14336000L, GTValues.EV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.EV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_IV_ENRICHED_SUNNARIUM = addItem(3054, "battery.iv.enriched_sunnarium")
                .addComponents(ElectricStats.createRechargeableBattery(57344000L, GTValues.IV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.IV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_LUV_ENRICHED_SUNNARIUM = addItem(3055, "battery.luv.enriched_sunnarium")
                .addComponents(ElectricStats.createRechargeableBattery(229376000L, GTValues.LuV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.LuV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_ZPM_NAQUADAH = addItem(3056, "battery.zpm.naquadah")
                .addComponents(ElectricStats.createRechargeableBattery(786432000L, GTValues.ZPM))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.ZPM).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_UV_NAQUADAH = addItem(3057, "battery.uv.naquadah")
                .addComponents(ElectricStats.createRechargeableBattery(3145728000L, GTValues.UV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_UHV_NAQUADAH = addItem(3058, "battery.uhv.naquadah")
                .addComponents(ElectricStats.createRechargeableBattery(12582912000L, GTValues.UHV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UHV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_ZPM_ENRICHED_NAQUADAH = addItem(3059, "battery.zpm.enriched_naquadah")
                .addComponents(ElectricStats.createRechargeableBattery(943718400L, GTValues.ZPM))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.ZPM).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_UV_ENRICHED_NAQUADAH = addItem(3060, "battery.uv.enriched_naquadah")
                .addComponents(ElectricStats.createRechargeableBattery(3774873600L, GTValues.UV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_UHV_ENRICHED_NAQUADAH = addItem(3061, "battery.uhv.enriched_naquadah")
                .addComponents(ElectricStats.createRechargeableBattery(15099494400L, GTValues.UHV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UHV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_ZPM_NAQUADRIA = addItem(3062, "battery.zpm.naquadria1")
                .addComponents(ElectricStats.createRechargeableBattery(1101004800L, GTValues.ZPM))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.ZPM).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_UV_NAQUADRIA = addItem(3063, "battery.uv.naquadria1")
                .addComponents(ElectricStats.createRechargeableBattery(4404019200L, GTValues.UV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_UHV_NAQUADRIA = addItem(3064, "battery.uhv.naquadria1")
                .addComponents(ElectricStats.createRechargeableBattery(17616076800L, GTValues.UHV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UHV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        BATTERY_UEV_COSMIC_NEUTRONIUM = addItem(3065, "battery.uev.cosmic_neutronium")
                .addComponents(ElectricStats.createRechargeableBattery(60397977600L, GTValues.UEV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UEV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 2, -1711276033, 10, false) */;

        BATTERY_UIV_COSMIC_NEUTRONIUM = addItem(3066, "battery.uiv.cosmic_neutronium")
                .addComponents(ElectricStats.createRechargeableBattery(241591910400L, GTValues.UIV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UIV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 2, -1711276033, 10, false) */;

        BATTERY_UXV_COSMIC_NEUTRONIUM = addItem(3067, "battery.uxv.cosmic_neutronium")
                .addComponents(ElectricStats.createRechargeableBattery(966367641600L, GTValues.UXV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UXV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 2, -1711276033, 10, false) */;

        BATTERY_UEV_INFINITY = addItem(3068, "battery.uev.infinity")
                .addComponents(ElectricStats.createRechargeableBattery(72477573120L, GTValues.UEV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UEV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 1, -16777216, 10, true, 8, 1.0f) */;

        BATTERY_UIV_INFINITY = addItem(3069, "battery.uiv.infinity")
                .addComponents(ElectricStats.createRechargeableBattery(289910292480L, GTValues.UIV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UIV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 1, -16777216, 10, true, 9, 1.0f) */;

        BATTERY_UXV_INFINITY = addItem(3070, "battery.uxv.infinity")
                .addComponents(ElectricStats.createRechargeableBattery(1159641169920L, GTValues.UXV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UXV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 1, -16777216, 10, true, 10, 1.0f) */;

        BATTERY_UEV_EMPOWERED_INFINITY = addItem(3071, "battery.uev.empowered_infinity")
                .addComponents(ElectricStats.createRechargeableBattery(84557168640L, GTValues.UEV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UEV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 1, -16777216, 10, true, 8, 1.0f) */;

        BATTERY_UIV_EMPOWERED_INFINITY = addItem(3072, "battery.uiv.empowered_infinity")
                .addComponents(ElectricStats.createRechargeableBattery(338228674560L, GTValues.UIV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UIV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 1, -16777216, 10, true, 9, 1.0f) */;

        BATTERY_UXV_EMPOWERED_INFINITY = addItem(3073, "battery.uxv.empowered_infinity")
                .addComponents(ElectricStats.createRechargeableBattery(1352914698240L, GTValues.UXV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UXV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 1, -16777216, 10, true, 10, 1.0f) */;

        BATTERY_OPV_MULTIPHASE_COSMIC_NEUTRONIUM = addItem(3074, "battery.opv.multiphase_cosmic_neutronium")
                .addComponents(ElectricStats.createRechargeableBattery(4509715660800L, GTValues.OpV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.OpV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 2, -1711276033, 10, false) */;

        BATTERY_MAX_MULTIPHASE_COSMIC_NEUTRONIUM = addItem(3075, "battery.max.multiphase_cosmic_neutronium")
                .addComponents(ElectricStats.createRechargeableBattery(18038862643200L, GTValues.MAX))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MAX).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 2, -1711276033, 10, false) */;

        BATTERY_OPV_ANTIMATTER = addItem(3076, "battery.opv.antimatter")
                .addComponents(ElectricStats.createRechargeableBattery(5411658792960L, GTValues.OpV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.OpV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 1, -16777216, 10, true, 8, 1.0f) */;

        BATTERY_MAX_ANTIMATTER = addItem(3077, "battery.max.antimatter")
                .addComponents(ElectricStats.createRechargeableBattery(21646635171840L, GTValues.MAX))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MAX).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 1, -16777216, 10, true, 9, 1.0f) */;

        BATTERY_OPV_MULTIVERSIUM = addItem(3078, "battery.opv.multiversium")
                .addComponents(ElectricStats.createRechargeableBattery(6313601925120L, GTValues.OpV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.OpV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 1, -16777216, 10, true, 8, 1.0f) */;

        BATTERY_MAX_MULTIVERSIUM = addItem(3079, "battery.max.multiversium")
                .addComponents(ElectricStats.createRechargeableBattery(25254407700480L, GTValues.MAX))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MAX).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS)
        /* .cosmicProperties(true, 1, -16777216, 10, true, 9, 1.0f) */;

        ENERGY_PILE = addItem(3080, "battery.energy_pile")
                .addComponents(ElectricStats.createRechargeableBattery(78014054400L, GTValues.UHV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UHV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        ENERGY_SWARM = addItem(3081, "battery.energy_swarm")
                .addComponents(ElectricStats.createRechargeableBattery(312056217600L, GTValues.UEV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UEV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        ENERGY_PLATOON = addItem(3082, "battery.energy_platoon")
                .addComponents(ElectricStats.createRechargeableBattery(1489816780800L, GTValues.UIV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UIV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        ENERGY_ARRAY = addItem(3083, "battery.energy_array")
                .addComponents(ElectricStats.createRechargeableBattery(5959267123200L, GTValues.UXV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UXV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        ENERGY_MOUNTAIN = addItem(3084, "battery.energy_mountain")
                .addComponents(ElectricStats.createRechargeableBattery(23837068492800L, GTValues.OpV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.OpV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        TEMPORAL_ENERGY_ARRAY = addItem(3085, "battery.energy_universe")
                .addComponents(ElectricStats.createRechargeableBattery(110810156236800L, GTValues.MAX))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MAX).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        ULTIMATE_BATTERY_UEV = addItem(3086, "max.battery.uev")
                .addComponents(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UEV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UEV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        ULTIMATE_BATTERY_UIV = addItem(3087, "max.battery.uiv")
                .addComponents(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UIV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UIV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        ULTIMATE_BATTERY_UXV = addItem(3088, "max.battery.uxv")
                .addComponents(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.UXV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UXV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        ULTIMATE_BATTERY_OPV = addItem(3089, "max.battery.opv")
                .addComponents(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.OpV))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.OpV).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        ULTIMATE_BATTERY_MAX = addItem(3090, "max.battery.max")
                .addComponents(ElectricStats.createRechargeableBattery(Long.MAX_VALUE, GTValues.MAX))
                .setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MAX).setModelAmount(8)
                .setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        // Galacticraft/Extra Planets Integration 3100-3199
        INGOT_HEAVY_DUTY_T1 = addItem(3100, "ingot.heavy_duty.t1")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        INGOT_HEAVY_DUTY_T2 = addItem(3101, "ingot.heavy_duty.t2")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        INGOT_HEAVY_DUTY_T3 = addItem(3102, "ingot.heavy_duty.t3")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        INGOT_HEAVY_DUTY_T4 = addItem(3103, "ingot.heavy_duty.t4")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        INGOT_HEAVY_DUTY_T5 = addItem(3104, "ingot.heavy_duty.t5")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        INGOT_HEAVY_DUTY_T6 = addItem(3105, "ingot.heavy_duty.t6")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        INGOT_HEAVY_DUTY_T7 = addItem(3106, "ingot.heavy_duty.t7")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        INGOT_HEAVY_DUTY_T8 = addItem(3107, "ingot.heavy_duty.t8")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        INGOT_HEAVY_DUTY_T9 = addItem(3108, "ingot.heavy_duty.t9")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        INGOT_HEAVY_DUTY_T10 = addItem(3109, "ingot.heavy_duty.t10")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        COMPUTER_CONTROL_ROCKET_T1 = addItem(3110, "rocket.computer.t1")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        COMPUTER_CONTROL_ROCKET_T2 = addItem(3111, "rocket.computer.t2")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        COMPUTER_CONTROL_ROCKET_T3 = addItem(3112, "rocket.computer.t3")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        COMPUTER_CONTROL_ROCKET_T4 = addItem(3113, "rocket.computer.t4")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        COMPUTER_CONTROL_ROCKET_T5 = addItem(3114, "rocket.computer.t5")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        COMPUTER_CONTROL_ROCKET_T6 = addItem(3115, "rocket.computer.t6")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        COMPUTER_CONTROL_ROCKET_T7 = addItem(3116, "rocket.computer.t7")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        COMPUTER_CONTROL_ROCKET_T8 = addItem(3117, "rocket.computer.t8")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        COMPUTER_CONTROL_ROCKET_T9 = addItem(3118, "rocket.computer.t9")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        COMPUTER_CONTROL_ROCKET_T10 = addItem(3119, "rocket.computer.t10")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        COMPUTER_CONTROL_BUGGY = addItem(3120, "buggy.computer")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        COMPUTER_CONTROL_MINER = addItem(3121, "miner.computer")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        COMPUTER_CONTROL_ROVER = addItem(3122, "rover.computer")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        BOOSTER_ROCKET_T2 = addItem(3123, "rocket.booster.t2")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        NOSE_CONE_ROCKET_T2 = addItem(3124, "rocket.cone.t2")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        ENGINE_ROCKET_T2 = addItem(3125, "rocket.engine.t2")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);

        FIN_ROCKET_T2 = addItem(3126, "rocket.fin.t2")
                .setCreativeTabs(GTHHApi.TAB_GTHH_GCEP);
    }
}
