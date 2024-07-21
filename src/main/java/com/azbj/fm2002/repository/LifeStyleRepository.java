package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.LifeStyleUpdateRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LifeStyleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void updateStatus(LifeStyleUpdateRequest request) {
        String updatePrimaryStatusQuery = "UPDATE LIFE_STYLE_RAD SET PRIMARY_LIFESTYLE_GROUP_STATUS = 'N' " +
                "WHERE PRODUCT_ID = 345 AND PRIMARY_LIFESTYLE_GROUP_STATUS = 'P' AND CONTRACT_ID = :contractId";
        String updateSecondaryStatusQuery = "UPDATE LIFE_STYLE_RAD SET SECONDARY_LIFESTYLE_GROUP_STATUS = 'N' " +
                "WHERE PRODUCT_ID = 345 AND SECONDARY_LIFESTYLE_GROUP_STATUS = 'P' AND CONTRACT_ID = :contractId";

        entityManager.createQuery(updatePrimaryStatusQuery)
                .setParameter("contractId", request.getContractId())
                .executeUpdate();

        entityManager.createQuery(updateSecondaryStatusQuery)
                .setParameter("contractId", request.getContractId())
                .executeUpdate();
    }
}
