package org.morrs.circusbackend.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class AnimalsTrainingsPK implements Serializable {
    private Integer animalNum;
    private Integer trainingCode;
}
