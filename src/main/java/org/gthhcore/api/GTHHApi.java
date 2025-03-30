package org.gthhcore.api;

import gregtech.api.GTValues;
import gregtech.api.util.BaseCreativeTab;
import gregtech.common.items.MetaItems;
import org.gthhcore.Tags;
import org.gthhcore.api.util.GTHHValues;
import org.gthhcore.common.items.GTHHMetaItems;

public class GTHHApi {

    public static final BaseCreativeTab TAB_GTHH = new BaseCreativeTab(Tags.MODID + ".main",
            () -> GTHHMetaItems.INGOT_HEAVY_DUTY_T5.getStackForm(), false);
}
