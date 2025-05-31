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
    @GetMapping
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
        TipoVehiculoDTO saveTipoVehiculoDTO = tipoVehiculoService.createTipoVehiculo(tipoVehiculoDTO);
        return new ResponseEntity<>(tipoVehiculoDTO, HttpStatus.CREATED);
    }

    // BUILD REST API

    @PutMapping("{id}")
    public ResponseEntity <TipoVehiculoDTO> updateTipoVehiculoById(@PathVariable Long tipoVehiculoId,
                                                                   @RequestBody TipoVehiculoDTO updateTipoVehiculo){
        TipoVehiculoDTO tipoVehiculoDTO = tipoVehiculoService.updateTipoVehiculoById(tipoVehiculoId, updateTipoVehiculo);
        return ResponseEntity.ok(tipoVehiculoDTO);

    }

}
