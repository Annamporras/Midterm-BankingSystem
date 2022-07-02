package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.DTO.AccountBalanceDTO;
import com.ironhack.bankingsystem.model.Account;
import com.ironhack.bankingsystem.model.Money;

public interface AccountService {

    Account changeAccountBalance(Integer id, AccountBalanceDTO accountBalanceDTO);

    Money getAccountBalance(Integer id);
}
