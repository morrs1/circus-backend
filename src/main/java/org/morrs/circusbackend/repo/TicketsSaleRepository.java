package org.morrs.circusbackend.repo;

import org.morrs.circusbackend.models.TicketsSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsSaleRepository extends JpaRepository<TicketsSale, Integer> {
}
