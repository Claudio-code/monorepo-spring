package com.payroll.mspayroll.entities;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Payments {
    private String name;
    private Double dailyIncome;
    private Integer days;
}
