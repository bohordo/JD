package com.juannas.jd.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bienes_servicios")
public class BienesServiciosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bienesServiciosId;

    @Column(name = "detalle")
    @JsonProperty("detalle")
    private String detalle;

    @Column(name = "total_mas_iva")
    @JsonProperty("total_mas_iva")
    private String totalMasIVA;

    @OneToMany(mappedBy = "bienesServicios", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("equipos")
    private List<EquipoEntity> equipos;
}
