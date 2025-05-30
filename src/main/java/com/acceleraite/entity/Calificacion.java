package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = TablaNombre.Calificacion)
@Data
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "Puntuacion")
    private double Puntuacion;

    @Column(name = TablaNombre.Fecha)
    private Date Fecha;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "ClienteId", foreignKey = @ForeignKey(name = "calificacion_cliente_id"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "VehiculoId", foreignKey = @ForeignKey(name = "calificacion_vehiculo_id"))
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "calificacion_estado_id"))
    private Estado estado;
}
