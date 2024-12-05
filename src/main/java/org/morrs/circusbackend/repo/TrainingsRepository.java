package org.morrs.circusbackend.repo;

import org.morrs.circusbackend.models.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingsRepository extends JpaRepository<Training, Integer> {
}
