package org.quera.bime.controller;


import org.quera.bime.model.dto.CompanyDto;
import org.quera.bime.model.dto.InsuranceDto;
import org.quera.bime.service.InsuranceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurances")
public class InsuranceController {
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody InsuranceDto insurance) {
        try {
            insuranceService.save(insurance);
            return ResponseEntity.ok("Insurance saved.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Insurance saving problem!");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity save(@PathVariable Long id) {
        try {
            InsuranceDto insurance = insuranceService.get(id);
            return ResponseEntity.ok(insurance);
        } catch (Exception e) {
            return ResponseEntity.ok("Insurance not found");
        }
    }
}
