package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.SecFrarReqService;
import com.azbj.fm2002.dto.SecFrarReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/frar")
public class SecFrarReqController {

    @Autowired
    private SecFrarReqService secFrarReqService;

    @GetMapping("/requirements")
    public ResponseEntity<List<SecFrarReqDTO>> getFrarRequirements() {
        List<SecFrarReqDTO> requirements = secFrarReqService.getFrarRequirements();
        return ResponseEntity.ok(requirements);
    }

    @PostMapping("/comments")
    public ResponseEntity<String> saveComments(@RequestBody String comments) {
        secFrarReqService.saveComments(comments);
        return ResponseEntity.ok("Comments saved successfully");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestParam String supervisorId, @RequestParam String password) {
        boolean isAuthenticated = secFrarReqService.authenticate(supervisorId, password);
        if (isAuthenticated) {
            return ResponseEntity.ok("Authenticated successfully");
        } else {
            return ResponseEntity.status(401).body("Authentication failed");
        }
    }

    @GetMapping("/reason-description")
    public ResponseEntity<String> getReasonDescription(@RequestParam int reason) {
        String description = secFrarReqService.getReasonDescription(reason);
        return ResponseEntity.ok(description);
    }

    @PostMapping("/approve")
    public ResponseEntity<String> approveRequest(@RequestBody SecFrarReqDTO secFrarReqDTO) {
        boolean isApproved = secFrarReqService.approveRequest(secFrarReqDTO);
        if (isApproved) {
            return ResponseEntity.ok("Approved");
        } else {
            return ResponseEntity.status(400).body("Approval failed");
        }
    }
}
