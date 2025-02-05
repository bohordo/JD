package com.juannas.jd.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.juannas.jd.enums.TipoOrdenServicio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orden_servicio_informativa")
public class OrdenServicioInformativaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordenServicioId;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_orden")
    @JsonProperty("tipo_orden")
    private TipoOrdenServicio tipoOrdenServicio;

    @Column(name = "consecutivo_orden_informativa")
    @JsonProperty("consecutivo_orden_informativa")
    private String consecutivoOrdenInformativa;

    @Column(name = "fecha_orden_informativa")
    @JsonProperty("fecha_orden_informativa")
    private LocalDate fechaOrdenInformativa;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", referencedColumnName = "proyectoId") // Columna de la FK
    @JsonProperty("proyecto")
    private ProyectoEntity proyectoEntity;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", referencedColumnName = "proveedorId") // Columna de la FK
    @JsonProperty("proveedor")
    private ProveedorEntity proveedorEntity;

    @Column(name = "especificaciones_tecnicas")
    @JsonProperty("especificaciones_tecnicas")
    private String especificacionesTecnicas;//Esto debe ser un objeto

    @Column(name = "obligaciones_contratado")
    @JsonProperty("obligaciones_contratado")
    private String obligacionesContratado;

    @Column(name = "obligaciones_contratante")
    @JsonProperty("obligaciones_contratante")
    private String obligacionesContratante;

    @Column(name = "condiciones_economicas")
    @JsonProperty("condiciones_economicas")
    private String condicionesEconomicas;

    @Column(name = "requisitos_personal_sst_texto")
    @JsonProperty("requisitos_personal_sst_texto")
    private String requisitosPersonalSstTexto;

    @Column(name = "observaciones",columnDefinition="LONGTEXT")
    @JsonProperty("observaciones")
    private String observaciones;

    @PostPersist
    public void generarConsecutivoOrdenInformativa() {
        if (this.consecutivoOrdenInformativa == null) {
            this.consecutivoOrdenInformativa = this.ordenServicioId + " " + LocalDate.now().getYear();
        }    }

    @PrePersist
    public void setFechaActual() {
        this.fechaOrdenInformativa = LocalDate.now();
    }
}
