package org.morrs.circusbackend.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ArtistReport {
    private UUID artistNum;
    private String surname;
    private String name;
    private String patronymic;
    private String speciality;
    private int age;
    private String contactInfo;
    private String amountOfPerformances;
}
