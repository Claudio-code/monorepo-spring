package com.payroll.mspayroll.services;

import com.payroll.mspayroll.entities.Payments;
import com.payroll.mspayroll.entities.Worker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@AllArgsConstructor
@Service
public class PaymentsService {
    private RestTemplate hrWorkerRestTemplate;

    public Payments gPayments(long workerId, int days) throws RuntimeException {
        final var worker = hrWorkerRestTemplate.getForObject("/workers/" + workerId, Worker.class);
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
