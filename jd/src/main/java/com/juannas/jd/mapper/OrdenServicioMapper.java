package com.juannas.jd.mapper;

import com.juannas.jd.controller.dto.EspecificacionesTecnicasDto;
import com.juannas.jd.controller.dto.OrdenServicioInformativaDto;
import com.juannas.jd.controller.dto.OrdenServicioInformativaFinalDto;
import com.juannas.jd.repository.entity.OrdenServicioInformativaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdenServicioMapper {

    @Autowired
    EspecificacionesTecnicasMapper especificacionesTecnicasMapper;

    public OrdenServicioInformativaFinalDto toDto(OrdenServicioInformativaEntity entity) {
        OrdenServicioInformativaFinalDto dto = new OrdenServicioInformativaFinalDto();
        EspecificacionesTecnicasDto eTDto;

        dto.setConsecutivoOrdenInformativa(entity.getConsecutivoOrdenInformativa());
        dto.setTipoOrden(entity.getTipoOrdenServicio().getTipoOrden());
        dto.setFechaOrdenInformativa(entity.getFechaOrdenInformativa().toString());
        dto.setProyectoEntity(entity.getProyectoEntity());
        dto.setProveedorEntity(entity.getProveedorEntity());

        eTDto = especificacionesTecnicasMapper.toDto(entity.getBienesServiciosEntity());

        dto.setEspecificacionesTecnicasDto(eTDto);

        dto.setObligacionesContratado(entity.getObligacionesContratado());
        dto.setObligacionesContratante(entity.getObligacionesContratante());
        dto.setCondicionesEconomicas(entity.getCondicionesEconomicas());
        dto.setRequisitos_personal_sst(entity.getRequisitosPersonalSstTexto());
        dto.setObservaciones(entity.getObservaciones());

        return dto;
    }

    public OrdenServicioInformativaEntity toEntity(OrdenServicioInformativaDto dto) {
        OrdenServicioInformativaEntity entity = new OrdenServicioInformativaEntity();
        //entity.setOrdenServicioId(dto.getId());
        //entity.setDetalle(dto.getDetalle());
        //entity.setTotalMasIVA(dto.getTotalMasIVA());
        // Mapea otros campos según sea necesario
        return entity;
    }

}
