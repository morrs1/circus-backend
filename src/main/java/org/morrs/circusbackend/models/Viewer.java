package org.morrs.circusbackend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "viewers")
@Data
public class Viewer {

    @Id
    @Column(name = "num_viewer")
    private int numViewer;

    @Column(name = "v_contact_info")
    private String ContactInfo;

    @Column(name = "v_surname")
    private String surname;

    @Column(name = "v_name")
    private String name;

    @Column(name = "v_patronymic")
    private String patronymic;

    @Column(name = "v_birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "viewer")
    @ToString.Exclude
    private List<TicketsSale> ticketsSales;
}
