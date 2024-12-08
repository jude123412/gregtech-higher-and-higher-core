package org.gthhcore.api.unification.ore;

import com.google.common.base.Preconditions;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconType;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.IOreRegistrationHandler;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.common.ConfigHolder;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import net.minecraft.client.resources.I18n;
import org.jetbrains.annotations.Nullable;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static org.gthhcore.api.unification.ore.GTHHOrePrefix.Conditions.*;
import static org.gthhcore.api.unification.ore.GTHHOrePrefix.Flags.*;

public class GTHHOrePrefix {

    private final static Map<String, GTHHOrePrefix> PREFIXES = new HashMap<>();
    private final static AtomicInteger idCounter = new AtomicInteger(0);

    public static final GTHHOrePrefix ore = new GTHHOrePrefix("ore", -1, null, MaterialIconType.ore, ENABLE_UNIFICATION,
            hasOreProperty);
    public static final GTHHOrePrefix oreGranite = new GTHHOrePrefix("oreGranite", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, hasOreProperty);
    public static final GTHHOrePrefix oreDiorite = new GTHHOrePrefix("oreDiorite", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, hasOreProperty);
    public static final GTHHOrePrefix oreAndesite = new GTHHOrePrefix("oreAndesite", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, hasOreProperty);
    public static final GTHHOrePrefix oreBlackgranite = new GTHHOrePrefix("oreBlackgranite", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, hasOreProperty);
    public static final GTHHOrePrefix oreRedgranite = new GTHHOrePrefix("oreRedgranite", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, hasOreProperty);
    public static final GTHHOrePrefix oreMarble = new GTHHOrePrefix("oreMarble", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, hasOreProperty);
    public static final GTHHOrePrefix oreBasalt = new GTHHOrePrefix("oreBasalt", -1, null, MaterialIconType.ore,
            ENABLE_UNIFICATION, hasOreProperty);

    public static final GTHHOrePrefix crushedCentrifuged = new GTHHOrePrefix("crushedCentrifuged", -1, null,
            MaterialIconType.crushedCentrifuged, ENABLE_UNIFICATION, hasOreProperty);
    public static final GTHHOrePrefix crushedPurified = new GTHHOrePrefix("crushedPurified", -1, null,
            MaterialIconType.crushedPurified, ENABLE_UNIFICATION, hasOreProperty);
    public static final GTHHOrePrefix crushed = new GTHHOrePrefix("crushed", -1, null, MaterialIconType.crushed,
            ENABLE_UNIFICATION, hasOreProperty,
            mat -> Collections.singletonList(I18n.format("metaitem.crushed.tooltip.purify")));

    // A hot Ingot, which has to be cooled down by a Vacuum Freezer.
    public static final GTHHOrePrefix ingotHot = new GTHHOrePrefix("ingotHot", M, null, MaterialIconType.ingotHot,
            ENABLE_UNIFICATION,
            hasBlastProperty.and(mat -> mat.getProperty(PropertyKey.BLAST).getBlastTemperature() > 1750));
    // A regular Ingot. Introduced by Eloraam
    public static final GTHHOrePrefix ingot = new GTHHOrePrefix("ingot", M, null, MaterialIconType.ingot, ENABLE_UNIFICATION,
            hasIngotProperty);

    // A regular Gem worth one Dust. Introduced by Eloraam
    public static final GTHHOrePrefix gem = new GTHHOrePrefix("gem", M, null, MaterialIconType.gem, ENABLE_UNIFICATION,
            hasGemProperty);
    // A regular Gem worth one small Dust. Introduced by TerraFirmaCraft
    public static final GTHHOrePrefix gemChipped = new GTHHOrePrefix("gemChipped", M / 4, null, MaterialIconType.gemChipped,
            ENABLE_UNIFICATION, hasGemProperty.and(unused -> ConfigHolder.recipes.generateLowQualityGems));
    // A regular Gem worth two small Dusts. Introduced by TerraFirmaCraft
    public static final GTHHOrePrefix gemFlawed = new GTHHOrePrefix("gemFlawed", M / 2, null, MaterialIconType.gemFlawed,
            ENABLE_UNIFICATION, hasGemProperty.and(unused -> ConfigHolder.recipes.generateLowQualityGems));
    // A regular Gem worth two Dusts. Introduced by TerraFirmaCraft
    public static final GTHHOrePrefix gemFlawless = new GTHHOrePrefix("gemFlawless", M * 2, null, MaterialIconType.gemFlawless,
            ENABLE_UNIFICATION, hasGemProperty);
    // A regular Gem worth four Dusts. Introduced by TerraFirmaCraft
    public static final GTHHOrePrefix gemExquisite = new GTHHOrePrefix("gemExquisite", M * 4, null,
            MaterialIconType.gemExquisite, ENABLE_UNIFICATION, hasGemProperty);

    // 1/4th of a Dust.
    public static final GTHHOrePrefix dustSmall = new GTHHOrePrefix("dustSmall", M / 4, null, MaterialIconType.dustSmall,
            ENABLE_UNIFICATION, hasDustProperty);
    // 1/9th of a Dust.
    public static final GTHHOrePrefix dustTiny = new GTHHOrePrefix("dustTiny", M / 9, null, MaterialIconType.dustTiny,
            ENABLE_UNIFICATION, hasDustProperty);
    // Dust with impurities. 1 Unit of Main Material and 1/9 - 1/4 Unit of secondary Material
    public static final GTHHOrePrefix dustImpure = new GTHHOrePrefix("dustImpure", M, null, MaterialIconType.dustImpure,
            ENABLE_UNIFICATION, hasOreProperty,
            mat -> Collections.singletonList(I18n.format("metaitem.dust.tooltip.purify")));
    // Pure Dust worth of one Ingot or Gem. Introduced by Alblaka.
    public static final GTHHOrePrefix dustPure = new GTHHOrePrefix("dustPure", M, null, MaterialIconType.dustPure,
            ENABLE_UNIFICATION, hasOreProperty,
            mat -> Collections.singletonList(I18n.format("metaitem.dust.tooltip.purify")));
    public static final GTHHOrePrefix dust = new GTHHOrePrefix("dust", M, null, MaterialIconType.dust, ENABLE_UNIFICATION,
            hasDustProperty);

    // A Nugget. Introduced by Eloraam
    public static final GTHHOrePrefix nugget = new GTHHOrePrefix("nugget", M / 9, null, MaterialIconType.nugget,
            ENABLE_UNIFICATION, hasIngotProperty);

    // 9 Plates combined in one Item.
    public static final GTHHOrePrefix plateDense = new GTHHOrePrefix("plateDense", M * 9, null, MaterialIconType.plateDense,
            ENABLE_UNIFICATION, mat -> mat.hasFlag(GENERATE_DENSE));
    // 2 Plates combined in one Item
    public static final GTHHOrePrefix plateDouble = new GTHHOrePrefix("plateDouble", M * 2, null, MaterialIconType.plateDouble,
            ENABLE_UNIFICATION, hasIngotProperty
            .and(mat -> mat.hasFlags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE) && !mat.hasFlag(NO_SMASHING)));
    // Regular Plate made of one Ingot/Dust. Introduced by Calclavia
    public static final GTHHOrePrefix plate = new GTHHOrePrefix("plate", M, null, MaterialIconType.plate, ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_PLATE));

    // Round made of 1 Nugget
    public static final GTHHOrePrefix round = new GTHHOrePrefix("round", M / 9, null, MaterialIconType.round,
            ENABLE_UNIFICATION, mat -> mat.hasFlag(GENERATE_ROUND));
    // Foil made of 1/4 Ingot/Dust.
    public static final GTHHOrePrefix foil = new GTHHOrePrefix("foil", M / 4, null, MaterialIconType.foil, ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_FOIL));

    // Stick made of an Ingot.
    public static final GTHHOrePrefix stickLong = new GTHHOrePrefix("stickLong", M, null, MaterialIconType.stickLong,
            ENABLE_UNIFICATION, mat -> mat.hasFlag(GENERATE_LONG_ROD));
    // Stick made of half an Ingot. Introduced by Eloraam
    public static final GTHHOrePrefix stick = new GTHHOrePrefix("stick", M / 2, null, MaterialIconType.stick,
            ENABLE_UNIFICATION, mat -> mat.hasFlag(GENERATE_ROD));

    // consisting out of 1/8 Ingot or 1/4 Stick.
    public static final GTHHOrePrefix bolt = new GTHHOrePrefix("bolt", M / 8, null, MaterialIconType.bolt, ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_BOLT_SCREW));
    // consisting out of 1/9 Ingot.
    public static final GTHHOrePrefix screw = new GTHHOrePrefix("screw", M / 9, null, MaterialIconType.screw,
            ENABLE_UNIFICATION, mat -> mat.hasFlag(GENERATE_BOLT_SCREW));
    // consisting out of 1/2 Stick.
    public static final GTHHOrePrefix ring = new GTHHOrePrefix("ring", M / 4, null, MaterialIconType.ring, ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_RING));
    // consisting out of 1 Fine Wire.
    public static final GTHHOrePrefix springSmall = new GTHHOrePrefix("springSmall", M / 4, null, MaterialIconType.springSmall,
            ENABLE_UNIFICATION, mat -> mat.hasFlag(GENERATE_SPRING_SMALL) && !mat.hasFlag(NO_SMASHING));
    // consisting out of 2 Sticks.
    public static final GTHHOrePrefix spring = new GTHHOrePrefix("spring", M, null, MaterialIconType.spring, ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_SPRING) && !mat.hasFlag(NO_SMASHING));
    // consisting out of 1/8 Ingot or 1/4 Wire.
    public static final GTHHOrePrefix wireFine = new GTHHOrePrefix("wireFine", M / 8, null, MaterialIconType.wireFine,
            ENABLE_UNIFICATION, mat -> mat.hasFlag(GENERATE_FINE_WIRE));
    // consisting out of 4 Plates, 1 Ring and 1 Screw.
    public static final GTHHOrePrefix rotor = new GTHHOrePrefix("rotor", M * 4, null, MaterialIconType.rotor,
            ENABLE_UNIFICATION, mat -> mat.hasFlag(GENERATE_ROTOR));
    public static final GTHHOrePrefix gearSmall = new GTHHOrePrefix("gearSmall", M, null, MaterialIconType.gearSmall,
            ENABLE_UNIFICATION, mat -> mat.hasFlag(GENERATE_SMALL_GEAR));
    // Introduced by me because BuildCraft has ruined the gear Prefix...
    public static final GTHHOrePrefix gear = new GTHHOrePrefix("gear", M * 4, null, MaterialIconType.gear, ENABLE_UNIFICATION,
            mat -> mat.hasFlag(GENERATE_GEAR));
    // 3/4 of a Plate or Gem used to shape a Lens. Normally only used on Transparent Materials.
    public static final GTHHOrePrefix lens = new GTHHOrePrefix("lens", (M * 3) / 4, null, MaterialIconType.lens,
            ENABLE_UNIFICATION, mat -> mat.hasFlag(GENERATE_LENS));

    // made of 4 Ingots.
    public static final GTHHOrePrefix toolHeadBuzzSaw = new GTHHOrePrefix("toolHeadBuzzSaw", M * 4, null,
            MaterialIconType.toolHeadBuzzSaw, ENABLE_UNIFICATION,
            hasNoCraftingToolProperty.and(mat -> mat.hasFlag(GENERATE_PLATE)));
    // made of 1 Ingots.
    public static final GTHHOrePrefix toolHeadScrewdriver = new GTHHOrePrefix("toolHeadScrewdriver", M, null,
            MaterialIconType.toolHeadScrewdriver, ENABLE_UNIFICATION,
            hasNoCraftingToolProperty.and(mat -> mat.hasFlag(GENERATE_LONG_ROD)));
    // made of 4 Ingots.
    public static final GTHHOrePrefix toolHeadDrill = new GTHHOrePrefix("toolHeadDrill", M * 4, null,
            MaterialIconType.toolHeadDrill, ENABLE_UNIFICATION,
            hasToolProperty.and(mat -> mat.hasFlag(GENERATE_PLATE)));
    // made of 2 Ingots.
    public static final GTHHOrePrefix toolHeadChainsaw = new GTHHOrePrefix("toolHeadChainsaw", M * 2, null,
            MaterialIconType.toolHeadChainsaw, ENABLE_UNIFICATION,
            hasNoCraftingToolProperty.and(mat -> mat.hasFlag(GENERATE_PLATE)));
    // made of 4 Ingots.
    public static final GTHHOrePrefix toolHeadWrench = new GTHHOrePrefix("toolHeadWrench", M * 4, null,
            MaterialIconType.toolHeadWrench, ENABLE_UNIFICATION,
            hasNoCraftingToolProperty.and(mat -> mat.hasFlag(GENERATE_PLATE)));
    // made of 5 Ingots.
    public static final GTHHOrePrefix turbineBlade = new GTHHOrePrefix("turbineBlade", M * 10, null,
            MaterialIconType.turbineBlade, ENABLE_UNIFICATION, hasRotorProperty
            .and(m -> m.hasFlags(GENERATE_BOLT_SCREW, GENERATE_PLATE) && !m.hasProperty(PropertyKey.GEM)));

    public static class Flags {

        public static final long ENABLE_UNIFICATION = 1;
        public static final long SELF_REFERENCING = 1 << 1;
    }

    public static class Conditions {

        public static final Predicate<Material> hasToolProperty = mat -> mat.hasProperty(PropertyKey.TOOL);
        public static final Predicate<Material> hasNoCraftingToolProperty = hasToolProperty
                .and(mat -> !mat.getProperty(PropertyKey.TOOL).getShouldIgnoreCraftingTools());
        public static final Predicate<Material> hasOreProperty = mat -> mat.hasProperty(PropertyKey.ORE);
        public static final Predicate<Material> hasGemProperty = mat -> mat.hasProperty(PropertyKey.GEM);
        public static final Predicate<Material> hasDustProperty = mat -> mat.hasProperty(PropertyKey.DUST);
        public static final Predicate<Material> hasIngotProperty = mat -> mat.hasProperty(PropertyKey.INGOT);
        public static final Predicate<Material> hasBlastProperty = mat -> mat.hasProperty(PropertyKey.BLAST);
        public static final Predicate<Material> hasRotorProperty = mat -> mat.hasProperty(PropertyKey.ROTOR);
    }


    public final String name;
    public final int id;

    public final boolean isUnificationEnabled;
    public final boolean isSelfReferencing;

    private @Nullable Predicate<Material> generationCondition;
    public final @Nullable MaterialIconType materialIconType;

    private final long materialAmount;

    /**
     * Contains a default material type for self-referencing OrePrefix
     * For self-referencing prefixes, it is always guaranteed for it to be not null
     * <p>
     * NOTE: Ore registrations with self-referencing OrePrefix still can occur with other materials
     */

    public @Nullable Material materialType;

    private final List<IOreRegistrationHandler> oreProcessingHandlers = new ArrayList<>();
    private final Set<Material> ignoredMaterials = new HashSet<>();
    private final Set<Material> generatedMaterials = new HashSet<>();
    private final Object2FloatMap<Material> materialAmounts = new Object2FloatOpenHashMap<>();
    private boolean isMarkerPrefix = false;

    public byte maxStackSize = 64;
    public final List<MaterialStack> secondaryMaterials = new ArrayList<>();
    public Function<Integer, Float> heatDamageFunction = null; // Negative for Frost Damage
    public Function<Material, List<String>> tooltipFunc;


    public GTHHOrePrefix(String name, long materialAmount, @Nullable Material material,
                     @Nullable MaterialIconType materialIconType, long flags, @Nullable Predicate<Material> condition) {
        this(name, materialAmount, material, materialIconType, flags, condition, null);
    }

    public GTHHOrePrefix(String name, long materialAmount, @Nullable Material material,
                     @Nullable MaterialIconType materialIconType, long flags, @Nullable Predicate<Material> condition,
                     @Nullable Function<Material, List<String>> tooltipFunc) {
        Preconditions.checkArgument(!PREFIXES.containsKey(name), "OrePrefix " + name + " already registered!");
        this.name = name;
        this.id = idCounter.getAndIncrement();
        this.materialAmount = materialAmount;
        this.isSelfReferencing = (flags & SELF_REFERENCING) != 0;
        this.isUnificationEnabled = (flags & ENABLE_UNIFICATION) != 0;
        this.materialIconType = materialIconType;
        this.generationCondition = condition;
        this.tooltipFunc = tooltipFunc;
        if (isSelfReferencing) {
            Preconditions.checkNotNull(material, "Material is null for self-referencing OrePrefix");
            this.materialType = material;
        }
        PREFIXES.put(name, this);
    }

}
