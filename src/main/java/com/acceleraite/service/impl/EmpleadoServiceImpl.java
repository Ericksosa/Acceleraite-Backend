package com.acceleraite.service.impl;

import com.acceleraite.dto.EmpleadoDTO;
import com.acceleraite.entity.Empleado;
import com.acceleraite.entity.Usuario;
import com.acceleraite.mapper.EmpleadoMapper;
import com.acceleraite.repository.EmpleadoRepository;
import com.acceleraite.repository.EstadoRepository;
import com.acceleraite.repository.UsuarioRepository;
import com.acceleraite.service.EmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public EmpleadoDTO createEmpleado(EmpleadoDTO empleadoDTO){
        Empleado empleado = EmpleadoMapper.toEntity(empleadoDTO);
        if (empleadoDTO.getEstadoId() != null) {
            empleado.setEstado(estadoRepository.findById(empleadoDTO.getEstadoId())
                    .orElseThrow(() -> new ResolutionException("No existe ningún estado con el ID: " + empleadoDTO.getEstadoId())));
        } else {
            empleado.setEstado(null);
        }
        Empleado savedEmpleado = empleadoRepository.save(empleado);
        return EmpleadoMapper.toDTO(savedEmpleado);
    }

    @Override
    public List<EmpleadoDTO> getAllEmpleados() {
        List<Empleado> empleados = empleadoRepository.findByEstado_Id(1L); // Asumiendo que 1 es el ID del estado activo
        return empleados.stream()
                .map(EmpleadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmpleadoDTO getEmpleadoById(Long empleadoId){
        Empleado empleado = empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new ResolutionException("No existe ningún empleado con el ID: " + empleadoId));
        return EmpleadoMapper.toDTO(empleado);
    }
    @Override
    public EmpleadoDTO updateEmpleadoById(Long empleadoId, EmpleadoDTO updateEmpleado) {
        Empleado empleado = empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new ResolutionException("No existe ningún empleado con el ID: " + empleadoId));

        empleado.setNombre(updateEmpleado.getNombre());
        empleado.setApellido(updateEmpleado.getApellido());
        empleado.setCedula(updateEmpleado.getCedula());
        empleado.setTandaLabor(updateEmpleado.getTandaLabor());
        empleado.setPorcientoComision(updateEmpleado.getPorcientoComision());
        empleado.setFechaIngreso(updateEmpleado.getFechaIngreso());

        if (updateEmpleado.getEstadoId() != null) {
            empleado.setEstado(estadoRepository.findById(updateEmpleado.getEstadoId())
                    .orElseThrow(() -> new ResolutionException("No existe ningún estado con el ID: " + updateEmpleado.getEstadoId())));
        } else {
            empleado.setEstado(null);
        }

        Empleado updatedEmpleado = empleadoRepository.save(empleado);
        return EmpleadoMapper.toDTO(updatedEmpleado);
    }
    @Override
    public void deleteEmpleado(Long empleadoId, Long estadoId) {
        Empleado empleado = empleadoRepository.findById(empleadoId)
                .orElseThrow(() -> new ResolutionException("No existe ningún empleado con el ID: " + empleadoId));

        // Cambiar el estado del empleado
        if (estadoId != null) {
            empleado.setEstado(estadoRepository.findById(estadoId)
                    .orElseThrow(() -> new ResolutionException("No existe ningún estado con el ID: " + estadoId)));
        }

        empleadoRepository.save(empleado);
    }
}