package org.quera.bime.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.quera.bime.model.enums.InsuranceType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "insurances")
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InsuranceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    InsuranceType type;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    Double price;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    CompanyEntity company;
}
