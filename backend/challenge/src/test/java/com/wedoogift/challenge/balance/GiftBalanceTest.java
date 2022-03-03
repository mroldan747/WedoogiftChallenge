package com.wedoogift.challenge.balance;

import java.time.LocalDate;

import com.wedoogift.challenge.entity.User;
import com.wedoogift.challenge.entity.deposit.Deposit;
import com.wedoogift.challenge.entity.deposit.GiftDeposit;
import com.wedoogift.challenge.exception.BalanceException;
import com.wedoogift.challenge.service.balance.GiftBalanceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GiftBalanceTest implements BalanceTestInterface {

    private static User user;

    @Autowired
    GiftBalanceService giftBalanceService;

    @BeforeAll
    public static void setUp() {
        user = new User("Mel");
        Deposit deposit = new GiftDeposit(100);
        Deposit deposit1 = new GiftDeposit(200, LocalDate.of(2021, 1, 3));
        user.addGiftDeposit(deposit);
        user.addGiftDeposit(deposit1);

    }

    @Test
    public void getBalanceBeforeExpireDateTest() {
        double balance = giftBalanceService.getBalance(user, LocalDate.of(2022, 1, 1));
        Assertions.assertEquals(200, balance);
    }

    @Test
    public void getBalanceAfterExpireDateTest() {
        double balance = giftBalanceService.getBalance(user, LocalDate.of(2022, 1, 3));
        Assertions.assertEquals(0, balance);
    }

    @Test
    public void getBalanceBeforeStartDateTest() {
        double balance = giftBalanceService.getBalance(user, LocalDate.of(2020, 12, 3));
        Assertions.assertEquals(0, balance);
    }


}
