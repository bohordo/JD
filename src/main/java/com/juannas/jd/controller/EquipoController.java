package com.juannas.jd.controller;

import com.juannas.jd.repository.entity.EquipoEntity;
import com.juannas.jd.service.EquipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipo")
public class EquipoController {
    private final EquipoService maquinaService;

    public EquipoController(EquipoService maquinaService) {
        this.maquinaService = maquinaService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<EquipoEntity> createMaquina(@RequestBody EquipoEntity maquina) {
        return ResponseEntity.ok(maquinaService.createMaquina(maquina));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<EquipoEntity>> getAllMaquinas() {
        return ResponseEntity.ok(maquinaService.getAllMaquinas());
    }
/*
    // GET BY PLACA
    @GetMapping("/by-placa/{placa}")
    public ResponseEntity<MaquinaEntity> getMaquinaByPlaca(@PathVariable String placa) {
        return ResponseEntity.ok(maquinaService.getMaquinaByPlaca(placa));
    }
*/
    // UPDATE BY PLACA
    @PutMapping("/update/{placa}")
    public ResponseEntity<EquipoEntity> updateMaquina(
            @PathVariable String placa,
            @RequestBody EquipoEntity updatedMaquina
    ) {
        return ResponseEntity.ok(maquinaService.updateMaquinaByPlaca(placa, updatedMaquina));
    }

    // DELETE BY PLACA
    @DeleteMapping("/delete/{placa}")
    public ResponseEntity<String> deleteMaquinaByPlaca(@PathVariable String placa) {
        maquinaService.deleteMaquinaByPlaca(placa);
        return ResponseEntity.ok().body("Deleted maquina by numero de placa: " + placa);
    }
}
