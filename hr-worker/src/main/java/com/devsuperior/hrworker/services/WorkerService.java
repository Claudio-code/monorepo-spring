package com.devsuperior.hrworker.services;

import com.devsuperior.hrworker.dto.WorkerDTO;
import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.factories.WorkerFactory;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class WorkerService {
    private WorkerRepository workerRepository;
    
    public List<WorkerDTO> findAll() {
        return workerRepository
                .findAll()
                .stream()
                .map(WorkerFactory::make)
                .toList();
    }

    public WorkerDTO findById(Long id) {
        final var worker = workerRepository
                .findById(id)
                .orElseThrow();
        return WorkerFactory.make(worker);
    }

    public void create(WorkerDTO workerDTO) {
        final var worker = new Worker();
        worker.setName(workerDTO.name());
        worker.setDailyIncome(workerDTO.dailyIncome());
        workerRepository.save(worker);
    }
}
