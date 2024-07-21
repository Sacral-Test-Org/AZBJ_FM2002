package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.MedicalLoadingValidationRequest;
import com.azbj.fm2002.dto.MedicalLoadingValidationResponse;
import com.azbj.fm2002.dto.CoverCodeDTO;
import com.azbj.fm2002.service.ReinsuranceCoverDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/reinsurance-cover-details")
public class ReinsuranceCoverDetailsController {

    @Autowired
    private ReinsuranceCoverDetailsService reinsuranceCoverDetailsService;

    @PostMapping("/validate-medical-loading")
    public ResponseEntity<MedicalLoadingValidationResponse> validateMedicalLoadingPercentage(@RequestBody MedicalLoadingValidationRequest request) {
        MedicalLoadingValidationResponse response = reinsuranceCoverDetailsService.validateMedicalLoadingPercentage(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/calculate-reinsurance-amount")
    public ResponseEntity<Double> calculateReinsuranceAmount(@RequestBody ReinsuranceAmountRequest request) {
        double calculatedAmount = reinsuranceCoverDetailsService.calculateReinsuranceAmount(request.getReinsurancePercentage(), request.getCoverAmount());
        return ResponseEntity.ok(calculatedAmount);
    }

    @GetMapping("/cover-codes")
    public ResponseEntity<List<CoverCodeDTO>> getCoverCodes() {
        List<CoverCodeDTO> coverCodes = reinsuranceCoverDetailsService.fetchCoverCodes();
        return ResponseEntity.ok(coverCodes);
    }

    public static class ReinsuranceAmountRequest {
        private double reinsurancePercentage;
        private double coverAmount;

        public double getReinsurancePercentage() {
            return reinsurancePercentage;
        }

        public void setReinsurancePercentage(double reinsurancePercentage) {
            this.reinsurancePercentage = reinsurancePercentage;
        }

        public double getCoverAmount() {
            return coverAmount;
        }

        public void setCoverAmount(double coverAmount) {
            this.coverAmount = coverAmount;
        }
    }
}