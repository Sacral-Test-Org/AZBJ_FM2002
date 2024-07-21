package com.project.azbj_fm2002.service;

import com.project.azbj_fm2002.repository.DiscountTypeRepository;
import com.project.azbj_fm2002.model.DiscountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class DiscountTypeService {

    @Autowired
    private DiscountTypeRepository discountTypeRepository;

    public DiscountType determineDiscountType(String agentCode, int productId, String applicationNumber, int solutionId, boolean webAggregatorFlag, boolean groupEmployeeFlag) {
        DiscountType discountType = new DiscountType();

        // Step 1: Check if product ID is not in the list
        if (productId != 269 && productId != 335 && productId != 337 && productId != 341 && productId != 343 && productId != 345) {
            String discountAgentFlag = discountTypeRepository.findDiscountAgentFlag(agentCode);
            discountType.setDiscountAgentFlag(discountAgentFlag != null ? "Y" : "N");
        }

        // Step 2: Retrieve employee code
        String employeeCode = discountTypeRepository.findEmployeeCode(applicationNumber);
        discountType.setEmployeeCode(employeeCode);

        // Step 3: Retrieve permanent receipt date
        Date permanentReceiptDate = discountTypeRepository.findPermanentReceiptDate(applicationNumber, solutionId);
        if (permanentReceiptDate == null) {
            permanentReceiptDate = new Date();
        }
        discountType.setPermanentReceiptDate(permanentReceiptDate);

        // Step 4: Retrieve IRDA launch date
        Date irdaLaunchDate = discountTypeRepository.findIrdaLaunchDate();
        discountType.setIrdaLaunchDate(irdaLaunchDate);

        // Step 5: Set discount type to NULL initially
        discountType.setDiscountType(null);

        // Step 6: Check offline/online flag
        boolean isOffline = discountTypeRepository.isOffline(agentCode);
        discountType.setOffline(isOffline);

        // Step 7: Determine discount type based on various conditions
        String determinedDiscountType = determineDiscountTypeBasedOnConditions(agentCode, productId, webAggregatorFlag, groupEmployeeFlag, isOffline);
        discountType.setDiscountType(determinedDiscountType);

        // Step 8: Clear and populate employee list if unit-linked product
        if (isUnitLinkedProduct(productId)) {
            discountType.clearEmployeeList();
            discountType.populateEmployeeList(determinedDiscountType);
        }

        // Step 9: Clear and populate solution discount list if not a group product
        if (!isGroupProduct(productId)) {
            discountType.clearSolutionDiscountList();
            discountType.populateSolutionDiscountList(determinedDiscountType);
        }

        return discountType;
    }

    private String determineDiscountTypeBasedOnConditions(String agentCode, int productId, boolean webAggregatorFlag, boolean groupEmployeeFlag, boolean isOffline) {
        // Implement the logic to determine the discount type based on the conditions
        // This is a placeholder implementation
        if (webAggregatorFlag) {
            return "WEB_AGGREGATOR";
        } else if (groupEmployeeFlag) {
            return "GROUP_EMPLOYEE";
        } else if (isOffline) {
            return "OFFLINE";
        } else {
            return "STANDARD";
        }
    }

    private boolean isUnitLinkedProduct(int productId) {
        // Implement the logic to check if the product is a unit-linked product
        // This is a placeholder implementation
        return productId >= 300 && productId <= 350;
    }

    private boolean isGroupProduct(int productId) {
        // Implement the logic to check if the product is a group product
        // This is a placeholder implementation
        return productId >= 200 && productId <= 250;
    }
}
