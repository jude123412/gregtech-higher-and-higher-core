package org.gthhcore.api.util;

import java.util.Random;

public class GTHHValues {

    static Random random = new Random();
    /**
     * For Recipe Duration time Use S
     * <p/>
     * S Is for Seconds.
     */
    public static final int S = 20;

    /**
     * For Offset Recipe Duration time Use O and supply a time in seconds
     * <p/>
     * O Is for offset-Seconds. The offset is to make the recipe duration more random
     */
    public static final int O(int time) {
        return (int) Math.round(160 * Math.sqrt(time * S));
    }
}
