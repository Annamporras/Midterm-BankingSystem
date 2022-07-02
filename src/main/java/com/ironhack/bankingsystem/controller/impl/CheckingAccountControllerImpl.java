package com.ironhack.bankingsystem.controller.impl;

import com.ironhack.bankingsystem.DTO.CheckingAccountDTO;
import com.ironhack.bankingsystem.DTO.CreditCardAccountDTO;
import com.ironhack.bankingsystem.controller.interfaces.CheckingAccountController;
import com.ironhack.bankingsystem.model.CheckingAccount;
import com.ironhack.bankingsystem.model.CreditCardAccount;
import com.ironhack.bankingsystem.service.interfaces.CheckingAccountService;
import com.ironhack.bankingsystem.service.interfaces.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CheckingAccountControllerImpl implements CheckingAccountController {

    @Autowired
    private CheckingAccountService checkingAccountService;

    @PostMapping("/checking-account/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CheckingAccount saveCheckingAccount(@RequestBody @Valid CheckingAccountDTO checkingAccountDTO){
        return checkingAccountService.store(checkingAccountDTO);
    }

}
