package com.azbj.fm2002.dto;

public class SpouseNetProfitCalculationRequest {
    private double spouseNetIncome;
    private double averageNetProfit;
    private int premiumPayer;

    public SpouseNetProfitCalculationRequest() {}

    public SpouseNetProfitCalculationRequest(double spouseNetIncome, double averageNetProfit, int premiumPayer) {
        this.spouseNetIncome = spouseNetIncome;
        this.averageNetProfit = averageNetProfit;
        this.premiumPayer = premiumPayer;
    }

    public double getSpouseNetIncome() {
        return spouseNetIncome;
    }

    public void setSpouseNetIncome(double spouseNetIncome) {
        this.spouseNetIncome = spouseNetIncome;
    }

    public double getAverageNetProfit() {
        return averageNetProfit;
    }

    public void setAverageNetProfit(double averageNetProfit) {
        this.averageNetProfit = averageNetProfit;
    }

    public int getPremiumPayer() {
        return premiumPayer;
    }

    public void setPremiumPayer(int premiumPayer) {
        this.premiumPayer = premiumPayer;
    }
}