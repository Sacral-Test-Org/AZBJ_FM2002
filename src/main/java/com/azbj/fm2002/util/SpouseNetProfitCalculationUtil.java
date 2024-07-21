package com.azbj.fm2002.util;

public class SpouseNetProfitCalculationUtil {

    /**
     * Calculates the spouse's net profit by subtracting the spouse's net income from the average net profit.
     *
     * @param spouseNetIncome the net income of the spouse
     * @param averageNetProfit the average net profit
     * @return the calculated net profit of the spouse
     */
    public static double calculateNetProfit(double spouseNetIncome, double averageNetProfit) {
        return averageNetProfit - spouseNetIncome;
    }
}
