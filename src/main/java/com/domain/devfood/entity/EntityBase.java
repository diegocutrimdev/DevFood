package com.domain.devfood.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public abstract class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Boolean active = true;
    private LocalDate createdOn = LocalDate.now();
}
