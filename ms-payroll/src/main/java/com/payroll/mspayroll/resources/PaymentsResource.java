package com.payroll.mspayroll.resources;

import com.payroll.mspayroll.entities.Payments;
import com.payroll.mspayroll.services.PaymentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentsResource {
    private PaymentsService service;

    @GetMapping(value = "/{workerId}/days/{days}")
    @ResponseStatus(code = HttpStatus.OK)
    public Payments gPayments(@PathVariable long workerId, @PathVariable Integer days) {
        return service.gPayments(workerId, days);
    }
}
