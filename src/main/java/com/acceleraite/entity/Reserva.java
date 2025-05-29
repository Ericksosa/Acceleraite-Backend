package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = TablaNombre.Reserva)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TablaNombre.FechaCreacion)
    private Date FechaCreacion;

    @Column(name = TablaNombre.FechaInicio)
    private Date FechaInicio;

    @Column(name = TablaNombre.MontoXDia)
    private double Monto_X_Dia;

    @Column(name = TablaNombre.CantidadDia)
    private double CantidadDia;

    @Column(name = TablaNombre.Comentario)
    private String Comentario;

    @Column(name = TablaNombre.MontoTotal)
    private double MontoTotal;

    // Relaciones de mappeo por otras tablas
    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<Pago> pago;

    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL)
    private Inspeccion inspeccion;

    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL)
    private Devolucion devolucion;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<Renta> rentas;

    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "EmpleadoId",foreignKey = @ForeignKey(name = "reserva_empleado_id"))
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "VehiculoId",foreignKey = @ForeignKey(name = "reserva_vehiculo_id"))
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "EstadoId",foreignKey = @ForeignKey(name = "reserva_estado_id"))
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "UsuarioId",foreignKey = @ForeignKey(name = "reserva_usuario_id"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "PagoId",foreignKey = @ForeignKey(name = "reserva_pago_id"))
    private Penalizacion penalizacion;

    // Muchos a mucho
    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<ReservaServicio> reservaServicios;

}
