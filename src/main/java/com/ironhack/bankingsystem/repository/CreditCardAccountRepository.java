package com.ironhack.bankingsystem.repository;

import com.ironhack.bankingsystem.model.CreditCardAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardAccountRepository extends JpaRepository<CreditCardAccount, Integer> {
}
