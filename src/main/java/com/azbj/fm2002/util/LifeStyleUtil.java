package com.azbj.fm2002.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LifeStyleUtil {
    private static final Logger logger = LogManager.getLogger(LifeStyleUtil.class);

    public static void logChanges(String contractId, String verificationNumber, String primaryStatus, String secondaryStatus) {
        logger.info("Contract ID: {} | Verification Number: {} | Primary Status: {} | Secondary Status: {}", 
                    contractId, verificationNumber, primaryStatus, secondaryStatus);
    }
}
