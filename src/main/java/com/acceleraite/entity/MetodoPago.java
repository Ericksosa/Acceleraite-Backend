package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = TablaNombre.MetodoPago)
@Data
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TablaNombre.Nombre)
    private String Nombre;

    @Column(name = TablaNombre.Descripcion)
    private String Descripcion;

    // Relaciones de mappeo por otras tablas
    @OneToMany(mappedBy = "metodoPago", cascade = CascadeType.ALL)
    private List<Pago> pagos;

    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "metodoPago_estado_id"))
    private Estado estado;
}
