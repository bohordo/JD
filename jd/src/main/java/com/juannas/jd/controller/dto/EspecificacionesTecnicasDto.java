package com.juannas.jd.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EspecificacionesTecnicasDto {

    @JsonProperty("placa")
    private String placa;

    @JsonProperty("tipo_equipo")
    private String tipoEquipo;

    @JsonProperty("descuento_combustible")
    private String descuentoCombustible;

    @JsonProperty("horas")
    private String horas;

    @JsonProperty("hora_inicial")
    private String horaInicial;

    @JsonProperty("hora_final")
    private String horaFinal;

    @JsonProperty("periodo")
    private String periodo;

    @JsonProperty("unidad_medida")
    private String unidadMedida;

    @JsonProperty("valor_unitario")
    private String valorUnitario;

    @JsonProperty("especificaciones_tecnicas_final")
    EspecificacionesTecnicasFinalDto especificacionesTecnicasFinalDto;
}
