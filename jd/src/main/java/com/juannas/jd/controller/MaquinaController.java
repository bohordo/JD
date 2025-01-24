package com.juannas.jd.controller;

import com.juannas.jd.repository.entity.MaquinaEntity;
import com.juannas.jd.service.MaquinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/maquina")
public class MaquinaController {
    @Autowired
    MaquinaService maquinaService;

    @GetMapping(path = "/list")
    public List<MaquinaEntity> ListMaquinas(){
        return maquinaService.listAllMaquinas();
    }

    @PostMapping(path = "/create")
    public ResponseEntity CreateMaquina(@RequestBody MaquinaEntity maquina){
        return ResponseEntity.ok().body(maquinaService.createMaquina(maquina));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> DeleteMaquinaByPlaca(@RequestParam String placa){
        maquinaService.deleteMaquina(placa);
        return ResponseEntity.ok().body("Deleted maquina by placa: " + placa);
    }

    @PatchMapping("/update/{placa}")
    public ResponseEntity<MaquinaEntity> updateMaquinaByPlaca(
            @PathVariable String placa,
            @RequestBody MaquinaEntity updatedMaquina) {
        MaquinaEntity maquina = maquinaService.updateMaquinaByPlaca(placa, updatedMaquina);
        return ResponseEntity.ok(maquina);
    }

}
