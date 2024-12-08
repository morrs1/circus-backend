package org.morrs.circusbackend.services;

import lombok.AllArgsConstructor;
import org.morrs.circusbackend.models.Artist;
import org.morrs.circusbackend.repo.ArtistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Transactional(readOnly = true)
public class ArtistsService {
    private ArtistsRepository artistsRepository;

    public List<Artist> readAll() {
        return artistsRepository.findAll();
    }

    public Artist read(int id) {
        return artistsRepository.findById(id).orElse(null);
    }

    @Transactional
    public void update(Artist artist, UUID id) {
        artist.setArtistNum(id);
        artistsRepository.save(artist);
    }

    @Transactional
    public void delete(int id) {
        artistsRepository.deleteById(id);
    }

    @Transactional
    public void save(Artist artist) {
        artistsRepository.save(artist);
    }

}
