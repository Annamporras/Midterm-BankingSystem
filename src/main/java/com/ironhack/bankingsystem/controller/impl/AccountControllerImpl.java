package com.ironhack.bankingsystem.controller.impl;


import com.ironhack.bankingsystem.DTO.CreditCardAccountDTO;
import com.ironhack.bankingsystem.controller.interfaces.AccountController;
import com.ironhack.bankingsystem.model.Account;
import com.ironhack.bankingsystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountControllerImpl implements AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/hello/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String helloName(@PathVariable(name = "name") String name) {
        return "Hello " + name;
    }





}