package org.morrs.circusbackend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "artists")
@Data
public class Artist {

    @Id
    @Column(name = "artist_num")
    private int artistNum;

    @Column(name = "a_surname")
    private String surname;

    @Column(name = "a_name")
    private String name;

    @Column(name = "a_patronymic")
    private String patronymic;

    @Column(name = "a_birth_date")
    private LocalDate birthDate;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "a_contact_info")
    private String contactInfo;

    @OneToMany(mappedBy = "artist")
    @ToString.Exclude
    private List<Animal> animals;

    @ManyToMany(mappedBy = "artists")
    @ToString.Exclude
    private List<Performance> performances;
}
