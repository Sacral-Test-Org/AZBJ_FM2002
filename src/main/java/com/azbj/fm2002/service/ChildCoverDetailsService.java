package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.ChildCoverDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildCoverDetailsService {

    @Autowired
    private ChildCoverDetailsRepository childCoverDetailsRepository;

    public void deleteChildCover(Long recordId) {
        childCoverDetailsRepository.deleteById(recordId);
    }
}
