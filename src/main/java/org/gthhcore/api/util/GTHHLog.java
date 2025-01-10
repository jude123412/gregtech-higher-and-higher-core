package org.gthhcore.api.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gthhcore.Tags;
import org.jetbrains.annotations.NotNull;

public class GTHHLog {

    public static Logger logger = LogManager.getLogger(Tags.MODNAME);

    private GTHHLog() {}

    public static void init(@NotNull Logger modLogger) {
        logger = modLogger;
    }
}
