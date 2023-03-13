package org.quera.bime.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CompanyDto {
    String name;
    List<InsuranceDto> insurances;
}
