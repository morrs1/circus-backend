package org.morrs.circusbackend.repo;

import org.morrs.circusbackend.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Integer> {
}
