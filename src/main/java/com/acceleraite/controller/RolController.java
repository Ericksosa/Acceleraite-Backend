package com.acceleraite.controller;

import com.acceleraite.dto.RolDTO;
import com.acceleraite.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @Autowired
    public RolController(RolService rolService){
        this.rolService = rolService;
    }

    // Build Get Rol Rest Api
    @GetMapping("{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable("id") Long rolId){
        RolDTO rolDTO = rolService.getRolByID(rolId);
        return ResponseEntity.ok(rolDTO);
    }

    // Build Get All Rol Rest Api
    @GetMapping
    public ResponseEntity <List<RolDTO>> getAllRols(){
        List<RolDTO> rols = rolService.getAllRols();
        return ResponseEntity.ok(rols);
    }

    // BUILD API ROL REST API
    @PostMapping
    public ResponseEntity<RolDTO> createRol(@RequestBody RolDTO rolDTO){
        RolDTO saveRol = rolService.createRol(rolDTO);
        return new ResponseEntity<>(saveRol, HttpStatus.CREATED);
    }

    //Build Get Update Rol Api
    @PutMapping("{id}")
    public ResponseEntity <RolDTO> updateRolById(@PathVariable("id") Long rolId,
                                                 @RequestBody RolDTO updateRol){
        RolDTO rolDTO = rolService.updateRolById(rolId, updateRol);
        return ResponseEntity.ok(rolDTO);
    }

    // Build Delete REST API (CambioDeEstado)
    @PutMapping("/{id}/estado/{estadoId}")
    public ResponseEntity <String> deleteRol (@PathVariable("id") Long rolId,
                                              @PathVariable("estadoId") Long estadoId){
        rolService.deleteRol(rolId, estadoId);
        return ResponseEntity.ok("Rol eliminado correctamente!. ");
    }

}
