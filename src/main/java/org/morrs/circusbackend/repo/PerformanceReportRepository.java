package org.morrs.circusbackend.repo;

import lombok.AllArgsConstructor;
import org.morrs.circusbackend.dto.PerformanceReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PerformanceReportRepository {

    private final JdbcTemplate jdbcTemplate;


    public List<PerformanceReport> getPerformances() {
        String sql = """
                    SELECT p.per_code AS performanceCode,
                    p.name AS name,
                    p.date AS date,
                    p.time AS time,
                    COALESCE(artist_count.count_artists, 0) AS amountOfArtists,
                    COALESCE(ticket_count.available_tickets, 0) AS amountOfFreeTickets
                    FROM performances p
                    LEFT JOIN (SELECT ap.per_code, COUNT(ap.artist_num) AS count_artists
                                FROM artists_performances ap
                                GROUP BY ap.per_code) AS artist_count ON p.per_code = artist_count.per_code
                    LEFT JOIN (SELECT t.performance_code,
                                       COUNT(t.ticket_code) - COUNT(t.num_sale) AS available_tickets
                                FROM tickets t
                                LEFT JOIN tickets_sale ts ON t.num_sale = ts.num_sale
                                GROUP BY t.performance_code) AS ticket_count ON p.per_code = ticket_count.performance_code
                """;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PerformanceReport.class));
    }
}
