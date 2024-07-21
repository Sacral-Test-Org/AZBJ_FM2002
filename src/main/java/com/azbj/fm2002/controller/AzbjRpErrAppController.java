package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.AzbjRpErrAppService;
import com.azbj.fm2002.model.FormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/form")
public class AzbjRpErrAppController {

    @Autowired
    private AzbjRpErrAppService azbjRpErrAppService;

    @PostMapping("/handle")
    public ResponseEntity<Void> handleForm(@RequestBody FormData formData) {
        azbjRpErrAppService.processForm(formData);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
