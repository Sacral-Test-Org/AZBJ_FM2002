package com.project.azbj_fm2002.controller;

import com.project.azbj_fm2002.service.LiquidInvestmentService;
import com.project.azbj_fm2002.dto.LiquidInvestmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/liquid-investment")
public class LiquidInvestmentController {

    @Autowired
    private LiquidInvestmentService liquidInvestmentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveLiquidInvestmentDetails(@RequestBody LiquidInvestmentDTO liquidInvestmentDTO) {
        try {
            liquidInvestmentService.saveLiquidInvestmentDetails(liquidInvestmentDTO);
            return ResponseEntity.ok("Liquid investment details saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving liquid investment details: " + e.getMessage());
        }
    }
}
