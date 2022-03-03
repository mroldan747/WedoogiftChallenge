package com.wedoogift.challenge.service.distribution;

import com.wedoogift.challenge.entity.Company;
import com.wedoogift.challenge.entity.User;
import com.wedoogift.challenge.entity.deposit.Deposit;
import com.wedoogift.challenge.entity.deposit.GiftDeposit;
import com.wedoogift.challenge.exception.BalanceException;
import org.springframework.stereotype.Service;

@Service
public class DistributionGiftService implements DistributionInterface {

    @Override
    public void distributeDeposit(Company company, User user, double amount) throws BalanceException {
        double balance = company.getGiftBalance();
        if (balance == 0 || balance - amount < 0) {
            throw new BalanceException();
        }
        Deposit deposit = new GiftDeposit(amount);
        user.addGiftDeposit(deposit);
        balance -= amount;
        company.setMealBalance(balance);
    }


}
