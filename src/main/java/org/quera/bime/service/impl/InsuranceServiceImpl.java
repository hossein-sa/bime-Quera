package org.quera.bime.service.impl;

import org.quera.bime.model.CompanyEntity;
import org.quera.bime.model.PersonInsuranceEntity;
import org.quera.bime.model.VehicleInsuranceEntity;
import org.quera.bime.model.dto.InsuranceDto;
import org.quera.bime.model.dto.PersonInsuranceDto;
import org.quera.bime.model.dto.VehicleInsuranceDto;
import org.quera.bime.model.enums.InsuranceType;
import org.quera.bime.repository.CompanyRepository;
import org.quera.bime.repository.InsuranceRepository;
import org.quera.bime.service.InsuranceService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;


    private final CompanyRepository companyRepository;

    public InsuranceServiceImpl(InsuranceRepository insuranceRepository, CompanyRepository companyRepository) {
        this.insuranceRepository = insuranceRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public void save(InsuranceDto insuranceDto) {
        Optional<CompanyEntity> company = companyRepository.findById(insuranceDto.getCompanyId());
        if (!company.isPresent()) {
            throw new IllegalArgumentException("Company not found with id: " + insuranceDto.getCompanyId());
        }
        if (insuranceDto instanceof PersonInsuranceDto) {
            PersonInsuranceDto personInsuranceDto = (PersonInsuranceDto) insuranceDto;
            insuranceRepository.save(
                    PersonInsuranceEntity.builder()
                            .type(InsuranceType.PERSON)
                            .name(insuranceDto.getName())
                            .price(insuranceDto.getPrice())
                            .company(company.get())
                            .minAge(personInsuranceDto.getMinAge())
                            .build()
            );
        } else if (insuranceDto instanceof VehicleInsuranceDto) {
            VehicleInsuranceDto vehicleInsuranceDto = (VehicleInsuranceDto) insuranceDto;
            insuranceRepository.save(
                    VehicleInsuranceEntity.builder()
                            .type(InsuranceType.VEHICLE)
                            .name(insuranceDto.getName())
                            .price(insuranceDto.getPrice())
                            .company(company.get())
                            .usage(vehicleInsuranceDto.getUsage())
                            .build()
            );
        }
    }

}
