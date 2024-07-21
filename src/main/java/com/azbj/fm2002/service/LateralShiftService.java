package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.AzbjOtherInsurancePolicyRepository;
import com.azbj.fm2002.model.OldProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LateralShiftService {

    @Autowired
    private AzbjOtherInsurancePolicyRepository repository;

    public List<OldProductData> fetchOldProductData() {
        return repository.findAll();
    }
}
