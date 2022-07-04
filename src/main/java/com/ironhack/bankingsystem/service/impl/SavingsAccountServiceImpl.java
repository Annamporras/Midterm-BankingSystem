package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.DTO.SavingsAccountDTO;
import com.ironhack.bankingsystem.model.AccountHolder;
import com.ironhack.bankingsystem.model.Money;
import com.ironhack.bankingsystem.model.SavingsAccount;
import com.ironhack.bankingsystem.repository.AccountHolderRepository;
import com.ironhack.bankingsystem.repository.SavingsAccountRepository;
import com.ironhack.bankingsystem.service.interfaces.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Override
    public SavingsAccount store(SavingsAccountDTO savingsAccountDTO) {

        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setBalance(new Money(savingsAccountDTO.getBalance(), savingsAccountDTO.getCurrency()));

        Optional<AccountHolder> optionalPrimaryOwner = accountHolderRepository.findById(savingsAccountDTO.getPrimaryOwner());
        if(!optionalPrimaryOwner.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        savingsAccount.setPrimaryOwner(optionalPrimaryOwner.get());
        Optional<AccountHolder> optionalSecondaryOwner = accountHolderRepository.findById(savingsAccountDTO.getSecondaryOwner());

        if(optionalSecondaryOwner.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        savingsAccount.setSecondaryOwner(optionalSecondaryOwner.get());


        return savingsAccountRepository.save(savingsAccount);
    }
}

