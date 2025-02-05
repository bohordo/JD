package com.juannas.jd.service;

import com.juannas.jd.controller.dto.OrdenServicioInformativaDto;
import com.juannas.jd.enums.TipoOrdenServicio;
import com.juannas.jd.repository.OrdenServicioRepository;
import com.juannas.jd.repository.entity.OrdenServicioInformativaEntity;
import com.juannas.jd.repository.entity.ProveedorEntity;
import com.juannas.jd.repository.entity.ProyectoEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        OrdenServicioInformativaEntity osi= new OrdenServicioInformativaEntity();;

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

        //Create Bienes y Servicios

        //Calculate Bienes y Servicios

        //Add Observaciones
        osi.setObservaciones(ordenServicioInformativaDto.getObservaciones());

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
