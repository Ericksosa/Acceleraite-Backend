package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

                import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = TablaNombre.Calificacion)
@Data
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Puntuacion")
    private double puntuacion;

    @Column(name = TablaNombre.Fecha)
    private LocalDate fecha;

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
