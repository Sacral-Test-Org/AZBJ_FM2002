package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.ValidationRequest;
import com.azbj.fm2002.dto.ValidationResponse;
import com.azbj.fm2002.dto.QuestionnaireValidationRequest;
import com.azbj.fm2002.dto.QuestionnaireValidationResponse;
import com.azbj.fm2002.service.AzbjBbuQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/azbj-bbu-questions")
public class AzbjBbuQuestionsController {

    @Autowired
    private AzbjBbuQuestionsService azbjBbuQuestionsService;

    @PostMapping("/validate-description")
    public ResponseEntity<ValidationResponse> validateDescriptionInput(@RequestBody ValidationRequest request) {
        ValidationResponse response = azbjBbuQuestionsService.validateDescription(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validate-answers")
    public ResponseEntity<Boolean> validateAnswers(@RequestBody Object[] answers) {
        boolean isValid = azbjBbuQuestionsService.validateAnswers(answers);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/process-answers")
    public ResponseEntity<Void> processAnswers(@RequestBody Object[] answers) {
        azbjBbuQuestionsService.processAnswers(answers);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/validate-answer")
    public ResponseEntity<QuestionnaireValidationResponse> validateAnswer(@RequestBody QuestionnaireValidationRequest request) {
        QuestionnaireValidationResponse response = azbjBbuQuestionsService.validateAnswer(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/check-control-variable-status")
    public ResponseEntity<String> checkControlVariableStatus() {
        String status = azbjBbuQuestionsService.checkStatus();
        return ResponseEntity.ok(status);
    }
}
