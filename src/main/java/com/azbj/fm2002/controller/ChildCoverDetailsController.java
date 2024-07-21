package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.ChildCoverDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/child-cover-details")
public class ChildCoverDetailsController {

    @Autowired
    private ChildCoverDetailsService childCoverDetailsService;

    @DeleteMapping("/delete/{recordId}")
    public ResponseEntity<Void> deleteChildCover(@PathVariable Long recordId) {
        childCoverDetailsService.deleteChildCover(recordId);
        return ResponseEntity.noContent().build();
    }
}
