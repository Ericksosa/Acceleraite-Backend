package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = TablaNombre.Opinion)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.Comentario)
    private String Comentario;

    @Column(name = TablaNombre.Fecha)
    private Date Fecha;

    // Relaciones de mappeo por otras tablas


    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "ClienteId",foreignKey = @ForeignKey(name = "opinion_cliente_id"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "VehiculoId",foreignKey = @ForeignKey(name = "opinion_vehiculo_id"))
    private Vehiculo vehiculo;

}
