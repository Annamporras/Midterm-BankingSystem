package com.ironhack.bankingsystem.controller.interfaces;

import com.ironhack.bankingsystem.DTO.SavingsAccountDTO;
import com.ironhack.bankingsystem.model.SavingsAccount;

public interface SavingsAccountController {

    SavingsAccount saveSavingsAccount (SavingsAccountDTO savingsAccountDTO);
}
