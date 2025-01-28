package com.juannas.jd.service;

import com.juannas.jd.repository.OrdenServicioRepository;
import com.juannas.jd.repository.entity.OrdenServicioEntity;
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
    public OrdenServicioService(OrdenServicioRepository ordenServicioRepository) {
        this.ordenServicioRepository = ordenServicioRepository;
    }

    public List<OrdenServicioEntity> findAll() {
        return StreamSupport.stream(ordenServicioRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<OrdenServicioEntity> findById(int id) {
        return ordenServicioRepository.findById(id);
    }

    public OrdenServicioEntity save(OrdenServicioEntity ordenServicio) {
        return ordenServicioRepository.save(ordenServicio);
    }

    public OrdenServicioEntity update(int id, OrdenServicioEntity updatedOrdenServicio) {
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
