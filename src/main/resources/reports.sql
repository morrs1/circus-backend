SELECT p.per_code                                  AS performance_code,
       p.name                                      AS name,
       p.date                                      AS date,
       p.time                                      AS time,
       COALESCE(artist_count.count_artists, 0)     AS amount_of_artists,
       COALESCE(ticket_count.available_tickets, 0) AS amount_of_free_tickets
FROM performances p
         LEFT JOIN
     (SELECT ap.per_code,
             COUNT(ap.artist_num) AS count_artists
      FROM artists_performances ap
      GROUP BY ap.per_code) AS artist_count ON p.per_code = artist_count.per_code
         LEFT JOIN
     (SELECT t.performance_code,
             COUNT(t.ticket_code) - COUNT(t.num_sale) AS available_tickets
      FROM tickets t
               LEFT JOIN
           tickets_sale ts ON t.num_sale = ts.num_sale
      GROUP BY t.performance_code) AS ticket_count ON p.per_code = ticket_count.performance_code;



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
      GROUP BY ap.artist_num) AS performance_count ON a.artist_num = performance_count.artist_num;



SELECT p.per_code AS performanceCode,
       COALESCE(sold_tickets.count_sold_tickets, 0) AS amountOfSoldTickets,
       COALESCE(available_tickets.count_available_tickets, 0) AS amountOfFreeTickets,
       CASE
           WHEN COALESCE(available_tickets.count_available_tickets, 0) + COALESCE(sold_tickets.count_sold_tickets, 0) = 0 THEN 0
           ELSE
               CASE
                   WHEN COALESCE(sold_tickets.count_sold_tickets, 0) * 1.0 /
                        (COALESCE(sold_tickets.count_sold_tickets, 0) + COALESCE(available_tickets.count_available_tickets, 0)) > 0.7 THEN 1
                   ELSE 0
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
