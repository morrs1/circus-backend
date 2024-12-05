package org.morrs.circusbackend.repo;

import org.morrs.circusbackend.models.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewersRepository extends JpaRepository<Viewer, Integer> {
}
