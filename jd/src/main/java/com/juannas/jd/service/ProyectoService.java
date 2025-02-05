package com.juannas.jd.service;

import com.juannas.jd.repository.entity.EquipoEntity;
import com.juannas.jd.repository.EquipoRepository;
import com.juannas.jd.repository.entity.ProyectoEntity;
import com.juannas.jd.repository.ProyectoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;
    private final EquipoRepository maquinaRepository;

    public ProyectoService(ProyectoRepository proyectoRepository, EquipoRepository maquinaRepository) {
        this.proyectoRepository = proyectoRepository;
        this.maquinaRepository = maquinaRepository;
    }

    // CREATE
    @Transactional
    public ProyectoEntity createProyecto(ProyectoEntity proyecto) {
        return proyectoRepository.save(proyecto);
    }

    // READ ALL
    public List<ProyectoEntity> getAllProyectos() {
        return StreamSupport.stream(proyectoRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // READ BY NOMBRE
    public ProyectoEntity getProyectoByNombre(String nombre) {
        return proyectoRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }

    // UPDATE BY NOMBRE
    @Transactional
    public ProyectoEntity updateProyectoByNombre(String nombre, ProyectoEntity updatedProyecto) {
        ProyectoEntity existing = getProyectoByNombre(nombre);
        existing.setNombre(updatedProyecto.getNombre());
        return proyectoRepository.save(existing);
    }

    // DELETE BY NOMBRE
    @Transactional
    public void deleteProyectoByNombre(String nombre) {
        proyectoRepository.deleteByNombre(nombre);
    }

    // LINK MAQUINA TO PROYECTO
    @Transactional
    public void addMaquinaToProyecto(String proyectoNombre, String maquinaPlaca) {
        ProyectoEntity proyecto = getProyectoByNombre(proyectoNombre);
        EquipoEntity maquina = maquinaRepository.findByPlaca(maquinaPlaca)
                .orElseThrow(() -> new RuntimeException("Machine not found"));

        //proyecto.getEquipos().add(maquina);
        maquina.getProyectos().add(proyecto);
        maquinaRepository.save(maquina);
    }

    // UNLINK MAQUINA FROM PROYECTO
    @Transactional
    public void removeMaquinaFromProyecto(String proyectoNombre, String maquinaPlaca) {
        ProyectoEntity proyecto = getProyectoByNombre(proyectoNombre);
        EquipoEntity maquina = maquinaRepository.findByPlaca(maquinaPlaca)
                .orElseThrow(() -> new RuntimeException("Machine not found"));

        //proyecto.getEquipos().remove(maquina);
        maquina.getProyectos().remove(proyecto);
        maquinaRepository.save(maquina);
    }
}
