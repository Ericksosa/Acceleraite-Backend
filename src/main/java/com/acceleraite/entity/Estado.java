package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = TablaNombre.Estado)
@Data
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TablaNombre.Nombre)
    private String nombre;

    @Column(name = TablaNombre.Descripcion)
    private String descripcion;

    // Relaciones de mappeo por otras tablas

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Empleado> empleado;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Cliente> cliente;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Modelo> modelo;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Marca> marca;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<TipoVehiculo> tipoVehiculos;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<RedPago> redPagos;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Pago> Pagos;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<MetodoPago> metodoPagos;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Penalizacion> penalizaciones;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Inspeccion> inspecciones;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<MensajesLogs> mensajesLogs;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Renta> rentas;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Rol> roles;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Calificacion> calificaciones;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Opinion> opiniones;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Multimedia> multimedias;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<EstadoGoma> estadoGomas;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<CantidadCombustible> cantidadCombustibles;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<ServiciosAdicionales> serviciosAdicionales;

    // Relaciones de toma de atributos de otras tablas

}
