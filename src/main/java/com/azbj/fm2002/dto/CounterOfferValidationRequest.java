package com.azbj.fm2002.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CounterOfferValidationRequest {
    private List<String> reasonCodes;
    private BeneficiaryDetails beneficiaryDetails;
    private String productId;
    private Date dateOfBirth;
    private List<String> telephoneNumbers;
    private List<String> counterOfferTypes;
    private List<String> coverCodes;
    private BigDecimal sumAssured;
    private Integer benefitTerm;
    private Integer premiumTerm;
    private BigDecimal premiumAmount;

    // Getters and Setters
    public List<String> getReasonCodes() {
        return reasonCodes;
    }

    public void setReasonCodes(List<String> reasonCodes) {
        this.reasonCodes = reasonCodes;
    }

    public BeneficiaryDetails getBeneficiaryDetails() {
        return beneficiaryDetails;
    }

    public void setBeneficiaryDetails(BeneficiaryDetails beneficiaryDetails) {
        this.beneficiaryDetails = beneficiaryDetails;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(List<String> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public List<String> getCounterOfferTypes() {
        return counterOfferTypes;
    }

    public void setCounterOfferTypes(List<String> counterOfferTypes) {
        this.counterOfferTypes = counterOfferTypes;
    }

    public List<String> getCoverCodes() {
        return coverCodes;
    }

    public void setCoverCodes(List<String> coverCodes) {
        this.coverCodes = coverCodes;
    }

    public BigDecimal getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(BigDecimal sumAssured) {
        this.sumAssured = sumAssured;
    }

    public Integer getBenefitTerm() {
        return benefitTerm;
    }

    public void setBenefitTerm(Integer benefitTerm) {
        this.benefitTerm = benefitTerm;
    }

    public Integer getPremiumTerm() {
        return premiumTerm;
    }

    public void setPremiumTerm(Integer premiumTerm) {
        this.premiumTerm = premiumTerm;
    }

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }
}
