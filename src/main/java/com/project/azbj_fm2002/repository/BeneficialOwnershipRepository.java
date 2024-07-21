package com.project.azbj_fm2002.repository;

import com.project.azbj_fm2002.model.BeneficialOwnership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficialOwnershipRepository extends JpaRepository<BeneficialOwnership, Long> {

    @Modifying
    @Query("DELETE FROM BeneficialOwnership bo WHERE bo.contractId = :contractId")
    void deleteByContractId(@Param("contractId") String contractId);

    @Override
    <S extends BeneficialOwnership> List<S> saveAll(Iterable<S> entities);

    @Override
    <S extends BeneficialOwnership> S save(S entity);
}
