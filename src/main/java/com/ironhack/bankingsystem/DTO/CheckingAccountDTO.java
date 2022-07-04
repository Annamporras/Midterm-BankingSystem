package com.ironhack.bankingsystem.DTO;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Currency;

public class CheckingAccountDTO {
    @NotNull(message = "Account's Balance must be specified")
    private BigDecimal balance;

    @NotNull(message = "Account's Currency must be specified")
    private Currency currency;

    @NotNull(message = "Account's Primary Owner must be specified")
    private Integer primaryOwner;

    private Integer secondaryOwner;

    @NotNull(message = "Account's Secret Key must be specified")
    private String secretKey;

    public CheckingAccountDTO() {
    }

    public CheckingAccountDTO(BigDecimal balance, Currency currency, Integer primaryOwner, Integer secondaryOwner, String secretKey) {
        this.balance = balance;
        this.currency = currency;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.secretKey = secretKey;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(Integer primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public Integer getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(Integer secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
