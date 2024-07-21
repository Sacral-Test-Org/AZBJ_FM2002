package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.UnderwritingLimitsService;
import com.azbj.fm2002.model.UnderwritingLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/underwriting-limits")
public class UnderwritingLimitsController {

    @Autowired
    private UnderwritingLimitsService underwritingLimitsService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<UnderwritingLimit>> getUnderwritingLimits(@PathVariable String userId) {
        try {
            List<UnderwritingLimit> limits = underwritingLimitsService.getUnderwritingLimits(userId);
            return ResponseEntity.ok(limits);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
