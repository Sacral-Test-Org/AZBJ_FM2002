package com.project.azbj_fm2002.controller;

import com.project.azbj_fm2002.service.DiscountTypeService;
import com.project.azbj_fm2002.model.DiscountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discount")
public class DiscountTypeController {

    @Autowired
    private DiscountTypeService discountTypeService;

    @GetMapping("/determine")
    public DiscountType getDiscountType() {
        return discountTypeService.determineDiscountType();
    }
}
