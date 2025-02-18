package com.juannas.jd.mapper;

import com.juannas.jd.controller.dto.EspecificacionesTecnicasDto;
import com.juannas.jd.controller.dto.EspecificacionesTecnicasFinalDto;
import com.juannas.jd.repository.entity.BienesServiciosEntity;
import org.springframework.stereotype.Component;

@Component
public class EspecificacionesTecnicasMapper {

    public EspecificacionesTecnicasDto toDto (BienesServiciosEntity entity){
        EspecificacionesTecnicasDto dto = new EspecificacionesTecnicasDto();
        EspecificacionesTecnicasFinalDto dto2 = new EspecificacionesTecnicasFinalDto();

        dto.setPlaca(entity.getEquipos().get(0).getPlaca());
        dto.setTipoEquipo(entity.getEquipos().get(0).getTipoEquipo());
        dto.setHoraInicial(entity.getEquipos().get(0).getHoraInicial());
        dto.setHoraFinal(entity.getEquipos().get(0).getHoraFinal());
        dto.setPeriodo(entity.getEquipos().get(0).getPeriodo());
        dto.setUnidadMedida(entity.getEquipos().get(0).getUnidadMedida());
        dto.setValorUnitario(entity.getEquipos().get(0).getValorUnitario());

        dto2.setDetalle(entity.getDetalle());
        dto2.setTotalMasIVA(entity.getTotalMasIVA());

        dto.setEspecificacionesTecnicasFinalDto(dto2);

        return dto;
    }

}
