package com.ironhack.bankingsystem.controller.interfaces;

import com.ironhack.bankingsystem.DTO.CreditCardAccountDTO;
import com.ironhack.bankingsystem.model.CreditCardAccount;

public interface CreditCardAccountController {
    CreditCardAccount saveCreditCardAccount(CreditCardAccountDTO creditCardAccountDTO);
}
