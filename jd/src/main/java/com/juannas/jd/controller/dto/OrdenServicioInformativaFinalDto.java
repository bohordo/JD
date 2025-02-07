package com.juannas.jd.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.juannas.jd.repository.entity.ProveedorEntity;
import com.juannas.jd.repository.entity.ProyectoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class OrdenServicioInformativaFinalDto {

    @JsonProperty("consecutivo_orden_informativa")
    private String consecutivoOrdenInformativa;

    @JsonProperty("tipo_orden")
    private String tipoOrden;

    @JsonProperty("fecha_orden_informativa")
    private String fechaOrdenInformativa;

    //@JsonSerialize(using = ToStringSerializer.class)
    @JsonProperty("proyecto")
    private ProyectoEntity proyectoEntity;

    //@JsonSerialize(using = ToStringSerializer.class)
    @JsonProperty("proveedor")
    private ProveedorEntity proveedorEntity;

    //@JsonSerialize(using = ToStringSerializer.class)
    @JsonProperty("especificaciones_tecnicas")
    private EspecificacionesTecnicasDto especificacionesTecnicasDto;

    @JsonProperty("obligaciones_contratado")
    private String obligacionesContratado;

    @JsonProperty("obligaciones_contratante")
    private String obligacionesContratante;

    @JsonProperty("condiciones_economicas")
    private String condicionesEconomicas;

    @JsonProperty("requisitos_personal_sst")
    private String requisitos_personal_sst;

    @JsonProperty("observaciones")
    private String observaciones;


}
