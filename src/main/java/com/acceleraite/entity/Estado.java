package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Estado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.Descripcion)
    private String Descripcion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EmpleadoId", foreignKey = @ForeignKey(name = "empleado_id"))
    private Empleado empleado;
}
