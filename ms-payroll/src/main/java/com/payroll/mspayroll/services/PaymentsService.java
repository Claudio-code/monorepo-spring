package com.payroll.mspayroll.services;

import com.payroll.mspayroll.entities.Payments;
import org.springframework.stereotype.Service;

@Service
public class PaymentsService {
    public Payments gPayments(long workerId, int days) {
        return Payments
                .builder()
                .name("Bob")
                .dailyIncome(200.0)
                .days(days)
                .build();
    }
}
