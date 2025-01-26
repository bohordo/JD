package com.juannas.jd.repository.entity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PropietarioRepository extends CrudRepository<PropietarioEntity, Integer> {
    Optional<PropietarioEntity> findByIdentificacion(String identificacion);

    @Transactional
    @Modifying
    @Query("DELETE FROM PropietarioEntity p WHERE p.identificacion = :identificacion")
    void deleteByIdentificacion(String identificacion);
}
