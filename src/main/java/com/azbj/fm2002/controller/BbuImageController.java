package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.NavigationRequest;
import com.azbj.fm2002.dto.NavigationResponse;
import com.azbj.fm2002.service.BbuImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bbu-image")
public class BbuImageController {

    @Autowired
    private BbuImageService bbuImageService;

    @PostMapping("/hide-questions")
    public ResponseEntity<NavigationResponse> hideQuestions(@RequestBody NavigationRequest request) {
        try {
            NavigationResponse response = bbuImageService.handleHideQuestions(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            NavigationResponse response = new NavigationResponse();
            response.setTargetItem(request.getSpecifiedItem());
            return ResponseEntity.ok(response);
        }
    }
}
