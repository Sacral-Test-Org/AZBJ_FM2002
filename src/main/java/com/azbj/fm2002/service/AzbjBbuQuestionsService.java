package com.azbj.fm2002.service;

import com.azbj.fm2002.dto.ValidationRequest;
import com.azbj.fm2002.dto.ValidationResponse;
import com.azbj.fm2002.dto.QuestionnaireValidationRequest;
import com.azbj.fm2002.dto.QuestionnaireValidationResponse;
import com.azbj.fm2002.repository.AzbjBbuQuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AzbjBbuQuestionsService {

    @Autowired
    private AzbjBbuQuestionsRepository repository;

    public ValidationResponse validateDescription(ValidationRequest request) {
        if (!"Y".equals(request.getAnswer()) && request.getQuestionId() != 85 && (request.getSubQuestionId() == 68 || request.getSubQuestionId() == 69) && request.getDescription() != null && !request.getDescription().isEmpty()) {
            return new ValidationResponse("Answer to the question is N. Hence cannot enter description.");
        }
        return new ValidationResponse("Validation successful.");
    }

    public boolean validateAnswers(Object[] answers) {
        // Call repository method to validate answers
        return repository.validateAnswers(answers);
    }

    public void processAnswers(Object[] answers) {
        // Call repository method to process answers
        repository.processAnswers(answers);
    }

    public QuestionnaireValidationResponse validateAnswer(QuestionnaireValidationRequest request) {
        // Call repository method to validate a single answer
        return repository.validateAnswer(request);
    }

    public String checkStatus() {
        try {
            // Call repository method to get status
            return repository.getStatus();
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
            return "Error occurred while checking status.";
        }
    }
}
