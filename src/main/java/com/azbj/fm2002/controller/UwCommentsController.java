package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.UwCommentsService;
import com.azbj.fm2002.dto.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UwCommentsController {

    @Autowired
    private UwCommentsService uwCommentsService;

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> fetchComments(@RequestParam String contractId) {
        List<Comment> comments = uwCommentsService.getComments(contractId);
        return ResponseEntity.ok(comments);
    }
}
