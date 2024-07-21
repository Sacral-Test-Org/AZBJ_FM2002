package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.ReinsurerCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReinsurerSelectionRepository extends JpaRepository<ReinsurerCode, Long> {

    @Query("SELECT r.reinsurerCode FROM ReinsurerCode r WHERE r.reinsuranceType = NVL(:reinsuranceType, 'AUTO') AND r.productId = :productId AND r.coverCode = :coverCode")
    List<ReinsurerCode> findReinsurerCodes(@Param("reinsuranceType") String reinsuranceType, 
                                           @Param("productId") String productId, 
                                           @Param("coverCode") String coverCode);

    void deleteById(Long recordId);
}
