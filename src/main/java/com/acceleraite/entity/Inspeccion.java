package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = TablaNombre.Inspeccion)
@Data
public class Inspeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = TablaNombre.TieneRalladuras)
    private Boolean TieneRalladuras;

    @Column(name = TablaNombre.TieneGomaRespuesta)
    private Boolean TieneGomaRespuesta;

    @Column(name = TablaNombre.TieneGato)
    private Boolean TieneGato;

    @Column(name = TablaNombre.TieneRoturaCristal)
    private Boolean TieneRoturaCristal;

    @Column(name = TablaNombre.Fecha)
    private Date Fecha;

    // Relaciones de mappeo por otras tablas
    @OneToMany(mappedBy = "inspeccion", cascade = CascadeType.ALL)
    private List<Penalizacion> penalizaciones;

    // Relaciones de toma de atributos de otras tablas

    @OneToOne
    @JoinColumn(name = "UltimoClienteId", foreignKey = @ForeignKey(name = "inspeccion_UltimoCliente_id"))
    private Reserva reserva;

    @OneToOne
    @JoinColumn(name = "CantidadCombustibleId", foreignKey = @ForeignKey(name = "inspeccion_cantidadCombustible_id"))
    private CantidadCombustible cantidadCombustible;

    @OneToOne
    @JoinColumn(name = "EstadoGomaId", foreignKey = @ForeignKey(name = "inspeccion_estadoGoma_id"))
    private EstadoGoma estadoGoma;

    @ManyToOne
    @JoinColumn(name = "EmpleadoEncargadoId", foreignKey = @ForeignKey(name = "inspeccion_empleadoEncargado_id"))
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "inspeccion_estado_id"))
    private Estado estado;


}
