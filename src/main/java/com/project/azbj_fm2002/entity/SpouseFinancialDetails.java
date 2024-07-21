package com.project.azbj_fm2002.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "AZBJ_SPOUSE_FIN_UW_DETAILS")
public class SpouseFinancialDetails {

    @Id
    @Column(name = "CONTRACT_ID")
    private String contractId;

    @Column(name = "APPLICATION_NO")
    private String applicationNo;

    @Column(name = "PROPOSAL_NO")
    private String proposalNo;

    @Column(name = "SP_INC_PROOF_TYPE")
    private String spIncProofType;

    @Column(name = "SP_GROSS_INCOME")
    private Double spGrossIncome;

    @Column(name = "SP_EXEMPTED_INCOME")
    private Double spExemptedIncome;

    @Column(name = "SP_ONETIME_INCOME")
    private Double spOnetimeIncome;

    @Column(name = "SP_TOTAL_INCOME")
    private Double spTotalIncome;

    @Column(name = "SP_DEDUCTION")
    private Double spDeduction;

    @Column(name = "SP_TAX")
    private Double spTax;

    @Column(name = "SP_NET_INCOME")
    private Double spNetIncome;

    @Column(name = "SP_PL_PROOF_TYPE")
    private String spPlProofType;

    @Column(name = "SP_GROSS_PL")
    private Double spGrossPl;

    @Column(name = "SP_EXEMPTED_PL")
    private Double spExemptedPl;

    @Column(name = "SP_ONETIME_PL")
    private Double spOnetimePl;

    @Column(name = "SP_TOTAL_PL")
    private Double spTotalPl;

    @Column(name = "SP_DEDUCTION_PL")
    private Double spDeductionPl;

    @Column(name = "SP_TAX_PL")
    private Double spTaxPl;

    @Column(name = "SP_NET_PL")
    private Double spNetPl;

    @Column(name = "IP_NO")
    private String ipNo;

    // Getters and Setters

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getProposalNo() {
        return proposalNo;
    }

    public void setProposalNo(String proposalNo) {
        this.proposalNo = proposalNo;
    }

    public String getSpIncProofType() {
        return spIncProofType;
    }

    public void setSpIncProofType(String spIncProofType) {
        this.spIncProofType = spIncProofType;
    }

    public Double getSpGrossIncome() {
        return spGrossIncome;
    }

    public void setSpGrossIncome(Double spGrossIncome) {
        this.spGrossIncome = spGrossIncome;
    }

    public Double getSpExemptedIncome() {
        return spExemptedIncome;
    }

    public void setSpExemptedIncome(Double spExemptedIncome) {
        this.spExemptedIncome = spExemptedIncome;
    }

    public Double getSpOnetimeIncome() {
        return spOnetimeIncome;
    }

    public void setSpOnetimeIncome(Double spOnetimeIncome) {
        this.spOnetimeIncome = spOnetimeIncome;
    }

    public Double getSpTotalIncome() {
        return spTotalIncome;
    }

    public void setSpTotalIncome(Double spTotalIncome) {
        this.spTotalIncome = spTotalIncome;
    }

    public Double getSpDeduction() {
        return spDeduction;
    }

    public void setSpDeduction(Double spDeduction) {
        this.spDeduction = spDeduction;
    }

    public Double getSpTax() {
        return spTax;
    }

    public void setSpTax(Double spTax) {
        this.spTax = spTax;
    }

    public Double getSpNetIncome() {
        return spNetIncome;
    }

    public void setSpNetIncome(Double spNetIncome) {
        this.spNetIncome = spNetIncome;
    }

    public String getSpPlProofType() {
        return spPlProofType;
    }

    public void setSpPlProofType(String spPlProofType) {
        this.spPlProofType = spPlProofType;
    }

    public Double getSpGrossPl() {
        return spGrossPl;
    }

    public void setSpGrossPl(Double spGrossPl) {
        this.spGrossPl = spGrossPl;
    }

    public Double getSpExemptedPl() {
        return spExemptedPl;
    }

    public void setSpExemptedPl(Double spExemptedPl) {
        this.spExemptedPl = spExemptedPl;
    }

    public Double getSpOnetimePl() {
        return spOnetimePl;
    }

    public void setSpOnetimePl(Double spOnetimePl) {
        this.spOnetimePl = spOnetimePl;
    }

    public Double getSpTotalPl() {
        return spTotalPl;
    }

    public void setSpTotalPl(Double spTotalPl) {
        this.spTotalPl = spTotalPl;
    }

    public Double getSpDeductionPl() {
        return spDeductionPl;
    }

    public void setSpDeductionPl(Double spDeductionPl) {
        this.spDeductionPl = spDeductionPl;
    }

    public Double getSpTaxPl() {
        return spTaxPl;
    }

    public void setSpTaxPl(Double spTaxPl) {
        this.spTaxPl = spTaxPl;
    }

    public Double getSpNetPl() {
        return spNetPl;
    }

    public void setSpNetPl(Double spNetPl) {
        this.spNetPl = spNetPl;
    }

    public String getIpNo() {
        return ipNo;
    }

    public void setIpNo(String ipNo) {
        this.ipNo = ipNo;
    }
}