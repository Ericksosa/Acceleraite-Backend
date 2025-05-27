package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.NombreUsuario)
    private String NombreUsuario;

    @Column(name = TablaNombre.Correo)
    private String Correo;

    @Column(name = TablaNombre.Password)
    private String Password;

    @ManyToOne
    @JoinColumn(name = "RolId", foreignKey = @ForeignKey(name = "rol_id"), nullable = false)
    private Rol rol;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Empleado empleado;
}
