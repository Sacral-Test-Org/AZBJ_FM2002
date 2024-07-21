package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.AlertListRepository;
import com.azbj.fm2002.dto.AlertListValidationRequest;
import com.azbj.fm2002.dto.AlertListValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertListService {

    @Autowired
    private AlertListRepository alertListRepository;

    public AlertListValidationResponse validateOptions(AlertListValidationRequest request) {
        // Call the repository method to validate options
        AlertListValidationResponse response = alertListRepository.validateOptions(request);
        return response;
    }
}
