package com.azbj.fm2002.util;

import org.apache.log4j.Logger;

public class SaveOnlyUtil {
    private static final Logger logger = Logger.getLogger(SaveOnlyUtil.class);

    public static void logUserAction(String action, String description) {
        logger.info("User action: " + action + ", Description: " + description);
    }
}
