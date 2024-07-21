package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.Cover;
import com.azbj.fm2002.model.CoversHealthDTO;
import com.azbj.fm2002.model.Package;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CoversRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void manageInsuranceCoverDetails() {
        // Delete existing record group
        Query deleteQuery = entityManager.createNativeQuery("DELETE FROM THL_COVER_RG");
        deleteQuery.executeUpdate();

        // Create new record group
        String createQuery = "SELECT COVER_DESCRIPTION, COVER_CODE INTO :COVERS.CV_COVER_DESC, :COVERS.CV_COVER_CODE FROM CFG_V_PROD_COVERS_API WHERE PRODUCT_ID = :CONTROL.CN_PRODUCT_ID AND PROD_VERSION = :CONTROL.CN_PRODUCT_VERSION";
        Query createRecordGroupQuery = entityManager.createNativeQuery(createQuery);
        createRecordGroupQuery.executeUpdate();

        // Populate the record group and handle errors
        try {
            Query populateQuery = entityManager.createNativeQuery(createQuery);
            populateQuery.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set LOV property (Assuming LOV is handled in the front-end)
    }

    public void updateFormStatusControl(String globalLoadingFlag) {
        if ("F".equals(globalLoadingFlag)) {
            Query updateQuery = entityManager.createNativeQuery("UPDATE FORM_STATUS_CONTROL SET STATUS = 'Y'");
            updateQuery.executeUpdate();
        }
    }

    public boolean validateAndTrackChanges(double frequencyOfOccurrenceAmount) {
        // Logic to validate frequencyOfOccurrenceAmount and track changes
        // Assuming validation logic is implemented here
        return true;
    }

    public List<Cover> findByProductID(long productID) {
        Query query = entityManager.createQuery("SELECT c FROM Cover c WHERE c.productID = :productID");
        query.setParameter("productID", productID);
        return query.getResultList();
    }

    public void savePremiumTerm(int premiumTerm) {
        Query query = entityManager.createNativeQuery("UPDATE PREMIUM_TERM SET TERM = :premiumTerm");
        query.setParameter("premiumTerm", premiumTerm);
        query.executeUpdate();
    }

    public void updateFormStatus() {
        Query query = entityManager.createNativeQuery("UPDATE FORM_STATUS SET STATUS = 'Y'");
        query.executeUpdate();
    }

    public void setPremiumTerm(int benefitTerm) {
        Query query = entityManager.createNativeQuery("UPDATE PREMIUM_TERM SET TERM = :benefitTerm");
        query.setParameter("benefitTerm", benefitTerm);
        query.executeUpdate();
    }

    public boolean findEntryAge(int entryAge) {
        Query query = entityManager.createNativeQuery("SELECT 1 FROM ENTRY_AGE WHERE AGE = :entryAge");
        query.setParameter("entryAge", entryAge);
        return query.getResultList().size() > 0;
    }

    public Package findPackageCode(String packageCode) {
        Query query = entityManager.createQuery("SELECT p FROM Package p WHERE p.code = :packageCode");
        query.setParameter("packageCode", packageCode);
        return (Package) query.getSingleResult();
    }

    public List<String> findReasonsForCounterOffers() {
        Query query = entityManager.createNativeQuery("SELECT SYS_DESC FROM AZBJ_SYSTEM_CONSTANTS WHERE SYS_TYPE='REASONS'");
        return query.getResultList();
    }

    public Package findPackageDetails(String productId, String receiptDate) {
        Query query = entityManager.createNativeQuery("SELECT * FROM azbj_package_master WHERE product_id=:productId AND :receiptDate >= NVL(start_date, TO_DATE('01/09/2001', 'dd/mm/yyyy')) AND :receiptDate < NVL(end_date, TO_DATE('01/01/3000', 'dd/mm/yyyy'))");
        query.setParameter("productId", productId);
        query.setParameter("receiptDate", receiptDate);
        return (Package) query.getSingleResult();
    }

    public void savePolicyDetails(Object policyDetails) {
        // Assuming policyDetails is a mapped entity
        entityManager.persist(policyDetails);
    }

    public boolean findBookingFrequency(String bookingFrequency) {
        Query query = entityManager.createNativeQuery("SELECT 1 FROM BOOKING_FREQUENCY WHERE FREQUENCY = :bookingFrequency");
        query.setParameter("bookingFrequency", bookingFrequency);
        return query.getResultList().size() > 0;
    }

    public void deleteCover(String coverId) {
        Query query = entityManager.createNativeQuery("DELETE FROM COVERS WHERE COVER_ID = :coverId");
        query.setParameter("coverId", coverId);
        query.executeUpdate();
    }

    public void save(String frequency) {
        Query query = entityManager.createNativeQuery("INSERT INTO PAYOUT_FREQUENCY (FREQUENCY) VALUES (:frequency)");
        query.setParameter("frequency", frequency);
        query.executeUpdate();
    }

    public void saveLoanDisbursedDate(String loanDisbursedDate) {
        Query query = entityManager.createNativeQuery("INSERT INTO LOAN_DISBURSED_DATE (DISBURSED_DATE) VALUES (:loanDisbursedDate)");
        query.setParameter("loanDisbursedDate", loanDisbursedDate);
        query.executeUpdate();
    }

    public List<CoversHealthDTO> findByProductId(Long productId) {
        Query query = entityManager.createQuery("SELECT c FROM CoversHealthDTO c WHERE c.productId = :productId");
        query.setParameter("productId", productId);
        return query.getResultList();
    }

    public CoversHealthDTO save(CoversHealthDTO coversHealthDTO) {
        entityManager.persist(coversHealthDTO);
        return coversHealthDTO;
    }
}
