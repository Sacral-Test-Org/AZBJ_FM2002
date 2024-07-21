package com.azbj.fm2002.dto;

public class SpouseFinancialDetailsDTO {
    private String proofType;
    private double grossIncome;
    private double exemptedIncome;
    private double oneTimeIncome;
    private double deductions;
    private double tax;
    private double totalIncome;
    private double netIncome;

    // Getters and Setters
    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getExemptedIncome() {
        return exemptedIncome;
    }

    public void setExemptedIncome(double exemptedIncome) {
        this.exemptedIncome = exemptedIncome;
    }

    public double getOneTimeIncome() {
        return oneTimeIncome;
    }

    public void setOneTimeIncome(double oneTimeIncome) {
        this.oneTimeIncome = oneTimeIncome;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(double netIncome) {
        this.netIncome = netIncome;
    }
}