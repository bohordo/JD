package com.juannas.jd.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "soat")
public class SoatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int soatId;
    private String numeroPoliza;
    private LocalDate vigenciaDesde;
    private LocalDate vigenciaHasta;
    private String aseguradora;
}
