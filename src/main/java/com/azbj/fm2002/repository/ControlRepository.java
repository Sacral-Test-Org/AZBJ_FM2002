package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.ControlItem;
import com.azbj.fm2002.model.HoAllocationListDTO;
import com.azbj.fm2002.model.ReinsuranceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControlRepository extends JpaRepository<ControlItem, Long> {

    @Query("SELECT c FROM ControlItem c")
    List<ControlItem> findAll();

    @Override
    <S extends ControlItem> List<S> saveAll(Iterable<S> entities);

    @Query("CALL populate_auto_reinsurance()")
    void populateAutoReinsurance();

    @Query("UPDATE FormStatus SET status = :status WHERE formId = :formId")
    void updateFormStatus(@Param("formId") String formId, @Param("status") String status);

    @Query("SELECT new com.azbj.fm2002.model.HoAllocationListDTO(a.screenValue, a.internalValue) FROM AzbjHoAllocationList a WHERE a.activeFlag = 'Y'")
    List<HoAllocationListDTO> findActiveHoAllocationList();

    @Query("SELECT new com.azbj.fm2002.model.HoAllocationListDTO(a.screenValue, a.internalValue) FROM AzbjHoAllocationList a WHERE a.screenValue = :selectedValue")
    HoAllocationListDTO findHoAllocationByValue(@Param("selectedValue") String selectedValue);

    @Query("SELECT new com.azbj.fm2002.model.ReinsuranceData(r.type, r.code) FROM ReinsuranceData r")
    ReinsuranceData fetchReinsuranceData();

    @Query("SELECT ic_code FROM azbj_signature WHERE sub_ic_code = '1234'")
    List<String> findDoctorCodes();

    @Query("DELETE FROM customer.azbj_beneficiary_trustee_rep WHERE contract_id = :contractId")
    void deleteByContractId(@Param("contractId") String contractId);

    @Query("SELECT COUNT(a) > 0 FROM Application a WHERE a.applicationNumber = :applicationNumber")
    boolean findApplicationNumber(@Param("applicationNumber") String applicationNumber);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.userId = :userId")
    boolean findUserId(@Param("userId") String userId);
}
