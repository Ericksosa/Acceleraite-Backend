package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = TablaNombre.Marca)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = TablaNombre.Nombre)
    private String Nombre;

    @Column(name = TablaNombre.Descripcion)
    private String Descripcion;

    // Relaciones

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    private List<Modelo> modelos;

    @ManyToOne
    @JoinColumn(name = "EstadoId",foreignKey = @ForeignKey(name = "marca_estado_id"))
    private Estado estado;

}