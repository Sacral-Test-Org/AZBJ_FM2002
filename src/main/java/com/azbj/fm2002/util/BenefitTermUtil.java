package com.azbj.fm2002.util;

public class BenefitTermUtil {

    // Method to calculate the premium term as two-thirds of the benefit term, truncated to an integer
    public static int calculatePremiumTerm(int benefitTerm) {
        return (int) Math.floor(benefitTerm * 2.0 / 3.0);
    }

    // Method to calculate the benefit term based on the age
    public static int calculateBenefitTerm(int age) {
        return 100 - age;
    }
}
