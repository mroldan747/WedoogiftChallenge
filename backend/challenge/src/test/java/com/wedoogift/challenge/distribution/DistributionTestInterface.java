package com.wedoogift.challenge.distribution;

import com.wedoogift.challenge.exception.BalanceException;

public interface DistributionTestInterface {

    void setUp();
    void distributeDepositTest() throws BalanceException;
    void notEnoughBalanceToDistributeDepositTest();
    void notEnoughBalanceToDistributeDepositWhenBalanceIsZeroTest();
}
