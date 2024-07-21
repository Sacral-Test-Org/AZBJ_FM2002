package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.PanApprovalDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PanApprovalRepository extends JpaRepository<PanApprovalDetailsDTO, Long> {

    @Query("UPDATE azbj_supervisor_appr_det SET approval_status = :approvalStatus WHERE application_no = :applicationNo")
    void saveApprovalStatus(@Param("approvalStatus") String approvalStatus, @Param("applicationNo") String applicationNo);

    @Query("SELECT APPROVED_USER, az_pk2_general.getusername(APPROVED_USER) AS user_name, TRUNC(CREATE_DATE) AS apprv_date, TO_CHAR(CREATE_DATE, 'hh:mi:ss am') AS apprv_time, (CASE WHEN PAN_STD_FLAG = 'Y' THEN 'Standard' WHEN PAN_STD_FLAG = 'N' THEN 'Non-Standard' WHEN PAN_STD_FLAG = 'R' THEN 'Review' END) AS status FROM azbj_supervisor_appr_det WHERE AGE_PROOF = 'PC' AND NVL(PAN_STD_FLAG, 'NA') <> 'NA' AND application_no = :applicationNo ORDER BY CREATE_DATE DESC")
    List<PanApprovalDetailsDTO> findPanApprovalDetails(@Param("applicationNo") String applicationNo);
}
