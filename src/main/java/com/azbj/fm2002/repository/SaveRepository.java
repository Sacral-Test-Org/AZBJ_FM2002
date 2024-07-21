package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.SeniorUnderwriterDTO;
import com.azbj.fm2002.dto.SaveReasonDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaveRepository extends JpaRepository<SaveReasonDTO, Long> {

    @Query("SELECT action FROM SelectedAction WHERE id = 1")
    String findSelectedAction();

    @Query("UPDATE SelectedAction SET action = :action WHERE id = 1")
    void saveSelectedAction(@Param("action") String action);

    @Query("SELECT new com.azbj.fm2002.dto.SeniorUnderwriterDTO(sys_desc, char_value) FROM azbj_system_constants WHERE sys_type = 'SU' AND sys_code = 'SENIOR_UW'")
    List<SeniorUnderwriterDTO> findSeniorUnderwriters();

    @Query("UPDATE RecordStatus SET status = CASE WHEN :action = 'ISSUED' THEN 'IM' WHEN :action IN ('REJECTED', 'DECLINED') THEN 'RM' ELSE NULL END WHERE id = 1")
    void updateStatus(@Param("action") String action);

    @Query("UPDATE ExitFlag SET flag = :flag WHERE id = 1")
    void updateFlag(@Param("flag") String flag);

    @Override
    <S extends SaveReasonDTO> S save(S entity);

    @Override
    Optional<SaveReasonDTO> findById(Long id);

    @Query("INSERT INTO azbj_uw_comments (event_no, contract_id, policy_no, user_id, comment_date, comments, flag) VALUES (:#{#reason.eventNo}, :#{#reason.contractId}, :#{#reason.policyNo}, :#{#reason.userId}, SYSDATE, :#{#reason.comments}, 'Y')")
    void saveReason(@Param("reason") SaveReasonDTO reason);
}
