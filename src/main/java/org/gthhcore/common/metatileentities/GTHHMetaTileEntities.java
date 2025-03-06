package org.gthhcore.common.metatileentities;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static org.gthhcore.api.util.GTHHUtility.gthhId;

import org.gthhcore.common.metatileentities.multi.nuclear.MetaTileEntityFissionReactor;

public class GTHHMetaTileEntities {

    public static MetaTileEntityFissionReactor FISSION_REACTOR;

    public static void init() {
        FISSION_REACTOR = registerMetaTileEntity(0, new MetaTileEntityFissionReactor(gthhId("fission_reactor")));
    }
}
