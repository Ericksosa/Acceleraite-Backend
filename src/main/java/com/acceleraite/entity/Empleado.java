package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = TablaNombre.Empleado)
@Data
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TablaNombre.Nombre)
    private String nombre;

    @Column(name = TablaNombre.Apellido)
    private String apellido;

    @Column(name = TablaNombre.Cedula)
    private String cedula;

    @Column(name = TablaNombre.TandaLabor)
    private String tandaLabor;

    @Column(name = TablaNombre.PorcientoComision)
    private Double porcientoComision;

    @Column(name = TablaNombre.FechaIngreso)
    private Date fechaIngreso;

    // Relaciones de mappeo por otras tablas
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<Inspeccion> inspeccion;

    // Relaciones de toma de atributos de otras tablas
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UsuarioId", foreignKey = @ForeignKey(name = "empleado_usuario_id"), unique = true)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "EstadoId",foreignKey = @ForeignKey(name = "empleado_estado_id"))
    private Estado estado;
}
