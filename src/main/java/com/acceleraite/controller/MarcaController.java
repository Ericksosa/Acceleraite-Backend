package com.acceleraite.controller;

import com.acceleraite.dto.MarcaDTO;
import com.acceleraite.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;
    @Autowired
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public ResponseEntity<List<MarcaDTO>> getAllMarcas() {
            List<MarcaDTO> marcas = marcaService.getAllMarcas();
        return ResponseEntity.ok(marcas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> getMarcaById(@PathVariable("id") Long marcaId) {
        MarcaDTO marca = marcaService.getMarcaById(marcaId);
        return ResponseEntity.ok(marca);
    }
    @PostMapping
    public ResponseEntity<MarcaDTO> createMarca(@RequestBody MarcaDTO marcaDTO) {
        MarcaDTO savedMarca = marcaService.createMarca(marcaDTO);
        return ResponseEntity.status(201).body(savedMarca);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MarcaDTO> updateMarcaById(@PathVariable("id") Long marcaId,
                                                     @RequestBody MarcaDTO updateMarca) {
        MarcaDTO updatedMarca = marcaService.updateMarcaById(marcaId, updateMarca);
        return ResponseEntity.ok(updatedMarca);
    }
    @PutMapping("/{id}/estado/{estadoId}")
    public ResponseEntity<String> deleteMarca(@PathVariable("id") Long marcaId,
                                               @PathVariable("estadoId") Long estadoId) {
        marcaService.deleteMarca(marcaId, estadoId);
        return ResponseEntity.ok("Marca eliminada correctamente");
    }
}
