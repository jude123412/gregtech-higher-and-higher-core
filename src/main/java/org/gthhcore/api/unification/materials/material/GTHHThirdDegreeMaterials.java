package org.gthhcore.api.unification.materials.material;

public class GTHHThirdDegreeMaterials {

    private static int startId = 11500;
    private static int endId = 11999;

    public static void register() {}

    private static int getMetaItemId() {
        if (startId < endId) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
