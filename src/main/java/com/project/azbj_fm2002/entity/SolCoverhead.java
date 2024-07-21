package com.project.azbj_fm2002.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "sol_coverhead")
public class SolCoverhead {

    @Id
    @Column(name = "contract_id")
    private String contractId;

    @Column(name = "sum_assured")
    private Double sumAssured;

    @Column(name = "solution_name")
    private String solutionName;

    @Column(name = "product_definition")
    private String productDefinition;

    @Column(name = "pension_flag")
    private Integer pensionFlag;

    @Column(name = "booking_frequency")
    private String bookingFrequency;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "vesting_age")
    private Integer vestingAge;

    @Column(name = "benefit_term")
    private Integer benefitTerm;

    @Column(name = "premium_term")
    private Integer premiumTerm;

    @Column(name = "discount_type")
    private String discountType;

    // Getters and Setters

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public Double getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(Double sumAssured) {
        this.sumAssured = sumAssured;
    }

    public String getSolutionName() {
        return solutionName;
    }

    public void setSolutionName(String solutionName) {
        this.solutionName = solutionName;
    }

    public String getProductDefinition() {
        return productDefinition;
    }

    public void setProductDefinition(String productDefinition) {
        this.productDefinition = productDefinition;
    }

    public Integer getPensionFlag() {
        return pensionFlag;
    }

    public void setPensionFlag(Integer pensionFlag) {
        this.pensionFlag = pensionFlag;
    }

    public String getBookingFrequency() {
        return bookingFrequency;
    }

    public void setBookingFrequency(String bookingFrequency) {
        this.bookingFrequency = bookingFrequency;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getVestingAge() {
        return vestingAge;
    }

    public void setVestingAge(Integer vestingAge) {
        this.vestingAge = vestingAge;
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

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }
}
