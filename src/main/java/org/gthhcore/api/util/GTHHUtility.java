package org.gthhcore.api.util;

import gregtech.api.GTValues;
import net.minecraft.util.ResourceLocation;
import org.gthhcore.Tags;
import org.jetbrains.annotations.NotNull;

public class GTHHUtility {

    @NotNull
    public static ResourceLocation gthhId(@NotNull String path) {
        return new ResourceLocation(Tags.MODID, path);
    }

}
