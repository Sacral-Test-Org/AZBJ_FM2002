package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.DeclineRepository;
import com.azbj.fm2002.model.DeclineReason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclineService {

    @Autowired
    private DeclineRepository declineRepository;

    public List<String> fetchDistrictNames(String state) {
        return declineRepository.getDistrictNames(state);
    }

    public void updateFormStatus(String formId, String status) {
        declineRepository.updateFormStatus(formId, status);
    }

    public List<DeclineReason> fetchDeclineReasons() {
        return declineRepository.findDeclineReasons();
    }
}
