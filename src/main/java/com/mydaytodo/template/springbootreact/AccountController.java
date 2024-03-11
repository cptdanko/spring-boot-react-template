package com.mydaytodo.template.springbootreact;

import com.mydaytodo.template.springbootreact.model.Account;
import com.mydaytodo.template.springbootreact.model.ApiResponse;
import com.mydaytodo.template.springbootreact.service.AccountServiceImpl;
import com.mydaytodo.template.springbootreact.validation.AccountValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/account")
@Slf4j
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private AccountValidator accountValidator;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> createAccount(@RequestBody Account account) {
        log.info(String.format("Received request to add acount -> [ %s ]", account.toString()));
        // do something
        ApiResponse response = accountService.addAccount(account);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @GetMapping("/{account-id}")
    public ResponseEntity<ApiResponse> getAccount(@PathVariable("account-id") String accountId) {
        ApiResponse validation = accountValidator.accountExists(accountId);
        if(validation != null) {
            return new ResponseEntity<>(validation, HttpStatus.valueOf(validation.getResponseCode()));
        }
        ApiResponse response = accountService.getAccount(accountId);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @PutMapping("/update/{account-id}")
    public ResponseEntity<ApiResponse> updateAccount(@PathVariable("account-id") String accountId, @RequestBody Account account) {
        ApiResponse validation = accountValidator.accountExists(accountId);
        if(validation != null) {
            return new ResponseEntity<>(validation, HttpStatus.valueOf(validation.getResponseCode()));
        }
        ApiResponse response = accountService.updateAccount(accountId, account);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }

    @DeleteMapping("/{account-id}")
    public ResponseEntity<ApiResponse> deleteAccount(@PathVariable("account-id") String accountId) {
        ApiResponse validation = accountValidator.accountExists(accountId);
        if(validation != null) {
            return new ResponseEntity<>(validation, HttpStatus.valueOf(validation.getResponseCode()));
        }
        ApiResponse response = accountService.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.valueOf(response.getResponseCode()));
    }
    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<ApiResponse> getAllAccounts() {
        log.info("Received request to get all accounts");
        ApiResponse response = accountService.getAllAccounts();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getResponseCode()));
    }
}