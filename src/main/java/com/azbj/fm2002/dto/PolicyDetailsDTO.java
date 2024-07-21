package com.azbj.fm2002.dto;

import java.math.BigDecimal;

public class PolicyDetailsDTO {
    private String partnerId;
    private String policyReference;
    private String partnerName;
    private BigDecimal annualPremium;
    private String policyStatus;
    private String coverCode;
    private BigDecimal sumInsuredForWholeCover;
    private Integer entryAge;
    private Integer premiumTerm;
    private Integer benefitTerm;
    private BigDecimal interestRate;
    private BigDecimal frequencyStandardPremium;
    private BigDecimal extraAmount;
    private BigDecimal mlPercentage;
    private BigDecimal ocPercentage;
    private BigDecimal nriPercentage;
    private BigDecimal srPercentage;
    private BigDecimal premiumDiscountAmount;

    // Getters and Setters
    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPolicyReference() {
        return policyReference;
    }

    public void setPolicyReference(String policyReference) {
        this.policyReference = policyReference;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public BigDecimal getAnnualPremium() {
        return annualPremium;
    }

    public void setAnnualPremium(BigDecimal annualPremium) {
        this.annualPremium = annualPremium;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getCoverCode() {
        return coverCode;
    }

    public void setCoverCode(String coverCode) {
        this.coverCode = coverCode;
    }

    public BigDecimal getSumInsuredForWholeCover() {
        return sumInsuredForWholeCover;
    }

    public void setSumInsuredForWholeCover(BigDecimal sumInsuredForWholeCover) {
        this.sumInsuredForWholeCover = sumInsuredForWholeCover;
    }

    public Integer getEntryAge() {
        return entryAge;
    }

    public void setEntryAge(Integer entryAge) {
        this.entryAge = entryAge;
    }

    public Integer getPremiumTerm() {
        return premiumTerm;
    }

    public void setPremiumTerm(Integer premiumTerm) {
        this.premiumTerm = premiumTerm;
    }

    public Integer getBenefitTerm() {
        return benefitTerm;
    }

    public void setBenefitTerm(Integer benefitTerm) {
        this.benefitTerm = benefitTerm;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getFrequencyStandardPremium() {
        return frequencyStandardPremium;
    }

    public void setFrequencyStandardPremium(BigDecimal frequencyStandardPremium) {
        this.frequencyStandardPremium = frequencyStandardPremium;
    }

    public BigDecimal getExtraAmount() {
        return extraAmount;
    }

    public void setExtraAmount(BigDecimal extraAmount) {
        this.extraAmount = extraAmount;
    }

    public BigDecimal getMlPercentage() {
        return mlPercentage;
    }

    public void setMlPercentage(BigDecimal mlPercentage) {
        this.mlPercentage = mlPercentage;
    }

    public BigDecimal getOcPercentage() {
        return ocPercentage;
    }

    public void setOcPercentage(BigDecimal ocPercentage) {
        this.ocPercentage = ocPercentage;
    }

    public BigDecimal getNriPercentage() {
        return nriPercentage;
    }

    public void setNriPercentage(BigDecimal nriPercentage) {
        this.nriPercentage = nriPercentage;
    }

    public BigDecimal getSrPercentage() {
        return srPercentage;
    }

    public void setSrPercentage(BigDecimal srPercentage) {
        this.srPercentage = srPercentage;
    }

    public BigDecimal getPremiumDiscountAmount() {
        return premiumDiscountAmount;
    }

    public void setPremiumDiscountAmount(BigDecimal premiumDiscountAmount) {
        this.premiumDiscountAmount = premiumDiscountAmount;
    }
}