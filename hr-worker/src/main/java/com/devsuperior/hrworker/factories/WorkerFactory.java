package com.devsuperior.hrworker.factories;

import com.devsuperior.hrworker.dto.WorkerDTO;
import com.devsuperior.hrworker.entities.Worker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WorkerFactory {
    public static WorkerDTO make(Worker worker) {
        return WorkerDTO
                .builder()
                .id(worker.getId())
                .name(worker.getName())
                .dailyIncome(worker.getDailyIncome())
                .build();
    }
}
