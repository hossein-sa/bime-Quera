package org.quera.bime.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person_insurance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonInsuranceEntity extends InsuranceEntity {
    @Column(name = "min_age", nullable = false)
    private int minAge;
}
