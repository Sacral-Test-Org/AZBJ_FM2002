package com.azbj.fm2002.util;

import java.util.Optional;

public class DoctorSignatureUtil {

    public static void setMessageLevel(int level) {
        // Logic to set the message level
        System.out.println("Message level set to: " + level);
    }

    public static void resetMessageLevel() {
        // Logic to reset the message level to default
        System.out.println("Message level reset to default");
    }

    public static Optional<String> validateDoctorCode(String doctorCode) {
        if (doctorCode == null || doctorCode.isEmpty()) {
            return Optional.of("Please enter the doctor code.");
        }
        return Optional.empty();
    }

    public static Optional<String> handleNoDataFound() {
        return Optional.of("Doctor code does not exist. Please check the code.");
    }

    public static Optional<String> handleError(Exception e) {
        return Optional.of("An error occurred: " + e.getMessage());
    }
}
