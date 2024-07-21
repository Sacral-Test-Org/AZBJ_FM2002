package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.BiReportRequest;
import com.azbj.fm2002.dto.BiReportResponse;
import com.azbj.fm2002.dto.GstCalculationRequest;
import com.azbj.fm2002.dto.GstCalculationResponse;
import com.azbj.fm2002.service.AzbjCoDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/azbj-co-details")
public class AzbjCoDetailsController {

    @Autowired
    private AzbjCoDetailsService azbjCoDetailsService;

    @PostMapping("/generate-bi-report")
    public ResponseEntity<BiReportResponse> generateBiReport(@RequestBody BiReportRequest request) {
        BiReportResponse response = azbjCoDetailsService.generateBiReport(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/calculate-gst")
    public ResponseEntity<GstCalculationResponse> calculateGst(@RequestBody GstCalculationRequest request) {
        GstCalculationResponse response = azbjCoDetailsService.calculateGst(request);
        return ResponseEntity.ok(response);
    }
}
