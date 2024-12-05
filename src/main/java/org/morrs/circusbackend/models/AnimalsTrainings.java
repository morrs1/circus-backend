package org.morrs.circusbackend.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "animals_trainings")
@Data
public class AnimalsTrainings {
    @EmbeddedId
    private AnimalsTrainingsPK id;

    @ManyToOne
    @MapsId("animalNum") // Указывает, что animalNum является частью составного ключа
    @JoinColumn(name = "animal_num")
    private Animal animal;

    @ManyToOne
    @MapsId("trainingCode") // Указывает, что trainingCode является частью составного ключа
    @JoinColumn(name = "training_code")
    private Training training;

    @Column(name = "special_instructions")
    private String specialInstructions;
}
