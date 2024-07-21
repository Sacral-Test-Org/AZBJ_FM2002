package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.SpouseFinancialDetailsDTO;
import com.azbj.fm2002.dto.ProofTypeDTO;
import com.azbj.fm2002.service.SpouseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/spouse-details")
public class SpouseDetailsController {

    @Autowired
    private SpouseDetailsService spouseDetailsService;

    @PostMapping("/validate-dob")
    public ResponseEntity<?> validateDOB(@RequestBody Date dob) {
        var result = spouseDetailsService.validateDOB(dob);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/financial-details")
    public ResponseEntity<SpouseFinancialDetailsDTO> addSpouseFinancialDetails(@RequestBody SpouseFinancialDetailsDTO details) {
        var result = spouseDetailsService.addSpouseFinancialDetails(details);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/financial-details/{id}")
    public ResponseEntity<SpouseFinancialDetailsDTO> getSpouseFinancialDetails(@PathVariable Long id) {
        var result = spouseDetailsService.getSpouseFinancialDetails(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/financial-details")
    public ResponseEntity<SpouseFinancialDetailsDTO> updateSpouseFinancialDetails(@RequestBody SpouseFinancialDetailsDTO details) {
        var result = spouseDetailsService.updateSpouseFinancialDetails(details);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/proof-types")
    public ResponseEntity<List<ProofTypeDTO>> getProofTypes() {
        var result = spouseDetailsService.getProofTypes();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/proof-types")
    public ResponseEntity<Void> saveProofType(@RequestBody ProofTypeDTO proofType) {
        spouseDetailsService.saveProofType(proofType);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/calculate-net-profit")
    public ResponseEntity<Double> calculateNetProfit() {
        var result = spouseDetailsService.calculateNetProfit();
        return ResponseEntity.ok(result);
    }
}
