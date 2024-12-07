package org.morrs.circusbackend.dto;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class PerformanceReport {
    private int performanceCode;
    private String name;
    private LocalDate date;
    private LocalTime time;
    private int amountOfArtists;
    private int amountOfFreeTickets;
}
