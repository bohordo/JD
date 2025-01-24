package com.juannas.jd.repository.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface MaquinaRepository extends CrudRepository<MaquinaEntity, Integer> {
    @Transactional
    void deleteByPlaca(@Param(value = "placa") String placa);
    Optional<MaquinaEntity> findByPlaca(String placa);
}
