package com.azbj.fm2002.util;

public class ThirdPartyChequeUtil {

    // Utility method to validate payment mode
    public static boolean validatePaymentMode(String paymentMode) {
        return paymentMode != null && !paymentMode.trim().isEmpty();
    }

    // Utility method to validate question length
    public static boolean validateQuestionLength(String question) {
        return question != null && question.length() <= 1000;
    }

    // Utility method to validate confidence percentage
    public static boolean validateConfidencePercentage(int confidencePercentage) {
        return confidencePercentage >= 0 && confidencePercentage <= 100;
    }

    // Utility method to get predefined confidence percentages
    public static int[] getPredefinedConfidencePercentages() {
        int[] percentages = new int[20];
        for (int i = 0; i < 20; i++) {
            percentages[i] = (i + 1) * 5;
        }
        return percentages;
    }
}
