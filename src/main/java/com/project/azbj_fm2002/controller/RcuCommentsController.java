package com.project.azbj_fm2002.controller;

import com.project.azbj_fm2002.service.RcuCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/rcu-comments")
public class RcuCommentsController {

    @Autowired
    private RcuCommentsService rcuCommentsService;

    @PostMapping("/get")
    public ResponseEntity<?> getRcuComments(@RequestBody Map<String, Object> params) {
        return rcuCommentsService.getRcuComments(params);
    }
}
