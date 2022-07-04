package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.DTO.SavingsAccountDTO;
import com.ironhack.bankingsystem.model.SavingsAccount;

public interface SavingsAccountService {

    SavingsAccount store(SavingsAccountDTO savingsAccountDTO);
}
