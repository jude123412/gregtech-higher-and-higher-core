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
    public static final OrePrefix orePluto = new OrePrefix("orePluto", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreHaumea = new OrePrefix("oreHaumea", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix orePhobos = new OrePrefix("orePhobos", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreIo = new OrePrefix("oreIo", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreEuropa = new OrePrefix("oreEuropa", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreGanymede = new OrePrefix("oreGanymede", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreCallisto = new OrePrefix("oreCallisto", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreEnceladus = new OrePrefix("oreEnceladus", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreTitan = new OrePrefix("oreTitan", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreMiranda = new OrePrefix("oreMiranda", -1, null,
            MaterialIconType.ore,
            OrePrefix.Flags.ENABLE_UNIFICATION,
            OrePrefix.Conditions.hasOreProperty);
    public static final OrePrefix oreTriton = new OrePrefix("oreTriton", -1, null,
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

    public static final OrePrefix compressed = new OrePrefix("compressed", -1, null,
            GTHHMaterialIconType.compressed,
            ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_COMPRESSED));

    public static void init() {
        // Galacticraft Stone Types
        if (GalacticraftCore.isModLoaded() || GalacticraftPlanets.isModLoaded()) {
            oreMoon.addSecondaryMaterial(new MaterialStack(MoonStone, OrePrefix.dust.getMaterialAmount(MoonStone)));
            oreMars.addSecondaryMaterial(new MaterialStack(MarsStone, OrePrefix.dust.getMaterialAmount(MarsStone)));
            oreAsteroid.addSecondaryMaterial(
                    new MaterialStack(AsteroidStone, OrePrefix.dust.getMaterialAmount(AsteroidStone)));
            oreVenus.addSecondaryMaterial(new MaterialStack(VenusStone, OrePrefix.dust.getMaterialAmount(VenusStone)));
        }
        // Galaxy Space Stone Types
        if (GalaxySpace.isModLoaded()) {
            oreMercury.addSecondaryMaterial(
                    new MaterialStack(MercuryStone, OrePrefix.dust.getMaterialAmount(MercuryStone)));
            oreCeres.addSecondaryMaterial(new MaterialStack(CeresStone, OrePrefix.dust.getMaterialAmount(CeresStone)));
            orePluto.addSecondaryMaterial(new MaterialStack(PlutoStone, OrePrefix.dust.getMaterialAmount(PlutoStone)));
            oreHaumea.addSecondaryMaterial(
                    new MaterialStack(HaumeaStone, OrePrefix.dust.getMaterialAmount(HaumeaStone)));
            orePhobos.addSecondaryMaterial(
                    new MaterialStack(PhobosStone, OrePrefix.dust.getMaterialAmount(PhobosStone)));
            oreIo.addSecondaryMaterial(new MaterialStack(IoStone, OrePrefix.dust.getMaterialAmount(IoStone)));
            oreEuropa.addSecondaryMaterial(
                    new MaterialStack(EuropaStone, OrePrefix.dust.getMaterialAmount(EuropaStone)));
            oreGanymede.addSecondaryMaterial(
                    new MaterialStack(GanymedeStone, OrePrefix.dust.getMaterialAmount(GanymedeStone)));
            oreCallisto.addSecondaryMaterial(
                    new MaterialStack(CallistoStone, OrePrefix.dust.getMaterialAmount(CallistoStone)));
            oreEnceladus.addSecondaryMaterial(
                    new MaterialStack(EnceladusStone, OrePrefix.dust.getMaterialAmount(EnceladusStone)));
            oreTitan.addSecondaryMaterial(new MaterialStack(TitanStone, OrePrefix.dust.getMaterialAmount(TitanStone)));
            oreMiranda.addSecondaryMaterial(
                    new MaterialStack(MirandaStone, OrePrefix.dust.getMaterialAmount(MirandaStone)));
            oreTriton.addSecondaryMaterial(
                    new MaterialStack(TritonStone, OrePrefix.dust.getMaterialAmount(TritonStone)));
        }

        // Set Ignore Stuff
        cluster.setIgnored(Iron);
        cluster.setIgnored(Gold);
        cluster.setIgnored(Copper);
        cluster.setIgnored(Tin);
        cluster.setIgnored(Silver);
        cluster.setIgnored(Lead);
        cluster.setIgnored(Cinnabar);

        MetaItems.addOrePrefix(raw);
        MetaItems.addOrePrefix(compressed);
    }
}
