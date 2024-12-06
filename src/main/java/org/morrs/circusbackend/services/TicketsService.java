package org.morrs.circusbackend.services;

import lombok.AllArgsConstructor;
import org.morrs.circusbackend.models.Ticket;
import org.morrs.circusbackend.repo.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Transactional(readOnly = true)
public class TicketsService {
    private TicketsRepository ticketsRepository;

    public List<Ticket> readAll() {
        return ticketsRepository.findAll();
    }

    public Ticket read(int id) {
        return ticketsRepository.findById(id).orElse(null);
    }

    @Transactional
    public void update(Ticket ticket, int id) {
        ticket.setTicketCode(id);
        ticketsRepository.save(ticket);
    }

    @Transactional
    public void delete(int id) {
        ticketsRepository.deleteById(id);
    }

    @Transactional
    public void save(Ticket ticket) {
        ticketsRepository.save(ticket);
    }

}
