package com.juannas.jd.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrdenServicioInformativaDto {

    @JsonProperty("proveedor_id")
    private String proveedorId;

    @JsonProperty("nombre_proyecto")
    private String nombreProyecto;

    @JsonProperty("especificaciones_tecnicas")
    private String especificaciones_tecnicas;

    @JsonProperty("observaciones")
    private String observaciones;
}
