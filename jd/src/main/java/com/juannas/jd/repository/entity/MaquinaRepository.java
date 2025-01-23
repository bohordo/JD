package com.juannas.jd.repository.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaquinaRepository extends CrudRepository<MaquinaEntity, Integer> {
}
