package com.ironhack.bankingsystem.controller.interfaces;

import com.ironhack.bankingsystem.security.CustomUserDetails;

public interface UserController {

    String helloUser(CustomUserDetails customUserDetails);
}
