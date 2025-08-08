package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = TablaNombre.Devolucion)
@Data
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TablaNombre.Descripcion)
    private String descripcion;

    @Column(name = TablaNombre.FechaDevolucion)
    private Date fechaDevolucion;

    @Column(name = TablaNombre.EstadoObjeto)
    private String estadoObjeto;

    // Relaciones de mappeo por otras tablas


    // Relaciones de toma de atributos de otras tablas
    @OneToOne
    @JoinColumn(name = "InspeccionId", foreignKey = @ForeignKey(name = "devolucion_inspeccion_id"))
    private Inspeccion inspeccion;

    @ManyToOne
    @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "devolucion_estado_id"))
    private Estado estado;

    @OneToOne()
    @JoinColumn(name = "ReservaId", foreignKey = @ForeignKey(name = "devolucion_reserva_id"))
    private Reserva reserva;

}
