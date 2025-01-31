package com.juannas.jd.controller;

import com.juannas.jd.repository.entity.ProyectoEntity;
import com.juannas.jd.service.ProyectoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proyecto")
public class ProyectoController {
    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ProyectoEntity> createProyecto(@RequestBody ProyectoEntity proyecto) {
        return ResponseEntity.ok(proyectoService.createProyecto(proyecto));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<ProyectoEntity>> getAllProyectos() {
        return ResponseEntity.ok(proyectoService.getAllProyectos());
    }
    /*
    // GET BY NOMBRE
    @GetMapping("/by-nombre/{nombre}")
    public ResponseEntity<ProyectoEntity> getProyectoByNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(proyectoService.getProyectoByNombre(nombre));
    }
    */

    // UPDATE BY NOMBRE
    @PutMapping("/update/{nombre}")
    public ResponseEntity<ProyectoEntity> updateProyecto(
            @PathVariable String nombre,
            @RequestBody ProyectoEntity updatedProyecto
    ) {
        return ResponseEntity.ok(proyectoService.updateProyectoByNombre(nombre, updatedProyecto));
    }

    // DELETE BY NOMBRE
    @DeleteMapping("/delete/{nombre}")
    public ResponseEntity<String> deleteProyectoByNombre(@PathVariable String nombre) {
        proyectoService.deleteProyectoByNombre(nombre);
        return ResponseEntity.ok().body("Deleted proyecto by nombre: " + nombre);
    }
/*
    // LINK MAQUINA
    @PostMapping("/{proyectoNombre}/maquinas/{maquinaPlaca}")
    public ResponseEntity<Void> addMaquinaToProyecto(
            @PathVariable String proyectoNombre,
            @PathVariable String maquinaPlaca
    ) {
        proyectoService.addMaquinaToProyecto(proyectoNombre, maquinaPlaca);
        return ResponseEntity.noContent().build();
    }
    // UNLINK MAQUINA
    @DeleteMapping("/{proyectoNombre}/maquinas/{maquinaPlaca}")
    public ResponseEntity<Void> removeMaquinaFromProyecto(
            @PathVariable String proyectoNombre,
            @PathVariable String maquinaPlaca
    ) {
        proyectoService.removeMaquinaFromProyecto(proyectoNombre, maquinaPlaca);
        return ResponseEntity.noContent().build();
    }

 */
}