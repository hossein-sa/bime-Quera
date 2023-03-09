package org.quera.bime.controller;

import org.quera.bime.model.CompanyEntity;
import org.quera.bime.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/save")
    public ResponseEntity<String> createCompany(@RequestBody CompanyEntity company) {
        try {
            CompanyEntity savedCompany = companyService.createCompany(company);
            return ResponseEntity.ok("Company saved");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Company saving problem!");
        }
    }
}