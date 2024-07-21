package com.project.azbj_fm2002.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "WIP_AZBJ_POLICY_RISK_REP")
public class PolicyRisk {

    @Id
    @Column(name = "CONTRACT_ID")
    private String contractId;

    @Column(name = "POLICY_NO")
    private String policyNo;

    @Column(name = "ACTION_CODE")
    private String actionCode;

    @Column(name = "LIFE_COVERAGE_SUM")
    private Double lifeCoverageSum;

    @Column(name = "YR_OF_ISSUE")
    private Integer yearOfIssue;

    @Column(name = "IP_TYPE")
    private Integer ipType;

    @Column(name = "PREMIUM")
    private Double premium;

    // Getters and Setters

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public Double getLifeCoverageSum() {
        return lifeCoverageSum;
    }

    public void setLifeCoverageSum(Double lifeCoverageSum) {
        this.lifeCoverageSum = lifeCoverageSum;
    }

    public Integer getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(Integer yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public Integer getIpType() {
        return ipType;
    }

    public void setIpType(Integer ipType) {
        this.ipType = ipType;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }
}