package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.NewBusinessRepository;
import com.azbj.fm2002.model.RelationshipDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewBusinessService {

    @Autowired
    private NewBusinessRepository newBusinessRepository;

    public void addRelationshipDetail(String relationshipDetail) {
        if (relationshipDetail != null && relationshipDetail.length() <= 25) {
            RelationshipDetail detail = new RelationshipDetail();
            detail.setDetail(relationshipDetail);
            newBusinessRepository.save(detail);
        } else {
            throw new IllegalArgumentException("Relationship detail must be non-null and up to 25 characters long.");
        }
    }

    public void updateRelationshipDetail(Long id, String relationshipDetail) {
        if (relationshipDetail != null && relationshipDetail.length() <= 25) {
            RelationshipDetail detail = newBusinessRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid relationship detail ID."));
            detail.setDetail(relationshipDetail);
            newBusinessRepository.save(detail);
        } else {
            throw new IllegalArgumentException("Relationship detail must be non-null and up to 25 characters long.");
        }
    }

    public List<RelationshipDetail> getRelationshipDetails() {
        return newBusinessRepository.findAll();
    }
}
