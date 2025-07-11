package com.acceleraite.service.impl;


import com.acceleraite.dto.EmpleadoDTO;
import com.acceleraite.dto.VehiculoDTO;
import com.acceleraite.entity.Empleado;
import com.acceleraite.entity.TipoVehiculo;
import com.acceleraite.entity.Vehiculo;
import com.acceleraite.mapper.EmpleadoMapper;
import com.acceleraite.mapper.VehiculoMapper;
import com.acceleraite.repository.EstadoRepository;
import com.acceleraite.repository.TipoVehiculoRepository;
import com.acceleraite.repository.VehiculoRepository;
import com.acceleraite.service.VehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehiculoServicelmpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    @Override
    public VehiculoDTO createVehiculo(VehiculoDTO vehiculoDTO){
        Vehiculo vehiculo = VehiculoMapper.toEntity(vehiculoDTO);
        if (vehiculoDTO.getEstadoId() != null) {
            vehiculo.setEstado(estadoRepository.findById(vehiculoDTO.getEstadoId())
                    .orElseThrow(() -> new ResolutionException("No existe ningún estado con el ID: " + vehiculoDTO.getEstadoId())));
        } else {
            vehiculo.setEstado(null);
        }
        Vehiculo savedVehiculo = vehiculoRepository.save(vehiculo);
        return VehiculoMapper.toDTO(savedVehiculo);
    }

    @Override
    public List<VehiculoDTO> getAllVehiculos() {
        List<Vehiculo> vehiculos = vehiculoRepository.findByEstado_Id(1L); // Asumiendo que 1 es el ID del estado activo
        return vehiculos.stream()
                .map(VehiculoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehiculoDTO getVehiculoById(Long vehiculoId) {
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new ResolutionException("No existe ningún vehiculo con el ID: " + vehiculoId));
        return VehiculoMapper.toDTO(vehiculo);
    }

    @Override
    public VehiculoDTO updateVehiculoById(Long vehiculoId, VehiculoDTO updateVehiculo) {
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new ResolutionException("No existe ningún vehiculo con el ID: " + vehiculoId));

        vehiculo.setDescripcion(updateVehiculo.getDescripcion());
        vehiculo.setNoChasis(updateVehiculo.getNoChasis());
        vehiculo.setNoMotor(updateVehiculo.getNoMotor());
        vehiculo.setNoPlaca(updateVehiculo.getNoPlaca());
        vehiculo.setColor(updateVehiculo.getColor());

        if (updateVehiculo.getEstadoId() != null) {
            vehiculo.setEstado(estadoRepository.findById(updateVehiculo.getEstadoId())
                    .orElseThrow(() -> new ResolutionException("No existe ningún vehiculo con el ID: " + updateVehiculo.getEstadoId())));
        } else {
            vehiculo.setEstado(null);
        }

        //TipoVehiculo
        if (updateVehiculo.getTipoVehiculoId() != null) {
            TipoVehiculo tipoVehiculo = tipoVehiculoRepository.findById(updateVehiculo.getTipoVehiculoId())
                    .orElseThrow(() -> new ResolutionException("No existe ningún tipo de vehículo con el ID: " + updateVehiculo.getTipoVehiculoId()));
            vehiculo.setTipoVehiculo(tipoVehiculo);
        } else {
            vehiculo.setTipoVehiculo(null);
        }

        Vehiculo updatedVehiculo = vehiculoRepository.save(vehiculo);
        return VehiculoMapper.toDTO(updatedVehiculo);
    }

    @Override
    public void deleteVehiculo(Long vehiculoId, Long estadoId) {
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new ResolutionException("No existe ningún vehiculo con el ID: " + vehiculoId));

        // Cambiar el estado del empleado
        if (estadoId != null) {
            vehiculo.setEstado(estadoRepository.findById(estadoId)
                    .orElseThrow(() -> new ResolutionException("No existe ningún estado con el ID: " + estadoId)));
        }

        vehiculoRepository.save(vehiculo);
    }
}
