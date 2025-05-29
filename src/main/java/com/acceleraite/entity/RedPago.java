package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = TablaNombre.RedPago)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RedPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.Nombre)
    private String Nombre;

    @Column(name = TablaNombre.Descripcion)
    private String Descripcion;

    // Relaciones de mappeo por otras tablas
    @OneToMany(mappedBy = "redPago", cascade = CascadeType.ALL)
    private List<Pago> pagos;

    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "redpago_estado_id"))
    private Estado estado;
}
