package com.juannas.jd.controller;

import com.juannas.jd.repository.entity.RequisitoPersonalSstEntity;
import com.juannas.jd.service.RequisitoPersonalSstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requisitos-personal-sst")
public class RequisitoPersonalSstController {

    private final RequisitoPersonalSstService requisitoPersonalSstService;

    @Autowired
    public RequisitoPersonalSstController(RequisitoPersonalSstService requisitoPersonalSstService) {
        this.requisitoPersonalSstService = requisitoPersonalSstService;
    }

    @GetMapping
    public ResponseEntity<List<RequisitoPersonalSstEntity>> getAll() {
        return ResponseEntity.ok(requisitoPersonalSstService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequisitoPersonalSstEntity> getById(@PathVariable int id) {
        return requisitoPersonalSstService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<RequisitoPersonalSstEntity> create(@RequestBody RequisitoPersonalSstEntity entity) {
        RequisitoPersonalSstEntity createdEntity = requisitoPersonalSstService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequisitoPersonalSstEntity> update(@PathVariable int id, @RequestBody RequisitoPersonalSstEntity entity) {
        try {
            return ResponseEntity.ok(requisitoPersonalSstService.update(id, entity));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            requisitoPersonalSstService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}