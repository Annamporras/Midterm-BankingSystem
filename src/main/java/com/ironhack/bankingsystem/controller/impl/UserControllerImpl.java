package com.ironhack.bankingsystem.controller.impl;

import com.ironhack.bankingsystem.controller.interfaces.UserController;
import com.ironhack.bankingsystem.security.CustomUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {
    @GetMapping("/hello-user")
    @ResponseStatus(HttpStatus.OK)
    public String helloUser(@AuthenticationPrincipal CustomUserDetails userDetails) {
    userDetails.getUser().getUserId();
        return "Hello " + userDetails.getUser().getUsername();
    }
}
