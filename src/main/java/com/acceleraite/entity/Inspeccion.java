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
    private Long id;

    @Column(name = TablaNombre.TieneRalladuras)
    private Boolean tieneRalladuras;

    @Column(name = TablaNombre.TieneGomaRespuesta)
    private Boolean tieneGomaRespuesta;

    @Column(name = TablaNombre.TieneGato)
    private Boolean tieneGato;

    @Column(name = TablaNombre.TieneRoturaCristal)
    private Boolean tieneRoturaCristal;

    @Column(name = TablaNombre.Fecha)
    private Date fecha;

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
