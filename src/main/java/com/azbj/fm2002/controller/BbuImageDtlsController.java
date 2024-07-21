package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.BbuImageDtlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bbu-image-dtls")
public class BbuImageDtlsController {

    @Autowired
    private BbuImageDtlsService bbuImageDtlsService;

    @PostMapping("/validate-answer")
    public ResponseEntity<String> validateAnswer(@RequestBody String answer) {
        try {
            bbuImageDtlsService.validateAnswer(answer);
            return new ResponseEntity<>("Answer processed successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while processing the answer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
