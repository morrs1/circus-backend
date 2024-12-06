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
@Transactional(readOnly = true)
public class AnimalsService {

    private AnimalsRepository animalsRepository;

    public List<Animal> readAll() {
        return animalsRepository.findAll();
    }

    public Animal read(int id) {
        return animalsRepository.findById(id).orElse(null);
    }

    @Transactional
    public void update(Animal animal, int id) {
        animal.setAnimalNum(id);
        animalsRepository.save(animal);
    }

    @Transactional
    public void delete(int id) {
        animalsRepository.deleteById(id);
    }

    @Transactional
    public void save(Animal animal) {
        animalsRepository.save(animal);
    }

}
