package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.AzbjRpErrAppRepository;
import com.azbj.fm2002.model.FormData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AzbjRpErrAppService {

    @Autowired
    private AzbjRpErrAppRepository azbjRpErrAppRepository;

    public void processForm(FormData formData) {
        // Call the repository method to save the form data
        azbjRpErrAppRepository.saveFormData(formData);
    }
}
