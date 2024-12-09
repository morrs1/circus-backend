package org.morrs.circusbackend.repo;

import org.morrs.circusbackend.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Integer> {

    @Query(value = "SELECT * FROM tickets WHERE num_sale IS NULL AND performance_code = ?1", nativeQuery = true)
    List<Ticket> findAllFreeTickets(int performanceCode);
}
