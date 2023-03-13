package org.quera.bime.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles_insurance")
@DiscriminatorValue("VEHICLES")
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleInsuranceEntity extends InsuranceEntity {
    @Column(nullable = false)
    String usage;
}
