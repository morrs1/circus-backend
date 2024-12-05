package org.morrs.circusbackend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "animals")
@Data
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

    @ManyToOne()
    @JoinColumn(name = "artist_num", referencedColumnName = "artist_num")
    @ToString.Exclude
    private Artist artist;

    @OneToMany(mappedBy = "animal")
    @ToString.Exclude
    private List<AnimalsTrainings> animalTrainings;

    @ManyToMany
    @JoinTable(
            name = "animals_trainings",
            joinColumns = @JoinColumn(name = "animal_num"),
            inverseJoinColumns = @JoinColumn(name = "training_code")
    )
    @ToString.Exclude
    private List<Training> trainings;

}
