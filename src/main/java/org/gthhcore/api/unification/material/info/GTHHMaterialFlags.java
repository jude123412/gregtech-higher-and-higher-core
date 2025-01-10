package org.gthhcore.api.unification.material.info;

import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.properties.PropertyKey;

public class GTHHMaterialFlags {

    public static final MaterialFlag GENERATE_RAW = new MaterialFlag.Builder("generate_raw")
            .requireProps(PropertyKey.DUST)
            .build();

    public static final MaterialFlag GENERATE_HOT = new MaterialFlag.Builder("generate_hot")
            .requireProps(PropertyKey.INGOT)
            .build();

}