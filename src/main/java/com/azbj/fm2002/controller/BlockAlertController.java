package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.BlockAlertValidationRequest;
import com.azbj.fm2002.dto.BlockAlertValidationResponse;
import com.azbj.fm2002.service.BlockAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/block-alert")
public class BlockAlertController {

    @Autowired
    private BlockAlertService blockAlertService;

    @PostMapping("/validate-conditions")
    public BlockAlertValidationResponse validateConditions(@RequestBody BlockAlertValidationRequest request) {
        return blockAlertService.validateConditions(request);
    }

    @GetMapping("/unitlink/{cn_product_id}")
    public String getUnitlinkValue(@PathVariable String cn_product_id) {
        return blockAlertService.unitlink(cn_product_id);
    }

    @PostMapping("/validate-radio-dispatch")
    public BlockAlertValidationResponse validateRadioDispatch(@RequestBody BlockAlertValidationRequest request) {
        return blockAlertService.validateConditions(request);
    }

    @PostMapping("/update-policy-status")
    public void updatePolicyStatus(@RequestBody BlockAlertValidationRequest request) {
        blockAlertService.updateStatus(request);
    }

    @PostMapping("/validate-backdation")
    public boolean validateBackdation(@RequestBody boolean backdationOption) {
        return blockAlertService.validateBackdation(backdationOption);
    }

    @PostMapping("/validate-proceed-button")
    public BlockAlertValidationResponse validateProceedButton(@RequestBody BlockAlertValidationRequest request) {
        return blockAlertService.validateProceedButton(request);
    }
}
