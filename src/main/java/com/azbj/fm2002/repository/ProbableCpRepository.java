package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.ProbableCP;
import com.azbj.fm2002.model.PolicyDetailsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProbableCpRepository extends CrudRepository<ProbableCP, Long> {

    @Query("SELECT unique part_id FROM azbj_auto_cp_merge_details WHERE appln_no = TO_CHAR (NVL (:applicationNumber, :verificationNumber, :signCardNumber)) AND partner_type = 'IP' AND top_indicator = 'Y'")
    List<ProbableCP> findProbableCPDetails(String applicationNumber, String verificationNumber, String signCardNumber);

    @Query("SELECT partner_id, a.contract_id, f.booking_frequency, azbj_pk0_acc.get_policy_ref (a.contract_id) policy_ref, e.sum_insured_whole_cover, e.cover_code, b.before_title ||' '||b.first_name ||' '||b.surname name, g.ann_prem, c.change_description status, c.product_id, e.FTPREMIUM_OR_WHOLE_COVER, g.entry_age, g.premium_term, g.benefit_term, g.col6 interest_rate, g.freq_std_prem, g.extra_amt, g.ml_perc, g.oc_perc, g.nri_perc, g.sr_perc, g.prem_disc_amt FROM ocp_interested_parties a, cp_partners b, ocp_policy_versions c, ocp_policy_covers e, ocp_policy_bases f, azbj_policy_covers_ext g, azbj_policy_contract_ext h WHERE a.partner_id = :insuredPersonId AND a.partner_id = b.part_id AND a.contract_id = c.contract_id AND a.contract_id = e.contract_id AND e.cover_code LIKE 'L%' AND f.contract_id = c.contract_id AND a.contract_id = f.contract_id AND g.contract_id = c.contract_id AND a.contract_id = g.contract_id AND h.contract_id = c.contract_id AND a.contract_id = h.contract_id")
    PolicyDetailsEntity findPolicyDetails(String insuredPersonId);

    @Query("SELECT premium_amount FROM WIP_AZBJ_POLICY_BASES_EXT WHERE contract_id = :contractId UNION SELECT premium_amount FROM AZBJ_POLICY_BASES_EXT WHERE contract_id = :contractId AND top_indicator = 'Y' AND action_code <> 'D'")
    BigDecimal findPremiumAmount(String contractId);

    @Query("SELECT inception_date FROM wip_policy_contracts WHERE contract_id = :contractId UNION SELECT inception_date FROM ocp_policy_contracts WHERE contract_id = :contractId")
    LocalDate findInceptionDate(String contractId);
}
