package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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

    @OneToOne
    @JoinColumn(name = "UsuarioId", foreignKey = @ForeignKey(name = "usuario_id"), unique = true)
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "EstadoId",foreignKey = @ForeignKey(name = "estado_id"))
    private Estado estado;

}
