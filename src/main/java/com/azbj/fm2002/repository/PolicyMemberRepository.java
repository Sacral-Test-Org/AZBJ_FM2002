package com.azbj.fm2002.repository;

import com.azbj.fm2002.entity.PolicyMember;
import com.azbj.fm2002.entity.AgeProofDetails;
import com.azbj.fm2002.entity.LateralShiftRecord;
import com.azbj.fm2002.entity.LoadingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PolicyMemberRepository extends JpaRepository<PolicyMember, Long> {

    PolicyMember save(PolicyMember memberDetails);

    void deleteById(Long memberId);

    Optional<PolicyMember> findById(Long memberId);

    @Query("SELECT p FROM PolicyMember p WHERE p.partnerId = :partnerId")
    Optional<PolicyMember> findByPartnerId(String partnerId);

    @Query("SELECT COUNT(p) > 0 FROM PolicyMember p WHERE p.hniFlag = true")
    Boolean queryHniPolicies();

    @Query("SELECT COUNT(*) > 0 FROM balic_history_details WHERE appl_no = TO_CHAR(NVL(:ipSignCardNo, :ipVerfNo)) AND UPPER(tele_ver_status) = 'COMPLETE' AND updated_flag = 'Y'")
    Boolean checkPreviousLapsePolicies(String ipSignCardNo, String ipVerfNo);

    @Query("UPDATE PolicyMember p SET p.weightChange = :weightChange WHERE p.id = :id")
    void updateWeightChange(Long id, Double weightChange);

    @Query("UPDATE PolicyMember p SET p.formStatus = :formStatus WHERE p.id = :id")
    void updateFormStatus(Long id, String formStatus);

    @Query("SELECT a FROM AgeProofDetails a WHERE a.proofType = :proofType")
    AgeProofDetails findAgeProofDetails(String proofType);

    @Query("DELETE FROM Covers c WHERE c.coverCode = :coverCode")
    void deleteFromCovers(String coverCode);

    @Query("DELETE FROM FurtherRequirements f WHERE f.ipNumber = :ipNumber AND f.testNumber = :testNumber")
    void deleteFromFurtherRequirements(String ipNumber, String testNumber);

    @Query("DELETE FROM FcfLoadingDetails f WHERE f.partId = :partId")
    void deleteFromFcfLoadingDetails(String partId);

    @Query("DELETE FROM BbuQuestions b WHERE b.partId = :partId")
    void deleteFromBbuQuestions(String partId);

    @Query("DELETE FROM PolicyMember p WHERE p.id = :memberId")
    void deleteFromPolicyMember(String memberId);

    @Query("SELECT p FROM PolicyMember p WHERE p.partId = :partId")
    PolicyMember fetchPolicyMemberDetails(String partId);

    @Query("SELECT p FROM PolicyMember p WHERE p.id = :policyMemberId")
    Optional<PolicyMember> findById(Long policyMemberId);

    @Query("SELECT p FROM PolicyMember p WHERE p.memberId = :memberId")
    void deleteById(String memberId);

    @Query("SELECT l FROM LateralShiftRecord l WHERE l.partnerId = :partnerId")
    List<LateralShiftRecord> findLateralShiftRecords(String partnerId);

    LateralShiftRecord saveLateralShiftRecord(LateralShiftRecord lateralShiftRecord);

    void deleteLateralShiftRecord(LateralShiftRecord lateralShiftRecord);

    @Query("SELECT p FROM PolicyMember p")
    List<PolicyMember> findPolicyMemberRecords();

    @Query("SELECT l FROM LoadingDetails l")
    List<LoadingDetails> findLoadingDetailsRecords();

    LoadingDetails saveLoadingDetailsRecord(LoadingDetails loadingDetails);

    @Query("SELECT a FROM AgeProofType a")
    List<AgeProofType> findValidAgeProofTypes();

    @Query("SELECT a FROM Agent a WHERE a.agentCode = :agentCode")
    Agent findAgentByCode(String agentCode);

    @Query("SELECT p FROM PolicyMember p WHERE p.id = :id")
    PolicyMember save(AddMemberRequest addMemberRequest);

    @Query("SELECT p FROM PolicyMember p WHERE p.bmi = :bmi")
    Boolean validateBMI(Double bmi);

    @Query("SELECT p FROM PolicyMember p WHERE p.height = :height")
    Boolean validateHeight(Double height);
}
