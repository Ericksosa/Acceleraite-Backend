package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = TablaNombre.Pago)
@Data
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TablaNombre.MontoAPagar)
    private String montoAPagar;

    @Column(name = TablaNombre.NoTarjeta)
    private Long noTarjeta;

    @Column(name = TablaNombre.FechaVencimientoTarjeta)
    private LocalDate fechaVencimientoTarjeta;

    @Column(name = TablaNombre.CVV)
    private int CVV;

    @Column(name = TablaNombre.OwnerNombreTarjeta)
    private String ownerNombreTarjeta;

    // Relaciones de mappeo por otras tablas


    // Relaciones de toma de atributos de otras tablas
    @ManyToOne
    @JoinColumn(name = "RedPagoId", foreignKey = @ForeignKey(name = "Pago_redPago_id"))
    private RedPago redPago;

    @ManyToOne
    @JoinColumn(name = "ReservaId", foreignKey = @ForeignKey(name = "Pago_reserva_id"))
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "EstadoId", foreignKey = @ForeignKey(name = "Pago_estado_id"))
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "MetodoPagoId", foreignKey = @ForeignKey(name = "Pago_MetodoPago_id"))
    private MetodoPago metodoPago;

}
