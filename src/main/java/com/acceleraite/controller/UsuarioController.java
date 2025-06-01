package com.acceleraite.controller;

import com.acceleraite.dto.UsuarioDTO;
import com.acceleraite.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // BUILD REST API GET BY ID
    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long usuarioId){
        UsuarioDTO usuarioDTO = usuarioService.getUsuarioByID(usuarioId);
        return ResponseEntity.ok(usuarioDTO);
    }

    // BUILD REST API GET ALL
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios(){
        List<UsuarioDTO> usuarioDTOS = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarioDTOS);
    }

    //BUILD REST API CREATE
    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO saveUsuario = usuarioService.createUsuario(usuarioDTO);
        return new ResponseEntity <>(saveUsuario, HttpStatus.CREATED);
    }

    // BUILD REST API UPDATE
    @PutMapping("{id}")
    public ResponseEntity<UsuarioDTO> updateUsuarioByID (@PathVariable("id") Long usuarioId,
                                                         @RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO updateUsuario = usuarioService.updateUsuarioById(usuarioId, usuarioDTO);
        return ResponseEntity.ok(updateUsuario);
    }

    // BUILD REST API DELETE
    @PutMapping("{id}/estado/{estadoId}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") Long usuarioId,
                                                @PathVariable("estadoId") Long nuevoEstadoId){

       usuarioService.deleteUsuario(usuarioId, nuevoEstadoId);
       return ResponseEntity.ok("Usuario eliminado correcto");
    }
}
