package com.ironhack.bankingsystem.controller.impl;

import com.ironhack.bankingsystem.DTO.CreditCardAccountDTO;
import com.ironhack.bankingsystem.controller.interfaces.CreditCardAccountController;
import com.ironhack.bankingsystem.model.CreditCardAccount;
import com.ironhack.bankingsystem.service.interfaces.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CreditCardAccountControllerImpl implements CreditCardAccountController {

    @Autowired
    private CreditCardService creditCardService;
    //importar servicio
    @PostMapping("accounts/creditcard-account/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCardAccount saveCreditCardAccount(@RequestBody @Valid CreditCardAccountDTO creditCardAccountDTO) {
        return creditCardService.store(creditCardAccountDTO);
          // servicio . metodo del servicio(DTO)
    }
}
