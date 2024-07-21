package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsuredPersonRepository extends JpaRepository<InsuredPerson, String> {

    Optional<InsuredPerson> findById(String insuredPersonID);

    void save(InsuredPerson insuredPersonDetails);

    @Query("SELECT CASE WHEN COUNT(ip) > 0 THEN true ELSE false END FROM InsuredPerson ip WHERE ip.mibCode = :mibCode")
    boolean findByMibCode(@Param("mibCode") String mibCode);

    @Query("SELECT COUNT(*) FROM balic_history_details WHERE appl_no = TO_CHAR(NVL(:ipSignCardNo, :ipVerfNo)) AND UPPER(tele_ver_status) = 'COMPLETE' AND updated_flag = 'Y'")
    int checkPreviousPolicyDetails(@Param("ipSignCardNo") String ipSignCardNo, @Param("ipVerfNo") String ipVerfNo);

    @Query("SELECT COUNT(*) FROM azbj_phub_add_req_tracker a, azbj_phub_req_tracker b WHERE a.APPLICATION_NO = b.APPLICATION_NO AND a.REQ_TYPE = b.REQ_TYPE AND a.application_no = TO_CHAR(NVL(:ipVerfNo, :ipSignCardNo)) AND b.RECD_IN_OPUS = 'N'")
    int checkIncompleteInwardedApplications(@Param("ipVerfNo") String ipVerfNo, @Param("ipSignCardNo") String ipSignCardNo);

    @Query("SELECT DEFAULT_VALUE FROM azbj_cover_event_values WHERE Mn_policy_yr BETWEEN pol_year_from AND pol_year_to AND product_id = :productId AND Event_code = 'ALL' AND pk_vars.v_perm_rec_date >= start_date AND pk_vars.v_perm_rec_date <= NVL(end_date, TO_DATE('01/01/3000', 'dd/mm/yyyy'))")
    double findDefaultAllocationPercentage(@Param("policyYear") int policyYear, @Param("productId") int productId, @Param("eventCode") String eventCode, @Param("term") int term, @Param("permRecDate") java.util.Date permRecDate);

    @Query("SELECT AGE_UID FROM azbj_Age_proof_UID WHERE age_proof = :ageProof")
    Optional<String> findAgeProofUID(@Param("ageProof") String ageProof);

    @Query("SELECT * FROM AgeProof WHERE ageProof = :ageProof")
    Optional<AgeProof> findAgeProofType(@Param("ageProof") String ageProof);

    @Query("SELECT CASE WHEN COUNT(ip) > 0 THEN true ELSE false END FROM InsuredPerson ip WHERE ip.ageProofType = :ageProofType AND ip.ageProofID = :ageProofID")
    boolean validateAgeProofID(@Param("ageProofType") String ageProofType, @Param("ageProofID") String ageProofID);

    @Query("SELECT * FROM ProbableCP WHERE applicationNumber = :applicationNumber AND verificationNumber = :verificationNumber AND signCardNumber = :signCardNumber")
    List<ProbableCP> findProbableCPDetails(@Param("applicationNumber") String applicationNumber, @Param("verificationNumber") String verificationNumber, @Param("signCardNumber") String signCardNumber);

    @Query("SELECT productDefinition FROM ProductDefinition WHERE productId = :productId")
    String getProductDefinition(@Param("productId") String productId);

    @Query("SELECT packageCode FROM PackageCode WHERE packageId = :packageId")
    String getPackageCode(@Param("packageId") String packageId);

    @Query("SELECT * FROM MailingAddress WHERE IP_MAIL_ID = :IP_MAIL_ID")
    MailingAddressDTO findMailingAddress(@Param("IP_MAIL_ID") String IP_MAIL_ID);

    @Query("SELECT * FROM PassportDetails WHERE insuredPersonID = :insuredPersonID")
    PassportDetailsDTO findPassportDetails(@Param("insuredPersonID") String insuredPersonID);

    @Query("SELECT CASE WHEN COUNT(ip) > 0 THEN true ELSE false END FROM InsuredPerson ip WHERE ip.productId = :productId AND ip.ipType = '1'")
    boolean validateIpType(@Param("productId") int productId);

    @Query("SELECT COUNT(*) FROM balic_history_details WHERE appl_no = TO_CHAR(NVL(:applicationNumber, :verificationNumber)) AND UPPER(tele_ver_status) = 'COMPLETE' AND updated_flag = 'Y'")
    int countRecords(@Param("applicationNumber") String applicationNumber, @Param("verificationNumber") String verificationNumber, @Param("signCardNumber") String signCardNumber);

    @Query("SELECT COUNT(*) FROM azbj_phub_add_req_tracker a, azbj_phub_req_tracker b WHERE a.APPLICATION_NO = b.APPLICATION_NO AND a.REQ_TYPE = b.REQ_TYPE AND a.application_no = TO_CHAR(NVL(:applicationNumber, :verificationNumber)) AND b.RECD_IN_OPUS = 'N'")
    int checkIncompleteApplications(@Param("applicationNumber") String applicationNumber, @Param("verificationNumber") String verificationNumber, @Param("signCardNumber") String signCardNumber);

    @Query("SELECT * FROM LateralShiftRecord WHERE insuredPersonId = :insuredPersonId")
    Optional<LateralShiftRecord> findByInsuredPersonId(@Param("insuredPersonId") String insuredPersonId);

    void save(LateralShiftRecord lateralShiftRecord);

    void delete(LateralShiftRecord lateralShiftRecord);

    @Query("SELECT * FROM InsuredPerson WHERE partnerId = :partnerId")
    Optional<InsuredPerson> findByPartnerId(@Param("partnerId") String partnerId);

    @Query("SELECT * FROM ProductDefinition WHERE productId = :productId")
    ProductDefinition findProductDefinition(@Param("productId") String productId);
}