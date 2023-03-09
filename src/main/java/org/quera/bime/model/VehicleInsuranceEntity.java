package org.quera.bime.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles_insurance")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleInsuranceEntity extends InsuranceEntity {
    @Column(nullable = false)
    private String usage;
}
