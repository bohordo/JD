package com.juannas.jd.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrdenServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordenServicioId;

        @Column(name = "tipo_orden")
        @JsonProperty("tipo_orden")
        private String tipoOrden;

        @Column(name = "consecutivo_orden_final"/*, nullable = false*/)
        @JsonProperty("consecutivo_orden_final")
        private String consecutivoOrdenFinal;

        @Column(name = "consecutivo_orden_informativa")
        @JsonProperty("consecutivo_orden_informativa")
        private String consecutivoOrdenInformativa;

        @Column(name = "fecha_orden_informativa")
        @JsonProperty("fecha_orden_informativa")
        private LocalDate fechaOrdenInformativa;

        @Column(name = "fecha_orden_final")
        @JsonProperty("fecha_orden_Final")
        private LocalDate fechaOrdenFinal;

        //@Column(name = "proyecto")
        //@JsonProperty("proyecto")
        //@ManyToMany(mappedBy = "p", cascade = CascadeType.ALL)
        //private ProyectoEntity proyectoEntity;

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

        //@Column(name = "requisitos_personal_sst")
        //@JsonProperty("requisitos_personal_sst")
        //private RequisitoPersonalSstEntity requisitosPersonalSst;

        @Column(name = "observaciones",columnDefinition="LONGTEXT")
        @JsonProperty("observaciones")
        private String observaciones;

}
