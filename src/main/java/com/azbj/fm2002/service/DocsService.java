package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.DocsRepository;
import com.azbj.fm2002.dto.RejectedApplicationReasonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocsService {

    @Autowired
    private DocsRepository docsRepository;

    public List<RejectedApplicationReasonDTO> getRejectedApplicationReasons(String applicationNo, String alternateReq) {
        return docsRepository.findRejectedApplicationReasons(applicationNo, alternateReq);
    }
}
