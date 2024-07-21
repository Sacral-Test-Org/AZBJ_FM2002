package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.DoctorDetails;
import com.azbj.fm2002.model.DoctorPanelData;
import com.azbj.fm2002.model.ImageData;
import com.azbj.fm2002.model.DoctorDetailsDTO;
import com.azbj.fm2002.model.DoctorClientNamesResponse;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface PanelDoctorRepository extends JpaRepository<DoctorDetails, Long> {

    @Query("SELECT d FROM DoctorDetails d WHERE d.doctorCode = :doctorCode")
    DoctorDetails findDoctorByCode(@Param("doctorCode") String doctorCode);

    @Query("DELETE FROM DoctorDetails d WHERE d.doctorCode = :doctorCode")
    void deleteDoctorByCode(@Param("doctorCode") String doctorCode);

    @Query("SELECT new com.azbj.fm2002.model.DoctorPanelData(d.doctorCode, d.doctorName) FROM DoctorDetails d")
    List<DoctorPanelData> findAllDoctors();

    @Query("SELECT new com.azbj.fm2002.model.ImageData(i.imageUrl) FROM ImageData i WHERE i.doctorCode = :doctorCode")
    List<ImageData> findImagesByDoctorCode(@Param("doctorCode") String doctorCode);

    @Query("SELECT TO_CHAR(opus_date, 'DD/MM/YYYY') FROM azbj_system_constants WHERE sys_type = 'OPUS_DATE'")
    String getOpusDate();

    @Query("SELECT d.doctorCode FROM azbj_scrutiny_test_dtl d WHERE d.testNo = :testCode AND d.life = :lifeType AND d.applicationNo = :applicationNo")
    String findDoctorCode(@Param("lifeType") String lifeType, @Param("testCode") String testCode, @Param("applicationNo") String applicationNo);

    @Query("SELECT new com.azbj.fm2002.model.Doctor(d.panelDoctorName, d.panelDoctor) FROM azbj_panel_doctor_ref d WHERE NOT EXISTS (SELECT 1 FROM azbj_panel_doctor_terminated t WHERE t.panelDoctor = d.panelDoctor) AND (d.panelDoctor NOT IN ('DO27220559', 'DO27200589') AND d.panelDoctor LIKE 'D%') = FALSE")
    List<Doctor> findDoctorNames();

    @Query("SELECT COUNT(*) > 0 FROM AZBJ_DOCTOR_TEST_DETAIL d WHERE d.doctorCode = :doctorCode AND d.testCode = :testCode")
    boolean checkDoctorAuthorization(@Param("doctorCode") String doctorCode, @Param("testCode") String testCode);

    @Query("SELECT COUNT(*) > 0 FROM azbj_med_payout_extract p WHERE p.contractId = :contractId AND p.doctorCode = :doctorCode AND p.testCode = :testCode AND p.paidFlag = 'Y'")
    boolean checkPaymentStatus(@Param("contractId") String contractId, @Param("doctorCode") String doctorCode, @Param("testCode") String testCode);

    @Query("DELETE FROM DoctorDetails d WHERE d.doctorCode = :doctorCode AND d.testCode = :testCode")
    void deleteDoctorRecord(@Param("doctorCode") String doctorCode, @Param("testCode") String testCode);

    @Query("SELECT new com.azbj.fm2002.model.DoctorDetailsDTO(d.doctorCode, d.doctorName, d.testCode, d.merNo, d.ipNo) FROM azbj_cardio_details d WHERE d.policyRef = :policyRef AND d.doctorCode IS NOT NULL UNION ALL SELECT new com.azbj.fm2002.model.DoctorDetailsDTO(d.doctorCode, d.doctorName, d.testCode, d.merNo, d.ipNo) FROM azbj_patho_details d WHERE d.policyRef = :policyRef AND d.doctorCode IS NOT NULL")
    List<DoctorDetailsDTO> fetchDoctorDetails(@Param("policyRef") String policyRef);

    @Query("SELECT s.signature FROM azbj_panel_doctor_ref d, azbj_signature s WHERE d.panelDoctor = s.icCode AND s.subIcCode = '1234' AND d.icCode = :doctorCode")
    String findDoctorSignature(@Param("doctorCode") String doctorCode);

    @Query("SELECT new com.azbj.fm2002.model.DoctorClientNamesResponse(c.clientName, ROWNUM) FROM (SELECT DISTINCT c.clientName FROM AZBJ_DOCT_CUST_DETAILS c WHERE c.userId = :doctorCode AND c.applicationNo = TO_CHAR(NVL(:verfNo, :signCardNo)))")
    List<DoctorClientNamesResponse> findClientNamesByDoctorCode(@Param("doctorCode") String doctorCode, @Param("verfNo") String verfNo, @Param("signCardNo") String signCardNo);
}