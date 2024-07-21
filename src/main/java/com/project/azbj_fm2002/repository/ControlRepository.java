package com.project.azbj_fm2002.repository;

import com.project.azbj_fm2002.entity.Control;
import com.project.azbj_fm2002.entity.CRMComment;
import com.project.azbj_fm2002.entity.DoctorMobAppInfo;
import com.project.azbj_fm2002.entity.RiskScoreDetails;
import com.project.azbj_fm2002.entity.Supervisor;
import com.project.azbj_fm2002.entity.ProofType;
import com.project.azbj_fm2002.entity.FinancialDetails;
import com.project.azbj_fm2002.entity.SpouseFinancialDetails;
import com.project.azbj_fm2002.entity.LiquidInvestmentDetails;
import com.project.azbj_fm2002.entity.BeneficialOwnershipDetails;
import com.project.azbj_fm2002.entity.PartnerDetails;
import com.project.azbj_fm2002.entity.DmtAgents;
import com.project.azbj_fm2002.entity.CpPartners;
import com.project.azbj_fm2002.entity.AzbjAgentsExt;
import com.project.azbj_fm2002.entity.DmVAgentAssignments;
import com.project.azbj_fm2002.entity.Policy;
import com.project.azbj_fm2002.entity.PreviousPolicy;
import com.project.azbj_fm2002.entity.VideoCalling;
import com.project.azbj_fm2002.entity.FinancialUnderwriting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ControlRepository extends JpaRepository<Control, Long> {

    @Query("SELECT question_id, question_desc FROM azbj_crm_questions")
    List<Question> findAllQuestions();

    @Query("UPDATE azbj_crm_questions_detail SET active_questions ='N' WHERE policy_no = :policyRef AND contract_id = :contractId AND active_questions ='Y'")
    void deactivateActiveQuestions(@Param("policyRef") String policyRef, @Param("contractId") String contractId);

    @Query("INSERT INTO azbj_crm_questions_detail (policy_no, contract_id, question_desc, question_id, active_questions, check_flg, insert_date, insert_user) VALUES (:policyRef, :contractId, :questionDesc, :questionId, 'Y', :checkFlg, SYSDATE, USER)")
    void insertQuestions(@Param("policyRef") String policyRef, @Param("contractId") String contractId, @Param("questions") List<Question> questions);

    @Query("SELECT question_desc, description, crm_user, crm_date, flg1, flg2, flg3, flg4, flg5, flg6, flg7, flg8, flg9, flg10, flg11, flg12, flg13 FROM azbj_crm_questions_detail WHERE contract_id = :contractId AND check_flg = 'Y' ORDER BY active_questions DESC, TO_NUMBER(question_id)")
    List<CRMComment> findCRMCommentsByContractId(@Param("contractId") String contractId);

    @Query("SELECT perm_receipt_date FROM azbj_batch_items WHERE perm_receipt_no = :permReceiptNo")
    String findDataByPartnerType(@Param("partnerType") String partnerType);

    @Query("SELECT beneficial_owner, beb_owner_share, color_photo, identity_proof_desc, identity_doc_id, identity_doc_date, address_proof_desc, address_doc_id, address_doc_date, address, insert_date, insert_user, individual_shareholding, family_shareholdings, date_of_birth FROM azbj_beneficial_ownership WHERE contract_id = :contractId")
    BeneficialOwnershipDetails findBeneficialOwnershipDetails(@Param("contractId") String contractId);

    @Query("SELECT COUNT(1) FROM user_uw_limits WHERE uw_code = :vInternalValue AND medical_allowed = 'Y' AND user_id = :userId")
    boolean queryUserAuthorization(@Param("vInternalValue") String vInternalValue, @Param("userId") String userId);

    @Query("UPDATE azbj_financial_uw SET POLICY_REF = :policyRef, ITRS = :itrs, COMPUTATION = :computation, GROSS_INCOME = :grossIncome, NET_PROFIT = :netProfit, EXEMPTED_INCOME = :exemptedIncome, ONETIME_INCOME = :oneTimeIncome, TOTAL_INCOME = :totalIncome, DEDUCTION = :deduction, TAX = :tax, PROOF_TYPE = :proofType WHERE CONTRACT_ID = :contractId AND IP_NO = :premiumPayer AND YRS = :yrs")
    void updateValues(@Param("policyRef") String policyRef, @Param("itrs") String itrs, @Param("computation") String computation, @Param("grossIncome") String grossIncome, @Param("netProfit") String netProfit, @Param("exemptedIncome") String exemptedIncome, @Param("oneTimeIncome") String oneTimeIncome, @Param("totalIncome") String totalIncome, @Param("deduction") String deduction, @Param("tax") String tax, @Param("proofType") String proofType, @Param("contractId") String contractId, @Param("premiumPayer") String premiumPayer, @Param("yrs") String yrs);

    @Query("SELECT NUM_VALUE FROM azbj_system_constants WHERE SYS_TYPE = 'SHARE_HOLDING' AND SYS_CODE = 'FAMILY_SHARE_HOLDING'")
    Integer findMaxFamilyShareholding();

    @Query("SELECT NUM_VALUE FROM azbj_system_constants WHERE SYS_TYPE = 'SHARE_HOLDING' AND SYS_CODE = 'INDIVIDUAL_SHARE_HOLDING'")
    Integer findMaxIndividualShareholding();

    @Query("UPDATE azbj_policy_status SET status = :status WHERE policy_no = :policyNo")
    void updatePolicyStatus(@Param("status") String status, @Param("policyNo") String policyNo);

    @Query("SELECT * FROM AZBJ_DOCT_CUST_DETAILS WHERE application_no = TO_CHAR(NVL(:insuredPersonIpVerfNo, :insuredPersonIpSignCardNo)) ORDER BY upd_date DESC, CLIENT_NAME")
    List<DoctorMobAppInfo> findDoctorMobAppInfo(@Param("applicationNumber") String applicationNumber);

    @Query("SELECT b.application_no, rule_desc AS param_name, b.module, (CASE WHEN b.module IN ('SCRUTINY', 'BOTH') THEN a.risk_value ELSE 0 END) branch_risk_score, (CASE WHEN b.module IN ('DE-QC', 'BOTH') THEN a.risk_value ELSE 0 END) deqc_risk_score FROM azbj_claim_uw_rule_transaction a, azbj_claim_uw_transaction b, azbj_claim_uw_rules d WHERE rule_action = 2 AND a.version_no = b.version_no AND a.rule_id = d.rule_id AND b.param_id = d.param_id AND b.version_no = (SELECT MAX(version_no) FROM azbj_claim_uw_transaction c WHERE c.application_no = TO_CHAR(NVL(:insuredPersonIpVerfNo, :insuredPersonIpSignCardNo)) AND c.module IN ('SCRUTINY', 'DE-QC', 'BOTH')) AND a.trans_id = b.trans_id AND b.application_no = TO_CHAR(NVL(:insuredPersonIpVerfNo, :insuredPersonIpSignCardNo)) AND b.module IN ('SCRUTINY', 'DE-QC', 'BOTH')")
    List<RiskScoreDetails> fetchRiskScoreDetails(@Param("applicationNo") String applicationNo);

    @Query("SELECT * FROM DM_V_AGENT_ASSIGNMENTS WHERE REFERENCE_CODE = :agentCode AND :effectiveDate >= START_DATE AND :effectiveDate <= NVL(END_DATE, :effectiveDate)")
    Optional<DmVAgentAssignments> findSupervisor(@Param("username") String username);

    @Query("SELECT * FROM azbj_financial_uw WHERE CONTRACT_ID = :contractId AND IP_NO = :premiumPayer")
    List<FinancialDetails> findFinancialDetailsByPremiumPayer(@Param("premiumPayer") int premiumPayer);

    @Query("SELECT * FROM azbj_liquid_investment_dtls WHERE CONTRACT_ID = :contractId AND IP_NO = :premiumPayer")
    List<LiquidInvestmentDetails> findLiquidInvestmentDetailsByPremiumPayer(@Param("premiumPayer") int premiumPayer);

    @Query("SELECT * FROM azbj_beneficial_ownership WHERE contract_id = :contractId")
    BeneficialOwnershipDetails findBeneficialOwnershipDetailsByContractId(@Param("contractId") String contractId);

    @Query("SELECT TRIM(UPPER(first_name)), TRIM(UPPER(middle_name)), TRIM(UPPER(surname)), DATE_OF_BIRTH FROM cp_partners WHERE part_id = :insuredPersonId")
    List<PartnerDetails> fetchPartnerDetails(@Param("partnerType") String partnerType, @Param("insuredPersonId") String insuredPersonId, @Param("policyHolderId") String policyHolderId);

    @Query("SELECT ADDRESS_LINE4 FROM cp_addresses WHERE add_id = :addressId")
    String fetchCityDetails(@Param("addressId") String addressId);

    @Query("SELECT CUST_PART_UNIQUE_CODE, int_id FROM dmt_agents WHERE reference_code = :agentCode")
    Optional<DmtAgents> findByReferenceCode(@Param("agentCode") String agentCode);

    @Query("SELECT * FROM CP_PARTNERS WHERE CP_PARTNERS.PARTNER_REF = :uniqueCode")
    Optional<CpPartners> findByPartnerRef(@Param("uniqueCode") String uniqueCode);

    @Query("SELECT * FROM azbj_agents_ext WHERE int_id = :internalId")
    Optional<AzbjAgentsExt> findByIntId(@Param("internalId") int internalId);

    @Query("SELECT * FROM azbj_vdo_cv_approved_cases WHERE application_no = TO_CHAR(NVL(:insuredPersonIpSignCardNo, :insuredPersonIpVerfNo))")
    VideoCalling findVideoCallingStatus(@Param("applicationNumber") String applicationNumber);

    @Query("SELECT * FROM azbj_aml_sip_dtls WHERE application_no = :applicationNo AND MODULE_FLAG = 'BBU' AND top_indicator = 'Y'")
    List<Control> findExistingRecords(@Param("applicationNo") String applicationNo, @Param("moduleFlag") String moduleFlag, @Param("topIndicator") String topIndicator);

    @Query("UPDATE azbj_aml_sip_dtls SET top_indicator = 'N' WHERE application_no = :applicationNo AND MODULE_FLAG = 'BBU' AND top_indicator = 'Y'")
    void updateTopIndicator(@Param("applicationNo") String applicationNo, @Param("moduleFlag") String moduleFlag, @Param("topIndicator") String topIndicator);

    @Query("INSERT INTO azbj_aml_sip_dtls (application_no, proposal_no, top_indicator, action_code, proof_type, doc_value, doc_expiry_date, module_flag, sg_premium, sg_tasa) VALUES (:applicationNo, :proposalNo, 'Y', 'A', :proofType, :docValue, :docExpiryDate, 'BBU', :sgPremium, :sgTasa)")
    void insertNewRecord(@Param("applicationNo") String applicationNo, @Param("proposalNo") String proposalNo, @Param("proofType") String proofType, @Param("docValue") String docValue, @Param("docExpiryDate") String docExpiryDate, @Param("sgPremium") String sgPremium, @Param("sgTasa") String sgTasa);

    @Query("SELECT * FROM azbj_prev_policy_tracker WHERE application_no = :applicationNo OR proposal_no = :proposalNo")
    List<PreviousPolicy> findPreviousPolicyDetails(@Param("applicationNo") String applicationNo, @Param("proposalNo") String proposalNo);

    @Query("SELECT COUNT(*) FROM AZBJ_PREV_POLICY_TRACKER WHERE application_no = TO_CHAR(NVL(:insuredPersonIpVerfNo, :insuredPersonIpSignCardNo)) OR proposal_no = :policyRef")
    int checkRecordExists(@Param("applicationNo") String applicationNo, @Param("proposalNo") String proposalNo);

    @Query("UPDATE AZBJ_PREV_POLICY_TRACKER SET top_indicator = 'N' WHERE application_no = TO_CHAR(NVL(:insuredPersonIpVerfNo, :insuredPersonIpSignCardNo)) OR proposal_no = :policyRef")
    void updateRecord(@Param("applicationNo") String applicationNo, @Param("proposalNo") String proposalNo);

    @Query("INSERT INTO AZBJ_PREV_POLICY_TRACKER (application_no, proposal_no, USER_ID, UW_DECISION, UW_COMMENTS, ACTIVITY_DATE, TOP_INDICATOR) VALUES (TO_CHAR(NVL(:insuredPersonIpVerfNo, :insuredPersonIpSignCardNo)), :policyRef, USER, :uwDecision, :uwComments, SYSDATE, 'Y')")
    void insertRecord(@Param("applicationNo") String applicationNo, @Param("proposalNo") String proposalNo, @Param("userId") String userId, @Param("uwDecision") String uwDecision, @Param("uwComments") String uwComments, @Param("activityDate") String activityDate, @Param("topIndicator") String topIndicator);

    @Query("SELECT approval_status, approval_substatus, remarks FROM CUSTOMER.azbj_vdo_cv_approved_cases WHERE application_no = TO_CHAR(NVL(:insuredPersonIpSignCardNo, :insuredPersonIpVerfNo))")
    VideoCalling findVideoCallingStatus(@Param("applicationNumber") String applicationNumber);

    @Query("DELETE FROM azbj_financial_uw WHERE CONTRACT_ID = :contractId AND IP_NO = :premiumPayer")
    void deleteFinancialUnderwriting(@Param("contractId") String contractId, @Param("premiumPayer") String premiumPayer);

    @Query("INSERT INTO azbj_financial_uw (POLICY_REF, CONTRACT_ID, IP_NO, YRS, ITRS, COMPUTATION, GROSS_INCOME, NET_PROFIT, EXEMPTED_INCOME, ONETIME_INCOME, TOTAL_INCOME, DEDUCTION, TAX, PROOF_TYPE) VALUES (:policyRef, :contractId, :premiumPayer, :yrs, :itrs, :computation, :grossIncome, :netProfit, :exemptedIncome, :oneTimeIncome, :totalIncome, :deduction, :tax, :proofType)")
    void insertFinancialUnderwriting(@Param("policyRef") String policyRef, @Param("contractId") String contractId, @Param("premiumPayer") String premiumPayer, @Param("yrs") String yrs, @Param("itrs") String itrs, @Param("computation") String computation, @Param("grossIncome") String grossIncome, @Param("netProfit") String netProfit, @Param("exemptedIncome") String exemptedIncome, @Param("oneTimeIncome") String oneTimeIncome, @Param("totalIncome") String totalIncome, @Param("deduction") String deduction, @Param("tax") String tax, @Param("proofType") String proofType);
}