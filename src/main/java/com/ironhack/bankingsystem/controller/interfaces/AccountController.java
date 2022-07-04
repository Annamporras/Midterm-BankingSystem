package com.ironhack.bankingsystem.controller.interfaces;

import com.ironhack.bankingsystem.DTO.AccountBalanceDTO;
import com.ironhack.bankingsystem.DTO.AccountStatusDTO;
import com.ironhack.bankingsystem.model.Account;
import com.ironhack.bankingsystem.model.Money;
import org.springframework.web.bind.annotation.RestController;

public interface AccountController {

        Account patchAccountStatus(Integer id, AccountStatusDTO accountStatusDTO);
        Account patchAccountBalance(Integer id, AccountBalanceDTO accountBalanceDTO);
        Money getAccountBalance(Integer id);
        Account deleteAccount(Integer id);


}
