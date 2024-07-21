package com.project.azbj_fm2002.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "control")
public class Control {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "policy_ref")
    private String policyRef;

    @Column(name = "contract_id")
    private String contractId;

    @Column(name = "question_desc")
    private String questionDesc;

    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "active_questions")
    private String activeQuestions;

    @Column(name = "check_flg")
    private String checkFlg;

    @Column(name = "insert_date")
    private Date insertDate;

    @Column(name = "insert_user")
    private String insertUser;

    @Column(name = "relation_with_staff")
    private String relationWithStaff;

    @Column(name = "description")
    private String description;

    @Column(name = "crm_user")
    private String crmUser;

    @Column(name = "crm_date")
    private Date crmDate;

    @Column(name = "flg1")
    private Boolean flg1;

    @Column(name = "flg2")
    private Boolean flg2;

    @Column(name = "flg3")
    private Boolean flg3;

    @Column(name = "flg4")
    private Boolean flg4;

    @Column(name = "flg5")
    private Boolean flg5;

    @Column(name = "flg6")
    private Boolean flg6;

    @Column(name = "flg7")
    private Boolean flg7;

    @Column(name = "flg8")
    private Boolean flg8;

    @Column(name = "flg9")
    private Boolean flg9;

    @Column(name = "flg10")
    private Boolean flg10;

    @Column(name = "flg11")
    private Boolean flg11;

    @Column(name = "flg12")
    private Boolean flg12;

    @Column(name = "flg13")
    private Boolean flg13;

    @Column(name = "partner_type")
    private String partnerType;

    @Column(name = "relevant_data")
    private String relevantData;

    @Column(name = "beneficial_owner")
    private String beneficialOwner;

    @Column(name = "owner_share")
    private String ownerShare;

    @Column(name = "color_photo")
    private String colorPhoto;

    @Column(name = "identity_proof_desc")
    private String identityProofDesc;

    @Column(name = "identity_doc_id")
    private String identityDocId;

    @Column(name = "identity_doc_date")
    private Date identityDocDate;

    @Column(name = "address_proof_desc")
    private String addressProofDesc;

    @Column(name = "address_doc_id")
    private String addressDocId;

    @Column(name = "address_doc_date")
    private Date addressDocDate;

    @Column(name = "address")
    private String address;

    @Column(name = "individual_shareholding")
    private Integer individualShareholding;

    @Column(name = "family_shareholdings")
    private Integer familyShareholdings;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "ho_allocation_internal_value")
    private String hoAllocationInternalValue;

    @Column(name = "ho_allocation_screen_value")
    private String hoAllocationScreenValue;

    @Column(name = "politically_exposed_person_flag")
    private String politicallyExposedPersonFlag;

    @Column(name = "removal_flag")
    private String removalFlag;

    @Column(name = "v_ip_other_sa")
    private int vIpOtherSa;

    @Column(name = "v_ph_other_sa")
    private int vPhOtherSa;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "city")
    private String city;

    @Column(name = "v_nri_gst_waiver")
    private String vNriGstWaiver;

    @Column(name = "bkd_flg")
    private String bkdFlg;

    @Column(name = "ch_inception_date")
    private Date chInceptionDate;

    @Column(name = "nri_gst_waiver")
    private String nriGstWaiver;

    @Column(name = "cibil_score")
    private Integer cibilScore;

    @Column(name = "income_segment")
    private Integer incomeSegment;

    @Column(name = "application_no")
    private String applicationNo;

    @Column(name = "proposal_no")
    private String proposalNo;

    @Column(name = "top_indicator")
    private String topIndicator;

    @Column(name = "action_code")
    private String actionCode;

    @Column(name = "proof_type")
    private String proofType;

    @Column(name = "doc_value")
    private String docValue;

    @Column(name = "doc_expiry_date")
    private Date docExpiryDate;

    @Column(name = "module_flag")
    private String moduleFlag;

    @Column(name = "sg_premium")
    private String sgPremium;

    @Column(name = "sg_tasa")
    private String sgTasa;

    @Column(name = "underwriting_decision")
    private String underwritingDecision;

    @Column(name = "underwriting_comments")
    private String underwritingComments;

    @Column(name = "approval_status")
    private String approvalStatus;

    @Column(name = "approval_substatus")
    private String approvalSubstatus;

    @Column(name = "remarks")
    private String remarks;

    // Getters and Setters

    // Add getters and setters for all fields

    // Example getter and setter for policyRef
    public String getPolicyRef() {
        return policyRef;
    }

    public void setPolicyRef(String policyRef) {
        this.policyRef = policyRef;
    }

    // Add similar getters and setters for all other fields
}