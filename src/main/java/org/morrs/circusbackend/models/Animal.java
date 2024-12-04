package org.morrs.circusbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @Column(name = "animal_num")
    private int animalNum;

    @Column(name = "species")
    private String species;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "artist_num")
    private int artistNum;


}
