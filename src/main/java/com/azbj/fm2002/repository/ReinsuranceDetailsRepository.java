package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.ReinsuranceDetails;
import com.azbj.fm2002.model.ReinsurerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReinsuranceDetailsRepository extends JpaRepository<ReinsuranceDetails, Long> {

    // Fetch all reinsurance details
    List<ReinsuranceDetails> findAll();

    // Fetch data for calculations
    @Query("SELECT rd FROM ReinsuranceDetails rd")
    List<Object> fetchData();

    // Fetch all reinsurer details
    List<ReinsurerDetails> findAllReinsurerDetails();

    // Save reinsurer details
    ReinsurerDetails save(ReinsurerDetails reinsurerDetails);

    // Save reinsurance details
    ReinsuranceDetails save(ReinsuranceDetails reinsuranceDetails);

    // Delete record by ID
    void deleteById(Long recordId);

    // Find reinsurer codes based on reinsurance type and product ID
    @Query("SELECT r.reinsurerCode FROM ReinsurerDetails r WHERE r.reinsuranceType = ?1 AND r.productId = ?2")
    List<String> findReinsurerCodes(String reinsuranceType, String productId);
}