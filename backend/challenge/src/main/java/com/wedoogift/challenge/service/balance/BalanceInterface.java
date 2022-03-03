package com.wedoogift.challenge.service.balance;

import java.time.LocalDate;

import com.wedoogift.challenge.entity.User;

public interface BalanceInterface {

    double getBalance(User user, LocalDate date);
}
