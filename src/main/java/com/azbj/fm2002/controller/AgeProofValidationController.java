package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.AgeProofValidationService;
import com.azbj.fm2002.model.ValidationResponse;
import com.azbj.fm2002.model.AgeProofDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/age-proof")
public class AgeProofValidationController {

    @Autowired
    private AgeProofValidationService ageProofValidationService;

    @PostMapping("/validate")
    public ResponseEntity<ValidationResponse> validate(@RequestParam String ageProofType, @RequestParam String ageProofID, @RequestParam String agentCode) {
        ValidationResponse response = ageProofValidationService.validate(ageProofType, ageProofID, agentCode);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/details")
    public AgeProofDetails getAgeProofDetails(@RequestParam String proofType) {
        return ageProofValidationService.getAgeProofDetails(proofType);
    }

    @PostMapping("/determine-type")
    public String determineAgeProofType(@RequestBody Object ageProofDetails) {
        return ageProofValidationService.determineAgeProofType(ageProofDetails);
    }

    @PostMapping("/validate-id")
    public ResponseEntity<?> validateAgeProofID(@RequestParam String ageProofType, @RequestParam String ageProofID) {
        return ResponseEntity.ok(ageProofValidationService.validateAgeProofID(ageProofType, ageProofID));
    }

    @PostMapping("/validate-proof")
    public String validateAgeProof(@RequestParam String ageProof) {
        return ageProofValidationService.validateAgeProof(ageProof);
    }
}
