package com.azbj.fm2002.service;

import com.azbj.fm2002.dto.NavigationRequest;
import com.azbj.fm2002.dto.NavigationResponse;
import com.azbj.fm2002.repository.BbuImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbuImageService {

    @Autowired
    private BbuImageRepository bbuImageRepository;

    public NavigationResponse handleHideQuestions(NavigationRequest request) {
        NavigationResponse response = new NavigationResponse();
        try {
            boolean isItemEnabled = bbuImageRepository.getItemStatus(request.getItemId());
            if (isItemEnabled) {
                response.setNavigationTarget(request.getItemId());
            } else {
                response.setNavigationTarget("COVERS_DEFAULT_ITEM");
            }
        } catch (Exception e) {
            response.setNavigationTarget(request.getItemId());
        }
        return response;
    }
}
