package com.acceleraite.controller;

import com.acceleraite.dto.TipoCombustibleDTO;
import com.acceleraite.service.TipoCombustibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tipo-combustibles")
public class TipoCombustibleController {
    @Autowired
    private TipoCombustibleService tipoCombustibleService;
    @Autowired
    public TipoCombustibleController(TipoCombustibleService tipoCombustibleService) {
        this.tipoCombustibleService = tipoCombustibleService;
    }
    @GetMapping
    public ResponseEntity<List<TipoCombustibleDTO>> getAllTipoCombustibles() {
        List<TipoCombustibleDTO> tipoCombustibles = tipoCombustibleService.getAllTipoCombustibles();
        return ResponseEntity.ok(tipoCombustibles);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoCombustibleDTO> getTipoCombustibleById(Long tipoCombustibleId) {
        TipoCombustibleDTO tipoCombustible = tipoCombustibleService.getTipoCombustibleById(tipoCombustibleId);
        return ResponseEntity.ok(tipoCombustible);
    }
    @PostMapping
    public ResponseEntity<TipoCombustibleDTO> createTipoCombustible(@RequestBody TipoCombustibleDTO tipoCombustibleDTO) {
        TipoCombustibleDTO savedTipoCombustible = tipoCombustibleService.createTipoCombustible(tipoCombustibleDTO);
        return ResponseEntity.status(201).body(savedTipoCombustible);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TipoCombustibleDTO> updateTipoCombustibleById(@PathVariable("id") Long tipoCombustibleId,
                                                                          @RequestBody TipoCombustibleDTO updateTipoCombustible) {
        TipoCombustibleDTO updatedTipoCombustible = tipoCombustibleService.updateTipoCombustibleById(tipoCombustibleId, updateTipoCombustible);
        return ResponseEntity.ok(updatedTipoCombustible);
    }
    @PutMapping("/{id}/estado/{estadoId}")
    public ResponseEntity<String> deleteTipoCombustible(@PathVariable("id") Long tipoCombustibleId,
                                                         @PathVariable("estadoId") Long estadoId) {
        tipoCombustibleService.deleteTipoCombustible(tipoCombustibleId, estadoId);
        return ResponseEntity.ok("Tipo de combustible eliminado correctamente");
    }
}
