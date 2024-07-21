package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.CommissionDetailsService;
import com.azbj.fm2002.model.CommissionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommissionDetailsController {

    @Autowired
    private CommissionDetailsService commissionDetailsService;

    @GetMapping("/commission-details")
    public CommissionDetails getCommissionDetails(@RequestParam String agentCode) {
        return commissionDetailsService.getCommissionDetails(agentCode);
    }
}
