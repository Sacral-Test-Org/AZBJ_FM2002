package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.AlertListService;
import com.azbj.fm2002.dto.AlertListValidationRequest;
import com.azbj.fm2002.dto.AlertListValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alert-list")
public class AlertListController {

    @Autowired
    private AlertListService alertListService;

    @PostMapping("/validate-options")
    public AlertListValidationResponse validateOptions(@RequestBody AlertListValidationRequest request) {
        return alertListService.validateOptions(request);
    }
}
