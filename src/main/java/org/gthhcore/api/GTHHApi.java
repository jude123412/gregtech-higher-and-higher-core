package org.gthhcore.api;

import org.gthhcore.Tags;
import org.gthhcore.common.items.GTHHMetaItems;

import gregtech.api.util.BaseCreativeTab;

public class GTHHApi {

    public static final BaseCreativeTab TAB_GTHH_GCEP = new BaseCreativeTab(Tags.MODID + ".galacticraft",
            () -> GTHHMetaItems.INGOT_HEAVY_DUTY_T5.getStackForm(), false);
}
