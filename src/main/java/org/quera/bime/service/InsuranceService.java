package org.quera.bime.service;

import org.quera.bime.model.dto.InsuranceDto;

public interface InsuranceService {
    void save(InsuranceDto insuranceDto);
    InsuranceDto get(Long id);
}
