package com.wedoogift.challenge.service.balance;

import java.time.LocalDate;

import com.wedoogift.challenge.entity.User;
import com.wedoogift.challenge.entity.deposit.Deposit;
import org.springframework.stereotype.Service;

@Service
public class GiftBalanceService implements BalanceInterface {

    @Override
    public double getBalance(User user, LocalDate date) {

        return user.getGiftDeposits().stream()
                .filter(mealDeposit -> date.isBefore(mealDeposit.getEndDate()) && date.isAfter(mealDeposit.getStartDate()))
                .mapToDouble(Deposit::getAmount).sum();
    }
}
