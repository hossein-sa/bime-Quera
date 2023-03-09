package org.quera.bime.service.impl;

import org.quera.bime.model.CompanyEntity;
import org.quera.bime.model.InsuranceEntity;
import org.quera.bime.model.PersonInsuranceEntity;
import org.quera.bime.model.VehicleInsuranceEntity;
import org.quera.bime.model.dto.CreateInsuranceDto;
import org.quera.bime.model.enums.Type;
import org.quera.bime.repository.CompanyRepository;
import org.quera.bime.repository.InsuranceRepository;
import org.quera.bime.service.InsuranceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;


    private final CompanyRepository companyRepository;

    public InsuranceServiceImpl(InsuranceRepository insuranceRepository, CompanyRepository companyRepository) {
        this.insuranceRepository = insuranceRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public void createInsurance(CreateInsuranceDto createInsuranceDto) {
        InsuranceEntity insurance;
        if (createInsuranceDto.getType() == Type.PERSON) {
            insurance = new PersonInsuranceEntity();
            ((PersonInsuranceEntity) insurance).setMinAge(createInsuranceDto.getMinAge());
        } else if (createInsuranceDto.getType() == Type.VEHICLE) {
            insurance = new VehicleInsuranceEntity();
            ((VehicleInsuranceEntity) insurance).setUsage(createInsuranceDto.getUsage());
        } else {
            throw new IllegalArgumentException("Invalid insurance type");
        }
        insurance.setName(createInsuranceDto.getName());
        insurance.setPrice(createInsuranceDto.getPrice());
        insurance.setCreatedAt(LocalDateTime.now());
        CompanyEntity company = companyRepository.findById(createInsuranceDto.getCompanyId())
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));
        insurance.setCompany(company);
        insuranceRepository.save(insurance);
    }
}
