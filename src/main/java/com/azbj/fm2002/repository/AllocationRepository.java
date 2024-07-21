package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.DiscountType;
import com.azbj.fm2002.model.FundDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AllocationRepository extends JpaRepository<FundDetails, String> {

    @Query("UPDATE FundDetails f SET f.allocation = :allocation WHERE f.id = :id")
    void updateAllocations(@Param("id") String id, @Param("allocation") String allocation);

    @Query("DELETE FROM FundDetails f WHERE f.id = :fundId")
    void deleteById(@Param("fundId") String fundId);

    @Query("SELECT d FROM DiscountType d WHERE d.type = :discountType")
    Optional<DiscountType> findByDiscountType(@Param("discountType") String discountType);

    @Query("SELECT f FROM FundDetails f WHERE f.portfolioStrategy = :portfolioStrategy AND f.productId = :productId")
    List<FundDetails> findFundDetails(@Param("portfolioStrategy") String portfolioStrategy, @Param("productId") String productId);

    @Query("SELECT f FROM FundDetails f WHERE f.portfolioStrategy = :portfolioStrategy AND f.productId = :productId")
    List<FundDetails> autoPopulateFunds(@Param("portfolioStrategy") String portfolioStrategy, @Param("productId") int productId);
}
