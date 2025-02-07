package com.juannas.jd.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.juannas.jd.repository.entity.ProveedorEntity;
import com.juannas.jd.repository.entity.ProyectoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrdenServicioInformativaFinalCSVDto {

    @JsonProperty("consecutivo_orden_informativa")
    private String consecutivoOrdenInformativa;

    @JsonProperty("tipo_orden")
    private String tipoOrden;

    @JsonProperty("fecha_orden_informativa")
    private String fechaOrdenInformativa;

    @JsonProperty("detalle")
    private String detalle;

    @JsonProperty("total_mas_iva")
    private String totalMasIVA;


}
