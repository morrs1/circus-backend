package org.morrs.circusbackend.repo;

import org.morrs.circusbackend.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistsRepository extends JpaRepository<Artist, Integer> {
}
