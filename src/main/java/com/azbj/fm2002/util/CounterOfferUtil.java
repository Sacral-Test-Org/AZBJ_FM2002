package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.CounterOfferRequest;
import com.azbj.fm2002.entity.CounterOfferEntity;

public class CounterOfferUtil {

    public static void validateCounterOfferRequest(CounterOfferRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Counter offer request cannot be null");
        }
        if (request.getPolicyRef() == null || request.getPolicyRef().isEmpty()) {
            throw new IllegalArgumentException("Policy reference cannot be null or empty");
        }
        if (request.getCounterOfferDetails() == null || request.getCounterOfferDetails().isEmpty()) {
            throw new IllegalArgumentException("Counter offer details cannot be null or empty");
        }
        // Add more validations as per business rules
    }

    public static CounterOfferEntity mapToEntity(CounterOfferRequest request) {
        CounterOfferEntity entity = new CounterOfferEntity();
        entity.setPolicyRef(request.getPolicyRef());
        entity.setContractId(request.getContractId());
        entity.setApplicationNo(request.getApplicationNo());
        entity.setActivityNo(request.getActivityNo());
        entity.setActivityDate(request.getActivityDate());
        entity.setEventType(request.getEventType());
        entity.setUserId(request.getUserId());
        entity.setTopIndicator("Y");
        entity.setProductId(request.getProductId());
        entity.setPackageCode(request.getPackageCode());
        entity.setCoverCode(request.getCoverCode());
        entity.setSumAssured(request.getSumAssured());
        entity.setBenefitTerm(request.getBenefitTerm());
        entity.setPremiumTerm(request.getPremiumTerm());
        entity.setPremium(request.getPremium());
        entity.setGst(request.getGst());
        entity.setDepositColl(request.getDepositColl());
        entity.setBop(request.getBop());
        entity.setCheckCoFlag(request.getCheckCoFlag());
        entity.setMultiplier(request.getMultiplier());
        entity.setMlPerc(request.getMlPerc());
        entity.setMlAmt(request.getMlAmt());
        entity.setOcPerc(request.getOcPerc());
        entity.setOcAmt(request.getOcAmt());
        entity.setSrPerc(request.getSrPerc());
        entity.setSrAmt(request.getSrAmt());
        entity.setNriPerc(request.getNriPerc());
        entity.setNriAmt(request.getNriAmt());
        entity.setCoReason1(request.getCoReason1());
        entity.setCoReason2(request.getCoReason2());
        entity.setCoReason3(request.getCoReason3());
        entity.setSignMismatchFlg(request.getSignMismatchFlg());
        entity.setOldBiNo(request.getOldBiNo());
        entity.setBUrl(request.getBUrl());
        entity.setBiNo(request.getBiNo());
        entity.setBMessage(request.getBMessage());
        entity.setBStep(request.getBStep());
        entity.setBStatus(request.getBStatus());
        entity.setBPremiumTerm(request.getBPremiumTerm());
        entity.setBBenefitTerm(request.getBBenefitTerm());
        entity.setBPrem(request.getBPrem());
        entity.setBSumAssured(request.getBSumAssured());
        entity.setBQuoteId(request.getBQuoteId());
        entity.setRiderName(request.getRiderName());
        entity.setRiderCover(request.getRiderCover());
        return entity;
    }
}
