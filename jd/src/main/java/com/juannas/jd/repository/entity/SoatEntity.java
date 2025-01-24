package com.juannas.jd.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SoatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int soatId;
    private LocalDate vigenciaDesde;
    private LocalDate vigenciaHasta;
    private String aseguradora;
}
