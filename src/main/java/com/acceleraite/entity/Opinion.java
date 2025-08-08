package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = TablaNombre.Opinion)
@Data
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TablaNombre.Comentario)
    private String comentario;

    @Column(name = TablaNombre.Fecha)
    private Date fecha;

    // Relaciones de mappeo por otras tablas


    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "ClienteId",foreignKey = @ForeignKey(name = "opinion_cliente_id"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "VehiculoId",foreignKey = @ForeignKey(name = "opinion_vehiculo_id"))
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "EstadoId",foreignKey = @ForeignKey(name = "opinion_estado_id"))
    private Estado estado;
}
