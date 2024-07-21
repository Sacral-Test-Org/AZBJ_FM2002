package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.PanApprovalService;
import com.azbj.fm2002.dto.PanApprovalDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/pan-approval")
public class PanApprovalController {

    @Autowired
    private PanApprovalService panApprovalService;

    @PostMapping("/save-approval-status")
    public void saveApprovalStatus(@RequestBody String approvalStatus) {
        panApprovalService.saveApprovalStatus(approvalStatus);
    }

    @GetMapping("/details")
    public ResponseEntity<List<PanApprovalDetailsDTO>> getPanApprovalDetails(HttpServletRequest request) {
        String applicationNumber = request.getParameter("applicationNumber");
        List<PanApprovalDetailsDTO> details = panApprovalService.getPanApprovalDetails(applicationNumber);
        return ResponseEntity.ok(details);
    }
}
