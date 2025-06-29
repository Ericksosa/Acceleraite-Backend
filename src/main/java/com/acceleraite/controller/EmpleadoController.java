package com.acceleraite.controller;

import com.acceleraite.dto.EmpleadoDTO;
import com.acceleraite.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> getAllEmpleados() {
        List<EmpleadoDTO> empleados = empleadoService.getAllEmpleados();
        return ResponseEntity.ok(empleados);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> getEmpleadoById(@PathVariable("id") Long empleadoId) {
        EmpleadoDTO empleado = empleadoService.getEmpleadoById(empleadoId);
        return ResponseEntity.ok(empleado);
    }
    @PostMapping
    public ResponseEntity<EmpleadoDTO> createEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        EmpleadoDTO savedEmpleado = empleadoService.createEmpleado(empleadoDTO);
        return new ResponseEntity<>(savedEmpleado, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> updateEmpleadoById(@PathVariable("id") Long empleadoId,
                                                           @RequestBody EmpleadoDTO updateEmpleado) {
        EmpleadoDTO updatedEmpleado = empleadoService.updateEmpleadoById(empleadoId, updateEmpleado);
        return ResponseEntity.ok(updatedEmpleado);
    }
    @PutMapping("/{id}/estado/{estadoId}")
    public ResponseEntity<String> deleteEmpleado(@PathVariable("id") Long empleadoId,
                                                  @PathVariable("estadoId") Long estadoId) {
        empleadoService.deleteEmpleado(empleadoId, estadoId);
        return ResponseEntity.ok("Empleado eliminado correctamente");
    }
}
