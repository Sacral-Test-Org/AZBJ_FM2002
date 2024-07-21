package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.ReinsuranceDetailsService;
import com.azbj.fm2002.dto.ReinsuranceDetailsDTO;
import com.azbj.fm2002.dto.ReinsurerDetailsDTO;
import com.azbj.fm2002.dto.ReinsuranceCoverDetailsDTO;
import com.azbj.fm2002.dto.ValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reinsurance")
public class ReinsuranceDetailsController {

    @Autowired
    private ReinsuranceDetailsService reinsuranceDetailsService;

    @GetMapping("/details")
    public List<ReinsuranceDetailsDTO> getReinsuranceDetails() {
        return reinsuranceDetailsService.fetchReinsuranceDetails();
    }

    @PostMapping("/validate-occ-perc")
    public void validateOccPercField() {
        reinsuranceDetailsService.validateOccPercField();
    }

    @PostMapping("/validate-special-risk-percentage")
    public ResponseEntity<String> validateSpecialRiskPercentage(@RequestBody ReinsuranceCoverDetailsDTO reinsuranceCoverDetailsDTO) {
        reinsuranceDetailsService.validateSpecialRiskPercentage(reinsuranceCoverDetailsDTO);
        return ResponseEntity.ok("Validation successful");
    }

    @GetMapping("/calculate-values")
    public Map<String, Object> getCalculatedValues() {
        return reinsuranceDetailsService.calculateValues();
    }

    @GetMapping("/reinsurer-details")
    public List<ReinsurerDetailsDTO> getReinsurerDetails() {
        return reinsuranceDetailsService.getReinsurerDetails();
    }

    @PostMapping("/refer-to-reinsurer")
    public void referToReinsurer(@RequestBody ReinsurerDetailsDTO reinsurerDetailsDTO) {
        reinsuranceDetailsService.referToReinsurer(reinsurerDetailsDTO);
    }

    @PostMapping("/save-reinsurance-details")
    public ReinsuranceDetailsDTO saveReinsuranceDetails(@RequestBody ReinsuranceDetailsDTO reinsuranceDetailsDTO) {
        return reinsuranceDetailsService.saveReinsuranceDetails(reinsuranceDetailsDTO);
    }

    @DeleteMapping("/delete-record/{recordId}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long recordId) {
        reinsuranceDetailsService.deleteRecord(recordId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reinsurer-codes")
    public List<String> getReinsurerCodes(@RequestParam String reinsuranceType, @RequestParam String productId) {
        return reinsuranceDetailsService.getReinsurerCodes(reinsuranceType, productId);
    }

    @PostMapping("/validate-reinsurance-details")
    public ValidationResponse validateReinsuranceDetails(@RequestBody ReinsuranceDetailsDTO reinsuranceDetailsDTO) {
        return reinsuranceDetailsService.validateReinsuranceDetails(reinsuranceDetailsDTO);
    }

    @PostMapping("/navigate-to-medical-underwriting")
    public void navigateToMedicalUnderwriting() {
        reinsuranceDetailsService.navigateToMedicalUnderwriting();
    }
}