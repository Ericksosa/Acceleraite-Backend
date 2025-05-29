package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = TablaNombre.Calificacion)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
