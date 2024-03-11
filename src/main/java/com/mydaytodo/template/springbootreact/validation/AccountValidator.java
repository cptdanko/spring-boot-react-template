package com.mydaytodo.template.springbootreact.validation;

import com.mydaytodo.template.springbootreact.dao.AccountDaoImpl;
import com.mydaytodo.template.springbootreact.model.Account;
import com.mydaytodo.template.springbootreact.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class AccountValidator {

    public static String ACCOUNT_WITH_ID_NOT_EXIST_MSG = "Account with Id does not exist";
    @Autowired
    private AccountDaoImpl accountDao;
    public ApiResponse accountExists(String id) {
        Optional<Account> account = accountDao.getAccount(id);
        if (account.isEmpty()) {
            return ApiResponse.builder()
                    .responseCode(HttpStatus.NOT_FOUND.value())
                    .message("Account with id doesn't exist")
                    .data(null)
                    .build();
        }
        return null;
    }
}
