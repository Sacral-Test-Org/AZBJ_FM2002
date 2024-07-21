package com.azbj.fm2002.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadingsRepository extends JpaRepository<Loading, Long> {

    @Query("SELECT l.loadingType FROM Loading l WHERE l.productId = :productId")
    String findLoadingType(@Param("productId") String productId);

    @Query("UPDATE Loading l SET l.loadingType = :loadingType WHERE l.coverCode = :coverCode")
    void updateLoadingType(@Param("loadingType") String loadingType, @Param("coverCode") String coverCode);

    @Query("SELECT pd FROM ProductDefinition pd WHERE pd.productDefinition = :productDefinition")
    ProductDefinition findProductDefinition(@Param("productDefinition") String productDefinition);
}
