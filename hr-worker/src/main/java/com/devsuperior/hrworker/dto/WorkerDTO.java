package com.devsuperior.hrworker.dto;

import lombok.Builder;

@Builder
public record WorkerDTO(Long id,
                        String name,
                        Double dailyIncome) {
}
