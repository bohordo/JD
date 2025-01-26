package com.juannas.jd.controller;

import com.juannas.jd.repository.entity.PropietarioEntity;
import com.juannas.jd.service.PropietarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {
    private final PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<PropietarioEntity> createPropietario(@RequestBody PropietarioEntity propietario) {
        return ResponseEntity.ok(propietarioService.createPropietario(propietario));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<PropietarioEntity>> getAllPropietarios() {
        return ResponseEntity.ok(propietarioService.getAllPropietarios());
    }
    /*
    @GetMapping("/{identificacion}")
    public ResponseEntity<PropietarioEntity> getPropietario(@PathVariable String identificacion) {
        return ResponseEntity.ok(propietarioService.getPropietarioByIdentificacion(identificacion));
    }
    */
    @PutMapping("/update/{identificacion}")
    public ResponseEntity<PropietarioEntity> updatePropietario(@PathVariable String identificacion,
                                                               @RequestBody PropietarioEntity propietario) {
        return ResponseEntity.ok(propietarioService.updatePropietario(identificacion, propietario));
    }

    @DeleteMapping("/delete/{identificacion}")
    public ResponseEntity<String> deletePropietario(@PathVariable String identificacion) {
        propietarioService.deletePropietario(identificacion);
        return ResponseEntity.ok().body("Deleted propietario by identificacion: " + identificacion);
    }
}
