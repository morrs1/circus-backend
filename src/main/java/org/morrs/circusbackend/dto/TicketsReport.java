package org.morrs.circusbackend.dto;

import lombok.Data;

@Data
public class TicketsReport {
    private int performanceCode;
    private int amountOfSoldTickets;
    private int amountOfFreeTickets;
    private double ratioSoldTicketsToFreeTickets;
}
