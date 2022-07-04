package com.ironhack.bankingsystem.controller.impl;


import com.ironhack.bankingsystem.DTO.AccountBalanceDTO;
import com.ironhack.bankingsystem.DTO.AccountStatusDTO;
import com.ironhack.bankingsystem.controller.interfaces.AccountController;
import com.ironhack.bankingsystem.model.Account;
import com.ironhack.bankingsystem.model.Money;
import com.ironhack.bankingsystem.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AccountControllerImpl implements AccountController {

    @Autowired
    private AccountService accountService;


    @PatchMapping("/change-balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account patchAccountBalance(@PathVariable("id") Integer id, @RequestBody @Valid AccountBalanceDTO accountBalanceDTO) {
        return accountService.changeAccountBalance(id,accountBalanceDTO);
    }
    @PatchMapping("/change-status/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account patchAccountStatus(@PathVariable("id") Integer id, @RequestBody @Valid AccountStatusDTO accountStatusDTO) {
        return accountService.changeAccountStatus(id,accountStatusDTO);
    }

    @GetMapping("/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Money getAccountBalance(@AuthenticationPrincipal @PathVariable("id") Integer id) {

        return accountService.getAccountBalance(id);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account deleteAccount(@PathVariable("id") Integer id) {
        return accountService.deleteAccount(id);
    }
}