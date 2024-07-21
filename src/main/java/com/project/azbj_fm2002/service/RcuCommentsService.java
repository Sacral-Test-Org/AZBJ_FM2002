package com.project.azbj_fm2002.service;

import com.project.azbj_fm2002.repository.RcuCommentsRepository;
import com.project.azbj_fm2002.model.RcuComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RcuCommentsService {

    @Autowired
    private RcuCommentsRepository rcuCommentsRepository;

    public List<RcuComments> getRcuComments(Map<String, Object> params) {
        String policyNo = (String) params.get("POLICY_NO");
        String moduleName = (String) params.get("MODULE_NAME");

        // Fetch the RCU comments based on the provided parameters
        return rcuCommentsRepository.findByPolicyNoAndModuleName(policyNo, moduleName);
    }
}
