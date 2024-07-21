package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.FamilyHistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/family-history")
public class FamilyHistController {

    @Autowired
    private FamilyHistService familyHistService;

    @DeleteMapping("/delete-member/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        familyHistService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}
