package org.morrs.circusbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "artists")
@Data
@NoArgsConstructor
public class Artist {

    @Id
    @Column(name = "artist_num")
    private UUID artistNum = UUID.randomUUID();

    @NotEmpty(message = "Фамилия не должна быть пустой")
    @Column(name = "a_surname")
    private String surname;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Column(name = "a_name")
    private String name;

    @NotEmpty(message = "Отчество не должно быть пустым")
    @Column(name = "a_patronymic")
    private String patronymic;

    @Column(name = "a_birth_date")
    private LocalDate birthDate;

    @NotEmpty(message = "Специальность не должна быть пустой")
    @Column(name = "speciality")
    private String speciality;

    @Email(message = "Почта должна быть валидной")
    @Column(name = "a_contact_info")
    private String contactInfo;

    @OneToMany(mappedBy = "artist")
    @ToString.Exclude
    private List<Animal> animals;

    @ManyToMany(mappedBy = "artists")
    @ToString.Exclude
    private List<Performance> performances;

    public Artist(
            UUID artistNum,
            String surname,
            String name,
            String patronymic,
            LocalDate birthDate,
            String speciality,
            String contactInfo
    ) {
        this.artistNum = artistNum;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.speciality = speciality;
        this.contactInfo = contactInfo;
    }

    @AssertTrue(message = "Дата рождения не может быть раньше 1 января 1900 года")
    public boolean isBirthDateValid() {
        return birthDate != null && !birthDate.isBefore(LocalDate.of(1900, 1, 1));
    }
}
