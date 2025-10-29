package org.gthhcore.loaders.recipe.mod.gregtech;

import org.gthhcore.loaders.recipe.handlers.GTHHRecipeHandlerList;
import org.gthhcore.loaders.recipe.mod.GTHHModRecipeLoader;

public class GTHHRecipeManager {

    private GTHHRecipeManager() {}

    public static void preLoad() {
        GTHHMachineRecipeLoader.registerEarly();
        GTHHModRecipeLoader.registerEarly();
        GTHHRecipeHandlerList.registerEarly();
    }

    public static void load() {
        GTHHRecipeHandlerList.register();
        GTHHModRecipeLoader.register();
        GTHHMetaTileEntityLoader.register();
    }
}
