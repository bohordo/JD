package com.juannas.jd.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EspecificacionesTecnicasFinalDto {

    @JsonProperty("detalle")
    private String detalle;

    @JsonProperty("total_mas_iva")
    private String totalMasIVA;

}
