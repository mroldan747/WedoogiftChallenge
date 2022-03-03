package com.wedoogift.challenge.entity;

import java.util.ArrayList;
import java.util.List;

import com.wedoogift.challenge.entity.deposit.Deposit;

public class User {

    private List<Deposit> mealDeposits = new ArrayList<>();
    private List<Deposit> giftDeposits = new ArrayList<>();

    public User(String name) {
    }

    public List<Deposit> getMealDeposits() {
        return mealDeposits;
    }

    public void setMealDeposits(List<Deposit> mealDeposits) {
        this.mealDeposits = mealDeposits;
    }

    public void addMealDeposit(Deposit mealDeposit) {
        this.mealDeposits.add(mealDeposit);
    }

    public List<Deposit> getGiftDeposits() {
        return giftDeposits;
    }

    public void setGiftDeposits(List<Deposit> giftDeposits) {
        this.giftDeposits = giftDeposits;
    }

    public void addGiftDeposit(Deposit giftDeposit) {
        this.giftDeposits.add(giftDeposit);
    }
}
