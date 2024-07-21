package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.UnderwriterRepository;
import com.azbj.fm2002.model.Underwriter;
import com.azbj.fm2002.dto.UnderwriterValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnderwriterService {

    @Autowired
    private UnderwriterRepository underwriterRepository;

    public UnderwriterValidationResponse validateUnderwriter(String underwriterId, String currentUserId) {
        UnderwriterValidationResponse response = new UnderwriterValidationResponse();

        // Check if the underwriterId is exactly 8 characters long
        if (underwriterId.length() != 8) {
            response.setValid(false);
            response.setMessage("Underwriter ID must be exactly 8 characters long.");
            return response;
        }

        // Check if the underwriterId is the same as the current user
        if (underwriterId.equals(currentUserId)) {
            response.setValid(false);
            response.setMessage("Selected underwriter cannot be the same as the current user.");
            return response;
        }

        // Check if the underwriter exists in the list of underwriters
        Optional<Underwriter> underwriter = underwriterRepository.findUnderwriterById(underwriterId);
        if (!underwriter.isPresent()) {
            response.setValid(false);
            response.setMessage("Selected underwriter does not exist.");
            return response;
        }

        // If all checks pass
        response.setValid(true);
        response.setMessage("Case will be forwarded to the selected underwriter.");
        return response;
    }
}
