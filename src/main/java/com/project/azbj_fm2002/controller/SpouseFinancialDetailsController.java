package com.project.azbj_fm2002.controller;

import com.project.azbj_fm2002.service.SpouseFinancialDetailsService;
import com.project.azbj_fm2002.dto.SpouseFinancialDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/spouse-financial-details")
public class SpouseFinancialDetailsController {

    @Autowired
    private SpouseFinancialDetailsService spouseFinancialDetailsService;

    @PostMapping("/save")
    public ResponseEntity<String> saveSpouseFinancialDetails(@RequestBody SpouseFinancialDetailsDTO spouseFinancialDetailsDTO) {
        spouseFinancialDetailsService.saveSpouseFinancialDetails(spouseFinancialDetailsDTO);
        return ResponseEntity.ok("Spouse financial details saved successfully.");
    }
}
