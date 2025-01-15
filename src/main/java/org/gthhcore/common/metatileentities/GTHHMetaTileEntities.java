package org.gthhcore.common.metatileentities;

import org.gthhcore.api.util.GTHHValues;
import org.gthhcore.common.metatileentities.multi.nuclear.MetaTileEntityFissionReactor;

import static gregtech.api.GTValues.EV;
import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;
import static org.gthhcore.api.util.GTHHUtility.gthhId;

public class GTHHMetaTileEntities {

    public static MetaTileEntityFissionReactor FISSION_REACTOR;

    public static void init() {
        FISSION_REACTOR = registerMetaTileEntity(0, new MetaTileEntityFissionReactor(gthhId("fission_reactor")));
    }
}
