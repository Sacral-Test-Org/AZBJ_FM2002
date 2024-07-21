package com.azbj.fm2002.dto;

import java.util.Date;

public class FakeDocumentDTO {
    private String policyRef;
    private String contractId;
    private String documentDesc;
    private String documentType;
    private String documentCode;
    private boolean fakeDocument;
    private String insertUser;
    private Date insertDt;
    private String updateUser;
    private Date updateDt;
    private String comments;
    private String branchCode;
    private String hubCode;
    private String icCode;
    private String stmCode;
    private boolean fakeMark;
    private String docProofType;
    private String category;

    // Getters and Setters
    public String getPolicyRef() {
        return policyRef;
    }

    public void setPolicyRef(String policyRef) {
        this.policyRef = policyRef;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getDocumentDesc() {
        return documentDesc;
    }

    public void setDocumentDesc(String documentDesc) {
        this.documentDesc = documentDesc;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    public boolean isFakeDocument() {
        return fakeDocument;
    }

    public void setFakeDocument(boolean fakeDocument) {
        this.fakeDocument = fakeDocument;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser;
    }

    public Date getInsertDt() {
        return insertDt;
    }

    public void setInsertDt(Date insertDt) {
        this.insertDt = insertDt;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getHubCode() {
        return hubCode;
    }

    public void setHubCode(String hubCode) {
        this.hubCode = hubCode;
    }

    public String getIcCode() {
        return icCode;
    }

    public void setIcCode(String icCode) {
        this.icCode = icCode;
    }

    public String getStmCode() {
        return stmCode;
    }

    public void setStmCode(String stmCode) {
        this.stmCode = stmCode;
    }

    public boolean isFakeMark() {
        return fakeMark;
    }

    public void setFakeMark(boolean fakeMark) {
        this.fakeMark = fakeMark;
    }

    public String getDocProofType() {
        return docProofType;
    }

    public void setDocProofType(String docProofType) {
        this.docProofType = docProofType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}