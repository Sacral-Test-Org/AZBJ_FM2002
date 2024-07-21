package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.LoadingsService;
import com.azbj.fm2002.dto.MedicalLoadingValidationRequest;
import com.azbj.fm2002.dto.MedicalLoadingValidationResponse;
import com.azbj.fm2002.dto.OccupationLoadingValidationRequest;
import com.azbj.fm2002.dto.OccupationLoadingValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loadings")
public class LoadingsController {

    @Autowired
    private LoadingsService loadingsService;

    @PostMapping("/validateLoadingType")
    public ResponseEntity<Boolean> validateLoadingType(@RequestBody String productId, @RequestBody String loadingType) {
        boolean isValid = loadingsService.validateLoadingType(productId, loadingType);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/validateLoading")
    public ResponseEntity<Void> validateLoading(@RequestBody String productDefinition, @RequestBody String coverCode, @RequestBody double loadingPercentage) {
        loadingsService.validateLoading(productDefinition, coverCode, loadingPercentage);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/validateOccupationLoading")
    public ResponseEntity<ValidationResult> validateOccupationLoading(@RequestBody String productDefinition, @RequestBody double occupationLoadingPercentage, @RequestBody String coverCode) {
        ValidationResult result = loadingsService.validateLoading(productDefinition, occupationLoadingPercentage, coverCode);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/validateMLP")
    public ResponseEntity<MedicalLoadingValidationResponse> validateMLP(@RequestBody MedicalLoadingValidationRequest request) {
        MedicalLoadingValidationResponse response = loadingsService.validateMLP(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validateOccupationLoadingClass")
    public ResponseEntity<OccupationLoadingValidationResponse> validateOccupationLoadingClass(@RequestBody OccupationLoadingValidationRequest request) {
        OccupationLoadingValidationResponse response = loadingsService.validateOccupationLoadingClass(request);
        return ResponseEntity.ok(response);
    }
}
