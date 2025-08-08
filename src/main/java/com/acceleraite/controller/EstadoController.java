package com.acceleraite.controller;

import com.acceleraite.dto.EstadoDTO;
import com.acceleraite.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    public EstadoController(EstadoService estadoService){
        this.estadoService = estadoService;
    }

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> getAllEstados(){
        List<EstadoDTO> estados = estadoService.getAllEstados();
        return ResponseEntity.ok(estados);
    }
}
