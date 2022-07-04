package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.DTO.AccountBalanceDTO;
import com.ironhack.bankingsystem.DTO.AccountStatusDTO;
import com.ironhack.bankingsystem.model.Account;
import com.ironhack.bankingsystem.model.Money;

public interface AccountService {

    Money getAccountBalance(Integer id);
    Account changeAccountStatus(Integer id, AccountStatusDTO accountStatusDTO);
    Account changeAccountBalance(Integer id, AccountBalanceDTO accountBalanceDTO);

    Account deleteAccount(Integer id);
}
