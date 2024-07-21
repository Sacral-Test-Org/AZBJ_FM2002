package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.DocsService;
import com.azbj.fm2002.dto.RejectedApplicationReasonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocsController {

    @Autowired
    private DocsService docsService;

    @GetMapping("/rejected-reasons")
    public List<RejectedApplicationReasonDTO> getRejectedApplicationReasons(@RequestParam String applicationNo, @RequestParam String alternateReq) {
        return docsService.getRejectedApplicationReasons(applicationNo, alternateReq);
    }
}
