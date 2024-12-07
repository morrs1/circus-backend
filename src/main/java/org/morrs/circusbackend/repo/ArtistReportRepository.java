package org.morrs.circusbackend.repo;

import lombok.AllArgsConstructor;
import org.morrs.circusbackend.dto.ArtistReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ArtistReportRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<ArtistReport> getReport() {
        String sql = """
                SELECT a.artist_num                                      AS artistNum,
                       a.a_surname                                       AS surname,
                       a.a_name                                          AS name,
                       a.a_patronymic                                    AS patronymic,
                       a.speciality                                      AS speciality,
                       EXTRACT(YEAR FROM AGE(a.a_birth_date))            AS age,
                       a.a_contact_info                                  AS contactInfo,
                       COALESCE(performance_count.count_performances, 0) AS amountOfPerformances
                FROM artists a
                         LEFT JOIN
                     (SELECT ap.artist_num,
                             COUNT(ap.per_code) AS count_performances
                      FROM artists_performances ap
                      GROUP BY ap.artist_num) AS performance_count ON a.artist_num = performance_count.artist_num;""";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ArtistReport.class));
    }
}
