package org.gthhcore.api.unification.materials.material;

import static gregtech.api.unification.material.Materials.*;
import static org.gthhcore.api.unification.material.info.GTHHMaterialFlags.*;
import static org.gthhcore.api.unification.materials.material.GTHHMaterials.*;

public class GTHHNuclearMaterials {

    private static int startId = 8000;
    private static int endId = 8999;

    public static void register() {}

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
