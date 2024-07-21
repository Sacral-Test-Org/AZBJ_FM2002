package com.project.azbj_fm2002.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "azbj_financial_uw")
public class FinancialUnderwriting {

    @Id
    @Column(name = "CONTRACT_ID")
    private String contractId;

    @Column(name = "POLICY_REF")
    private String policyRef;

    @Column(name = "IP_NO")
    private int premiumPayer;

    @Column(name = "YRS")
    private int years;

    @Column(name = "ITRS")
    private String itrs;

    @Column(name = "COMPUTATION")
    private String computation;

    @Column(name = "GROSS_INCOME")
    private double grossIncome;

    @Column(name = "NET_PROFIT")
    private double netProfit;

    @Column(name = "EXEMPTED_INCOME")
    private double exemptedIncome;

    @Column(name = "ONETIME_INCOME")
    private double oneTimeIncome;

    @Column(name = "TOTAL_INCOME")
    private double totalIncome;

    @Column(name = "DEDUCTION")
    private double deduction;

    @Column(name = "TAX")
    private double tax;

    @Column(name = "PROOF_TYPE")
    private String proofType;

    // Getters and Setters

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getPolicyRef() {
        return policyRef;
    }

    public void setPolicyRef(String policyRef) {
        this.policyRef = policyRef;
    }

    public int getPremiumPayer() {
        return premiumPayer;
    }

    public void setPremiumPayer(int premiumPayer) {
        this.premiumPayer = premiumPayer;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getItrs() {
        return itrs;
    }

    public void setItrs(String itrs) {
        this.itrs = itrs;
    }

    public String getComputation() {
        return computation;
    }

    public void setComputation(String computation) {
        this.computation = computation;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
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

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }
}