package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.SurrogateProofDetailsService;
import com.azbj.fm2002.dto.SurrogateProofDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/surrogate-proof-details")
public class SurrogateProofDetailsController {

    @Autowired
    private SurrogateProofDetailsService surrogateProofDetailsService;

    @PostMapping("/save")
    public ResponseEntity<String> saveSurrogateProofDetails(@RequestBody SurrogateProofDetailsDTO surrogateProofDetailsDTO) {
        return surrogateProofDetailsService.saveSurrogateProofDetails(surrogateProofDetailsDTO);
    }
}
