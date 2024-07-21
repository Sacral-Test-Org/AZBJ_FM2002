package com.azbj.fm2002.dto;

public class SpouseNetProfitCalculationResponse {
    private double calculatedNetProfit;

    public SpouseNetProfitCalculationResponse(double calculatedNetProfit) {
        this.calculatedNetProfit = calculatedNetProfit;
    }

    public double getCalculatedNetProfit() {
        return calculatedNetProfit;
    }

    public void setCalculatedNetProfit(double calculatedNetProfit) {
        this.calculatedNetProfit = calculatedNetProfit;
    }
}
