package org.quera.bime.model.dto;

import lombok.*;
import org.quera.bime.model.enums.Type;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateInsuranceDto {
    private Type type;
    private String name;
    private Double price;
    private Long companyId;
    private Integer minAge;
    private String usage;
}
