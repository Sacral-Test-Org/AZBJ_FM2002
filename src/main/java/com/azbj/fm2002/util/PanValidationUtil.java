package com.azbj.fm2002.util;

public class PanValidationUtil {

    /**
     * Validates the PAN card number format.
     * @param panCard the PAN card number as a string
     * @return true if the PAN card number is valid, false otherwise
     */
    public static boolean validatePanCardFormat(String panCard) {
        if (panCard == null || panCard.isEmpty()) {
            return false; // PAN card number is not entered
        }
        if (panCard.length() != 10) {
            return false; // PAN card number is not exactly 10 characters long
        }
        String regex = "^[A-Z]{3}[C,P,H,F,A,T,B,L,J,G][A-Z][0-9]{4}[A-Z]$";
        return panCard.matches(regex); // Check if PAN card number follows the correct format
    }
}
