package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.Comment;
import com.azbj.fm2002.model.ManualCasePushDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UwCommentsRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT * FROM AZBJ_UW_COMMENTS WHERE contract_id = :contractId")
    List<Comment> findCommentsByContractId(@Param("contractId") String contractId);

    @Query("SELECT EVENT_NO, CONTRACT_ID, POLICY_NO, IP_NO, MOVE_CODE, POLICY_STATUS, USER_ID, COMMENT_DATE, COMMENTS, USERROLE, OPINION, FLAG " +
            "FROM AZBJ_UW_COMMENTS " +
            "WHERE contract_id = :contractId " +
            "AND 0 = (CASE WHEN (user_id LIKE 'P00%' AND NVL(flag, 'N') = 'Y') THEN 1 ELSE 0 END)")
    List<Comment> findCommentsByContractIdAndUserIdNotStartingWithP00AndFlagNotY(@Param("contractId") String contractId);

    @Query("SELECT * FROM AZBJ_UW_COMMENTS WHERE contract_id = :contractId AND NVL(flag, 'N') = 'N'")
    List<Comment> findCommentsByContractIdAndFlagN(@Param("contractId") String contractId);

    @Query("SELECT CASE WHEN source_flag = 'BBU' THEN param_val_string ELSE 'Rule Configurator' END AS param_type, rule_message, a.trans_id " +
            "FROM bbu_trans a, bbu_trans_dtls b " +
            "WHERE a.trans_id = b.trans_id AND action_id = 2 AND a.appl_no = :applNo")
    List<ManualCasePushDTO> findManualCasePushDetails(@Param("applNo") String applNo);

    @Query("SELECT question_desc FROM azbj_qc_questions WHERE question_id = (" +
            "SELECT SUBSTR(rule_message, 37) FROM bbu_trans_dtls WHERE trans_id = :transId AND param_val_string = 'QC REQUIREMENTS' " +
            "AND action_id = 2 AND rule_message != 'QC Requirements raised.' AND rule_message = :ruleMessage)")
    String findQuestionDescription(@Param("transId") Long transId, @Param("ruleMessage") String ruleMessage);
}
