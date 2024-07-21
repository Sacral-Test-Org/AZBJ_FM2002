package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.EndMovement1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndMovement1Service {

    @Autowired
    private EndMovement1Repository repository;

    public boolean validateAgentCode(String agentCode) {
        // Validate the agent code against specific patterns
        String pattern = "^[A-Z]{3}[0-9]{3}$"; // Example pattern: 3 letters followed by 3 digits
        return agentCode.matches(pattern);
    }

    public void navigateAndValidate(String action) {
        if ("SE".equals(action)) {
            // Navigate through different blocks and validate the status of requirements
            // Display messages if any status is invalid or missing
            // Example logic (pseudo-code):
            // if (blockStatusInvalid) {
            //     displayMessage("Invalid status in block");
            // }
        }
    }

    public void insertComments(String comments) {
        // Insert comments into the database
        repository.insertComments(comments);
    }

    public void updateProposalStatus(String status) {
        // Update the proposal status in the database
        repository.updateProposalStatus(status);
    }

    public void updateUserProfiles(UserProfile userProfile) {
        // Update user profiles in the database
        repository.updateUserProfiles(userProfile);
    }

    public void deleteComments(Long commentId) {
        // Delete specific comments from the database
        repository.deleteComments(commentId);
    }
}
