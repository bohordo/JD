package com.juannas.jd.repository;

import com.juannas.jd.repository.entity.ClienteEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<ClienteEntity, Integer> {
    Optional<ClienteEntity> findByIdentificacion(String identificacion);

    @Transactional
    @Modifying
    @Query("DELETE FROM ClienteEntity c WHERE c.identificacion = :identificacion")
    void deleteByIdentificacion(String identificacion);
}