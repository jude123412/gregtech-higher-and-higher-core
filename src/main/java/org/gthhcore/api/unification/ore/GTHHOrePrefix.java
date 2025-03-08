package org.gthhcore.api.unification.ore;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.unification.ore.OrePrefix.Flags.*;
import static org.gthhcore.api.unification.material.info.GTHHMaterialFlags.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.api.util.GTHHMods.*;

import org.gthhcore.api.unification.material.info.GTHHMaterialIconType;

import gregtech.api.unification.material.info.MaterialIconType;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.common.items.MetaItems;

public class GTHHOrePrefix {

    public static final OrePrefix oreMoon = new OrePrefix("oreMoon", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreMars = new OrePrefix("oreMars", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreAsteroid = new OrePrefix("oreAsteroid", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreVenus = new OrePrefix("oreVenus", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreMercury = new OrePrefix("oreMercury", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreCeres = new OrePrefix("oreCeres", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreJupiter = new OrePrefix("oreJupiter", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreSaturn = new OrePrefix("oreSaturn", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreUranus = new OrePrefix("oreUranus", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreNeptune = new OrePrefix("oreNeptune", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix orePluto = new OrePrefix("orePluto", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreEris = new OrePrefix("oreEris", -1,
            null, MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreKepler22B = new OrePrefix("oreKepler22B", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreEuropa = new OrePrefix("oreEuropa", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreIo = new OrePrefix("oreIo", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreDeimos = new OrePrefix("oreDeimos", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix orePhobos = new OrePrefix("orePhobos", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreTriton = new OrePrefix("oreTriton", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreCallisto = new OrePrefix("oreCallisto", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreGanymede = new OrePrefix("oreGanymede", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreRhea = new OrePrefix("oreRhea", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreTitan = new OrePrefix("oreTitan", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreOberon = new OrePrefix("oreOberon", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreTitania = new OrePrefix("oreTitania", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreIapetus = new OrePrefix("oreIapetus", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);

    public static final OrePrefix cluster = new OrePrefix("cluster", -1, null,
            GTHHMaterialIconType.cluster,
            ENABLE_UNIFICATION,
            mat -> mat.hasProperty(PropertyKey.ORE));

    public static final OrePrefix glob = new OrePrefix("glob", -1, null,
            GTHHMaterialIconType.glob,
            ENABLE_UNIFICATION,
            mat -> mat.hasProperty(PropertyKey.ORE));

    public static final OrePrefix fragment = new OrePrefix("fragment", -1, null,
            GTHHMaterialIconType.fragment,
            ENABLE_UNIFICATION,
            mat -> mat.hasProperty(PropertyKey.ORE));

    public static final OrePrefix murky = new OrePrefix("murky", -1, null,
            GTHHMaterialIconType.murky,
            ENABLE_UNIFICATION,
            mat -> mat.hasProperty(PropertyKey.ORE));

    public static final OrePrefix raw = new OrePrefix("raw", -1, null,
            GTHHMaterialIconType.raw,
            ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_RAW));

    public static final OrePrefix rodFuelSingle = new OrePrefix("rodFuelSingle", -1, null,
            GTHHMaterialIconType.rodFuelSingle,
            ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_ROD_FUEL));

    public static final OrePrefix rodFuelDual = new OrePrefix("rodFuelDual", -1, null,
            GTHHMaterialIconType.rodFuelDual,
            ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_ROD_FUEL));

    public static final OrePrefix rodFuelQuad = new OrePrefix("rodFuelQuad", -1, null,
            GTHHMaterialIconType.rodFuelQuad,
            ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_ROD_FUEL));

    public static final OrePrefix rodDepletedSingle = new OrePrefix("rodDepletedSingle", -1, null,
            GTHHMaterialIconType.rodDepletedSingle,
            ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_ROD_FUEL));

    public static final OrePrefix rodDepletedDual = new OrePrefix("rodDepletedDual", -1, null,
            GTHHMaterialIconType.rodDepletedDual,
            ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_ROD_FUEL));

    public static final OrePrefix rodDepletedQuad = new OrePrefix("rodDepletedQuad", -1, null,
            GTHHMaterialIconType.rodDepletedQuad,
            ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_ROD_FUEL));

    public static void init() {
        oreMoon.addSecondaryMaterial(new MaterialStack(MoonStone, OrePrefix.dust.getMaterialAmount(MoonStone)));
        oreMars.addSecondaryMaterial(new MaterialStack(MarsStone, OrePrefix.dust.getMaterialAmount(MarsStone)));
        oreAsteroid.addSecondaryMaterial(
                new MaterialStack(AsteroidStone, OrePrefix.dust.getMaterialAmount(AsteroidStone)));
        oreVenus.addSecondaryMaterial(new MaterialStack(VenusStone, OrePrefix.dust.getMaterialAmount(VenusStone)));
        oreMercury
                .addSecondaryMaterial(new MaterialStack(MercuryStone, OrePrefix.dust.getMaterialAmount(MercuryStone)));
        oreCeres.addSecondaryMaterial(new MaterialStack(CeresStone, OrePrefix.dust.getMaterialAmount(CeresStone)));
        oreJupiter
                .addSecondaryMaterial(new MaterialStack(JupiterStone, OrePrefix.dust.getMaterialAmount(JupiterStone)));
        oreSaturn.addSecondaryMaterial(new MaterialStack(SaturnStone, OrePrefix.dust.getMaterialAmount(SaturnStone)));
        oreUranus.addSecondaryMaterial(new MaterialStack(UranusStone, OrePrefix.dust.getMaterialAmount(UranusStone)));
        oreNeptune
                .addSecondaryMaterial(new MaterialStack(NeptuneStone, OrePrefix.dust.getMaterialAmount(NeptuneStone)));
        orePluto.addSecondaryMaterial(new MaterialStack(PlutoStone, OrePrefix.dust.getMaterialAmount(PlutoStone)));
        oreEris.addSecondaryMaterial(new MaterialStack(ErisStone, OrePrefix.dust.getMaterialAmount(ErisStone)));
        oreKepler22B.addSecondaryMaterial(
                new MaterialStack(Kepler22bStone, OrePrefix.dust.getMaterialAmount(Kepler22bStone)));
        oreEuropa.addSecondaryMaterial(new MaterialStack(EuropaStone, OrePrefix.dust.getMaterialAmount(EuropaStone)));
        oreIo.addSecondaryMaterial(new MaterialStack(IoStone, OrePrefix.dust.getMaterialAmount(IoStone)));
        oreDeimos.addSecondaryMaterial(new MaterialStack(DeimosStone, OrePrefix.dust.getMaterialAmount(DeimosStone)));
        orePhobos.addSecondaryMaterial(new MaterialStack(PhobosStone, OrePrefix.dust.getMaterialAmount(PhobosStone)));
        oreTriton.addSecondaryMaterial(new MaterialStack(TritonStone, OrePrefix.dust.getMaterialAmount(TritonStone)));
        oreCallisto.addSecondaryMaterial(
                new MaterialStack(CallistoStone, OrePrefix.dust.getMaterialAmount(CallistoStone)));
        oreGanymede.addSecondaryMaterial(
                new MaterialStack(GanymedeStone, OrePrefix.dust.getMaterialAmount(GanymedeStone)));
        oreRhea.addSecondaryMaterial(new MaterialStack(RheaStone, OrePrefix.dust.getMaterialAmount(RheaStone)));
        oreTitan.addSecondaryMaterial(new MaterialStack(TitanStone, OrePrefix.dust.getMaterialAmount(TitanStone)));
        oreOberon.addSecondaryMaterial(new MaterialStack(OberonStone, OrePrefix.dust.getMaterialAmount(OberonStone)));
        oreTitania
                .addSecondaryMaterial(new MaterialStack(TitaniaStone, OrePrefix.dust.getMaterialAmount(TitaniaStone)));
        oreIapetus
                .addSecondaryMaterial(new MaterialStack(IapetusStone, OrePrefix.dust.getMaterialAmount(IapetusStone)));

        // Set Ignore Stuff
        cluster.setIgnored(Iron);
        cluster.setIgnored(Gold);
        cluster.setIgnored(Copper);
        cluster.setIgnored(Tin);
        cluster.setIgnored(Silver);
        cluster.setIgnored(Lead);
        cluster.setIgnored(Cinnabar);

        // Ae2
        if (Ae2.isModLoaded()) {
            gem.setIgnored(CertusQuartz);
            gem.setIgnored(ChargedCertusQuartz);
            gem.setIgnored(Fluix);
            gem.setIgnored(FluixPearl);
            dust.setIgnored(SkyStone);
            block.setIgnored(CertusQuartz);
            block.setIgnored(Fluix);
            block.setIgnored(Fluixilized);
            block.modifyMaterialAmount(CertusQuartz, 4);
            block.modifyMaterialAmount(Fluix, 4);
            block.modifyMaterialAmount(Fluixilized, 4);
        }

        // Astral Sorcery
        if (AstralSorcery.isModLoaded()) {
            dust.setIgnored(Starmetal);

            ingot.setIgnored(Starmetal);

            gem.setIgnored(Aquamarine);
        }

        // Avaritia
        if (Avaritia.isModLoaded()) {
            nugget.setIgnored(CosmicNeutronium);

            ingot.setIgnored(CrystalMatrix);
            ingot.setIgnored(CosmicNeutronium);
            ingot.setIgnored(Infinity);

            gem.setIgnored(InfinityCatalyst);

            block.setIgnored(CrystalMatrix);
            block.setIgnored(CosmicNeutronium);
            block.setIgnored(Infinity);
        }

        // Botania
        if (Botania.isModLoaded()) {
            nugget.setIgnored(ManaSteel);
            nugget.setIgnored(TerraSteel);
            nugget.setIgnored(Elementium);

            ingot.setIgnored(ManaSteel);
            ingot.setIgnored(TerraSteel);
            ingot.setIgnored(Elementium);
            ingot.setIgnored(GaiaSpirit);

            gem.setIgnored(ManaDiamond);
            gem.setIgnored(ManaPearl);

            MetaItems.addOrePrefix(glob);
        }

        // Ender Io
        if (EnderIo.isModLoaded()) {
            nugget.setIgnored(ElectricalSteel);
            nugget.setIgnored(EnergeticAlloy);
            nugget.setIgnored(VibrantAlloy);
            nugget.setIgnored(RedstoneAlloy);
            nugget.setIgnored(ConductiveIron);
            nugget.setIgnored(PulsatingIron);
            nugget.setIgnored(DarkSteel);
            nugget.setIgnored(Soularium);
            nugget.setIgnored(EndSteel);

            ingot.setIgnored(ElectricalSteel);
            ingot.setIgnored(EnergeticAlloy);
            ingot.setIgnored(VibrantAlloy);
            ingot.setIgnored(RedstoneAlloy);
            ingot.setIgnored(ConductiveIron);
            ingot.setIgnored(PulsatingIron);
            ingot.setIgnored(DarkSteel);
            ingot.setIgnored(Soularium);
            ingot.setIgnored(EndSteel);

            dust.setIgnored(PulsatingCrystal);
            dust.setIgnored(VibrantCrystal);
            dust.setIgnored(EnderCrystal);
            dust.setIgnored(PrescientCrystal);

            gem.setIgnored(PulsatingCrystal);
            gem.setIgnored(VibrantCrystal);
            gem.setIgnored(EnderCrystal);
            gem.setIgnored(EnticingCrystal);
            gem.setIgnored(WeatherCrystal);
            gem.setIgnored(PrescientCrystal);

            block.setIgnored(ElectricalSteel);
            block.setIgnored(EnergeticAlloy);
            block.setIgnored(VibrantAlloy);
            block.setIgnored(RedstoneAlloy);
            block.setIgnored(ConductiveIron);
            block.setIgnored(PulsatingIron);
            block.setIgnored(DarkSteel);
            block.setIgnored(Soularium);
            block.setIgnored(EndSteel);

            if (EnderIoEndergy.isModLoaded()) {
                nugget.setIgnored(CrudeSteel);
                nugget.setIgnored(CrystallineAlloy);
                nugget.setIgnored(MelodicAlloy);
                nugget.setIgnored(StellarAlloy);
                nugget.setIgnored(CrystallinePinkSlime);
                nugget.setIgnored(EnergeticSilver);
                nugget.setIgnored(VividAlloy);

                ingot.setIgnored(CrudeSteel);
                ingot.setIgnored(CrystallineAlloy);
                ingot.setIgnored(MelodicAlloy);
                ingot.setIgnored(StellarAlloy);
                ingot.setIgnored(CrystallinePinkSlime);
                ingot.setIgnored(EnergeticSilver);
                ingot.setIgnored(VividAlloy);

                block.setIgnored(CrudeSteel);
                block.setIgnored(CrystallineAlloy);
                block.setIgnored(MelodicAlloy);
                block.setIgnored(StellarAlloy);
                block.setIgnored(CrystallinePinkSlime);
                block.setIgnored(EnergeticSilver);
                block.setIgnored(VividAlloy);
            }
        }

        // Thaumcraft
        if (Thaumcraft.isModLoaded()) {
            MetaItems.addOrePrefix(cluster);
        }

        // Astra Sorcery
        if (AstralSorcery.isModLoaded()) {
            MetaItems.addOrePrefix(fragment);
        }

        // Blood Magic
        if (BloodMagic.isModLoaded()) {
            MetaItems.addOrePrefix(murky);
        }

        MetaItems.addOrePrefix(raw);
        MetaItems.addOrePrefix(rodFuelSingle);
        MetaItems.addOrePrefix(rodFuelDual);
        MetaItems.addOrePrefix(rodFuelQuad);
        MetaItems.addOrePrefix(rodDepletedSingle);
        MetaItems.addOrePrefix(rodDepletedDual);
        MetaItems.addOrePrefix(rodDepletedQuad);
    }
}
