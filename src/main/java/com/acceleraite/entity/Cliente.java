package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.Nombre)
    private String Nombre;

    @Column(name = TablaNombre.Apellido)
    private String Apellido;

    @Column(name = TablaNombre.TarjetaCR)
    private Long TarjetaCR;

    @Column(name = TablaNombre.LimiteCredito)
    private Double LimiteCredito;

    @Column(name = TablaNombre.TipoPersona)
    private String TipoPersona;


}
