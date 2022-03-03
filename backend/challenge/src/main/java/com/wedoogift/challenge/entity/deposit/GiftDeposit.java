package com.wedoogift.challenge.entity.deposit;

import java.time.LocalDate;

import com.wedoogift.challenge.entity.deposit.Deposit;

public class GiftDeposit extends Deposit {

    public GiftDeposit(double amount) {
        this.setAmount(amount);
        LocalDate date = LocalDate.now();
        this.setStartDate(date);
        this.setEndDate(date.plusDays(365));
    }

    public GiftDeposit(double amount, LocalDate startDate) {
        this.setAmount(amount);
        this.setStartDate(startDate);
        this.setEndDate(startDate.plusDays(365));
    }

}
