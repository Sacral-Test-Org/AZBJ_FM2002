package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.OldProductData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AzbjOtherInsurancePolicyRepository extends JpaRepository<OldProductData, Long> {

    @Query("SELECT new com.azbj.fm2002.model.OldProductData(p.companyName, p.policyName) FROM AzbjOtherInsurancePolicy p")
    List<OldProductData> findAll();
}
