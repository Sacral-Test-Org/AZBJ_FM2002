package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.SurrogateProofDetailsRepository;
import com.azbj.fm2002.dto.SurrogateProofDetailsDTO;
import com.azbj.fm2002.entity.SurrogateProofDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurrogateProofDetailsService {

    @Autowired
    private SurrogateProofDetailsRepository surrogateProofDetailsRepository;

    public SurrogateProofDetailsEntity saveSurrogateProofDetails(SurrogateProofDetailsDTO surrogateProofDetailsDTO) {
        // Convert DTO to Entity
        SurrogateProofDetailsEntity entity = new SurrogateProofDetailsEntity();
        entity.setSurrogateProofType(surrogateProofDetailsDTO.getSurrogateProofType());
        entity.setProofDescription(surrogateProofDetailsDTO.getProofDescription());
        entity.setFieldValue(surrogateProofDetailsDTO.getFieldValue());
        entity.setDocumentDate(surrogateProofDetailsDTO.getDocumentDate());
        entity.setDerivedIncome(surrogateProofDetailsDTO.getDerivedIncome());
        entity.setDerivedTasaValue(surrogateProofDetailsDTO.getDerivedTasaValue());

        // Save entity using repository
        return surrogateProofDetailsRepository.save(entity);
    }
}
