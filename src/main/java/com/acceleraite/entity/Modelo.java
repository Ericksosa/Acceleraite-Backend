package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = TablaNombre.Modelo)
@Data
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = TablaNombre.Nombre)
    private String Nombre;

    @Column(name = TablaNombre.Descripcion)
    private String Descripcion;

    // Relaciones

    @ManyToOne
    @JoinColumn(name = "MarcaId",foreignKey = @ForeignKey(name = "modelo_marca_id"))
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "EstadoId",foreignKey = @ForeignKey(name = "modelo_estado_id"))
    private Estado estado;



}
