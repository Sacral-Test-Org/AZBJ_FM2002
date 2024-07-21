package com.azbj.fm2002.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.azbj.fm2002.repository.LanguageRepository;

@Component
public class LanguageUtil {

    @Autowired
    private LanguageRepository languageRepository;

    public boolean validateLanguageId(Long languageId) {
        if (languageId == null) {
            return false;
        }
        return languageRepository.existsById(languageId);
    }
}
