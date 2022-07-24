package com.payroll.mspayroll.services;

import com.payroll.mspayroll.clients.WorkerFeignClient;
import com.payroll.mspayroll.entities.Payments;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
public class PaymentsService {
    private WorkerFeignClient workerFeignClient;

    public Payments gPayments(long workerId, int days) throws RuntimeException {
        final var worker = workerFeignClient.findById(workerId)
                .getBody();
        if (Objects.isNull(worker)) {
            throw new RuntimeException("worker not Found");
        }

        return Payments
                .builder()
                .name(worker.getName())
                .dailyIncome(worker.getDailyIncome())
                .days(days)
                .build();
    }
}
