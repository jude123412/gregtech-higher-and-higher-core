package org.gthhcore.api.util;

import java.util.function.Function;

import net.minecraftforge.fml.common.Loader;

public enum GTHHMods {

    Thaumcraft(Names.THAUMCRAFT),
    Botania(Names.BOTANIA),
    AstralSorcery(Names.ASTRAL_SORCERY),
    BloodMagic(Names.BLOOD_MAGIC),
    Ae2(Names.APPLIED_ENERGISTICS_2),
    CrazyAe(Names.CRAZY_AE),
    LogisticsPipes(Names.LOGISTICS_PIPES),
    Avaritia(Names.AVARITIA),
    EternalSingularity(Names.ETERNAL_SINGULARITY),
    EnderIo(Names.ENDER_IO),
    EnderIoConduits(Names.ENDER_IO_CONDUITS),
    EnderIoEndergy(Names.ENDER_IO_ENDERGY),
    EnderIoMachines(Names.ENDER_IO_MACHINES),
    GalacticraftCore(Names.GALACTICRAFT_CORE),
    GalacticraftPlanets(Names.GALACTICRAFT_PLANETS),
    ExtraPlanets(Names.EXTRA_PLANETS);

    public static class Names {

        public static final String THAUMCRAFT = "thaumcraft";
        public static final String BOTANIA = "botania";
        public static final String ASTRAL_SORCERY = "astralsorcery";
        public static final String BLOOD_MAGIC = "bloodmagic";
        public static final String APPLIED_ENERGISTICS_2 = "appliedenergistics2";
        public static final String CRAZY_AE = "crazyae";
        public static final String LOGISTICS_PIPES = "logisticspipes";
        public static final String AVARITIA = "avaritia";
        public static final String ETERNAL_SINGULARITY = "eternalsingularity";
        public static final String ENDER_IO = "enderio";
        public static final String ENDER_IO_CONDUITS = "enderioconduits";
        public static final String ENDER_IO_ENDERGY = "enderioendergy";
        public static final String ENDER_IO_MACHINES = "enderiomachines";
        public static final String GALACTICRAFT_CORE = "galacticraftcore";
        public static final String GALACTICRAFT_PLANETS = "galacticraftplanets";
        public static final String EXTRA_PLANETS = "extraplanets";
    }

    private final String ID;
    private final Function<GTHHMods, Boolean> extraCheck;
    protected Boolean modLoaded;

    GTHHMods(String ID) {
        this.ID = ID;
        this.extraCheck = null;
    }

    GTHHMods(String ID, Function<GTHHMods, Boolean> extraCheck) {
        this.ID = ID;
        this.extraCheck = extraCheck;
    }

    public boolean isModLoaded() {
        if (this.modLoaded == null) {
            this.modLoaded = Loader.isModLoaded(this.ID);
            if (this.modLoaded) {
                if (this.extraCheck != null && !this.extraCheck.apply(this)) {
                    this.modLoaded = false;
                }
            }
        }
        return this.modLoaded;
    }
}
