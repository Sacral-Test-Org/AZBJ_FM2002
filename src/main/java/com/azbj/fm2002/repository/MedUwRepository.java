package com.azbj.fm2002.repository;

import com.azbj.fm2002.entity.MedicalTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedUwRepository extends JpaRepository<MedicalTestEntity, Long> {

    MedicalTestEntity save(MedicalTestEntity medicalTestEntity);

    void deleteById(Long id);

    Optional<MedicalTestEntity> findById(Long id);

    List<MedicalTestEntity> findAll();

    @Query("SELECT opusDate FROM SystemConstants")
    Date getOpusDate();

    @Query("SELECT m FROM MedicalTestEntity m WHERE m.id = :testId")
    MedicalTestEntity findTestById(@Param("testId") Long testId);

    @Query("UPDATE MedicalTestEntity m SET m.dateReceived = CURRENT_DATE WHERE m.resultReceived = 'Y'")
    void updateDateReceived(@Param("resultReceived") String resultReceived);

    @Query("SELECT m FROM MedicalTestEntity m WHERE m.testNumber = :testNumber")
    MedicalTestEntity findTestDetails(@Param("testNumber") String testNumber);

    @Query("UPDATE MedicalTestEntity m SET m.receiptStatus = :receiptStatus WHERE m.id = :id")
    void updateReceiptStatus(@Param("receiptStatus") String receiptStatus, @Param("id") Long id);

    @Query("CALL validate_test1(:param)")
    void validateTest1(@Param("param") String param);

    @Query("CALL validate_ecpl_home_visit()")
    void validateEcplHomeVisit();

    @Query("CALL check_medical_center()")
    void checkMedicalCenter();

    @Query("CALL validate_homevisit()")
    void validateHomeVisit();

    @Query("CALL azbj_clean_mer()")
    void azbjCleanMer();

    @Query("SELECT COUNT(*) > 0 FROM MedicalTestEntity m WHERE m.partnerId = :partnerId AND m.applicationNo = :applicationNo AND m.medTestId = :medTestId AND m.locked = 'Y' AND m.testConductedFrom = 'THYROCARE'")
    boolean checkIfLockedAndConveyed(@Param("partnerId") String partnerId, @Param("applicationNo") String applicationNo, @Param("medTestId") String medTestId);

    @Query("UPDATE MedicalTestEntity m SET m.testConductedFrom = NULL WHERE m.partnerId = :partnerId AND m.applicationNo = :applicationNo")
    void clearTestConductedFrom(@Param("partnerId") String partnerId, @Param("applicationNo") String applicationNo);

    @Query("SELECT COUNT(*) > 0 FROM MedicalTestEntity m WHERE m.testNo = :testNo AND m.ipType = :ipType AND m.reTest = 'Y'")
    boolean checkForReTests(@Param("testNo") String testNo, @Param("ipType") String ipType);

    @Query("DELETE FROM MedicalTestEntity m WHERE m.medTestId = :medTestId")
    void deleteMedicalTest(@Param("medTestId") String medTestId);

    @Query("SELECT * FROM UnderwritingRequirementsRaised u, SystemConstants s WHERE u.contractId = s.contractId AND u.eventNumber = s.eventNumber")
    List<MedUwResponse> findAllUnderwritingRequirements();

    @Query("INSERT INTO UnderwritingRequirementsRaised (testCode, description, ipType, dateCalled) VALUES (:testCode, :description, :ipType, :dateCalled)")
    void saveUnderwritingRequirement(@Param("testCode") String testCode, @Param("description") String description, @Param("ipType") String ipType, @Param("dateCalled") Date dateCalled);
}