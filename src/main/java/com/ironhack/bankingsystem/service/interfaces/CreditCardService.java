package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.DTO.CreditCardAccountDTO;
import com.ironhack.bankingsystem.model.CreditCardAccount;

public interface CreditCardService {

    CreditCardAccount store(CreditCardAccountDTO creditCardAccountDTO);


}
