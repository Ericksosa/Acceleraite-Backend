package com.acceleraite.controller;

import com.acceleraite.dto.ReservaDTO;
import com.acceleraite.entity.Reserva;
import com.acceleraite.mapper.ReservaMapper;
import com.acceleraite.repository.ReservaRepository;
import com.acceleraite.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;
    @Autowired
    public ReservaController(ReservaService reservaService){
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> getAllReservas() {
        List<ReservaDTO> reservas = reservaService.getAllReservas();
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> getReservaById(@PathVariable("id") Long reservaId) {
        ReservaDTO reserva = reservaService.getReservaById(reservaId);
        return ResponseEntity.ok(reserva);
    }

    @PostMapping
    public ResponseEntity<ReservaDTO> createReserva(@RequestBody ReservaDTO reservaDTO) {
        ReservaDTO reservaCreada = reservaService.createReserva(reservaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaCreada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDTO> updateReservaById(@PathVariable("id") Long reservaId,
                                                          @RequestBody ReservaDTO updateReserva) {
        ReservaDTO updatedReserva = reservaService.updateReservaById(reservaId, updateReserva);
        return ResponseEntity.ok(updatedReserva);
    }

    @PutMapping("/{id}/estado/{estadoId}")
    public ResponseEntity<String> deleteReserva(@PathVariable("id") Long reservaId,
                                                 @PathVariable("estadoId") Long estadoId) {
        reservaService.deleteReserva(reservaId, estadoId);
        return ResponseEntity.ok("Reserva eliminada correctamente");
    }

}
