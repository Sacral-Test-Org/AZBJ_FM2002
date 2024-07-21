package com.azbj.fm2002.util;

public class ReinsuranceCoverDetailsUtil {

    public static void validateSpecialRiskPercentage(String product, Double specialRiskPercentage) {
        if ("CAPITAL_SHIELD".equals(product) && specialRiskPercentage > 0) {
            throw new IllegalArgumentException("Product not allowed on extra Premium");
        }
    }
}
