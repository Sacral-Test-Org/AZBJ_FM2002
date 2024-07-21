package com.azbj.fm2002.util;

public class ReinsuranceCalculationUtil {

    public static double calculateReinsuranceAmount(double reinsurancePercentage, double coverAmount) {
        return (reinsurancePercentage / 100) * coverAmount;
    }
}
