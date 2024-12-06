package org.morrs.circusbackend.services;

import lombok.AllArgsConstructor;
import org.morrs.circusbackend.models.Performance;
import org.morrs.circusbackend.repo.PerformancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PerformanceService {

    private PerformancesRepository performancesRepository;

    public List<Performance> readAll() {
        return performancesRepository.findAll();
    }

    public Performance read(int id) {
        return performancesRepository.findById(id).orElse(null);
    }

    @Transactional
    public void update(Performance artist, int id) {
        artist.setPerCode(id);
        performancesRepository.save(artist);
    }

    @Transactional
    public void delete(int id) {
        performancesRepository.deleteById(id);
    }

    @Transactional
    public void save(Performance artist) {
        performancesRepository.save(artist);
    }
}
