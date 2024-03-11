package com.mydaytodo.template.springbootreact.model;

import lombok.*;
import lombok.extern.java.Log;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

@Getter
@Setter
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
