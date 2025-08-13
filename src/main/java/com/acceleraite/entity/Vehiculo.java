package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = TablaNombre.Vehiculo)
@Data
public class Vehiculo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = TablaNombre.Descripcion)
    private String descripcion;

    @Column(name = TablaNombre.NoChasis) // Los chasis pueden tener letras :D
    private String noChasis;

    @Column(name = TablaNombre.NoMotor)
    private String noMotor;

    @Column(name = TablaNombre.NoPlaca)
    private String noPlaca;

    @Column(name = TablaNombre.Color)
    private String color;

    @Column(name = "MontoPorDia")
    private Double montoPorDia;

    // Relaciones de mappeo por otras tablas

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Multimedia> multimedia = new ArrayList<>();

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Calificacion> calificaciones = new ArrayList<>();

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Opinion> opiniones = new ArrayList<>();

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();

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
