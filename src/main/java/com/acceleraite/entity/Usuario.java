package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = TablaNombre.Usuario)
@Data
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

    // Relaciones de mappeo por otras tablas
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "RolId", foreignKey = @ForeignKey(name = "usuario_rol_id"), nullable = false)
    private Rol rol;

   @ManyToOne
   @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "usuario_estado_id"), nullable = false)
    private Estado estado;

}
