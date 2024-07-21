package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.UnderwriterService;
import com.azbj.fm2002.dto.UnderwriterValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnderwriterController {

    @Autowired
    private UnderwriterService underwriterService;

    @GetMapping("/validateUnderwriter")
    public UnderwriterValidationResponse validateUnderwriter(@RequestParam String underwriterId) {
        return underwriterService.validateUnderwriter(underwriterId);
    }
}
