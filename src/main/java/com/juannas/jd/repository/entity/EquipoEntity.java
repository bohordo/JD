package com.juannas.jd.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "equipo")
public class EquipoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int equipoId;

    private String placa;

    private String tipoEquipo;

    private String horaInicial;

    private String horaFinal;

    private String periodo;

    @Column(name = "unidad_medida")
    @JsonProperty("unidad_medida")
    private String unidadMedida;

    @Column(name = "valor_unitario")
    @JsonProperty("valor_unitario")
    private String valorUnitario;

    @ManyToOne
    @JoinColumn(name = "bienes_servicios_id") // Clave foránea en la tabla EquipoEntity
    private BienesServiciosEntity bienesServicios;
}