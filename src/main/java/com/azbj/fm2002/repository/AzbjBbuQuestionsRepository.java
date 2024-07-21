package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.QuestionAnswer;
import com.azbj.fm2002.model.QuestionnaireValidationRequest;
import com.azbj.fm2002.model.QuestionnaireValidationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AzbjBbuQuestionsRepository extends JpaRepository<QuestionAnswer, Long> {

    void saveAnswers(List<QuestionAnswer> answers);

    void deleteAnswers(List<QuestionAnswer> answers);

    @Query("SELECT q FROM QuestionAnswer q WHERE q.partnerId = :partnerId")
    List<QuestionAnswer> findQuestionsAndAnswers(@Param("partnerId") String partnerId);

    @Query("SELECT q FROM QuestionAnswer q WHERE q.memberId = :memberId")
    void deleteByMemberId(@Param("memberId") String memberId);

    @Query("SELECT q FROM QuestionAnswer q WHERE q.questionId = :questionId AND q.subQuestion IN (68, 69) AND q.questionId != 85")
    QuestionnaireValidationResponse validateAnswer(@Param("questionId") Long questionId, @Param("answer") String answer, @Param("description") String description);

    @Query("SELECT c.status FROM ControlVariable c")
    String getStatus();
}