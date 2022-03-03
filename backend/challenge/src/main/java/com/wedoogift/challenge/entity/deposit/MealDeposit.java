package com.wedoogift.challenge.entity.deposit;

import java.time.LocalDate;

import com.wedoogift.challenge.entity.deposit.Deposit;

public class MealDeposit extends Deposit {


    public MealDeposit(double amount) {
        this.setAmount(amount);
        LocalDate date = LocalDate.now();
        this.setStartDate(date);
        this.setEndDate(LocalDate.of(date.getYear() + 1, 2, date.plusYears(1).isLeapYear() ? 29 : 28));
    }

    public MealDeposit(double amount, LocalDate startDate) {
        this.setAmount(amount);
        this.setStartDate(startDate);
        this.setEndDate(LocalDate.of(startDate.getYear() + 1, 2, startDate.plusYears(1).isLeapYear() ? 29 : 28));
    }
}
