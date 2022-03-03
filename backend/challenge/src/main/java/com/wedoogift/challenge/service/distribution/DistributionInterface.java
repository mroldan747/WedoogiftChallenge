package com.wedoogift.challenge.service.distribution;

import com.wedoogift.challenge.exception.BalanceException;
import com.wedoogift.challenge.entity.Company;
import com.wedoogift.challenge.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface DistributionInterface {

    void distributeDeposit(Company company, User user, double amount) throws BalanceException;

}
