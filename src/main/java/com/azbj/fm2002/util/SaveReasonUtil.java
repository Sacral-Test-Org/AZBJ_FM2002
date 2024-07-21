package com.azbj.fm2002.util;

import com.azbj.fm2002.exception.SaveReasonException;

public class SaveReasonUtil {

    /**
     * Validates the reason for exiting a specific process.
     *
     * @param reason the reason to validate
     * @throws SaveReasonException if the reason is null or empty
     */
    public static void validateReason(String reason) throws SaveReasonException {
        if (reason == null || reason.trim().isEmpty()) {
            throw new SaveReasonException("Please enter reason for Save & Exit and proceed.");
        }
    }
}
