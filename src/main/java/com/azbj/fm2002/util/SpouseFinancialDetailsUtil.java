package com.azbj.fm2002.util;

public class SpouseFinancialDetailsUtil {

    public static double calculateTotalIncome(double grossIncome, double exemptedIncome, double oneTimeIncome) {
        return grossIncome + exemptedIncome + oneTimeIncome;
    }

    public static double calculateNetIncome(double grossIncome, double exemptedIncome, double oneTimeIncome, double deductions, double tax) {
        double totalIncome = calculateTotalIncome(grossIncome, exemptedIncome, oneTimeIncome);
        return totalIncome - (deductions + tax);
    }
}
