package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.RelationshipDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewBusinessRepository extends JpaRepository<RelationshipDetail, Long> {
    // Method to add new relationship detail
    default RelationshipDetail addRelationshipDetail(String relationshipDetail) {
        RelationshipDetail newDetail = new RelationshipDetail();
        newDetail.setDetail(relationshipDetail);
        return save(newDetail);
    }

    // Method to update existing relationship detail
    default RelationshipDetail updateRelationshipDetail(Long id, String relationshipDetail) {
        RelationshipDetail existingDetail = findById(id).orElseThrow(() -> new RuntimeException("Detail not found"));
        existingDetail.setDetail(relationshipDetail);
        return save(existingDetail);
    }

    // Method to fetch all relationship details
    default List<RelationshipDetail> getRelationshipDetails() {
        return findAll();
    }
}
