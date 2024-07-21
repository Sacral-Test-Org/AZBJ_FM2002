package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.LifeStyleUpdateRequest;
import com.azbj.fm2002.dto.LifeStyleUpdateResponse;
import com.azbj.fm2002.service.LifeStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lifestyle")
public class LifeStyleController {

    @Autowired
    private LifeStyleService lifeStyleService;

    @PostMapping("/update-status")
    public LifeStyleUpdateResponse updateLifestyleStatus(@RequestBody LifeStyleUpdateRequest request) {
        return lifeStyleService.updateStatus(request);
    }
}
