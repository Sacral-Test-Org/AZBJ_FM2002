package com.azbj.fm2002.service;

import com.azbj.fm2002.dto.LifeStyleUpdateRequest;
import com.azbj.fm2002.repository.LifeStyleRepository;
import com.azbj.fm2002.util.LifeStyleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LifeStyleService {

    @Autowired
    private LifeStyleRepository lifeStyleRepository;

    @Autowired
    private LifeStyleUtil lifeStyleUtil;

    public void updateStatus(LifeStyleUpdateRequest request) {
        if (request.getProductId() == 345) {
            boolean isUpdated = false;
            if ("P".equals(request.getPrimaryStatus())) {
                request.setPrimaryStatus("N");
                isUpdated = true;
            }
            if ("P".equals(request.getSecondaryStatus())) {
                request.setSecondaryStatus("N");
                isUpdated = true;
            }
            if (isUpdated) {
                lifeStyleRepository.updateStatus(request);
                lifeStyleUtil.logChanges(request.getContractId(), request.getVerificationNumber(), request.getPrimaryStatus(), request.getSecondaryStatus());
            }
        }
    }
}
