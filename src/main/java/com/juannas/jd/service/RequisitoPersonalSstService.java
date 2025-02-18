package com.juannas.jd.service;

import com.juannas.jd.repository.RequisitoPersonalSstRepository;
import com.juannas.jd.repository.entity.RequisitoPersonalSstEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RequisitoPersonalSstService {

    private final RequisitoPersonalSstRepository requisitoPersonalSstRepository;

    @Autowired
    public RequisitoPersonalSstService(RequisitoPersonalSstRepository requisitoPersonalSstRepository) {
        this.requisitoPersonalSstRepository = requisitoPersonalSstRepository;
    }

    public List<RequisitoPersonalSstEntity> findAll() {
        return StreamSupport.stream(requisitoPersonalSstRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<RequisitoPersonalSstEntity> findById(int id) {
        return requisitoPersonalSstRepository.findById(id);
    }

    public RequisitoPersonalSstEntity save(RequisitoPersonalSstEntity requisitoPersonalSstEntity) {
        return requisitoPersonalSstRepository.save(requisitoPersonalSstEntity);
    }

    public RequisitoPersonalSstEntity update(int id, RequisitoPersonalSstEntity updatedEntity) {
        return requisitoPersonalSstRepository.findById(id)
                .map(existingEntity -> {
                    updatedEntity.setId(existingEntity.getId());
                    return requisitoPersonalSstRepository.save(updatedEntity);
                })
                .orElseThrow(() -> new RuntimeException("RequisitoPersonalSst no encontrado con ID: " + id));
    }

    public void deleteById(int id) {
        if (requisitoPersonalSstRepository.existsById(id)) {
            requisitoPersonalSstRepository.deleteById(id);
        } else {
            throw new RuntimeException("RequisitoPersonalSst no encontrado con ID: " + id);
        }
    }
}
