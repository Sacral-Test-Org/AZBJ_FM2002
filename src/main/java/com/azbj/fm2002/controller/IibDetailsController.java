package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.IibDetailsService;
import com.azbj.fm2002.model.IibDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class IibDetailsController {

    @Autowired
    private IibDetailsService iibDetailsService;

    @GetMapping("/iib-matched-details")
    public List<IibDetails> getIibMatchedDetails(@RequestParam String transactionId) {
        return iibDetailsService.getIibMatchedDetails(transactionId);
    }
}
