package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.PolicyMemberRepository;
import com.azbj.fm2002.util.PopulateQuestionsUtil;
import com.azbj.fm2002.repository.AzbjBbuQuestionsRepository;
import com.azbj.fm2002.repository.BbprocessRepository;
import com.azbj.fm2002.model.QuestionnaireValidationRequest;
import com.azbj.fm2002.model.QuestionnaireValidationResponse;
import com.azbj.fm2002.model.PopulateQuestionsRequest;
import com.azbj.fm2002.model.PopulateQuestionsResponse;
import com.azbj.fm2002.model.QuestionAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BbprocessService {

    @Autowired
    private PolicyMemberRepository policyMemberRepository;

    @Autowired
    private PopulateQuestionsUtil populateQuestionsUtil;

    @Autowired
    private AzbjBbuQuestionsRepository azbjBbuQuestionsRepository;

    @Autowired
    private BbprocessRepository bbprocessRepository;

    public PopulateQuestionsResponse populateQuestions(String partnerId) {
        if (partnerId == null || partnerId.isEmpty()) {
            throw new IllegalArgumentException("Please select partner");
        }

        Optional<PolicyMember> policyMemberOpt = policyMemberRepository.findByPartnerId(partnerId);
        if (policyMemberOpt.isPresent()) {
            PolicyMember policyMember = policyMemberOpt.get();
            return populateQuestionsUtil.populateQuestions(policyMember.getSex(), partnerId, policyMember.getIpNumber() != null ? policyMember.getIpNumber() : 1, policyMember.getName());
        }

        // Check insured person and policy holder IDs
        // Assuming methods getInsuredPersonId, getPolicyHolderId, getInsuredPersonSex, getPolicyHolderSex, getInsuredPersonName, getPolicyHolderName exist
        if (partnerId.equals(getInsuredPersonId())) {
            return populateQuestionsUtil.populateQuestions(getInsuredPersonSex(), partnerId, 1, getInsuredPersonName());
        } else if (partnerId.equals(getPolicyHolderId())) {
            return populateQuestionsUtil.populateQuestions(getPolicyHolderSex(), partnerId, 2, getPolicyHolderName());
        }

        throw new IllegalArgumentException("Partner ID not found");
    }

    public List<QuestionAnswer> fetchQuestionsAndAnswers(String partnerId) {
        return azbjBbuQuestionsRepository.findQuestionsAndAnswers(partnerId);
    }

    public QuestionnaireValidationResponse validateAndPopulate(QuestionnaireValidationRequest request) {
        // Assuming saveValidatedAnswers method exists in BbprocessRepository
        bbprocessRepository.saveValidatedAnswers(request);
        return new QuestionnaireValidationResponse("Validation and population successful");
    }

    public List<PopulateQuestionsResponse> populateQuestions(PopulateQuestionsRequest request) {
        return bbprocessRepository.fetchQuestions(request);
    }
}
