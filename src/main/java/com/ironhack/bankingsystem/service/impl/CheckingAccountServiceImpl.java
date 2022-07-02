package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.DTO.CheckingAccountDTO;
import com.ironhack.bankingsystem.model.AccountHolder;
import com.ironhack.bankingsystem.model.CheckingAccount;
import com.ironhack.bankingsystem.model.Money;
import com.ironhack.bankingsystem.repository.AccountHolderRepository;
import com.ironhack.bankingsystem.repository.CheckingAccountRepository;
import com.ironhack.bankingsystem.service.interfaces.CheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
@Service
public class CheckingAccountServiceImpl implements CheckingAccountService {

    @Autowired
    private CheckingAccountRepository checkingAccountRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Override
    public CheckingAccount store(CheckingAccountDTO checkingAccountDTO) {

        CheckingAccount checkingAccount = new CheckingAccount();

        checkingAccount.setBalance(new Money(checkingAccountDTO.getBalance(),checkingAccountDTO.getCurrency()));
        checkingAccount.setSecrecKey(checkingAccountDTO.getSecretKey());

        Optional<AccountHolder> optionalPrimaryOwner = accountHolderRepository.findById(checkingAccountDTO.getPrimaryOwner());
        if(!optionalPrimaryOwner.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        checkingAccount.setPrimaryOwner(optionalPrimaryOwner.get());

        Optional<AccountHolder> optionalSecondaryOwner = accountHolderRepository.findById(checkingAccountDTO.getSecondaryOwner());
        if(!optionalSecondaryOwner.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        checkingAccount.setSecondaryOwner(optionalSecondaryOwner.get());

        return checkingAccountRepository.save(checkingAccount);
    }
}
