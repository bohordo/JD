package com.juannas.jd.repository;

import com.juannas.jd.repository.entity.MaquinaEntity;
import com.juannas.jd.repository.entity.OrdenServicioEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrdenServicioRepository extends CrudRepository<OrdenServicioEntity, Integer> {
}
