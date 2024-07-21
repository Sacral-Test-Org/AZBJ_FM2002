package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.AllocationRepository;
import com.azbj.fm2002.model.FundDetails;
import com.azbj.fm2002.model.DiscountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AllocationService {

    @Autowired
    private AllocationRepository allocationRepository;

    public String populateAllocation() {
        // Logic to check and update unit-linked allocations
        allocationRepository.updateAllocations();
        return "Allocations updated successfully";
    }

    public void deleteFund(String fundId) throws Exception {
        // Check the total number of funds in the portfolio
        long fundCount = allocationRepository.countFunds();
        if (fundCount <= 1) {
            throw new Exception("Minimum one fund should be required under Auto Transfer!");
        }
        // Delete the selected fund
        allocationRepository.deleteById(fundId);
    }

    public boolean validateDiscountType(String discountType) {
        // Validate discount type selection based on business rules
        Optional<DiscountType> discountTypeOpt = allocationRepository.findByDiscountType(discountType);
        if (!discountTypeOpt.isPresent()) {
            return false;
        }
        DiscountType dt = discountTypeOpt.get();
        if (("AB".equals(discountType) || "BA".equals(discountType) || "BE".equals(discountType)) && (dt.getEmployeeId() == null || dt.getEmployeeCode() == null)) {
            System.out.println("Please Enter Employee Number for the Insured Person");
            return false;
        }
        if (("AB".equals(discountType) || "BA".equals(discountType) || "BE".equals(discountType)) && (!"3000000001".equals(dt.getAgentCode()) && !"3000000007".equals(dt.getAgentCode())) && "N".equals(dt.getInHouseFlag()) && "N".equals(dt.getWebAggregatorFlag())) {
            System.out.println("Employee Discount benefit is applicable through Direct Agents only");
            return false;
        }
        if ("SE".equals(discountType) && !dt.getAgentCode().startsWith("51")) {
            System.out.println("Stanchart Employee Discount benefit is applicable through Stanchart Bank Agents Only");
            return false;
        }
        // Call function to check UL allocations
        checkULAllocations();
        return true;
    }

    public List<FundDetails> getFundDetails(String portfolioStrategy, String productId) {
        // Fetch fund details from the database based on the portfolio strategy and product ID
        return allocationRepository.findFundDetails(portfolioStrategy, productId);
    }

    public List<FundDetails> populateFunds(String portfolioStrategy, int productId) {
        // Auto-populate funds from the database based on the portfolio strategy and product ID
        return allocationRepository.autoPopulateFunds(portfolioStrategy, productId);
    }

    public List<FundDetails> autoPopulateFunds(int productId, String portfolioStrategy) {
        // Call the repository to get fund details based on the product ID and portfolio strategy
        return allocationRepository.getFundDetails(productId, portfolioStrategy);
    }

    private void checkULAllocations() {
        // Logic to check UL allocations
        System.out.println("Checking UL allocations...");
    }
}
