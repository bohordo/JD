package com.juannas.jd.service;

import com.juannas.jd.controller.dto.OrdenServicioInformativaDto;
import com.juannas.jd.enums.TipoOrdenServicio;
import com.juannas.jd.repository.BienesServiciosRepository;
import com.juannas.jd.repository.EquipoRepository;
import com.juannas.jd.repository.OrdenServicioRepository;
import com.juannas.jd.repository.entity.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrdenServicioService {

    private final OrdenServicioRepository ordenServicioRepository;

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private EquipoService equipoService;

    @Autowired
    BienesServiciosRepository bienesServiciosRepository;

    @Autowired
    EquipoRepository equipoRepository;

    @Autowired
    public OrdenServicioService(OrdenServicioRepository ordenServicioRepository) {
        this.ordenServicioRepository = ordenServicioRepository;
    }

    public List<OrdenServicioInformativaEntity> findAll() {
        return StreamSupport.stream(ordenServicioRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<OrdenServicioInformativaEntity> findById(int id) {
        return ordenServicioRepository.findById(id);
    }

    public OrdenServicioInformativaEntity save(OrdenServicioInformativaEntity ordenServicio) {
        return ordenServicioRepository.save(ordenServicio);
    }

    public OrdenServicioInformativaEntity saveSOI(OrdenServicioInformativaDto ordenServicioInformativaDto) {
        OrdenServicioInformativaEntity osi= new OrdenServicioInformativaEntity();
        EquipoEntity equipoEntity = new EquipoEntity();

        //Set TipoOrdenServicio
        osi.setTipoOrdenServicio(TipoOrdenServicio.INFORMATIVA);

        //Set Consecutivo de Orden de Informativa
        //Se hace directamente en la entidad

        //Get proveedor by id
        ProveedorEntity proveedorEntity = proveedorService.getProveedorByIdentificacion(ordenServicioInformativaDto.getProveedorId());
        osi.setProveedorEntity(proveedorEntity);

        //Get proyecto by id
        ProyectoEntity proyectoEntity = proyectoService.getProyectoByNombre(ordenServicioInformativaDto.getNombreProyecto());
        osi.setProyectoEntity(proyectoEntity);

        equipoEntity.setHoraInicial(ordenServicioInformativaDto.getEspecificacionesTecnicasDto().getHoraInicial());
        equipoEntity.setHoraFinal(ordenServicioInformativaDto.getEspecificacionesTecnicasDto().getHoraFinal());
        equipoEntity.setPeriodo(ordenServicioInformativaDto.getEspecificacionesTecnicasDto().getPeriodo());

        //Query Bienes y Servicios
        equipoEntity = equipoService.getMaquinaByPlaca(ordenServicioInformativaDto.getEspecificacionesTecnicasDto().getPlaca());

        BienesServiciosEntity bienesServiciosEntity = new BienesServiciosEntity();
        bienesServiciosEntity.setDetalle(equipoEntity.getTipoEquipo()+" "+equipoEntity.getPlaca()+" "+equipoEntity.getHoraInicial()+" "+equipoEntity.getHoraFinal()+" "+equipoEntity.getPeriodo());
        bienesServiciosEntity.setEquipos(new ArrayList<>());
        bienesServiciosEntity.getEquipos().add(equipoEntity);

        //Calculate Bienes y Servicios



        //Cantidad * Valor Unitario
        int valorUnitario = Integer.parseInt(equipoEntity.getValorUnitario());
        int cantidad = Integer.parseInt(ordenServicioInformativaDto.getEspecificacionesTecnicasDto().getHoras());
        int setTotalMasIVA = valorUnitario*cantidad;
        bienesServiciosEntity.setTotalMasIVA(setTotalMasIVA+"");

        osi.setBienesServiciosEntity(bienesServiciosEntity);

        //Add Observaciones
        osi.setObservaciones(ordenServicioInformativaDto.getObservaciones());

        equipoRepository.save(equipoEntity);
        bienesServiciosRepository.save(bienesServiciosEntity);
        return ordenServicioRepository.save(osi);
    }

    public OrdenServicioInformativaEntity update(int id, OrdenServicioInformativaEntity updatedOrdenServicio) {
        return ordenServicioRepository.findById(id)
                .map(existing -> {
                    updatedOrdenServicio.setOrdenServicioId(existing.getOrdenServicioId());
                    return ordenServicioRepository.save(updatedOrdenServicio);
                })
                .orElseThrow(() -> new EntityNotFoundException("Orden de servicio no encontrada con ID: " + id));
    }

    public void deleteById(int id) {
        if (ordenServicioRepository.existsById(id)) {
            ordenServicioRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Orden de servicio no encontrada con ID: " + id);
        }
    }
}
