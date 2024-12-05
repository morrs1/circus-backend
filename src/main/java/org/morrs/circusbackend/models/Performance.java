package org.morrs.circusbackend.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "performances")
@Data
public class Performance {

    @Id
    @Column(name = "per_code")
    private Integer perCode;

    @Column()
    private String name;

    @Column()
    private LocalDate date;

    @Column()
    private LocalTime time;

    @ManyToMany
    @JoinTable(
            name = "artists_performances",
            joinColumns = @JoinColumn(name = "per_code"),
            inverseJoinColumns = @JoinColumn(name = "artist_num")
    )
    @ToString.Exclude
    private List<Artist> artists;

    @ToString.Exclude
    @OneToMany(mappedBy = "performance")
    private List<Ticket> tickets;

}
