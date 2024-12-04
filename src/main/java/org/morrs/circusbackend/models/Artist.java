package org.morrs.circusbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "artists")
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
}
