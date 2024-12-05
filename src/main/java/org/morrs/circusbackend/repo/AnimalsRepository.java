package org.morrs.circusbackend.repo;

import org.morrs.circusbackend.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalsRepository extends JpaRepository<Animal, Integer> {
}
