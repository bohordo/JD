package com.juannas.jd.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "proyecto")
public class ProyectoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proyectoId;

    private String nombre;

    @Column(name = "periodo")
    @JsonProperty("periodo")
    private String periodo;

    @Column(name = "municipio")
    @JsonProperty("municipio")
    private String municipio;

    @Column(name = "departamento")
    @JsonProperty("departamento")
    private String departamento;

    @Column(name = "lider_proyecto")
    @JsonProperty("lider_proyecto")
    private String liderProyecto;

    @Column(name = "cargo_lider_proyecto")
    @JsonProperty("cargo_lider_proyecto")
    private String cargoLiderProyecto;

    @Column(name = "objeto_general",columnDefinition="LONGTEXT")
    @JsonProperty("objeto_general")
    private String objetoGeneral;
}
