package com.acceleraite.entity;

import com.acceleraite.util.TablaNombre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = TablaNombre.Pago)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TablaNombre.MontoAPagar)
    private String MontoAPagar;

    @Column(name = TablaNombre.NoTarjeta)
    private Long NoTarjeta;

    @Column(name = TablaNombre.FechaVencimientoTarjeta)
    private Date FechaVencimientoTarjeta;

    @Column(name = TablaNombre.CVV)
    private int CVV;

    @Column(name = TablaNombre.OwnerNombreTarjeta)
    private String OwnerNombreTarjeta;


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

}
