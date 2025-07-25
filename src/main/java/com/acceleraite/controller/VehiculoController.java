package com.acceleraite.controller;

import com.acceleraite.dto.VehiculoDTO;
import com.acceleraite.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;
    @Autowired
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }
    @GetMapping
    public ResponseEntity<List<VehiculoDTO>> getAllVehiculos() {
        List<VehiculoDTO> vehiculos = vehiculoService.getAllVehiculos();
        return ResponseEntity.ok(vehiculos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> getVehiculoById(@PathVariable("id") Long vehiculoId) {
        VehiculoDTO vehiculo = vehiculoService.getVehiculoById(vehiculoId);
        return ResponseEntity.ok(vehiculo);
    }
    @PostMapping
    public ResponseEntity<VehiculoDTO> createVehiculo(@RequestBody VehiculoDTO vehiculoDTO) {
        VehiculoDTO savedVehiculo = vehiculoService.createVehiculo(vehiculoDTO);
        return new ResponseEntity<>(savedVehiculo, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<VehiculoDTO> updateVehiculoById(@PathVariable("id") Long vehiculoId,
                                                          @RequestBody VehiculoDTO updateVehiculo) {
        VehiculoDTO updatedVehiculo = vehiculoService.updateVehiculoById(vehiculoId, updateVehiculo);
        return ResponseEntity.ok(updatedVehiculo);
    }
    @PutMapping("/{id}/estado/{estadoId}")
    public ResponseEntity<String> deleteVehiculo(@PathVariable("id") Long vehiculoId,
                                                 @PathVariable("estadoId") Long estadoId) {
        vehiculoService.deleteVehiculo(vehiculoId, estadoId);
        return ResponseEntity.ok("Vehiculo eliminado correctamente");
    }
}
