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
@Transactional(readOnly = true)
public class PerformanceService {

    private PerformancesRepository performancesRepository;

    public List<Performance> readAll() {
        return performancesRepository.findAll();
    }

    public Performance read(int id) {
        return performancesRepository.findById(id).orElse(null);
    }

    @Transactional
    public void update(Performance performance, int id) {
        performance.setPerCode(id);
        performancesRepository.save(performance);
    }

    @Transactional
    public void delete(int id) {
        performancesRepository.deleteById(id);
    }

    @Transactional
    public void save(Performance performance) {
        performancesRepository.save(performance);
    }
}
