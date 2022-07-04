package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.DTO.AccountBalanceDTO;
import com.ironhack.bankingsystem.DTO.AccountStatusDTO;
import com.ironhack.bankingsystem.model.Account;
import com.ironhack.bankingsystem.model.Money;
import com.ironhack.bankingsystem.repository.AccountRepository;
import com.ironhack.bankingsystem.repository.UserRepository;
import com.ironhack.bankingsystem.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.awt.desktop.OpenFilesEvent;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    public Account findById(Integer id){
        Optional<Account> foundAccount = accountRepository.findById(id);

        if(!foundAccount.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There's no account with that id");
        }
       return foundAccount.get();
    }

    @Override
    public Money getAccountBalance(Integer id) {
        Account account = findById(id);
        return account.getBalance();
    }
    @Override
    public Account changeAccountBalance(Integer id, AccountBalanceDTO accountBalanceDTO) {
        Account newAccountBalance = findById(id);

        try {
            newAccountBalance.setBalance(new Money(accountBalanceDTO.getBalance(), accountBalanceDTO.getCurrency()));
            accountRepository.save(newAccountBalance);
        } catch (Exception e) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "This balance is not valid");
        }
        return newAccountBalance;
    }

    @Override
    public Account changeAccountStatus(Integer id, AccountStatusDTO accountStatusDTO) {
        Account newAccountStatus = findById(id);

        try {
            newAccountStatus.setStatus(accountStatusDTO.getStatus());
            accountRepository.save(newAccountStatus);
        } catch (Exception e) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "This status is not valid");
        }

        return newAccountStatus;
    }
    @Override
    public Account deleteAccount(Integer id) {
        Account foundAccount = findById(id);
        accountRepository.delete(foundAccount);

        return foundAccount;
    }
}
