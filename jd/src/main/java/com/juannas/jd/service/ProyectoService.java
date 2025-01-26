package com.juannas.jd.service;

import com.juannas.jd.repository.entity.MaquinaEntity;
import com.juannas.jd.repository.MaquinaRepository;
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
    private final MaquinaRepository maquinaRepository;

    public ProyectoService(ProyectoRepository proyectoRepository, MaquinaRepository maquinaRepository) {
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
        MaquinaEntity maquina = maquinaRepository.findByPlaca(maquinaPlaca)
                .orElseThrow(() -> new RuntimeException("Machine not found"));

        proyecto.getMaquinas().add(maquina);
        maquina.getProyectos().add(proyecto);
        maquinaRepository.save(maquina);
    }

    // UNLINK MAQUINA FROM PROYECTO
    @Transactional
    public void removeMaquinaFromProyecto(String proyectoNombre, String maquinaPlaca) {
        ProyectoEntity proyecto = getProyectoByNombre(proyectoNombre);
        MaquinaEntity maquina = maquinaRepository.findByPlaca(maquinaPlaca)
                .orElseThrow(() -> new RuntimeException("Machine not found"));

        proyecto.getMaquinas().remove(maquina);
        maquina.getProyectos().remove(proyecto);
        maquinaRepository.save(maquina);
    }
}
