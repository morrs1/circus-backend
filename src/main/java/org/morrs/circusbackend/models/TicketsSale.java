package org.morrs.circusbackend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tickets_sale")
@Data
public class TicketsSale {

    @Id
    @Column(name="num_sale")
    private int numSale;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "payment_type")
    private String paymentType;

    @OneToMany(mappedBy = "ticketsSale")
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "viewer_num", referencedColumnName = "num_viewer")
    @ToString.Exclude
    private Viewer viewer;


}
