package org.quera.bime.controller;

import org.quera.bime.model.dto.CreateInsuranceDto;
import org.quera.bime.service.InsuranceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurances")
public class InsuranceController {
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }
    @PostMapping("/save")
    public ResponseEntity<String> createInsurance(@RequestBody CreateInsuranceDto createInsuranceDto) {
        try {
            insuranceService.createInsurance(createInsuranceDto);
            return ResponseEntity.ok("Insurance saved");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Insurance saving problem!");
        }
    }
}
