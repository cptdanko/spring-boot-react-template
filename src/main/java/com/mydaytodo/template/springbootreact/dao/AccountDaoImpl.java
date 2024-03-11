package com.mydaytodo.template.springbootreact.dao;

import com.mydaytodo.template.springbootreact.model.Account;
import com.mydaytodo.template.springbootreact.model.ApiResponse;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Log
public class AccountDaoImpl {
    private List<Account> accounts = new ArrayList();

    public List<Account> getAccounts() {
        return accounts;
    }

    public Optional<Account> getAccount(String accountId) {
        return accounts.stream()
                .filter(account -> account.getAccountId().equals(accountId))
                .findFirst();
    }
    public ApiResponse addNewAccount(Account account) {
        log.info(String.format("About to add account [ %s ]", account.toString()));
        accounts.add(account);
        return ApiResponse.builder()
                .data(account)
                .responseCode(HttpStatus.CREATED.value())
                .message("")
                .build();
    }
    public ApiResponse getAccountFor(String accountId) {
        Optional<Account> account = getAccount(accountId);
        return ApiResponse.builder()
                .data(account.get())
                .responseCode(HttpStatus.OK.value())
                .build();
    }
    public ApiResponse deleteAccount(String accountId) {
        accounts = accounts.stream()
                .filter(account -> !(account.getAccountId().equals(accountId)))
                .toList();
        return ApiResponse.builder()
                .responseCode(HttpStatus.NO_CONTENT.value())
                .data(accounts)
                .build();
    }
    public ApiResponse updateAccount(String accountId, Account account) {
        accounts.stream()
                .filter(account1 -> account1.getAccountId().equals(accountId))
                .findFirst()
                .ifPresent(account1 -> account1.update(account));
        return ApiResponse.builder()
                .responseCode(HttpStatus.NO_CONTENT.value())
                .message("")
                .data(accounts)
                .build();
    }
    public ApiResponse getAllAccounts() {
        log.info("Received request to get all accounts");
        return ApiResponse.builder()
                .responseCode(HttpStatus.OK.value())
                .message("")
                .data(accounts)
                .build();
    }
}
