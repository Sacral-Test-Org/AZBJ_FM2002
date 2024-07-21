package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.NewBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/new-business")
public class NewBusinessController {

    @Autowired
    private NewBusinessService newBusinessService;

    @PostMapping("/relationship-detail")
    public ResponseEntity<?> addRelationshipDetail(@RequestBody String relationshipDetail) {
        newBusinessService.addRelationshipDetail(relationshipDetail);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/relationship-detail/{id}")
    public ResponseEntity<?> updateRelationshipDetail(@PathVariable Long id, @RequestBody String relationshipDetail) {
        newBusinessService.updateRelationshipDetail(id, relationshipDetail);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/relationship-details")
    public ResponseEntity<List<String>> getRelationshipDetails() {
        List<String> details = newBusinessService.getRelationshipDetails();
        return ResponseEntity.ok(details);
    }
}
