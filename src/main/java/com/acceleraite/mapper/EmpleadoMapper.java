// src/main/java/com/acceleraite/mapper/EmpleadoMapper.java
        package com.acceleraite.mapper;

        import com.acceleraite.dto.EmpleadoDTO;
        import com.acceleraite.entity.Empleado;
        import com.acceleraite.entity.Estado;

        public class EmpleadoMapper {
            public static EmpleadoDTO toDTO(Empleado empleado){
                EmpleadoDTO dto = new EmpleadoDTO();
                dto.setId(empleado.getId());
                dto.setNombre(empleado.getNombre());
                dto.setApellido(empleado.getApellido());
                dto.setCedula(empleado.getCedula());
                dto.setTandaLabor(empleado.getTandaLabor());
                dto.setPorcientoComision(empleado.getPorcientoComision());
                dto.setFechaIngreso(empleado.getFechaIngreso());
                dto.setEstadoId(empleado.getEstado() != null ? empleado.getEstado().getId() : null);
                return dto;
            }
            public static Empleado toEntity(EmpleadoDTO dto){
                Empleado empleado = new Empleado();
                empleado.setId(dto.getId());
                empleado.setNombre(dto.getNombre());
                empleado.setApellido(dto.getApellido());
                empleado.setCedula(dto.getCedula());
                empleado.setTandaLabor(dto.getTandaLabor());
                empleado.setPorcientoComision(dto.getPorcientoComision());
                empleado.setFechaIngreso(dto.getFechaIngreso());
                if (dto.getEstadoId() != null) {
                    Estado estado = new Estado();
                    estado.setId(dto.getEstadoId());
                    empleado.setEstado(estado);
                } else {
                    empleado.setEstado(null);
                }
                return empleado;
            }
        }