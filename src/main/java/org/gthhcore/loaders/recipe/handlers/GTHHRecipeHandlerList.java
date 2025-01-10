package org.gthhcore.loaders.recipe.handlers;

import static org.gthhcore.api.util.GTHHMods.*;

public class GTHHRecipeHandlerList {

    public static void registerEarly() {
        GTHHOreRecipeHandler.register();
        GTHHMaterialRecipeHandler.register();
    }

    public static void register() {
        if (Thaumcraft.isModLoaded()) {
            GTHHThaumcraftRecipeHandler.register();
        }
        if (Botania.isModLoaded()) {
            GTHHBotaniaRecipeHandler.register();
        }
        if (AstralSorcery.isModLoaded()) {
            GTHHAstralSorceryRecipeHandler.register();
        }
        if (BloodMagic.isModLoaded()) {
            GTHHBloodMagicRecipeHandler.register();
        }
    }
}
