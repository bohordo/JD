package com.juannas.jd.repository.entity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProyectoRepository extends CrudRepository<ProyectoEntity, Integer> {
    // Find by nombre (non-PK attribute)
    Optional<ProyectoEntity> findByNombre(String nombre);

    // Find proyectos by a list of nombres
    List<ProyectoEntity> findByNombreIn(Set<String> nombres);

    // Delete by nombre
    @Transactional
    @Modifying
    @Query("DELETE FROM ProyectoEntity p WHERE p.nombre = :nombre")
    void deleteByNombre(String nombre);
}