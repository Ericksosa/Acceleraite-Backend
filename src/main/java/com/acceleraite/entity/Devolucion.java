package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = TablaNombre.Devolucion)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.Descripcion)
    private String Descripcion;

    @Column(name = TablaNombre.FechaDevolucion)
    private Date FechaDevolucion;

    @Column(name = TablaNombre.EstadoObjeto)
    private String EstadoObjeto;

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
