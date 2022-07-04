package com.ironhack.bankingsystem.controller.interfaces;

import com.ironhack.bankingsystem.DTO.CheckingAccountDTO;
import com.ironhack.bankingsystem.model.CheckingAccount;

public interface CheckingAccountController {

    CheckingAccount saveCheckingAccount(CheckingAccountDTO checkingAccountDTO);

}
