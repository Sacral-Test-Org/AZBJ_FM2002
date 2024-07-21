package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.SurrogateProofDetailsDTO;
import com.azbj.fm2002.entity.SurrogateProofDetailsEntity;

public class SurrogateProofDetailsUtil {

    public static SurrogateProofDetailsEntity convertDtoToEntity(SurrogateProofDetailsDTO dto) {
        if (dto == null) {
            return null;
        }
        SurrogateProofDetailsEntity entity = new SurrogateProofDetailsEntity();
        entity.setSurrogateProofType(dto.getSurrogateProofType());
        entity.setProofDescription(dto.getProofDescription());
        entity.setFieldValue(dto.getFieldValue());
        entity.setDocumentDate(dto.getDocumentDate());
        entity.setDerivedIncome(dto.getDerivedIncome());
        entity.setDerivedTasaValue(dto.getDerivedTasaValue());
        return entity;
    }

    public static SurrogateProofDetailsDTO convertEntityToDto(SurrogateProofDetailsEntity entity) {
        if (entity == null) {
            return null;
        }
        SurrogateProofDetailsDTO dto = new SurrogateProofDetailsDTO();
        dto.setSurrogateProofType(entity.getSurrogateProofType());
        dto.setProofDescription(entity.getProofDescription());
        dto.setFieldValue(entity.getFieldValue());
        dto.setDocumentDate(entity.getDocumentDate());
        dto.setDerivedIncome(entity.getDerivedIncome());
        dto.setDerivedTasaValue(entity.getDerivedTasaValue());
        return dto;
    }
}