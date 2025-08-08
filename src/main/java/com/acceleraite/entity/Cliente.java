package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = TablaNombre.Cliente)
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TablaNombre.Nombre)
    private String nombre;

    @Column(name = TablaNombre.Apellido)
    private String apellido;

    @Column(name = TablaNombre.TarjetaCR)
    private Long tarjetaCR;

    @Column(name = TablaNombre.LimiteCredito)
    private Double limiteCredito;

    @Column(name = TablaNombre.TipoPersona)
    private String tipoPersona;

    // Relaciones de mappeo por otras tablas
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Calificacion> calificacion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Opinion> opinion;

    // Relaciones de toma de atributos de otras tablas
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UsuarioId", foreignKey = @ForeignKey(name = "cliente_usuario_id"), unique = true)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "EstadoId",foreignKey = @ForeignKey(name = "cliente_estado_id"))
    private Estado estado;


}
