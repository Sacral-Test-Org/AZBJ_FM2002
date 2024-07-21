package com.azbj.fm2002.util;

public class BbuImageDtlsUtil {

    /**
     * Validates the answer input.
     *
     * @param answer the answer to validate
     * @return true if the answer is valid ('Y' or 'N'), false otherwise
     */
    public static boolean validateAnswer(String answer) {
        if (answer == null) {
            return false;
        }
        return "Y".equalsIgnoreCase(answer) || "N".equalsIgnoreCase(answer);
    }
}
