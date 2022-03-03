package com.wedoogift.challenge.service.distribution;

import com.wedoogift.challenge.entity.Company;
import com.wedoogift.challenge.entity.User;
import com.wedoogift.challenge.entity.deposit.Deposit;
import com.wedoogift.challenge.entity.deposit.MealDeposit;
import com.wedoogift.challenge.exception.BalanceException;
import org.springframework.stereotype.Service;

@Service
public class DistributionMealService implements DistributionInterface {

    @Override
    public void distributeDeposit(Company company, User user, double amount) throws BalanceException {
        double balance = company.getMealBalance();
        if (balance == 0 || balance - amount < 0) {
            throw new BalanceException();
        }
        Deposit deposit = new MealDeposit(amount);
        user.addMealDeposit(deposit);
        balance -= amount;
        company.setMealBalance(balance);
    }

}
