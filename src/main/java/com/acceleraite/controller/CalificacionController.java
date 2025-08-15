package com.acceleraite.controller;

import com.acceleraite.dto.CalificacionDTO;
import com.acceleraite.service.CalificacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionController {

    private final CalificacionService service;

    public CalificacionController(CalificacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<CalificacionDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalificacionDTO> getById(@PathVariable Long id) {
        CalificacionDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<CalificacionDTO> create(@RequestBody CalificacionDTO dto) {
        CalificacionDTO creado = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CalificacionDTO> update(@PathVariable Long id,
                                                  @RequestBody CalificacionDTO dto) {
        CalificacionDTO actualizado = service.update(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
