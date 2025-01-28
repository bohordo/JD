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

        @Column(name = "nombre_proyecto")
        @JsonProperty("nombre_proyecto")
        private String nombreProyecto;

        @Column(name = "periodo")
        @JsonProperty("periodo")
        private String periodo;//Preguntar sobre

        @Column(name = "municipio")
        @JsonProperty("municipio")
        private String municipio;

        @Column(name = "departamento")
        @JsonProperty("departamento")
        private String departamento;

        @Column(name = "lider_proyecto")
        @JsonProperty("lider_proyecto")
        private String liderProyecto;

        @Column(name = "objeto_general")
        @JsonProperty("objeto_general")
        private String objetoGeneral;

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

        @Column(name = "requisitos_personal_sst")
        @JsonProperty("requisitos_personal_sst")
        private String requisitosPersonalSst;

        @Column(name = "nombre_razon_social")
        @JsonProperty("nombre_razon_social")
        private String nombreRazonSocial;

        @Column(name = "cedula_nit")
        @JsonProperty("cedula_nit")
        private String cedulaNit;

        @Column(name = "direccion")
        @JsonProperty("direccion")
        private String direccion;

        @Column(name = "tel_1")
        @JsonProperty("tel_1")
        private String telUno;

        @Column(name = "tel_2")
        @JsonProperty("tel_2")
        private String telDos;

        @Column(name = "email")
        @JsonProperty("email")
        private String email;

        @Column(name = "observaciones",columnDefinition="LONGTEXT")
        @JsonProperty("observaciones")
        private String observaciones;

}
