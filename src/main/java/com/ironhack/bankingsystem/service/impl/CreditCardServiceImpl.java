package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.DTO.CreditCardAccountDTO;
import com.ironhack.bankingsystem.model.AccountHolder;
import com.ironhack.bankingsystem.model.CreditCardAccount;
import com.ironhack.bankingsystem.model.Money;
import com.ironhack.bankingsystem.repository.AccountHolderRepository;
import com.ironhack.bankingsystem.repository.CreditCardAccountRepository;
import com.ironhack.bankingsystem.service.interfaces.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardAccountRepository creditCardAccountRepository;

@Autowired
private AccountHolderRepository accountHolderRepository;
    @Override
    public CreditCardAccount store(CreditCardAccountDTO creditCardAccountDTO) {

        CreditCardAccount creditCardAccount = new CreditCardAccount();

        creditCardAccount.setCreditLimit(new Money(creditCardAccountDTO.getCreditLimit()));
        creditCardAccount.setInterestRate(creditCardAccountDTO.getInterestRate());
        creditCardAccount.setBalance(new Money(creditCardAccountDTO.getBalance(), creditCardAccountDTO.getCurrency()));

        Optional<AccountHolder> optionalPrimaryOwner = accountHolderRepository.findById(creditCardAccountDTO.getPrimaryOwner());

        if(!optionalPrimaryOwner.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        creditCardAccount.setPrimaryOwner(optionalPrimaryOwner.get());
        Optional<AccountHolder> optionalSecondaryOwner = accountHolderRepository.findById(creditCardAccountDTO.getSecondaryOwner());

        if(optionalSecondaryOwner.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        creditCardAccount.setSecondaryOwner(optionalSecondaryOwner.get());


        return creditCardAccountRepository.save(creditCardAccount);
    }
}
