package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.CoversHealthService;
import com.azbj.fm2002.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/covers-health")
public class CoversHealthController {

    @Autowired
    private CoversHealthService coversHealthService;

    @PostMapping("/validate-entry-age")
    public ResponseEntity<EntryAgeValidationResponse> validateEntryAge(@RequestBody EntryAgeValidationRequest request) {
        EntryAgeValidationResponse response = coversHealthService.validateEntryAge(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/calculate-terms")
    public ResponseEntity<TermsCalculationResponse> calculateTerms(@RequestBody TermsCalculationRequest request) {
        TermsCalculationResponse response = coversHealthService.calculateTerms(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validate-sum-insured")
    public ResponseEntity<CoversHealthValidationResponse> validateSumInsured(@RequestBody CoversHealthValidationRequest request) {
        CoversHealthValidationResponse response = coversHealthService.validateSumInsured(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/navigate-next-item")
    public ResponseEntity<Void> navigateToNextItem() {
        coversHealthService.navigateToNextItem();
        return ResponseEntity.ok().build();
    }
}
