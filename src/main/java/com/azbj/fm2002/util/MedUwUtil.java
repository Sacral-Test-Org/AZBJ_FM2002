package com.azbj.fm2002.util;

public class MedUwUtil {

    /**
     * Validates the test code format.
     * 
     * @param testCode the test code to validate
     * @return boolean indicating whether the test code is valid
     */
    public static boolean validateTestCode(String testCode) {
        // Assuming the test code should be alphanumeric and between 1 to 10 characters long
        if (testCode == null || testCode.isEmpty()) {
            return false;
        }
        return testCode.matches("^[a-zA-Z0-9]{1,10}$");
    }
}
