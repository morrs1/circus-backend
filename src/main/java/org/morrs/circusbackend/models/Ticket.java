package org.morrs.circusbackend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;


@Entity
@Table(name = "tickets")
@Data
public class Ticket {

    @Id
    @Column(name = "ticket_code")
    private int ticketCode;

    @Column(name = "num_seat")
    private int numSeat;

    @Column
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "performance_code", referencedColumnName = "per_code")
    private Performance performance;

    @ManyToOne
    @JoinColumn(name = "num_sale", referencedColumnName = "num_sale")
    @ToString.Exclude
    private TicketsSale ticketsSale;
}
