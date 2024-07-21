package com.project.azbj_fm2002.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "azbj_beneficial_ownership")
public class BeneficialOwnership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contract_id")
    private String contractId;

    @Column(name = "beneficial_owner")
    private String beneficialOwner;

    @Column(name = "beb_owner_share")
    private Integer ownerShare;

    @Column(name = "color_photo")
    private String colorPhoto;

    @Column(name = "identity_proof_desc")
    private String identityProofDesc;

    @Column(name = "identity_doc_id")
    private String identityDocId;

    @Column(name = "identity_doc_date")
    @Temporal(TemporalType.DATE)
    private Date identityDocDate;

    @Column(name = "address_proof_desc")
    private String addressProofDesc;

    @Column(name = "address_doc_id")
    private String addressDocId;

    @Column(name = "address_doc_date")
    @Temporal(TemporalType.DATE)
    private Date addressDocDate;

    @Column(name = "address")
    private String address;

    @Column(name = "insert_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;

    @Column(name = "insert_user")
    private String insertUser;

    @Column(name = "individual_shareholding")
    private Integer individualShareholding;

    @Column(name = "family_shareholdings")
    private Integer familyShareholdings;

    @Column(name = "approval_id")
    private String approvalId;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getBeneficialOwner() {
        return beneficialOwner;
    }

    public void setBeneficialOwner(String beneficialOwner) {
        this.beneficialOwner = beneficialOwner;
    }

    public Integer getOwnerShare() {
        return ownerShare;
    }

    public void setOwnerShare(Integer ownerShare) {
        this.ownerShare = ownerShare;
    }

    public String getColorPhoto() {
        return colorPhoto;
    }

    public void setColorPhoto(String colorPhoto) {
        this.colorPhoto = colorPhoto;
    }

    public String getIdentityProofDesc() {
        return identityProofDesc;
    }

    public void setIdentityProofDesc(String identityProofDesc) {
        this.identityProofDesc = identityProofDesc;
    }

    public String getIdentityDocId() {
        return identityDocId;
    }

    public void setIdentityDocId(String identityDocId) {
        this.identityDocId = identityDocId;
    }

    public Date getIdentityDocDate() {
        return identityDocDate;
    }

    public void setIdentityDocDate(Date identityDocDate) {
        this.identityDocDate = identityDocDate;
    }

    public String getAddressProofDesc() {
        return addressProofDesc;
    }

    public void setAddressProofDesc(String addressProofDesc) {
        this.addressProofDesc = addressProofDesc;
    }

    public String getAddressDocId() {
        return addressDocId;
    }

    public void setAddressDocId(String addressDocId) {
        this.addressDocId = addressDocId;
    }

    public Date getAddressDocDate() {
        return addressDocDate;
    }

    public void setAddressDocDate(Date addressDocDate) {
        this.addressDocDate = addressDocDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser;
    }

    public Integer getIndividualShareholding() {
        return individualShareholding;
    }

    public void setIndividualShareholding(Integer individualShareholding) {
        this.individualShareholding = individualShareholding;
    }

    public Integer getFamilyShareholdings() {
        return familyShareholdings;
    }

    public void setFamilyShareholdings(Integer familyShareholdings) {
        this.familyShareholdings = familyShareholdings;
    }

    public String getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
