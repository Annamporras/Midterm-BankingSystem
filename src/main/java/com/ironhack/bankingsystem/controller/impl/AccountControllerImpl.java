package com.ironhack.bankingsystem.controller.impl;

import com.ironhack.bankingsystem.controller.interfaces.AccountController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountControllerImpl implements AccountController {

    @GetMapping("/hello/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String helloName(@PathVariable(name="name") String name) {
        return "Hello " + name;
    }
}
