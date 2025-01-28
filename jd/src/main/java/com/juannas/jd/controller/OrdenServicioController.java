package com.juannas.jd.controller;

import com.juannas.jd.repository.entity.OrdenServicioEntity;
import com.juannas.jd.service.OrdenServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes-servicio")
public class OrdenServicioController {

    private final OrdenServicioService ordenServicioService;

    @Autowired
    public OrdenServicioController(OrdenServicioService ordenServicioService) {
        this.ordenServicioService = ordenServicioService;
    }

    @GetMapping
    public ResponseEntity<List<OrdenServicioEntity>> getAllOrdenes() {
        return ResponseEntity.ok(ordenServicioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenServicioEntity> getOrdenById(@PathVariable int id) {
        return ordenServicioService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden de servicio no encontrada"));
    }

    @PostMapping
    public ResponseEntity<OrdenServicioEntity> createOrden(@RequestBody OrdenServicioEntity ordenServicio) {
        OrdenServicioEntity savedOrden = ordenServicioService.save(ordenServicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenServicioEntity> updateOrden(
            @PathVariable int id,
            @RequestBody OrdenServicioEntity ordenServicio) {
        return ResponseEntity.ok(ordenServicioService.update(id, ordenServicio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrden(@PathVariable int id) {
        ordenServicioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
