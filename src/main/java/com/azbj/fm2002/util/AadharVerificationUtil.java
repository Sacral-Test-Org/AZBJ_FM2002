package com.azbj.fm2002.util;

import java.time.LocalDate;
import java.time.Period;

public class AadharVerificationUtil {

    // Method to calculate the entry age based on the date of birth
    public static int calculateEntryAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        if ((dateOfBirth != null) && (currentDate != null)) {
            return Period.between(dateOfBirth, currentDate).getYears();
        } else {
            return 0;
        }
    }

    // Method to validate the age proof
    public static boolean validateAgeProof(String ageProof) {
        // Assuming valid age proofs are "Passport", "Driving License", "Voter ID", "Aadhar Card"
        if (ageProof == null || ageProof.isEmpty()) {
            return false;
        }
        switch (ageProof) {
            case "Passport":
            case "Driving License":
            case "Voter ID":
            case "Aadhar Card":
                return true;
            default:
                return false;
        }
    }

    // Method to validate the Aadhaar number using predefined logic or an external service
    public static boolean validate(String aadhaarNumber) {
        // Assuming a simple length check for Aadhaar number validation
        if (aadhaarNumber == null || aadhaarNumber.length() != 12) {
            return false;
        }
        // Additional logic for external service validation can be added here
        return true;
    }
}
