package com.wedoogift.challenge.exception;

public class BalanceException extends Exception {

    public BalanceException() {
        super("Your balance is not enough to make this operation");
    }
}
