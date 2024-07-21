package com.azbj.fm2002.util;

public class PolicyMemberValidationUtil {

    // Method to validate weight
    public static boolean validateWeight(double weight) {
        if (weight > 0) {
            return true;
        } else {
            System.out.println("Please Select a Valid Weight for the person");
            return false;
        }
    }

    // Method to calculate BMI
    public static double calculateBMI(double weight, double height) {
        if (height > 0) {
            return weight / Math.pow(height / 100, 2);
        } else {
            throw new IllegalArgumentException("Height must be greater than zero");
        }
    }

    // Method to validate BMI
    public static boolean validateBMI(double bmi) {
        // Assuming some business logic for BMI validation
        // For example, a valid BMI might be between 18.5 and 24.9
        return bmi >= 18.5 && bmi <= 24.9;
    }
}
