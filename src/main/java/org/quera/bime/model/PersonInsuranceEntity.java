package org.quera.bime.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "persons_insurance")
@DiscriminatorValue("PERSON")
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonInsuranceEntity extends InsuranceEntity {
    @Column(name = "min_age", nullable = false)
    int minAge;
}
