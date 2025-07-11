package com.acceleraite.controller;

import com.acceleraite.dto.ModeloDTO;
import com.acceleraite.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/modelos")
public class ModeloController {
    @Autowired
    private ModeloService modeloService;

    @Autowired
    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping
    public ResponseEntity<List<ModeloDTO>> getAllModelos() {
        List<ModeloDTO> Modelos = modeloService.getAllModelos();
        return ResponseEntity.ok(Modelos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ModeloDTO> getModeloById(@PathVariable("id") Long ModeloId) {
        ModeloDTO Modelo = modeloService.getModeloById(ModeloId);
        return ResponseEntity.ok(Modelo);
    }
    @PostMapping
    public ResponseEntity<ModeloDTO> createModelo(@RequestBody ModeloDTO ModeloDTO) {
        ModeloDTO savedModelo = modeloService.createModelo(ModeloDTO);
        return new ResponseEntity<>(savedModelo, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ModeloDTO> updateModeloById(@PathVariable("id") Long ModeloId,
                                                          @RequestBody ModeloDTO updateModelo) {
        ModeloDTO updatedModelo = modeloService.updateModeloById(ModeloId, updateModelo);
        return ResponseEntity.ok(updatedModelo);
    }
    @PutMapping("/{id}/estado/{estadoId}")
    public ResponseEntity<String> deleteModelo(@PathVariable("id") Long ModeloId,
                                                 @PathVariable("estadoId") Long estadoId) {
        modeloService.deleteModelo(ModeloId, estadoId);
        return ResponseEntity.ok("Modelo eliminado correctamente");
    }
}
