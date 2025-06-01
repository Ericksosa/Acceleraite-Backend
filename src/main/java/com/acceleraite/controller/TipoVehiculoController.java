package com.acceleraite.controller;

import com.acceleraite.dto.TipoVehiculoDTO;
import com.acceleraite.service.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/TipoVehiculos")
public class TipoVehiculoController {

    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @Autowired
    public TipoVehiculoController(TipoVehiculoService tipoVehiculoService) {
        this.tipoVehiculoService = tipoVehiculoService;
    }

    // BUILD REST API GET BY ID
    @GetMapping("{id}")
    public ResponseEntity<TipoVehiculoDTO> getTipoVehiculoById(@PathVariable("id") Long TipoVehiculoId){
        TipoVehiculoDTO tipoVehiculoDTO = tipoVehiculoService.getTipoVehiculoByID(TipoVehiculoId);
        return ResponseEntity.ok(tipoVehiculoDTO);
    }

    // BUILD REST API GET ALL
    @GetMapping
    public ResponseEntity<List<TipoVehiculoDTO>> getAllTipoVehiculo(){
        List<TipoVehiculoDTO> tipoVehiculos = tipoVehiculoService.getAllTipoVehiculos();
        return ResponseEntity.ok(tipoVehiculos);
    }

    // BUILD REST API CREATE
    @PostMapping
    public ResponseEntity<TipoVehiculoDTO> createTipoVehiculo(@RequestBody TipoVehiculoDTO tipoVehiculoDTO){
        TipoVehiculoDTO saveTipoVehiculo = tipoVehiculoService.createTipoVehiculo(tipoVehiculoDTO);
        return new ResponseEntity<>(saveTipoVehiculo, HttpStatus.CREATED);
    }

    // BUILD REST API UPDATE BY ID
    @PutMapping("{id}")
    public ResponseEntity <TipoVehiculoDTO> updateTipoVehiculoById(@PathVariable ("id") Long tipoVehiculoId,
                                                                   @RequestBody TipoVehiculoDTO updateTipoVehiculo){
        TipoVehiculoDTO tipoVehiculoDTO = tipoVehiculoService.updateTipoVehiculoById(tipoVehiculoId, updateTipoVehiculo);
        return ResponseEntity.ok(tipoVehiculoDTO);
    }

    // BUILD REST API DELETE BY ID
    @PutMapping("/{id}/estado/{estadoId}")
    public ResponseEntity <String> deleteTipoVehiculo(@PathVariable("id") Long TipoVehiculoId,
                                                      @PathVariable("estadoId") Long estadoId){
        tipoVehiculoService.deleteTipoVehiculo(TipoVehiculoId, estadoId);
        return ResponseEntity.ok("Tipo Vehiculo eliminado correctamente!. ");
    }

}
