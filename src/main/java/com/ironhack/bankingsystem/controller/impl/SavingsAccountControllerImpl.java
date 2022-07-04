package com.ironhack.bankingsystem.controller.impl;

import com.ironhack.bankingsystem.DTO.CreditCardAccountDTO;
import com.ironhack.bankingsystem.DTO.SavingsAccountDTO;
import com.ironhack.bankingsystem.controller.interfaces.SavingsAccountController;
import com.ironhack.bankingsystem.model.CreditCardAccount;
import com.ironhack.bankingsystem.model.SavingsAccount;
import com.ironhack.bankingsystem.service.interfaces.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SavingsAccountControllerImpl implements SavingsAccountController {

    @Autowired
    private SavingsAccountService savingsAccountService;
    @PostMapping("/savings-account/new")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingsAccount saveSavingsAccount(@RequestBody @Valid SavingsAccountDTO savingsAccountDTO) {
        return savingsAccountService.store(savingsAccountDTO);
    }


}

