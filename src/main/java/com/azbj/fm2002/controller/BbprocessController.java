package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.BbprocessService;
import com.azbj.fm2002.model.PopulateQuestionsResponse;
import com.azbj.fm2002.model.QuestionAnswer;
import com.azbj.fm2002.model.QuestionnaireValidationRequest;
import com.azbj.fm2002.model.QuestionnaireValidationResponse;
import com.azbj.fm2002.model.PopulateQuestionsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bbprocess")
public class BbprocessController {

    @Autowired
    private BbprocessService bbprocessService;

    @PostMapping("/populate-questions")
    public ResponseEntity<PopulateQuestionsResponse> populateQuestions(@RequestBody String partnerId) {
        PopulateQuestionsResponse response = bbprocessService.populateQuestions(partnerId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/questions-answers")
    public ResponseEntity<List<QuestionAnswer>> getQuestionsAndAnswers(@RequestParam String partnerId) {
        List<QuestionAnswer> response = bbprocessService.fetchQuestionsAndAnswers(partnerId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validate-populate-answers")
    public ResponseEntity<QuestionnaireValidationResponse> validateAndPopulateAnswers(@RequestBody QuestionnaireValidationRequest request) {
        QuestionnaireValidationResponse response = bbprocessService.validateAndPopulate(request);
        return ResponseEntity.ok(response);
    }
}