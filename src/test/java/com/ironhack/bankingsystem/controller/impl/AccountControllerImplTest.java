package com.ironhack.bankingsystem.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.bankingsystem.DTO.CheckingAccountDTO;
import com.ironhack.bankingsystem.model.*;
import com.ironhack.bankingsystem.repository.AccountHolderRepository;
import com.ironhack.bankingsystem.repository.AccountRepository;
import com.ironhack.bankingsystem.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static java.math.RoundingMode.HALF_EVEN;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerImplTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    private AccountHolder accountHolder1, accountHolder2;
    private CheckingAccount checkingAccount1, checkingAccount2;
    private Role adminRole, accountHolderRole;

    private final ObjectMapper objectMapper = new ObjectMapper();
    @BeforeEach
    void setUp() {
        accountHolder1 = new AccountHolder("name1", "username1", passwordEncoder.encode("test1"),
                new Date(1999, 2, 3),
                new Address("test street 1", "33kk4", "ciudad1", "country1"),
                new Address("test street 1", "33kk4", "ciudad1", "country1"));
        accountHolderRole = new Role("ACCOUNTHOLDER", accountHolder1);
        accountHolder1.setRoles(Set.of(accountHolderRole));

        accountHolder2 = new AccountHolder("name2", "username2", passwordEncoder.encode("test2"),
                new Date(1999, 2, 3),
                new Address("test street 2", "33kk4", "ciudad2", "country2"),
                new Address("test street 2", "33kk4", "ciudad2", "country2"));
        adminRole = new Role("ADMIN", accountHolder2);
        accountHolder2.setRoles(Set.of(adminRole));

        accountHolderRepository.saveAll(List.of(accountHolder1, accountHolder2));

       /* checkingAccount1 = new CheckingAccount(new CheckingAccountDTO(BigDecimal.valueOf(200), Currency.getInstance("EUR"), accountHolder1.getUserId(), accountHolder2.getUserId(),"44p0"));
        checkingAccount2 = CheckingAccount(new CheckingAccountDTO(BigDecimal.valueOf(300), Currency.getInstance("EUR"), accountHolder1.getUserId(), accountHolder2.getUserId(),"44p0"));
        accountRepository.saveAll(List.of(checkingAccount1, checkingAccount2));
    }*/
    }
    @AfterEach
    void tearDown() {
        accountHolderRepository.deleteAll();

    }

    @Test
    void patchAccountBalance() {
    }

    @Test
    void patchAccountStatus() {
    }

    @Test
    void getAccountBalance() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic QW5uYTE6dGVzdDE=");
        MvcResult mvcResult = mockMvc.perform(get("/balance/{id}").headers(httpHeaders))
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("250"));

    }

    @Test
    void deleteAccount() {
    }
}