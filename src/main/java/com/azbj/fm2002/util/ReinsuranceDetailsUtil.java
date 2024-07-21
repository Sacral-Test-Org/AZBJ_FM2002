package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.ReinsuranceDetailsDTO;

public class ReinsuranceDetailsUtil {

    /**
     * Calculate the reinsurance sum assured based on the input parameters in the ReinsuranceDetailsDTO.
     *
     * @param reinsuranceDetailsDTO the DTO containing reinsurance details
     * @return the calculated reinsurance sum assured
     */
    public static Double calculateReinsuranceSumAssured(ReinsuranceDetailsDTO reinsuranceDetailsDTO) {
        double sumAssured = 0.0;

        if (reinsuranceDetailsDTO != null) {
            double coverAmount = reinsuranceDetailsDTO.getCoverAmount();
            double reinsurancePercentage = reinsuranceDetailsDTO.getReinsurancePercentage();

            sumAssured = coverAmount * (reinsurancePercentage / 100);
        }

        return sumAssured;
    }
}
