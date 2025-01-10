package org.gthhcore.api.unification.ore;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconType;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.common.items.MetaItems;
import org.gthhcore.api.unification.material.info.GTHHMaterialIconType;

import java.util.function.Predicate;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.Conditions.hasBlastProperty;
import static gregtech.api.unification.ore.OrePrefix.Flags.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static org.gthhcore.api.unification.material.info.GTHHMaterialFlags.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;
import static org.gthhcore.api.util.GTHHMods.*;

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

    public static void init() {

            ingotHot.setGenerationCondition(hasBlastProperty.and(material -> material.getProperty(PropertyKey.BLAST).getBlastTemperature() > 1750).or(material -> material.hasFlag(GENERATE_HOT)));

            oreMoon.addSecondaryMaterial(new MaterialStack(MoonStone, OrePrefix.dust.getMaterialAmount(MoonStone)));
            oreMars.addSecondaryMaterial(new MaterialStack(MarsStone, OrePrefix.dust.getMaterialAmount(MarsStone)));
            oreAsteroid.addSecondaryMaterial(new MaterialStack(AsteroidStone, OrePrefix.dust.getMaterialAmount(AsteroidStone)));
            oreVenus.addSecondaryMaterial(new MaterialStack(VenusStone, OrePrefix.dust.getMaterialAmount(VenusStone)));
            oreMercury.addSecondaryMaterial(new MaterialStack(MercuryStone, OrePrefix.dust.getMaterialAmount(MercuryStone)));
            oreCeres.addSecondaryMaterial(new MaterialStack(CeresStone, OrePrefix.dust.getMaterialAmount(CeresStone)));
            oreJupiter.addSecondaryMaterial(new MaterialStack(JupiterStone, OrePrefix.dust.getMaterialAmount(JupiterStone)));
            oreSaturn.addSecondaryMaterial(new MaterialStack(SaturnStone, OrePrefix.dust.getMaterialAmount(SaturnStone)));
            oreUranus.addSecondaryMaterial(new MaterialStack(UranusStone, OrePrefix.dust.getMaterialAmount(UranusStone)));
            oreNeptune.addSecondaryMaterial(new MaterialStack(NeptuneStone, OrePrefix.dust.getMaterialAmount(NeptuneStone)));
            orePluto.addSecondaryMaterial(new MaterialStack(PlutoStone, OrePrefix.dust.getMaterialAmount(PlutoStone)));
            oreEris.addSecondaryMaterial(new MaterialStack(ErisStone, OrePrefix.dust.getMaterialAmount(ErisStone)));
            oreKepler22B.addSecondaryMaterial(new MaterialStack(Kepler22bStone, OrePrefix.dust.getMaterialAmount(Kepler22bStone)));
            oreEuropa.addSecondaryMaterial(new MaterialStack(EuropaStone, OrePrefix.dust.getMaterialAmount(EuropaStone)));
            oreIo.addSecondaryMaterial(new MaterialStack(IoStone, OrePrefix.dust.getMaterialAmount(IoStone)));
            oreDeimos.addSecondaryMaterial(new MaterialStack(DeimosStone, OrePrefix.dust.getMaterialAmount(DeimosStone)));
            orePhobos.addSecondaryMaterial(new MaterialStack(PhobosStone, OrePrefix.dust.getMaterialAmount(PhobosStone)));
            oreTriton.addSecondaryMaterial(new MaterialStack(TritonStone, OrePrefix.dust.getMaterialAmount(TritonStone)));
            oreCallisto.addSecondaryMaterial(new MaterialStack(CallistoStone, OrePrefix.dust.getMaterialAmount(CallistoStone)));
            oreGanymede.addSecondaryMaterial(new MaterialStack(GanymedeStone, OrePrefix.dust.getMaterialAmount(GanymedeStone)));
            oreRhea.addSecondaryMaterial(new MaterialStack(RheaStone, OrePrefix.dust.getMaterialAmount(RheaStone)));
            oreTitan.addSecondaryMaterial(new MaterialStack(TitanStone, OrePrefix.dust.getMaterialAmount(TitanStone)));
            oreOberon.addSecondaryMaterial(new MaterialStack(OberonStone, OrePrefix.dust.getMaterialAmount(OberonStone)));
            oreTitania.addSecondaryMaterial(new MaterialStack(TitaniaStone, OrePrefix.dust.getMaterialAmount(TitaniaStone)));
            oreIapetus.addSecondaryMaterial(new MaterialStack(IapetusStone, OrePrefix.dust.getMaterialAmount(IapetusStone)));

        // Set Ignore Stuff
        cluster.setIgnored(Iron);
        cluster.setIgnored(Gold);
        cluster.setIgnored(Copper);
        cluster.setIgnored(Tin);
        cluster.setIgnored(Silver);
        cluster.setIgnored(Lead);
        cluster.setIgnored(Cinnabar);

        if (Ae2.isModLoaded()) {
            gem.setIgnored(CertusQuartz);
            gem.setIgnored(ChargedCertusQuartz);
            gem.setIgnored(Fluix);
            gem.setIgnored(FluixPearl);
            dust.setIgnored(CertusQuartz);
            dust.setIgnored(Fluix);
            dust.setIgnored(SkyStone);
            block.setIgnored(CertusQuartz);
            block.setIgnored(Fluix);
            block.setIgnored(Fluixilized);
            block.modifyMaterialAmount(CertusQuartz, 4);
            block.modifyMaterialAmount(Fluix, 4);
            block.modifyMaterialAmount(SkyStone, 1);
            block.modifyMaterialAmount(Fluixilized, 4);

        }


        gem.setIgnored(InfinityCatalyst);

        if (Thaumcraft.isModLoaded()) {
            MetaItems.addOrePrefix(cluster);
        }

        if (Botania.isModLoaded()) {
            MetaItems.addOrePrefix(glob);
        }

        if (AstralSorcery.isModLoaded()) {
            MetaItems.addOrePrefix(fragment);
        }

        if (BloodMagic.isModLoaded()) {
            MetaItems.addOrePrefix(murky);
        }

        MetaItems.addOrePrefix(raw);
    }
}
