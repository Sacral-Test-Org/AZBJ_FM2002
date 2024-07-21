package com.project.azbj_fm2002.controller;

import com.project.azbj_fm2002.service.FinancialUnderwritingService;
import com.project.azbj_fm2002.dto.FinancialUnderwritingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/financial-underwriting")
public class FinancialUnderwritingController {

    @Autowired
    private FinancialUnderwritingService financialUnderwritingService;

    @PostMapping("/save")
    public ResponseEntity<String> saveFinancialUnderwritingDetails(@RequestBody FinancialUnderwritingDTO financialUnderwritingDTO) {
        try {
            financialUnderwritingService.saveFinancialUnderwritingDetails(financialUnderwritingDTO);
            return new ResponseEntity<>("Financial underwriting details saved successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving financial underwriting details: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
