package com.ironhack.bankingsystem.model;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@PrimaryKeyJoinColumn(name="id")
public class SavingsAccount extends Account{
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance")),
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency"))
    })
    @Embedded
    private Money minimumBalance;
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "monthly_maintenance_fee")),
            @AttributeOverride(name = "currency", column = @Column(name = "monthly_maintenance_fee_currency"))
    })
    @Embedded
    private Money monthlyMaintenanceFee;
    private BigDecimal interestFee;

}
