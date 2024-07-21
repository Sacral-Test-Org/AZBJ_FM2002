package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.LateralShiftService;
import com.azbj.fm2002.model.OldProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/lateral-shift")
public class LateralShiftController {

    @Autowired
    private LateralShiftService lateralShiftService;

    @GetMapping("/old-product-data")
    public ResponseEntity<List<OldProductData>> getOldProductData() {
        List<OldProductData> oldProductDataList = lateralShiftService.fetchOldProductData();
        return ResponseEntity.ok(oldProductDataList);
    }
}
