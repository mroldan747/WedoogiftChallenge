package com.wedoogift.challenge.distribution;

import java.util.List;

import com.wedoogift.challenge.entity.Company;
import com.wedoogift.challenge.entity.User;
import com.wedoogift.challenge.entity.deposit.Deposit;
import com.wedoogift.challenge.exception.BalanceException;
import com.wedoogift.challenge.service.distribution.DistributionMealService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DistributionMealTest implements DistributionTestInterface {

    @Autowired
    DistributionMealService distributionMealService;

    private static User user;
    private static Company company;

    @BeforeEach
    public void setUp() {

        company = new Company("Apple");
        company.setMealBalance(200);
        user = new User("Mel");
    }

    @Test
    public void distributeDepositTest() throws BalanceException {

        distributionMealService.distributeDeposit(company, user, 100);
        List<Deposit> deposits = user.getMealDeposits();
        assertEquals(deposits.size(), 1);
        assertEquals(deposits.get(0).getAmount(), 100);
    }

    @Test()
    public void notEnoughBalanceToDistributeDepositTest() {

        Exception exception = assertThrows(BalanceException.class, () -> {
            distributionMealService.distributeDeposit(company, user, 210);
        });

        String expectedMessage = "Your balance is not enough to make this operation";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test()
    public void notEnoughBalanceToDistributeDepositWhenBalanceIsZeroTest() {

        company.setMealBalance(0);

        Exception exception = assertThrows(BalanceException.class, () -> {
            distributionMealService.distributeDeposit(company, user, 210);
        });

        String expectedMessage = "Your balance is not enough to make this operation";
        assertEquals(expectedMessage, exception.getMessage());
    }

}
