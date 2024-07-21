package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.QuestionnaireValidationRequest;
import com.azbj.fm2002.model.PopulateQuestionsRequest;
import com.azbj.fm2002.model.PopulateQuestionsResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BbprocessRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveValidatedAnswers(QuestionnaireValidationRequest request) {
        // Logic to save validated answers to the database
        // Assuming request contains a list of answers to be saved
        request.getAnswers().forEach(answer -> entityManager.persist(answer));
    }

    public List<PopulateQuestionsResponse> fetchQuestions(PopulateQuestionsRequest request) {
        // Logic to fetch questions from the database based on the criteria in request
        String queryStr = "SELECT new com.azbj.fm2002.model.PopulateQuestionsResponse(q.questionId, q.subQuestion, q.formQuestionNo, q.questionDesc, q.answerType) " +
                "FROM AzbjBbuQuestions q WHERE q.displayed = 'Y' ";

        if (request.getProductId() == 221 || request.getProductId() == 259 || request.getProductId() == 297) {
            queryStr += "AND q.questionId <> CASE WHEN :phSex = 'F' THEN 0 ELSE 6 END ";
        } else if (!List.of("GROUP_CREDIT_PROTECT", "GROUP_LOAN_PROTECTOR", "GROUP_CREDIT_PROTECTION_PLUS").contains(request.getProductId())) {
            queryStr += "AND q.questionId > 48 AND q.questionId < 51 ";
        } else {
            queryStr += "AND q.questionId < 25 ";
        }

        queryStr += "ORDER BY q.questionId, q.subQuestion";

        TypedQuery<PopulateQuestionsResponse> query = entityManager.createQuery(queryStr, PopulateQuestionsResponse.class);
        query.setParameter("phSex", request.getPhSex());

        return query.getResultList();
    }
}
