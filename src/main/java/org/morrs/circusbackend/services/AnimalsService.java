package org.morrs.circusbackend.services;

import lombok.AllArgsConstructor;
import org.morrs.circusbackend.models.Animal;
import org.morrs.circusbackend.repo.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnimalsService {

    private AnimalsRepository animalsRepository;

    public List<Animal> readAll() {
        return animalsRepository.findAll();
    }

    public Animal read(int id) {
        return animalsRepository.findById(id).orElse(null);
    }

    @Transactional
    public void update(Animal artist, int id) {
        artist.setAnimalNum(id);
        animalsRepository.save(artist);
    }

    @Transactional
    public void delete(int id) {
        animalsRepository.deleteById(id);
    }

    @Transactional
    public void save(Animal artist) {
        animalsRepository.save(artist);
    }

}
