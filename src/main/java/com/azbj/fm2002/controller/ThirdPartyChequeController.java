package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.ThirdPartyChequeService;
import com.azbj.fm2002.dto.ThirdPartyChequeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/third-party-cheque")
public class ThirdPartyChequeController {

    @Autowired
    private ThirdPartyChequeService thirdPartyChequeService;

    @PostMapping("/manage")
    public ResponseEntity<ThirdPartyChequeDTO> manageThirdPartyChequeDetails(@RequestBody ThirdPartyChequeDTO thirdPartyChequeDTO) {
        ThirdPartyChequeDTO result = thirdPartyChequeService.manageThirdPartyChequeDetails(thirdPartyChequeDTO);
        return ResponseEntity.ok(result);
    }
}
