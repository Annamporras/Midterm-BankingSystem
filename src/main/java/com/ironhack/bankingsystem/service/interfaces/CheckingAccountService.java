package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.DTO.CheckingAccountDTO;
import com.ironhack.bankingsystem.model.CheckingAccount;

public interface CheckingAccountService {

    CheckingAccount store(CheckingAccountDTO checkingAccountDTO);
}
