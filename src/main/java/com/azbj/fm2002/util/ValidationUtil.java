package com.azbj.fm2002.util;

import java.time.LocalDate;
import java.time.Period;

public class ValidationUtil {

    public static int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        if (dateOfBirth != null) {
            return Period.between(dateOfBirth, currentDate).getYears();
        } else {
            throw new IllegalArgumentException("Date of birth cannot be null");
        }
    }

    public static boolean isLocationFlagSet(String mailingDistrict, String mailingState) {
        return "LEH".equalsIgnoreCase(mailingDistrict) && "JAMMU AND KASHMIR".equalsIgnoreCase(mailingState);
    }

    public static boolean isPanCardRequired(double totalPremium, double annualIncome, Thresholds thresholds) {
        return totalPremium > thresholds.getPremiumThreshold() || annualIncome > thresholds.getIncomeThreshold();
    }

    public static String validateDescription(String answer, int questionId, int subQuestionId, String description) {
        if (!"Y".equalsIgnoreCase(answer) && questionId != 85 && (subQuestionId == 68 || subQuestionId == 69) && description != null && !description.isEmpty()) {
            return "Answer to the question is N. Hence cannot enter description.";
        }
        return "Description is valid.";
    }
}

class Thresholds {
    private double premiumThreshold;
    private double incomeThreshold;

    public Thresholds(double premiumThreshold, double incomeThreshold) {
        this.premiumThreshold = premiumThreshold;
        this.incomeThreshold = incomeThreshold;
    }

    public double getPremiumThreshold() {
        return premiumThreshold;
    }

    public double getIncomeThreshold() {
        return incomeThreshold;
    }
}