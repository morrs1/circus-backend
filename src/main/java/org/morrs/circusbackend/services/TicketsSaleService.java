package org.morrs.circusbackend.services;

import lombok.AllArgsConstructor;
import org.morrs.circusbackend.models.TicketsSale;
import org.morrs.circusbackend.repo.TicketsSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Transactional(readOnly = true)
public class TicketsSaleService {

    private TicketsSaleRepository ticketsSaleRepository;

    public List<TicketsSale> readAll() {
        return ticketsSaleRepository.findAll();
    }

    public TicketsSale read(int id) {
        return ticketsSaleRepository.findById(id).orElse(null);
    }

    @Transactional
    public void update(TicketsSale ticketSale, int id) {
        ticketSale.setNumSale(id);
        ticketsSaleRepository.save(ticketSale);
    }

    @Transactional
    public void delete(int id) {
        ticketsSaleRepository.deleteById(id);
    }

    @Transactional
    public void save(TicketsSale ticketSale) {
        ticketsSaleRepository.save(ticketSale);
    }


}
