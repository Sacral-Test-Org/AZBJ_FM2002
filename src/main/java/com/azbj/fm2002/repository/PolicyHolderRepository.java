package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.*;
import com.azbj.fm2002.model.PolicyHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyHolderRepository extends JpaRepository<PolicyHolder, Long> {

    @Query("SELECT new com.azbj.fm2002.dto.ProposalTypeDTO(pt.displayName, pt.internalValue) FROM ProposalType pt")
    List<ProposalTypeDTO> findAllProposalTypes();

    @Query("SELECT a.ageUid FROM AgeProofUID a WHERE a.ageProof = :ageProof")
    String findAgeUidByAgeProof(@Param("ageProof") String ageProof);

    @Query("UPDATE FormStatus fs SET fs.status = :formStatus")
    int updateFormStatus(@Param("formStatus") String formStatus);

    @Override
    <S extends PolicyHolder> S save(S policyHolder);

    @Override
    void delete(PolicyHolder policyHolder);

    @Query("SELECT CASE WHEN COUNT(pa) > 0 THEN true ELSE false END FROM Partner pa WHERE pa.paCode = :paCode AND pa.partnerType = 'I'")
    boolean validatePaCode(@Param("paCode") String paCode);

    @Query("SELECT new com.azbj.fm2002.dto.MailingAddressDTO(a.addressLine1, a.addressLine2, a.city, a.state, a.country, a.postcode, a.telephone, a.mobile) FROM Address a WHERE a.partnerId = :partnerId")
    MailingAddressDTO findMailingAddress(@Param("partnerId") String partnerId);

    @Query("SELECT new com.azbj.fm2002.dto.BankAccountDetailsDTO(b.accountNumber, b.bankName, b.branchName, b.city) FROM BankAccountDetails b WHERE b.applicationNumber = :applicationNumber")
    BankAccountDetailsDTO getBankAccountDetails(@Param("applicationNumber") String applicationNumber);

    @Query("SELECT new com.azbj.fm2002.dto.VerificationStatusDTO(v.status) FROM VerificationStatus v WHERE v.applicationNumber = :applicationNumber")
    VerificationStatusDTO getVerificationStatus(@Param("applicationNumber") String applicationNumber);

    @Query("UPDATE AgeProofDetails apd SET apd.validatedDetails = :validatedDetails WHERE apd.ageProofID = :ageProofID")
    void updateAgeProofDetails(@Param("ageProofID") String ageProofID, @Param("validatedDetails") String validatedDetails);

    @Query("SELECT new com.azbj.fm2002.dto.PassportDetailsDTO(p.passportNumber, p.dateOfBirth, p.age, p.gender) FROM PassportDetails p")
    PassportDetailsDTO findPassportDetails();

    @Query("SELECT a.applicationNumber FROM Application a WHERE a.signCardNumber = :signCardNumber OR a.verificationNumber = :verificationNumber")
    String getApplicationNumber(@Param("signCardNumber") String signCardNumber, @Param("verificationNumber") String verificationNumber);

    @Query("SELECT ap.ageProof FROM AgeProof ap WHERE ap.insuredPersonId = :insuredPersonId OR ap.policyHolderId = :policyHolderId")
    String getAgeProof(@Param("insuredPersonId") String insuredPersonId, @Param("policyHolderId") String policyHolderId);

    @Query("SELECT ph.stateOfResidence FROM PolicyHolder ph WHERE ph.policyHolderId = :policyHolderId")
    String getStateOfResidence(@Param("policyHolderId") String policyHolderId);

    @Query("SELECT new com.azbj.fm2002.dto.DrivingLicenseDetailsDTO(dl.licenseNumber, dl.dateOfBirth) FROM DrivingLicenseDetails dl")
    DrivingLicenseDetailsDTO findDrivingLicenseDetails();

    @Query("SELECT new com.azbj.fm2002.dto.EiaDetailsDTO(e.eiaAccountType, e.eiaDocType) FROM EiaDetails e WHERE e.applicationNumber = :applicationNumber AND e.topIndicator = 'Y'")
    EiaDetailsDTO findEiaDetails(@Param("applicationNumber") String applicationNumber);

    @Query("SELECT new com.azbj.fm2002.dto.PolicyHolderDetailsDTO(ph.residentialState, ph.mailingState, ph.residentialCountry, ph.mailingCountry, ph.bankName) FROM PolicyHolderDetails ph WHERE ph.applicationNo = :applicationNo")
    PolicyHolderDetailsDTO findPolicyHolderDetails(@Param("applicationNo") String applicationNo);

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM EiaDetails e WHERE e.applicationNumber = :applicationNo AND e.topIndicator = 'Y' AND e.eiaAccountType = 'New_Applicant'")
    boolean checkExistingEIAccount(@Param("applicationNo") String applicationNo);

    @Query("INSERT INTO EiaDetails (applicationNumber, policyNumber, firstName, middleName, lastName, fatherHusbandName, gender, dob, dobProof, idProof, panCardNo, permAddr1, permAddr2, permAddr3, permAddrArea, permCity, permPin, permState, permCountry, permAddProof, corrAddr1, corrAddr2, corrAddr3, corrAddrArea, corrCity, corrPin, corrState, corrCountry, corrAddProof, applTeleNo, applAltTelNo, applMobNo, applEmailId, bankAccType, bankAccNo, bankName, branchName, micrCode, ifscCode, uidNo, moduleFlag, topIndicator, createUser, agentCode) SELECT :#{#details.applicationNumber}, :#{#details.policyNumber}, :#{#details.firstName}, :#{#details.middleName}, :#{#details.lastName}, :#{#details.fatherHusbandName}, :#{#details.gender}, :#{#details.dob}, :#{#details.dobProof}, :#{#details.idProof}, :#{#details.panCardNo}, :#{#details.permAddr1}, :#{#details.permAddr2}, :#{#details.permAddr3}, :#{#details.permAddrArea}, :#{#details.permCity}, :#{#details.permPin}, :#{#details.permState}, :#{#details.permCountry}, :#{#details.permAddProof}, :#{#details.corrAddr1}, :#{#details.corrAddr2}, :#{#details.corrAddr3}, :#{#details.corrAddrArea}, :#{#details.corrCity}, :#{#details.corrPin}, :#{#details.corrState}, :#{#details.corrCountry}, :#{#details.corrAddProof}, :#{#details.applTeleNo}, :#{#details.applAltTelNo}, :#{#details.applMobNo}, :#{#details.applEmailId}, :#{#details.bankAccType}, :#{#details.bankAccNo}, :#{#details.bankName}, :#{#details.branchName}, :#{#details.micrCode}, :#{#details.ifscCode}, :#{#details.uidNo}, :#{#details.moduleFlag}, :#{#details.topIndicator}, :#{#details.createUser}, :#{#details.agentCode} FROM DUAL")
    void insertNewEIAccount(@Param("details") PolicyHolderDetailsDTO details);

    @Query("SELECT new com.azbj.fm2002.dto.PolicyHolderDTO(ph) FROM PolicyHolder ph WHERE ph.id = :id")
    PolicyHolderDTO findPolicyHolderById(@Param("id") Long id);

    @Query("SELECT new com.azbj.fm2002.dto.LanguageDTO(l.languageName, l.languageId) FROM Language l ORDER BY l.languageId")
    List<LanguageDTO> findAllLanguages();

    @Query("UPDATE PolicyHolder ph SET ph.communicationLanguage = :languageId WHERE ph.id = :policyHolderId")
    void updateLanguage(@Param("languageId") int languageId, @Param("policyHolderId") Long policyHolderId);
}
