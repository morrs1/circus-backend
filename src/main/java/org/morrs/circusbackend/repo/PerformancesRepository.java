package org.morrs.circusbackend.repo;

import org.morrs.circusbackend.models.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformancesRepository extends JpaRepository<Performance, Integer> {
}
