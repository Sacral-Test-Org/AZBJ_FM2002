package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.DeclineService;
import com.azbj.fm2002.model.DeclineReason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/decline")
public class DeclineController {

    @Autowired
    private DeclineService declineService;

    @GetMapping("/districts")
    public List<String> getDistrictNames(@RequestParam String state) {
        return declineService.fetchDistrictNames(state);
    }

    @PutMapping("/form-status/{formId}")
    public void updateFormStatus(@PathVariable String formId, @RequestParam String status) {
        declineService.updateFormStatus(formId, status);
    }

    @GetMapping("/reasons")
    public List<DeclineReason> getDeclineReasons() {
        return declineService.fetchDeclineReasons();
    }
}
