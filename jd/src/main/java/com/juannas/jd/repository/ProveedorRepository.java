package com.juannas.jd.repository;

import com.juannas.jd.repository.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ProveedorRepository extends CrudRepository<ProveedorEntity, Integer> {
    Optional<ProveedorEntity> findByIdentificacion(String identificacion);

    @Transactional
    @Modifying
    @Query("DELETE FROM ProveedorEntity p WHERE p.identificacion = :identificacion")
    void deleteByIdentificacion(String identificacion);
}
