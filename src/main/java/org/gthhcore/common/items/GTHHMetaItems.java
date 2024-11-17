package org.gthhcore.common.items;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.gthhcore.common.items.metaitem.GTHHMetaItem;

import java.util.*;

public class GTHHMetaItems {
    private GTHHMetaItems() {
    }

    public static final List<GTHHMetaItem<?>> ITEMS = GTHHMetaItem.getMetaItems();

    //GregTech Components
    public static GTHHMetaItem<?>.GTHHMetaValueItem MicaBasedPulp;
    public static GTHHMetaItem<?>.GTHHMetaValueItem MicaBasedSheet;
    public static GTHHMetaItem<?>.GTHHMetaValueItem MicaInsulatorSheet;
    public static GTHHMetaItem<?>.GTHHMetaValueItem MicaInsulatorFoil;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CoolantCellTenK;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CoolantCellTenKNaK;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CoolantCellTenKSpace;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CoolantCellThirtyK;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CoolantCellThirtyKNaK;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CoolantCellThirtyKSpace;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CoolantCellSixtyK;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CoolantCellSixtyKNaK;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CoolantCellSixtyKSpace;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CoolantCellEmptyTenK;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CoolantCellEmptyThirtyK;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CoolantCellEmptySixtyK;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BorosilicateGlassTube;

    //Mod Integration
    public static GTHHMetaItem<?>.GTHHMetaValueItem UnfiredJuicer;
    public static GTHHMetaItem<?>.GTHHMetaValueItem UnfiredBakeware;
    public static GTHHMetaItem<?>.GTHHMetaValueItem SandCompoundWafer;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BasicChipWafer;
    public static GTHHMetaItem<?>.GTHHMetaValueItem AdvancedChipWafer;
    public static GTHHMetaItem<?>.GTHHMetaValueItem FpgaWafer;
    public static GTHHMetaItem<?>.GTHHMetaValueItem SandCompoundBoule;
    public static GTHHMetaItem<?>.GTHHMetaValueItem QuickAndDirtyPortalGenerator;

    //GregTech Circuit Components
    public static GTHHMetaItem<?>.GTHHMetaValueItem SlimewareProcessorZPM;
    public static GTHHMetaItem<?>.GTHHMetaValueItem SlimewareAssemblyUV;
    public static GTHHMetaItem<?>.GTHHMetaValueItem SlimewareComputerUHV;
    public static GTHHMetaItem<?>.GTHHMetaValueItem SlimewareMainframeUEV;
    public static GTHHMetaItem<?>.GTHHMetaValueItem LasertronicProcessorUV;
    public static GTHHMetaItem<?>.GTHHMetaValueItem LasertronicAssemblyUHV;
    public static GTHHMetaItem<?>.GTHHMetaValueItem LasertronicComputerUEV;
    public static GTHHMetaItem<?>.GTHHMetaValueItem LasertronicMainframeUIV;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BohemianProcessorUHV;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BohemianAssemblyUEV;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BohemianComputerUIV;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BohemianMainframeUXV;
    public static GTHHMetaItem<?>.GTHHMetaValueItem AntimatterProcessorUEV;
    public static GTHHMetaItem<?>.GTHHMetaValueItem SlimewareBoard;
    public static GTHHMetaItem<?>.GTHHMetaValueItem LasertronicBoard;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BohemianBoard;
    public static GTHHMetaItem<?>.GTHHMetaValueItem AntimatterBoard;
    public static GTHHMetaItem<?>.GTHHMetaValueItem TemporalBoard;
    public static GTHHMetaItem<?>.GTHHMetaValueItem SlimewareCircuitBoard;
    public static GTHHMetaItem<?>.GTHHMetaValueItem LasertronicCircuitBoard;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BohemianCircuitBoard;
    public static GTHHMetaItem<?>.GTHHMetaValueItem AntimatterCircuitBoard;
    public static GTHHMetaItem<?>.GTHHMetaValueItem TemporalCircuitBoard;
    public static GTHHMetaItem<?>.GTHHMetaValueItem NanoSmdTransistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem NanoSmdResistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem NanoSmdCapacitor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem NanoSmdDiode;
    public static GTHHMetaItem<?>.GTHHMetaValueItem NanoSmdInductor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem QuantumSmdTransistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem QuantumSmdResistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem QuantumSmdCapacitor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem QuantumSmdDiode;
    public static GTHHMetaItem<?>.GTHHMetaValueItem QuantumSmdInductor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CrystalSmdTransistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CrystalSmdResistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CrystalSmdCapacitor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CrystalSmdDiode;
    public static GTHHMetaItem<?>.GTHHMetaValueItem CrystalSmdInductor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem SlimewareSmdTransistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem SlimewareSmdResistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem SlimewareSmdCapacitor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem SlimewareSmdDiode;
    public static GTHHMetaItem<?>.GTHHMetaValueItem SlimewareSmdInductor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem LasertronicSmdTransistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem LasertronicSmdResistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem LasertronicSmdCapacitor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem LasertronicSmdDiode;
    public static GTHHMetaItem<?>.GTHHMetaValueItem LasertronicSmdInductor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BohemianSmdTransistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BohemianSmdResistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BohemianSmdCapacitor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BohemianSmdDiode;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BohemianSmdInductor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem AntimatterSmdTransistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem AntimatterSmdResistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem AntimatterSmdCapacitor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem AntimatterSmdDiode;
    public static GTHHMetaItem<?>.GTHHMetaValueItem AntimatterSmdInductor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem TemporalSmdTransistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem TemporalSmdResistor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem TemporalSmdCapacitor;
    public static GTHHMetaItem<?>.GTHHMetaValueItem TemporalSmdDiode;
    public static GTHHMetaItem<?>.GTHHMetaValueItem TemporalSmdInductor;

    //Superconductor Bases
    public static GTHHMetaItem<?>.GTHHMetaValueItem ManganesePhosphideBase;

    //Higher Tier Batteries
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullSmallNaqudria;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullMediumNaqudria;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullLargeNaqudria;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullSmallCosmicNeutronium;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullMediumCosmicNeutronium;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullLargeCosmicNeutronium;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullSmallMultiversium;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullMediumMultiversium;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullLargeMultiversium;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullZPMNaquadria;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullUVNaquadria;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullUHVNaquadria;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullUEVCosmicNeutronium;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullUIVCosmicNeutronium;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullUXVCosmicNeutronium;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullOPVMultiversium;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullMAX0Multiversium;
    public static GTHHMetaItem<?>.GTHHMetaValueItem BatteryHullMAX1Multiversium;

    public static void init() {
        GTHHMetaItem1 metaItem1 = new GTHHMetaItem1();
        metaItem1.setRegistryName("meta_item_1");
    }

    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        MinecraftForge.EVENT_BUS.register(GTHHMetaItems.class);
        for (GTHHMetaItem<?> item : ITEMS) {
            item.registerModels();
            item.registerTextureMesh();
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerColors() {
        for (GTHHMetaItem<?> item : ITEMS) {
            item.registerColor();
        }
    }
}
