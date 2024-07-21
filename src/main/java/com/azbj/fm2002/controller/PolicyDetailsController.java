package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.PolicyDetailsService;
import com.azbj.fm2002.dto.PreviousPolicyDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/policies")
public class PolicyDetailsController {

    private static final Logger logger = LogManager.getLogger(PolicyDetailsController.class);

    @Autowired
    private PolicyDetailsService policyDetailsService;

    @GetMapping("/previous/{customerId}")
    public ResponseEntity<PreviousPolicyDetailsDTO> getPreviousPolicyDetails(@PathVariable String customerId) {
        try {
            PreviousPolicyDetailsDTO previousPolicyDetails = policyDetailsService.getPreviousPolicyDetails(customerId);
            return new ResponseEntity<>(previousPolicyDetails, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error fetching previous policy details for customer ID: " + customerId, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
