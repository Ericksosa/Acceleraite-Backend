package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = TablaNombre.Estado)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = TablaNombre.Nombre)
    private String Nombre;

    @Column(name = TablaNombre.Descripcion)
    private String Descripcion;

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

    // Relaciones de toma de atributos de otras tablas

}
