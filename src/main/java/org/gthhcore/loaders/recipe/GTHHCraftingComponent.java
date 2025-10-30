package org.gthhcore.loaders.recipe;

import static gregtech.api.GTValues.*;
import static gregtech.common.blocks.BlockGlassCasing.CasingType.*;
import static gregtech.common.blocks.MetaBlocks.*;
import static org.gthhcore.api.util.GTHHMods.*;
import static org.gthhcore.common.blocks.GTHHMetaBlocks.*;
import static org.gthhcore.common.blocks.transparent.GlassCasing0.CasingType.*;
import static org.gthhcore.common.blocks.transparent.GlassCasing1.CasingType.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

import org.gthhcore.api.unification.materials.material.GTHHMaterials;
import org.gthhcore.api.util.GTHHUtility;
import org.gthhcore.common.blocks.GTHHMetaBlocks;
import org.gthhcore.common.blocks.transparent.GlassCasing0;
import org.gthhcore.common.blocks.transparent.GlassCasing1;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.loaders.recipe.CraftingComponent;

public class GTHHCraftingComponent extends CraftingComponent {

    public static void initializeGlassTiers() {
        NonNullList<ItemStack> blockGlass = OreDictionary.getOres("blockGlass");

        OreDictionary.registerOre("blockGlassST", TRANSPARENT_CASING_0.getItemVariant(BRONZE_GLASS));
        OreDictionary.registerOre("blockGlassULV", TRANSPARENT_CASING_0.getItemVariant(WROUGHT_IRON_GLASS));
        OreDictionary.registerOre("blockGlassLV", TRANSPARENT_CASING_0.getItemVariant(STEEL_GLASS));
        OreDictionary.registerOre("blockGlassMV", TRANSPARENT_CASING_0.getItemVariant(ALUMINIUM_GLASS));
        OreDictionary.registerOre("blockGlassHV", TRANSPARENT_CASING_0.getItemVariant(STAINLESS_STEEL_GLASS));
        OreDictionary.registerOre("blockGlassEV", TRANSPARENT_CASING_0.getItemVariant(TITANIUM_GLASS));
        OreDictionary.registerOre("blockGlassIV", TRANSPARENT_CASING_0.getItemVariant(TUNGSTENSTEEL_GLASS));
        OreDictionary.registerOre("blockGlassLuV", TRANSPARENT_CASING_0.getItemVariant(RHODIUM_PLATED_PALLADIUM_GLASS));
        OreDictionary.registerOre("blockGlassZPM", TRANSPARENT_CASING_1.getItemVariant(NAQUADAH_ALLOY_GLASS));
        OreDictionary.registerOre("blockGlassUV", TRANSPARENT_CASING_1.getItemVariant(DARMSTADTIUM_GLASS));
        OreDictionary.registerOre("blockGlassUHV", TRANSPARENT_CASING_1.getItemVariant(NEUTRONIUM_GLASS));

        // Register glass as blockGlassHV
        for (ItemStack glass : blockGlass) {
            OreDictionary.registerOre("blockGlassHV", glass);
        }

        OreDictionary.registerOre("blockGlassHV", TRANSPARENT_CASING.getItemVariant(
                        TEMPERED_GLASS));

        OreDictionary.registerOre("blockGlassEV", TRANSPARENT_CASING.getItemVariant(LAMINATED_GLASS));

        if (Botania.isModLoaded()) {
            OreDictionary.registerOre("blockGlassEV",
                    GTHHUtility.getItemStackFromString("botania", "managlass"));
            OreDictionary.registerOre("blockGlassIV",
                    GTHHUtility.getItemStackFromString("botania", "elfglass"));
        }
    }

    public static void initializeComponents() {
        WIRE_ELECTRIC = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Gold) },
                { LV, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Gold) },
                { MV, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Silver) },
                { HV, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Electrum) },
                { EV, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Platinum) },
                { IV, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Osmium) },
                { LuV, new UnificationEntry(OrePrefix.wireGtSingle, Materials.HSSS) },
                { ZPM, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Trinium) },
                { UV, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Tritanium) },
                { UHV, new UnificationEntry(OrePrefix.wireGtSingle, GTHHMaterials.NeutroniumSteel) },
                { UEV, new UnificationEntry(OrePrefix.wireGtSingle, GTHHMaterials.BlackPlutonium) },
                { UIV, new UnificationEntry(OrePrefix.wireGtSingle, GTHHMaterials.Infinity) },
                { UXV, new UnificationEntry(OrePrefix.wireGtSingle, GTHHMaterials.Chronarium) },
                { OpV, new UnificationEntry(OrePrefix.wireGtSingle, GTHHMaterials.FluxedAwakenedDraconium) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        WIRE_QUAD = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Lead) },
                { LV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Tin) },
                { MV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Copper) },
                { HV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Gold) },
                { EV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Aluminium) },
                { IV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Tungsten) },
                { LuV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NiobiumTitanium) },
                { ZPM, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.VanadiumGallium) },
                { UV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.YttriumBariumCuprate) },
                { UHV, new UnificationEntry(OrePrefix.wireGtQuadruple, GTHHMaterials.NeutroniumSteel) },
                { UEV, new UnificationEntry(OrePrefix.wireGtQuadruple, GTHHMaterials.BlackPlutonium) },
                { UIV, new UnificationEntry(OrePrefix.wireGtQuadruple, GTHHMaterials.Infinity) },
                { UXV, new UnificationEntry(OrePrefix.wireGtQuadruple, GTHHMaterials.Chronarium) },
                { OpV, new UnificationEntry(OrePrefix.wireGtQuadruple, GTHHMaterials.FluxedAwakenedDraconium) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        WIRE_OCT = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Lead) },
                { LV, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Tin) },
                { MV, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Copper) },
                { HV, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Gold) },
                { EV, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Aluminium) },
                { IV, new UnificationEntry(OrePrefix.wireGtOctal, Materials.Tungsten) },
                { LuV, new UnificationEntry(OrePrefix.wireGtOctal, Materials.NiobiumTitanium) },
                { ZPM, new UnificationEntry(OrePrefix.wireGtOctal, Materials.VanadiumGallium) },
                { UV, new UnificationEntry(OrePrefix.wireGtOctal, Materials.YttriumBariumCuprate) },
                { UHV, new UnificationEntry(OrePrefix.wireGtOctal, GTHHMaterials.NeutroniumSteel) },
                { UEV, new UnificationEntry(OrePrefix.wireGtOctal, GTHHMaterials.BlackPlutonium) },
                { UIV, new UnificationEntry(OrePrefix.wireGtOctal, GTHHMaterials.Infinity) },
                { UXV, new UnificationEntry(OrePrefix.wireGtOctal, GTHHMaterials.Chronarium) },
                { OpV, new UnificationEntry(OrePrefix.wireGtOctal, GTHHMaterials.FluxedAwakenedDraconium) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        WIRE_HEX = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.wireGtHex, Materials.Lead) },
                { LV, new UnificationEntry(OrePrefix.wireGtHex, Materials.Tin) },
                { MV, new UnificationEntry(OrePrefix.wireGtHex, Materials.Copper) },
                { HV, new UnificationEntry(OrePrefix.wireGtHex, Materials.Gold) },
                { EV, new UnificationEntry(OrePrefix.wireGtHex, Materials.Aluminium) },
                { IV, new UnificationEntry(OrePrefix.wireGtHex, Materials.Tungsten) },
                { LuV, new UnificationEntry(OrePrefix.wireGtHex, Materials.NiobiumTitanium) },
                { ZPM, new UnificationEntry(OrePrefix.wireGtHex, Materials.VanadiumGallium) },
                { UV, new UnificationEntry(OrePrefix.wireGtHex, Materials.YttriumBariumCuprate) },
                { UHV, new UnificationEntry(OrePrefix.wireGtHex, GTHHMaterials.NeutroniumSteel) },
                { UEV, new UnificationEntry(OrePrefix.wireGtHex, GTHHMaterials.BlackPlutonium) },
                { UIV, new UnificationEntry(OrePrefix.wireGtHex, GTHHMaterials.Infinity) },
                { UXV, new UnificationEntry(OrePrefix.wireGtHex, GTHHMaterials.Chronarium) },
                { OpV, new UnificationEntry(OrePrefix.wireGtHex, GTHHMaterials.FluxedAwakenedDraconium) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.RedAlloy) },
                { LV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin) },
                { MV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper) },
                { HV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold) },
                { EV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium) },
                { IV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Platinum) },
                { LuV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.NiobiumTitanium) },
                { ZPM, new UnificationEntry(OrePrefix.cableGtSingle, Materials.VanadiumGallium) },
                { UV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate) },
                { UHV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Europium) },
                { UEV, new UnificationEntry(OrePrefix.cableGtSingle, GTHHMaterials.Draconium) },
                { UIV, new UnificationEntry(OrePrefix.cableGtSingle, GTHHMaterials.Quaintum) },
                { UXV, new UnificationEntry(OrePrefix.cableGtSingle, GTHHMaterials.ChronosSteel) },
                { OpV, new UnificationEntry(OrePrefix.cableGtSingle, GTHHMaterials.FluxedElectrum) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_QUAD = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.RedAlloy) },
                { LV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Tin) },
                { MV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Copper) },
                { HV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Gold) },
                { EV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Aluminium) },
                { IV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Platinum) },
                { LuV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium) },
                { ZPM, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium) },
                { UV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.YttriumBariumCuprate) },
                { UHV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Europium) },
                { UEV, new UnificationEntry(OrePrefix.cableGtQuadruple, GTHHMaterials.Draconium) },
                { UIV, new UnificationEntry(OrePrefix.cableGtQuadruple, GTHHMaterials.Quaintum) },
                { UXV, new UnificationEntry(OrePrefix.cableGtQuadruple, GTHHMaterials.ChronosSteel) },
                { OpV, new UnificationEntry(OrePrefix.cableGtQuadruple, GTHHMaterials.FluxedElectrum) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_OCT = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.cableGtOctal, Materials.RedAlloy) },
                { LV, new UnificationEntry(OrePrefix.cableGtOctal, Materials.Tin) },
                { MV, new UnificationEntry(OrePrefix.cableGtOctal, Materials.Copper) },
                { HV, new UnificationEntry(OrePrefix.cableGtOctal, Materials.Gold) },
                { EV, new UnificationEntry(OrePrefix.cableGtOctal, Materials.Aluminium) },
                { IV, new UnificationEntry(OrePrefix.cableGtOctal, Materials.Platinum) },
                { LuV, new UnificationEntry(OrePrefix.cableGtOctal, Materials.NiobiumTitanium) },
                { ZPM, new UnificationEntry(OrePrefix.cableGtOctal, Materials.VanadiumGallium) },
                { UV, new UnificationEntry(OrePrefix.cableGtOctal, Materials.YttriumBariumCuprate) },
                { UHV, new UnificationEntry(OrePrefix.cableGtOctal, Materials.Europium) },
                { UEV, new UnificationEntry(OrePrefix.cableGtOctal, GTHHMaterials.Draconium) },
                { UIV, new UnificationEntry(OrePrefix.cableGtOctal, GTHHMaterials.Quaintum) },
                { UXV, new UnificationEntry(OrePrefix.cableGtOctal, GTHHMaterials.ChronosSteel) },
                { OpV, new UnificationEntry(OrePrefix.cableGtOctal, GTHHMaterials.FluxedElectrum) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_HEX = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.cableGtHex, Materials.RedAlloy) },
                { LV, new UnificationEntry(OrePrefix.cableGtHex, Materials.Tin) },
                { MV, new UnificationEntry(OrePrefix.cableGtHex, Materials.Copper) },
                { HV, new UnificationEntry(OrePrefix.cableGtHex, Materials.Gold) },
                { EV, new UnificationEntry(OrePrefix.cableGtHex, Materials.Aluminium) },
                { IV, new UnificationEntry(OrePrefix.cableGtHex, Materials.Platinum) },
                { LuV, new UnificationEntry(OrePrefix.cableGtHex, Materials.NiobiumTitanium) },
                { ZPM, new UnificationEntry(OrePrefix.cableGtHex, Materials.VanadiumGallium) },
                { UV, new UnificationEntry(OrePrefix.cableGtHex, Materials.YttriumBariumCuprate) },
                { UHV, new UnificationEntry(OrePrefix.cableGtHex, Materials.Europium) },
                { UEV, new UnificationEntry(OrePrefix.cableGtHex, GTHHMaterials.Draconium) },
                { UIV, new UnificationEntry(OrePrefix.cableGtHex, GTHHMaterials.Quaintum) },
                { UXV, new UnificationEntry(OrePrefix.cableGtHex, GTHHMaterials.ChronosSteel) },
                { OpV, new UnificationEntry(OrePrefix.cableGtHex, GTHHMaterials.FluxedElectrum) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_TIER_UP = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin) },
                { LV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper) },
                { MV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold) },
                { HV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium) },
                { EV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Platinum) },
                { IV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.NiobiumTitanium) },
                { LuV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.VanadiumGallium) },
                { ZPM, new UnificationEntry(OrePrefix.cableGtSingle, Materials.YttriumBariumCuprate) },
                { UV, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Europium) },
                { UHV, new UnificationEntry(OrePrefix.cableGtSingle, GTHHMaterials.Draconium) },
                { UEV, new UnificationEntry(OrePrefix.cableGtSingle, GTHHMaterials.Quaintum) },
                { UIV, new UnificationEntry(OrePrefix.cableGtSingle, GTHHMaterials.ChronosSteel) },
                { UXV, new UnificationEntry(OrePrefix.cableGtSingle, GTHHMaterials.FluxedElectrum) },
                { GTValues.FALLBACK, new UnificationEntry(OrePrefix.cableGtSingle, Materials.Europium) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_QUAD_TIER_UP = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Tin) },
                { LV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Copper) },
                { MV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Gold) },
                { HV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Aluminium) },
                { EV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Platinum) },
                { IV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.NiobiumTitanium) },
                { LuV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.VanadiumGallium) },
                { ZPM, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.YttriumBariumCuprate) },
                { UV, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Europium) },
                { UHV, new UnificationEntry(OrePrefix.cableGtQuadruple, GTHHMaterials.Draconium) },
                { UEV, new UnificationEntry(OrePrefix.cableGtQuadruple, GTHHMaterials.Quaintum) },
                { UIV, new UnificationEntry(OrePrefix.cableGtQuadruple, GTHHMaterials.ChronosSteel) },
                { UXV, new UnificationEntry(OrePrefix.cableGtQuadruple, GTHHMaterials.FluxedElectrum) },
                { GTValues.FALLBACK, new UnificationEntry(OrePrefix.cableGtQuadruple, Materials.Europium) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        GLASS.appendIngredients(Stream.of(new Object[][] {
                { FALLBACK, TRANSPARENT_CASING_0.getItemVariant(BRONZE_GLASS) },
                { ULV, TRANSPARENT_CASING_0.getItemVariant(GlassCasing0.CasingType.WROUGHT_IRON_GLASS) },
                { LV, TRANSPARENT_CASING_0.getItemVariant(GlassCasing0.CasingType.STEEL_GLASS) },
                { MV, TRANSPARENT_CASING_0.getItemVariant(GlassCasing0.CasingType.ALUMINIUM_GLASS) },
                { HV, TRANSPARENT_CASING_0
                        .getItemVariant(GlassCasing0.CasingType.STAINLESS_STEEL_GLASS) },
                { EV, TRANSPARENT_CASING_0.getItemVariant(GlassCasing0.CasingType.TITANIUM_GLASS) },
                { IV, TRANSPARENT_CASING_0.getItemVariant(GlassCasing0.CasingType.TUNGSTENSTEEL_GLASS) },
                { LuV, TRANSPARENT_CASING_0
                        .getItemVariant(GlassCasing0.CasingType.RHODIUM_PLATED_PALLADIUM_GLASS) },
                { ZPM, GTHHMetaBlocks.TRANSPARENT_CASING_1
                        .getItemVariant(NAQUADAH_ALLOY_GLASS) },
                { UV, GTHHMetaBlocks.TRANSPARENT_CASING_1.getItemVariant(GlassCasing1.CasingType.DARMSTADTIUM_GLASS) },
                { UHV, GTHHMetaBlocks.TRANSPARENT_CASING_1.getItemVariant(GlassCasing1.CasingType.NEUTRONIUM_GLASS) },
                { UEV, GTHHMetaBlocks.TRANSPARENT_CASING_1
                        .getItemVariant(GlassCasing1.CasingType.BLACK_PLUTONIUM_GLASS) },
                { UIV, GTHHMetaBlocks.TRANSPARENT_CASING_1.getItemVariant(GlassCasing1.CasingType.BEDROCKIUM_GLASS) },
                { UXV, GTHHMetaBlocks.TRANSPARENT_CASING_1
                        .getItemVariant(GlassCasing1.CasingType.ELECTRO_MATTER_GLASS) },
                { OpV, GTHHMetaBlocks.TRANSPARENT_CASING_1
                        .getItemVariant(GlassCasing1.CasingType.TEMPORALLY_CONSTRAINED_STAR_MATTER_GLASS) },
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        PLATE = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.plate, Materials.WroughtIron) },
                { LV, new UnificationEntry(OrePrefix.plate, Materials.Steel) },
                { MV, new UnificationEntry(OrePrefix.plate, Materials.Aluminium) },
                { HV, new UnificationEntry(OrePrefix.plate, Materials.StainlessSteel) },
                { EV, new UnificationEntry(OrePrefix.plate, Materials.Titanium) },
                { IV, new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel) },
                { LuV, new UnificationEntry(OrePrefix.plate, Materials.RhodiumPlatedPalladium) },
                { ZPM, new UnificationEntry(OrePrefix.plate, Materials.NaquadahAlloy) },
                { UV, new UnificationEntry(OrePrefix.plate, Materials.Darmstadtium) },
                { UHV, new UnificationEntry(OrePrefix.plate, Materials.Neutronium) },
                { UEV, new UnificationEntry(OrePrefix.plate, GTHHMaterials.BlackPlutonium) },
                { UIV, new UnificationEntry(OrePrefix.plate, GTHHMaterials.Bedrockium) },
                { UXV, new UnificationEntry(OrePrefix.plate, GTHHMaterials.ElectroMatter) },
                { OpV, new UnificationEntry(OrePrefix.plate, GTHHMaterials.TemporallyConstrainedStarMatter) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        DOUBLE_PLATE = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.plateDouble, Materials.WroughtIron) },
                { LV, new UnificationEntry(OrePrefix.plateDouble, Materials.Steel) },
                { MV, new UnificationEntry(OrePrefix.plateDouble, Materials.Aluminium) },
                { HV, new UnificationEntry(OrePrefix.plateDouble, Materials.StainlessSteel) },
                { EV, new UnificationEntry(OrePrefix.plateDouble, Materials.Titanium) },
                { IV, new UnificationEntry(OrePrefix.plateDouble, Materials.TungstenSteel) },
                { LuV, new UnificationEntry(OrePrefix.plateDouble, Materials.RhodiumPlatedPalladium) },
                { ZPM, new UnificationEntry(OrePrefix.plateDouble, Materials.NaquadahAlloy) },
                { UV, new UnificationEntry(OrePrefix.plateDouble, Materials.Darmstadtium) },
                { UHV, new UnificationEntry(OrePrefix.plateDouble, Materials.Neutronium) },
                { UEV, new UnificationEntry(OrePrefix.plateDouble, GTHHMaterials.BlackPlutonium) },
                { UIV, new UnificationEntry(OrePrefix.plateDouble, GTHHMaterials.Bedrockium) },
                { UXV, new UnificationEntry(OrePrefix.plateDouble, GTHHMaterials.ElectroMatter) },
                { OpV, new UnificationEntry(OrePrefix.plateDouble, GTHHMaterials.TemporallyConstrainedStarMatter) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        HULL_PLATE = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.plate, Materials.Wood) },
                { LV, new UnificationEntry(OrePrefix.plate, Materials.WroughtIron) },
                { MV, new UnificationEntry(OrePrefix.plate, Materials.WroughtIron) },
                { HV, new UnificationEntry(OrePrefix.plate, Materials.Polyethylene) },
                { EV, new UnificationEntry(OrePrefix.plate, Materials.Polyethylene) },
                { IV, new UnificationEntry(OrePrefix.plate, Materials.Polytetrafluoroethylene) },
                { LuV, new UnificationEntry(OrePrefix.plate, Materials.Polytetrafluoroethylene) },
                { ZPM, new UnificationEntry(OrePrefix.plate, Materials.Polybenzimidazole) },
                { UV, new UnificationEntry(OrePrefix.plate, Materials.Polybenzimidazole) },
                { GTValues.FALLBACK, new UnificationEntry(OrePrefix.plate, Materials.Polybenzimidazole) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        COIL_HEATING = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Copper) },
                { LV, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Copper) },
                { MV, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Cupronickel) },
                { HV, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Kanthal) },
                { EV, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Nichrome) },
                { IV, new UnificationEntry(OrePrefix.wireGtDouble, Materials.RTMAlloy) },
                { LuV, new UnificationEntry(OrePrefix.wireGtDouble, Materials.HSSG) },
                { ZPM, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Naquadah) },
                { UV, new UnificationEntry(OrePrefix.wireGtDouble, Materials.NaquadahAlloy) },
                { UHV, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Europium) },
                { UEV, new UnificationEntry(OrePrefix.wireGtDouble, GTHHMaterials.BlackPlutonium) },
                { UIV, new UnificationEntry(OrePrefix.wireGtDouble, GTHHMaterials.Infinity) },
                { UXV, new UnificationEntry(OrePrefix.wireGtDouble, GTHHMaterials.Chronarium) },
                { OpV, new UnificationEntry(OrePrefix.wireGtDouble, GTHHMaterials.FluxedElectrum) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        COIL_HEATING_DOUBLE = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Copper) },
                { LV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Copper) },
                { MV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Cupronickel) },
                { HV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Kanthal) },
                { EV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Nichrome) },
                { IV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.RTMAlloy) },
                { LuV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.HSSG) },
                { ZPM, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Naquadah) },
                { UV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NaquadahAlloy) },
                { UHV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Europium) },
                { UEV, new UnificationEntry(OrePrefix.wireGtQuadruple, GTHHMaterials.BlackPlutonium) },
                { UIV, new UnificationEntry(OrePrefix.wireGtQuadruple, GTHHMaterials.Infinity) },
                { UXV, new UnificationEntry(OrePrefix.wireGtQuadruple, GTHHMaterials.Chronarium) },
                { OpV, new UnificationEntry(OrePrefix.wireGtQuadruple, GTHHMaterials.FluxedElectrum) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        COIL_ELECTRIC = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.wireGtSingle, Materials.Tin) },
                { LV, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Tin) },
                { MV, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Copper) },
                { HV, new UnificationEntry(OrePrefix.wireGtDouble, Materials.Silver) },
                { EV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Steel) },
                { IV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Graphene) },
                { LuV, new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NiobiumNitride) },
                { ZPM, new UnificationEntry(OrePrefix.wireGtOctal, Materials.VanadiumGallium) },
                { UV, new UnificationEntry(OrePrefix.wireGtOctal, Materials.YttriumBariumCuprate) },
                { FALLBACK, new UnificationEntry(OrePrefix.wireGtHex, Materials.NaquadahAlloy) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        STICK_ELECTROMAGNETIC = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.stick, Materials.WroughtIron) },
                { LV, new UnificationEntry(OrePrefix.stick, Materials.Iron) },
                { MV, new UnificationEntry(OrePrefix.stick, Materials.Steel) },
                { HV, new UnificationEntry(OrePrefix.stick, Materials.Steel) },
                { EV, new UnificationEntry(OrePrefix.stick, Materials.Neodymium) },
                { IV, new UnificationEntry(OrePrefix.stick, Materials.Neodymium) },
                { LuV, new UnificationEntry(OrePrefix.stick, Materials.Samarium) },
                { FALLBACK, new UnificationEntry(OrePrefix.stick, Materials.Samarium) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        ROTOR = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.rotor, Materials.Tin) },
                { LV, new UnificationEntry(OrePrefix.rotor, Materials.Tin) },
                { MV, new UnificationEntry(OrePrefix.rotor, Materials.Bronze) },
                { HV, new UnificationEntry(OrePrefix.rotor, Materials.Steel) },
                { EV, new UnificationEntry(OrePrefix.rotor, Materials.StainlessSteel) },
                { IV, new UnificationEntry(OrePrefix.rotor, Materials.TungstenSteel) },
                { LuV, new UnificationEntry(OrePrefix.rotor, Materials.RhodiumPlatedPalladium) },
                { ZPM, new UnificationEntry(OrePrefix.rotor, Materials.NaquadahAlloy) },
                { UV, new UnificationEntry(OrePrefix.rotor, Materials.Darmstadtium) },
                { UHV, new UnificationEntry(OrePrefix.rotor, GTHHMaterials.BlackPlutonium) },
                { UEV, new UnificationEntry(OrePrefix.rotor, GTHHMaterials.Bedrockium) },
                { UIV, new UnificationEntry(OrePrefix.rotor, GTHHMaterials.ElectroMatter) },
                { UXV, new UnificationEntry(OrePrefix.rotor, GTHHMaterials.TemporallyConstrainedStarMatter) },
                { OpV, new UnificationEntry(OrePrefix.rotor, GTHHMaterials.PrismaticVoidMatter) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        PIPE_NORMAL = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Bronze) },
                { LV, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Bronze) },
                { MV, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Steel) },
                { HV, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.StainlessSteel) },
                { EV, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Titanium) },
                { IV, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.TungstenSteel) },
                { LuV, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.NiobiumTitanium) },
                { ZPM, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Iridium) },
                { UV, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Naquadah) },
                { GTValues.FALLBACK, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Neutronium) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        PIPE_LARGE = new Component(Stream.of(new Object[][] {
                { ULV, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Bronze) },
                { LV, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Bronze) },
                { MV, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Steel) },
                { HV, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.StainlessSteel) },
                { EV, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Titanium) },
                { IV, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.TungstenSteel) },
                { LuV, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.NiobiumTitanium) },
                { ZPM, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Ultimet) },
                { UV, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Naquadah) },
                { GTValues.FALLBACK, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Neutronium) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        PIPE_REACTOR = new Component(Stream.of(new Object[][] {
                { ULV, new ItemStack(Blocks.GLASS, LV, GTValues.W) },
                { LV, new ItemStack(Blocks.GLASS, LV, GTValues.W) },
                { MV, new ItemStack(Blocks.GLASS, LV, GTValues.W) },
                { HV, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Polyethylene) },
                { EV, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Polyethylene) },
                { IV, new UnificationEntry(OrePrefix.pipeHugeFluid, Materials.Polyethylene) },
                { LuV, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Polytetrafluoroethylene) },
                { ZPM, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Polytetrafluoroethylene) },
                { UV, new UnificationEntry(OrePrefix.pipeHugeFluid, Materials.Polytetrafluoroethylene) },
                { UHV, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Polybenzimidazole) },
                { UEV, new UnificationEntry(OrePrefix.pipeLargeFluid, Materials.Polybenzimidazole) },
                { UIV, new UnificationEntry(OrePrefix.pipeHugeFluid, Materials.Polybenzimidazole) },
                { GTValues.FALLBACK, new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Polyethylene) },

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
    }
}
