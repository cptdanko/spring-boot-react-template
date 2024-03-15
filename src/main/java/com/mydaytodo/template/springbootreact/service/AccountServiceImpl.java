package com.mydaytodo.template.springbootreact.service;

import com.mydaytodo.template.springbootreact.dao.AccountDaoImpl;
import com.mydaytodo.template.springbootreact.model.Account;
import com.mydaytodo.template.springbootreact.model.ApiResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Ideally, this should implement an interface for AcountService
 * However, ignoring it here to keep the code brief here
 */
@Service
@Log
public class AccountServiceImpl {
    @Autowired
    private AccountDaoImpl accountDao;

    public ApiResponse addAccount(Account account) {
        log.info("About to generate id");
        String id = Account.ID_PATTERN + System.currentTimeMillis();
        account.setAccountId(id);
        log.info("Adding value "+ id);
        return accountDao.addNewAccount(account);
    }
    public ApiResponse deleteAccount(String accountId) {
        return accountDao.deleteAccount(accountId);
    }
    public ApiResponse updateAccount(String accountId, Account account) {
        return accountDao.updateAccount(accountId, account);
    }
    public ApiResponse getAccount(String accountId) {
        return accountDao.getAccountFor(accountId);
    }
    public ApiResponse getAllAccounts() {
        return accountDao.getAllAccounts();
    }
}
