package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.EndMovement1Service;
import com.azbj.fm2002.model.EndMovement1Request;
import com.azbj.fm2002.model.EndMovement1Response;
import com.azbj.fm2002.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/end-movement1")
public class EndMovement1Controller {

    @Autowired
    private EndMovement1Service endMovement1Service;

    @PostMapping("/ok-button")
    public ResponseEntity<EndMovement1Response> handleOkButtonClick(@RequestBody EndMovement1Request request) {
        boolean isAgentCodeValid = endMovement1Service.validateAgentCode(request.getAgentCode());
        if (!isAgentCodeValid) {
            return ResponseEntity.badRequest().body(new EndMovement1Response("Invalid agent code"));
        }

        try {
            if ("SE".equals(request.getAction())) {
                endMovement1Service.navigateAndValidate(request.getAction());
                endMovement1Service.insertComments(request.getComments());
                endMovement1Service.updateProposalStatus(request.getStatus());
            } else if ("CE".equals(request.getAction())) {
                endMovement1Service.updateUserProfiles(request.getUserProfile());
                endMovement1Service.deleteComments(request.getCommentId());
            }

            // Suspend current work-in-progress if necessary
            // This is a placeholder for the actual suspension logic

            return ResponseEntity.ok(new EndMovement1Response("Action completed successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new EndMovement1Response("An error occurred: " + e.getMessage()));
        }
    }
}
