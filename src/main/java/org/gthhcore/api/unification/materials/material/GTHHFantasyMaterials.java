package org.gthhcore.api.unification.materials.material;

public class GTHHFantasyMaterials {

    private static int startId = 2000;
    private static int endId = 2999;

    public static void register() {}

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
