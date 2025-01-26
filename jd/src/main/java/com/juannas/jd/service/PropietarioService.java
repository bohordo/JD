package com.juannas.jd.service;

import com.juannas.jd.repository.entity.MaquinaRepository;
import com.juannas.jd.repository.entity.PropietarioEntity;
import com.juannas.jd.repository.entity.PropietarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PropietarioService {
    private final PropietarioRepository propietarioRepository;
    private final MaquinaRepository maquinaRepository; //Check relation

    public PropietarioService(PropietarioRepository propietarioRepository,
                              MaquinaRepository maquinaRepository) {
        this.propietarioRepository = propietarioRepository;
        this.maquinaRepository = maquinaRepository;
    }

    @Transactional
    public PropietarioEntity createPropietario(PropietarioEntity propietario) {
        return propietarioRepository.save(propietario);
    }

    // GET ALL
    public List<PropietarioEntity> getAllPropietarios() {
        return StreamSupport.stream(propietarioRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public PropietarioEntity getPropietarioByIdentificacion(String identificacion) {
        return propietarioRepository.findByIdentificacion(identificacion)
                .orElseThrow(() -> new RuntimeException("Propietario not found"));
    }

    @Transactional
    public PropietarioEntity updatePropietario(String identificacion,
                                               PropietarioEntity updatedPropietario) {
        PropietarioEntity existing = getPropietarioByIdentificacion(identificacion);
        existing.setNombre(updatedPropietario.getNombre());
        existing.setTipoIdentificacion(updatedPropietario.getTipoIdentificacion());
        return propietarioRepository.save(existing);
    }

    @Transactional
    public void deletePropietario(String identificacion) {
        // Cascade delete handled by JPA
        propietarioRepository.deleteByIdentificacion(identificacion);
    }
}
