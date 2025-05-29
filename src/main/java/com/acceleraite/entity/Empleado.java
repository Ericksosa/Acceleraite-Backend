package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = TablaNombre.Empleado)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.Nombre)
    private String Nombre;

    @Column(name = TablaNombre.Apellido)
    private String Apellido;

    @Column(name = TablaNombre.Cedula)
    private String Cedula;

    @Column(name = TablaNombre.TandaLabor)
    private String TandaLabor;

    @Column(name = TablaNombre.PorcientoComision)
    private Double PorcientoComision;

    @Column(name = TablaNombre.FechaIngreso)
    private Date FechaIngreso;

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
