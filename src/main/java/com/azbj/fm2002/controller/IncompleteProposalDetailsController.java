package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.IncompleteProposalDetailsService;
import com.azbj.fm2002.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/incomplete-proposal-details")
public class IncompleteProposalDetailsController {

    @Autowired
    private IncompleteProposalDetailsService incompleteProposalDetailsService;

    @GetMapping("/records")
    public ResponseEntity<List<Record>> getExistingRecords() {
        List<Record> records = incompleteProposalDetailsService.fetchExistingRecords();
        return ResponseEntity.ok(records);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleError(Exception error) {
        return ResponseEntity.status(500).body("An error occurred: " + error.getMessage());
    }
}
