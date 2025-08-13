package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = TablaNombre.Vehiculo)
@Data
public class Vehiculo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = TablaNombre.Descripcion)
    private String Descripcion;

    @Column(name = TablaNombre.NoChasis) // Los chasis pueden tener letras :D
    private String NoChasis;

    @Column(name = TablaNombre.NoMotor)
    private String NoMotor;

    @Column(name = TablaNombre.NoPlaca)
    private String NoPlaca;

    @Column(name = TablaNombre.Color)
    private String Color;

    @Column(name = "MontoPorDia")
    private Double montoPorDia;

    // Relaciones de mappeo por otras tablas

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Multimedia> multimedia;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Calificacion> calificaciones;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Opinion> opiniones;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "TipoCombustibleId", foreignKey = @ForeignKey(name = "Vehiculo_TipoCombustible_id"))
    private TipoCombustible tipoCombustible;

    @ManyToOne
    @JoinColumn(name = "ModeloId", foreignKey = @ForeignKey(name = "Vehiculo_Modelo_id"))
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "TipoVehiculoId", foreignKey = @ForeignKey(name = "Vehiculo_TipoVehiculo_id"))
    private TipoVehiculo tipoVehiculo;

    @ManyToOne
    @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "Vehiculo_Estado_id"))
    private Estado estado;

}
