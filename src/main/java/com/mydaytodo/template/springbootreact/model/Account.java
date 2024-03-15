package com.mydaytodo.template.springbootreact.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.java.Log;

import java.math.BigDecimal;

@Data
@ToString
@Log
@Builder
public class Account {
    public static String ID_PATTERN = "ACT_";

    private String accountId;
    private String name;
    private BigDecimal balance;
    private String accountType; // mapped from the Account type enum

    public void update(Account updateWith) {
        if(updateWith.getName() != null)
            this.setName(updateWith.getName());
        if(updateWith.getBalance() != null)
            this.setBalance(updateWith.getBalance());
        if(updateWith.getAccountType() != null)
            this.setAccountType(updateWith.getAccountType());
    }
}
