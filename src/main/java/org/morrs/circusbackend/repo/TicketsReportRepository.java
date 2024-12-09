package org.morrs.circusbackend.repo;

import lombok.AllArgsConstructor;
import org.morrs.circusbackend.dto.TicketsReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TicketsReportRepository {

    private JdbcTemplate jdbcTemplate;

    public List<TicketsReport> getReport() {
        String sql =
                """
                        SELECT p.per_code AS performanceCode,
                                                   COALESCE(sold_tickets.count_sold_tickets, 0) AS amountOfSoldTickets,
                                                   COALESCE(available_tickets.count_available_tickets, 0) AS amountOfFreeTickets,
                                                   CASE
                                                       WHEN COALESCE(available_tickets.count_available_tickets, 0) + COALESCE(sold_tickets.count_sold_tickets, 0) = 0 THEN 0
                                                       ELSE
                                                           CASE
                                                               WHEN COALESCE(sold_tickets.count_sold_tickets, 0) * 1.0 /\s
                                                                    (COALESCE(sold_tickets.count_sold_tickets, 0) + COALESCE(available_tickets.count_available_tickets, 0)) > 0.7 THEN 0
                                                               ELSE 1
                                                           END
                                                   END AS ratioSoldTicketsToFreeTickets
                                            FROM performances p
                                            LEFT JOIN
                                                (SELECT t.performance_code,
                                                        COUNT(t.ticket_code) - COUNT(ts.num_sale) AS count_available_tickets
                                                 FROM tickets t
                                                 LEFT JOIN tickets_sale ts ON t.num_sale = ts.num_sale
                                                 GROUP BY t.performance_code) AS available_tickets ON p.per_code = available_tickets.performance_code
                                            LEFT JOIN
                                                (SELECT t.performance_code,
                                                        COUNT(ts.num_sale) AS count_sold_tickets
                                                 FROM tickets t
                                                 JOIN tickets_sale ts ON t.num_sale = ts.num_sale
                                                 GROUP BY t.performance_code) AS sold_tickets ON p.per_code = sold_tickets.performance_code;
                    """;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TicketsReport.class));
    }

}
