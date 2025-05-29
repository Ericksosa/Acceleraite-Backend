package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = TablaNombre.TipoCombustible)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoCombustible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.Nombre)
    private String Nombre;

    @Column(name = TablaNombre.Descripcion)
    private String Descripcion;

    // Relaciones de mappeo por otras tablas
    @OneToMany(mappedBy = "tipoCombustible", cascade = CascadeType.ALL)
    private List<Vehiculo> vehiculo;

    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "EstadoId",foreignKey = @ForeignKey(name = "TipoCombustible_estado_id"))
    private Estado estado;


}
