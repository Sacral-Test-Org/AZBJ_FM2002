package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.ProductIdRequest;
import com.azbj.fm2002.dto.ProductIdResponse;
import com.azbj.fm2002.dto.ReceiptStatus;
import com.azbj.fm2002.service.WNrMedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wnrmed")
public class WNrMedController {

    @Autowired
    private WNrMedService wNrMedService;

    @PostMapping("/setInsurancePolicyType")
    public ProductIdResponse setInsurancePolicyType(@RequestBody ProductIdRequest productIdRequest) {
        return wNrMedService.setInsurancePolicyType(productIdRequest.getProductId());
    }

    @PostMapping("/updateReceiptStatus")
    public ResponseEntity<Void> updateReceiptStatus(@RequestBody ReceiptStatus receiptStatus) {
        wNrMedService.updateReceiptStatus(receiptStatus);
        return ResponseEntity.ok().build();
    }
}
