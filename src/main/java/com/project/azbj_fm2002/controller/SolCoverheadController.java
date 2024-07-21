package com.project.azbj_fm2002.controller;

import com.project.azbj_fm2002.service.SolCoverheadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sol-coverhead")
public class SolCoverheadController {

    @Autowired
    private SolCoverheadService solCoverheadService;

    @GetMapping("/sum-assured")
    public ResponseEntity<Number> getSumAssured() {
        Number sumAssured = solCoverheadService.getSumAssured();
        return ResponseEntity.ok(sumAssured);
    }

    @GetMapping("/solution-name")
    public ResponseEntity<String> getSolutionName() {
        String solutionName = solCoverheadService.getSolutionName();
        return ResponseEntity.ok(solutionName);
    }

    @GetMapping("/calculate-terms")
    public ResponseEntity<Map<String, Number>> calculateTerms(@RequestParam String productDefinition,
                                                              @RequestParam int pensionFlag,
                                                              @RequestParam String bookingFrequency,
                                                              @RequestParam Date dateOfBirth,
                                                              @RequestParam int vestingAge) {
        Map<String, Number> terms = solCoverheadService.calculateTerms(productDefinition, pensionFlag, bookingFrequency, dateOfBirth, vestingAge);
        return ResponseEntity.ok(terms);
    }

    @GetMapping("/process-records")
    public ResponseEntity<Void> processRecords() {
        solCoverheadService.processRecords();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/discount-type")
    public ResponseEntity<String> getDiscountType() {
        String discountType = solCoverheadService.determineDiscountType();
        return ResponseEntity.ok(discountType);
    }

    @GetMapping("/delete-beneficiary-trustee-rep")
    public ResponseEntity<Void> deleteBeneficiaryTrusteeRep(@RequestParam String contractId) {
        solCoverheadService.deleteBeneficiaryTrusteeRep(contractId);
        return ResponseEntity.ok().build();
    }
}
