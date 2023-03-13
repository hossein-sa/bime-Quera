package org.quera.bime.model.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;
import org.quera.bime.model.PersonInsuranceEntity;
import org.quera.bime.model.VehicleInsuranceEntity;
import org.quera.bime.model.enums.InsuranceType;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PersonInsuranceEntity.class, name = "PERSON"),
        @JsonSubTypes.Type(value = VehicleInsuranceEntity.class, name = "VEHICLE")
})
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public abstract class InsuranceDto {
    InsuranceType type;
    String name;
    double price;
    long companyId;

}
