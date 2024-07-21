package com.project.azbj_fm2002.controller;

import com.project.azbj_fm2002.service.PolicyRiskService;
import com.project.azbj_fm2002.dto.PolicyRiskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/policy-risk")
public class PolicyRiskController {

    @Autowired
    private PolicyRiskService policyRiskService;

    @PostMapping("/save")
    public ResponseEntity<String> savePolicyRiskDetails(@RequestBody PolicyRiskDTO policyRiskDTO) {
        policyRiskService.savePolicyRiskDetails(policyRiskDTO);
        return ResponseEntity.ok("Policy risk details saved successfully.");
    }
}
