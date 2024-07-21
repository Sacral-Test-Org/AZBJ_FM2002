package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.ProbableCpService;
import com.azbj.fm2002.dto.PolicyDetailsDTO;
import com.azbj.fm2002.dto.ProbableCpDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/probable-cp")
public class ProbableCpController {

    @Autowired
    private ProbableCpService probableCpService;

    @GetMapping("/details")
    public ResponseEntity<List<ProbableCpDetails>> getProbableCpDetails() {
        List<ProbableCpDetails> probableCpDetails = probableCpService.getProbableCpDetails();
        return ResponseEntity.ok(probableCpDetails);
    }

    @GetMapping("/policy-details/{insuredPersonId}")
    public ResponseEntity<PolicyDetailsDTO> getPolicyDetails(@PathVariable String insuredPersonId) {
        PolicyDetailsDTO policyDetails = probableCpService.getPolicyDetails(insuredPersonId);
        return ResponseEntity.ok(policyDetails);
    }
}
