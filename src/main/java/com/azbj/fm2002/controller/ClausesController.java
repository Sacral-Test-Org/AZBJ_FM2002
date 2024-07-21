package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.ClausesService;
import com.azbj.fm2002.model.Clause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clauses")
public class ClausesController {

    @Autowired
    private ClausesService clausesService;

    @GetMapping
    public ResponseEntity<List<Clause>> getClauses() {
        try {
            List<Clause> clauses = clausesService.getClauses();
            return ResponseEntity.ok(clauses);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
