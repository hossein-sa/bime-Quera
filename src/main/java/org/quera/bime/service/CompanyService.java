package org.quera.bime.service;

import org.quera.bime.model.CompanyEntity;
import org.quera.bime.model.dto.CompanyDto;

public interface CompanyService {
    CompanyEntity createCompany(CompanyEntity company);
    CompanyDto get(Long id);
}
