package com.ironhack.bankingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BankingSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(BankingSystemApplication.class, args);
	}

}
