package com.mydaytodo.template.springbootreact.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public enum AccountType {
    CHEQUE("cheque"),
    SAVINGS("savings"),
    CREDIT("credit");
    private String accountType;
    AccountType(String accountType) {
        this.accountType = accountType;
    }
}
