package org.quera.bime.service.impl;

import org.quera.bime.model.CompanyEntity;
import org.quera.bime.model.PersonInsuranceEntity;
import org.quera.bime.model.VehicleInsuranceEntity;
import org.quera.bime.model.dto.CompanyDto;
import org.quera.bime.model.dto.InsuranceDto;
import org.quera.bime.model.dto.PersonInsuranceDto;
import org.quera.bime.model.dto.VehicleInsuranceDto;
import org.quera.bime.model.enums.InsuranceType;
import org.quera.bime.repository.CompanyRepository;
import org.quera.bime.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyEntity createCompany(CompanyEntity company) {
        return companyRepository.save(company);
    }

    @Override
    public CompanyDto get(Long id) {
        Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
        if (!companyOptional.isPresent()) {
            throw new IllegalArgumentException("Company not found for id: " + id);
        }
        List<InsuranceDto> insurances = companyOptional.get()
                .getInsurances()
                .stream()
                .map(
                        e -> {
                            if (e.getType().equals(InsuranceType.PERSON)) {
                                PersonInsuranceEntity insurance = (PersonInsuranceEntity) e;
                                return PersonInsuranceDto.builder()
                                        .type(insurance.getType())
                                        .name(insurance.getName())
                                        .price(insurance.getPrice())
                                        .companyId(insurance.getCompany().getId())
                                        .minAge(insurance.getMinAge())
                                        .build();
                            } else {
                                VehicleInsuranceEntity insurance = (VehicleInsuranceEntity) e;
                                return VehicleInsuranceDto.builder()
                                        .type(insurance.getType())
                                        .name(insurance.getName())
                                        .price(insurance.getPrice())
                                        .companyId(insurance.getId())
                                        .usage(insurance.getUsage())
                                        .build();
                            }
                        }
                ).collect(Collectors.toList());
        return CompanyDto.builder()
                .name(companyOptional.get().getName())
                .insurances(insurances)
                .build();
    }
}
