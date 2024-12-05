package org.morrs.circusbackend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Entity
@Table(name = "trainings")
@Data
public class Training {

    @Id
    @Column(name = "training_code")
    private Integer trainingCode;

    @ManyToOne
    @JoinColumn(name = "start_time")
    private Interval interval;

    @OneToMany(mappedBy = "training")
    @ToString.Exclude
    private List<AnimalsTrainings> animalsTrainings;

    @OneToMany
    @JoinTable(
            name = "animals_trainings",
            joinColumns = @JoinColumn(name = "training_code"),
            inverseJoinColumns = @JoinColumn(name = "animal_num")
    )
    @ToString.Exclude
    private List<Animal> animals;
}
