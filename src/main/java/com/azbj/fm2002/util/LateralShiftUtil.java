package com.azbj.fm2002.util;

import com.azbj.fm2002.model.LateralShift;
import com.azbj.fm2002.repository.LateralShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LateralShiftUtil {

    @Autowired
    private LateralShiftRepository lateralShiftRepository;

    public void handleLateralShiftStatus(String insuredPersonId, boolean isChecked, String partnerName) {
        Optional<LateralShift> existingRecord = lateralShiftRepository.findByInsuredPersonId(insuredPersonId);

        if (existingRecord.isPresent()) {
            LateralShift lateralShift = existingRecord.get();
            if (isChecked) {
                lateralShift.setFlag("Y");
                lateralShiftRepository.save(lateralShift);
            } else {
                lateralShiftRepository.delete(lateralShift);
            }
        } else if (isChecked) {
            LateralShift newLateralShift = new LateralShift();
            newLateralShift.setInsuredPersonId(insuredPersonId);
            newLateralShift.setShiftNumber(1);
            newLateralShift.setPartnerName(partnerName);
            newLateralShift.setFlag("Y");
            lateralShiftRepository.save(newLateralShift);
        }
    }
}
