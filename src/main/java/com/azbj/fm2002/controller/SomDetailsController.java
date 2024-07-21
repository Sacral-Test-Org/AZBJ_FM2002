package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.SomDetailsService;
import com.azbj.fm2002.dto.HubInchargeDetailsDTO;
import com.azbj.fm2002.dto.SomDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/som-details")
public class SomDetailsController {

    @Autowired
    private SomDetailsService somDetailsService;

    @GetMapping("/fetch")
    public ResponseEntity<List<SomDetails>> fetchSomDetails() {
        List<SomDetails> somDetails = somDetailsService.getSomDetails();
        return ResponseEntity.ok(somDetails);
    }

    @GetMapping("/validate-flag")
    public ResponseEntity<Boolean> validateFlag() {
        boolean isValid = somDetailsService.validateFlag();
        return ResponseEntity.ok(isValid);
    }

    @GetMapping("/update-proposal-status")
    public ResponseEntity<Void> updateProposalStatus() {
        somDetailsService.updateProposalStatus();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hub-incharge-details")
    public ResponseEntity<HubInchargeDetailsDTO> getHubInchargeDetails(@RequestParam String branchCode, @RequestParam String applicationNo) {
        HubInchargeDetailsDTO hubInchargeDetails = somDetailsService.getHubInchargeDetails(branchCode, applicationNo);
        return ResponseEntity.ok(hubInchargeDetails);
    }
}
