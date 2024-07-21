package com.project.azbj_fm2002.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "azbj_liquid_investment_dtls")
public class LiquidInvestment {

    @Id
    @Column(name = "contract_id")
    private String contractId;

    @Column(name = "application_no")
    private String applicationNo;

    @Column(name = "proposal_no")
    private String proposalNo;

    @Column(name = "fixed_term_deposit")
    private Double fixedTermDeposit;

    @Column(name = "mutual_fund")
    private Double mutualFund;

    @Column(name = "equity_share")
    private Double equityShare;

    @Column(name = "fund_val_ul_pol")
    private Double fundValUlPol;

    @Column(name = "bank_balance")
    private Double bankBalance;

    @Column(name = "one_time_income")
    private Double oneTimeIncome;

    @Column(name = "liquid_investment")
    private Double liquidInvestment;

    @Column(name = "total_investment")
    private Double totalInvestment;

    @Column(name = "ip_no")
    private String ipNo;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_date")
    private Date createDate;

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

    public Double getFixedTermDeposit() {
        return fixedTermDeposit;
    }

    public void setFixedTermDeposit(Double fixedTermDeposit) {
        this.fixedTermDeposit = fixedTermDeposit;
    }

    public Double getMutualFund() {
        return mutualFund;
    }

    public void setMutualFund(Double mutualFund) {
        this.mutualFund = mutualFund;
    }

    public Double getEquityShare() {
        return equityShare;
    }

    public void setEquityShare(Double equityShare) {
        this.equityShare = equityShare;
    }

    public Double getFundValUlPol() {
        return fundValUlPol;
    }

    public void setFundValUlPol(Double fundValUlPol) {
        this.fundValUlPol = fundValUlPol;
    }

    public Double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(Double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public Double getOneTimeIncome() {
        return oneTimeIncome;
    }

    public void setOneTimeIncome(Double oneTimeIncome) {
        this.oneTimeIncome = oneTimeIncome;
    }

    public Double getLiquidInvestment() {
        return liquidInvestment;
    }

    public void setLiquidInvestment(Double liquidInvestment) {
        this.liquidInvestment = liquidInvestment;
    }

    public Double getTotalInvestment() {
        return totalInvestment;
    }

    public void setTotalInvestment(Double totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public String getIpNo() {
        return ipNo;
    }

    public void setIpNo(String ipNo) {
        this.ipNo = ipNo;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
