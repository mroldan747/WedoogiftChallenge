package com.wedoogift.challenge.entity;

public class Company {


    private double mealBalance = 0;

    private double giftBalance = 0;

    public Company(String companyName, double mealBalance, double giftBalance) {
        this.mealBalance = mealBalance;
        this.giftBalance = giftBalance;
    }

    public Company(String companyName) {

    }

    public double getMealBalance() {
        return mealBalance;
    }

    public void setMealBalance(double mealBalance) {
        this.mealBalance = mealBalance;
    }

    public double getGiftBalance() {
        return giftBalance;
    }

    public void setGiftBalance(double giftBalance) {
        this.giftBalance = giftBalance;
    }
}
