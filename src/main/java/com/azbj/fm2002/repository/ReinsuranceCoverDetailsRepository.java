package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.CoverCodeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReinsuranceCoverDetailsRepository extends JpaRepository<ReinsuranceCoverDetails, Long> {

    @Query("SELECT new com.azbj.fm2002.dto.CoverCodeDTO(b.coverCode, c.coverDescription) " +
            "FROM AzbjPackageMaster a, AzbjPackageCovers b, CfgVProdCoversApi c " +
            "WHERE a.packageCode = b.packageCode " +
            "AND a.productId = :productId " +
            "AND a.packageCode = :packageCode " +
            "AND a.productId = c.productId " +
            "AND b.coverCode = c.coverCode " +
            "ORDER BY b.coverCode")
    List<CoverCodeDTO> findCoverCodes(String productId, String packageCode);

    default void saveReinsuranceAmount(double reinsuranceAmount) {
        // Logic to save reinsurance amount in the database
        // This is a placeholder implementation
        // Actual implementation will depend on the database schema and JPA setup
    }
}
