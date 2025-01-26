package com.juannas.jd.controller;

import com.juannas.jd.repository.entity.MaquinaEntity;
import com.juannas.jd.service.MaquinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maquinas")
public class MaquinaController {
    private final MaquinaService maquinaService;

    public MaquinaController(MaquinaService maquinaService) {
        this.maquinaService = maquinaService;
    }

    // CREATE
    @PostMapping(path = "/create")
    public ResponseEntity<MaquinaEntity> createMaquina(@RequestBody MaquinaEntity maquina) {
        return ResponseEntity.ok(maquinaService.createMaquina(maquina));
    }

    // GET ALL
    @GetMapping(path = "/list")
    public ResponseEntity<List<MaquinaEntity>> getAllMaquinas() {
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
    public ResponseEntity<MaquinaEntity> updateMaquina(
            @PathVariable String placa,
            @RequestBody MaquinaEntity updatedMaquina
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
