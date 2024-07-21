package com.azbj.fm2002.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SeniorUnderwriterUtil {
    private static final Logger logger = LogManager.getLogger(SeniorUnderwriterUtil.class);

    public static void handleException(Exception e) {
        logger.error("An error occurred while processing the Senior Underwriter data: ", e);
        throw new SeniorUnderwriterException("Failed to process Senior Underwriter data", e);
    }
}

class SeniorUnderwriterException extends RuntimeException {
    public SeniorUnderwriterException(String message, Throwable cause) {
        super(message, cause);
    }
}