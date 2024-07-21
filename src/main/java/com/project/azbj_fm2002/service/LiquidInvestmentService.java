package com.project.azbj_fm2002.service;

import com.project.azbj_fm2002.repository.LiquidInvestmentRepository;
import com.project.azbj_fm2002.dto.LiquidInvestmentDTO;
import com.project.azbj_fm2002.model.LiquidInvestment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiquidInvestmentService {

    @Autowired
    private LiquidInvestmentRepository liquidInvestmentRepository;

    public void saveLiquidInvestmentDetails(LiquidInvestmentDTO liquidInvestmentDTO) {
        if (liquidInvestmentDTO == null) {
            throw new IllegalArgumentException("LiquidInvestmentDTO cannot be null");
        }

        LiquidInvestment liquidInvestment = new LiquidInvestment();
        liquidInvestment.setContractId(liquidInvestmentDTO.getContractId());
        liquidInvestment.setApplicationNo(liquidInvestmentDTO.getApplicationNo());
        liquidInvestment.setProposalNo(liquidInvestmentDTO.getProposalNo());
        liquidInvestment.setFixedTermDeposit(liquidInvestmentDTO.getFixedTermDeposit());
        liquidInvestment.setMutualFund(liquidInvestmentDTO.getMutualFund());
        liquidInvestment.setEquityShare(liquidInvestmentDTO.getEquityShare());
        liquidInvestment.setFundValUlPol(liquidInvestmentDTO.getFundValUlPol());
        liquidInvestment.setBankBalance(liquidInvestmentDTO.getBankBalance());
        liquidInvestment.setOneTimeIncome(liquidInvestmentDTO.getOneTimeIncome());
        liquidInvestment.setLiquidInvestment(liquidInvestmentDTO.getLiquidInvestment());
        liquidInvestment.setTotalInvestment(liquidInvestmentDTO.getTotalInvestment());
        liquidInvestment.setIpNo(liquidInvestmentDTO.getIpNo());
        liquidInvestment.setCreateUser(liquidInvestmentDTO.getCreateUser());
        liquidInvestment.setCreateDate(liquidInvestmentDTO.getCreateDate());

        liquidInvestmentRepository.save(liquidInvestment);
    }
}
