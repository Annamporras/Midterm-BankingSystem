package com.ironhack.bankingsystem.DTO;

import com.ironhack.bankingsystem.model.Money;

public class AccountBalanceDTO {

    private Money balance;

    public AccountBalanceDTO() {
    }

    public AccountBalanceDTO(Money balance) {
        this.balance = balance;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }
}
