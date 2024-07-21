package com.project.azbj_fm2002.controller;

import com.project.azbj_fm2002.service.SolCoversService;
import com.project.azbj_fm2002.model.SolCovers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/solcovers")
public class SolCoversController {

    @Autowired
    private SolCoversService solCoversService;

    @GetMapping("/all")
    public ResponseEntity<List<SolCovers>> getAllRecords() {
        List<SolCovers> records = solCoversService.getAllRecords();
        return ResponseEntity.ok(records);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateRecord(@RequestBody SolCovers record) {
        solCoversService.updateRecord(record);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateCovers")
    public ResponseEntity<List<SolCovers>> updateCovers() {
        List<SolCovers> updatedRecords = solCoversService.updateCovers();
        return ResponseEntity.ok(updatedRecords);
    }

    @PutMapping("/updateTerms")
    public ResponseEntity<Void> updateCovers(@RequestParam int benefitTerm, @RequestParam int premiumTerm) {
        solCoversService.updateCovers(benefitTerm, premiumTerm);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateRecord")
    public ResponseEntity<Void> updateRecord(@RequestBody SolCovers solCovers) {
        solCoversService.updateRecord(solCovers);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteRecord/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable String id) {
        solCoversService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
}
