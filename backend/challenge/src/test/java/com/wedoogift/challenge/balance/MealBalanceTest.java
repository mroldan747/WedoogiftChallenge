package com.wedoogift.challenge.balance;

import java.time.LocalDate;

import com.wedoogift.challenge.entity.User;
import com.wedoogift.challenge.entity.deposit.Deposit;
import com.wedoogift.challenge.entity.deposit.MealDeposit;
import com.wedoogift.challenge.exception.BalanceException;
import com.wedoogift.challenge.service.balance.BalanceInterface;
import com.wedoogift.challenge.service.balance.MealBalanceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MealBalanceTest implements BalanceTestInterface {

    private static User user;

    @Autowired
    MealBalanceService mealBalanceService;


    @BeforeAll
    public static void setUp() {
        user = new User("Mel");
        Deposit deposit = new MealDeposit(100);
        Deposit deposit1 = new MealDeposit(200, LocalDate.of(2021, 1, 3));
        user.addMealDeposit(deposit);
        user.addMealDeposit(deposit1);
    }

    @Test
    public void getBalanceBeforeExpireDateTest() {
        double balance = mealBalanceService.getBalance(user, LocalDate.of(2022, 1, 1));
        Assertions.assertEquals(200, balance);
    }

    @Test
    public void getBalanceAfterExpireDateTest() {
        double balance = mealBalanceService.getBalance(user, LocalDate.of(2022, 3, 1));
        Assertions.assertEquals(0, balance);
    }

    @Test
    public void getBalanceBeforeStartDateTest() {
        double balance = mealBalanceService.getBalance(user, LocalDate.of(2020, 12, 3));
        Assertions.assertEquals(0, balance);
    }
}
