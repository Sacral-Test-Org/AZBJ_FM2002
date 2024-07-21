package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.GpbOptedRequest;

public class GpbOptedUtil {

    public boolean validateGpbOptedSelection(GpbOptedRequest request) {
        boolean isValid = true;

        if (request.isGpbOpted()) {
            if ("T".equals(request.getJointLife())) {
                request.setCnJointLife("JL");

                if (request.getIpPartnerRef().equals(request.getPhPartnerRef())) {
                    request.setJointLife("F");
                    request.setCnJointLife("SL");
                    System.err.println("Error: Insured person and policy holder cannot be the same for joint life.");
                    isValid = false;
                }

                if (!request.isQuestionnairePhVisible()) {
                    request.setQuestionnairePhVisible(true);
                }

                request.setPhAgeProofEnabled(true);
                request.setPhAgePrfIdEnabled(true);
                request.setPhHeightEnabled(true);
                request.setPhWeightEnabled(true);
                request.setPhWtChgEnabled(true);
                request.setPhEqualInsEnabled(false);

                if (request.getChPackage() != null && !request.getChPackage().contains("Joint") && !isSpecifiedProduct(request.getProductDefinition())) {
                    request.setChPackage(null);
                    System.err.println("Warning: Please select the joint life package.");
                    isValid = false;
                }
            } else {
                request.setCnJointLife("SL");

                if (request.isQuestionnairePhVisible()) {
                    request.setQuestionnairePhVisible(false);
                }

                request.setPhAgeProofEnabled(false);
                request.setPhAgePrfIdEnabled(false);
                request.setPhHeightEnabled(false);
                request.setPhWeightEnabled(false);
                request.setPhWtChgEnabled(false);
                request.setPhEqualInsEnabled(true);
            }

            if ("F".equals(request.getLoading())) {
                request.setCnFormStat("Y");
            }

            navigateToChPackage();
        }

        return isValid;
    }

    private boolean isSpecifiedProduct(String productDefinition) {
        // Add logic to check if the product definition is one of the specified products
        return false;
    }

    private void navigateToChPackage() {
        // Add logic to navigate to the CH_PACKAGE item
    }
}
