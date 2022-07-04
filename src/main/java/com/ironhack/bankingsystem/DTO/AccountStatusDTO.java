package com.ironhack.bankingsystem.DTO;

import com.ironhack.bankingsystem.enums.Status;

import javax.persistence.Enumerated;

public class AccountStatusDTO {
    @Enumerated
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
