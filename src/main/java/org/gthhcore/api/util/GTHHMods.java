package org.gthhcore.api.util;

import net.minecraftforge.fml.common.Loader;

import java.util.function.Function;

public enum GTHHMods {
    Thaumcraft(Names.THAUMCRAFT),
    Botania(Names.BOTANIA),
    AstralSorcery(Names.ASTRAL_SORCERY),
    BloodMagic(Names.BLOOD_MAGIC),
    Ae2(Names.APPLIED_ENERGISTICS_2),
    CrazyAe(Names.CRAZY_AE),
    LogisticsPipes(Names.LOGISTICSPIPES);

    public static class Names {
        public static final String THAUMCRAFT = "thaumcraft";
        public static final String BOTANIA = "botania";
        public static final String ASTRAL_SORCERY = "astralsorcery";
        public static final String BLOOD_MAGIC = "bloodmagic";
        public static final String APPLIED_ENERGISTICS_2 = "appliedenergistics2";
        public static final String CRAZY_AE = "crazyae";
        public static final String LOGISTICSPIPES = "logisticspipes";
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
