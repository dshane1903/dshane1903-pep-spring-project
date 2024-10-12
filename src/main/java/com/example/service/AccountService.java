package com.example.service;
import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
import com.example.repository.AccountRepository;
import com.example.entity.Account;
import com.example.exception.*;
import java.util.*;

@Service
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public Account register(Account newAccount) throws AccountIsNullException, DuplicateUsernameException, UsernameIsBlankException, PasswordNotLongEnoughException {
            if (newAccount == null) {
                throw new AccountIsNullException("Account is null and could not be registered.");
            }
            if (newAccount.getPassword().length() < 4) {
                throw new PasswordNotLongEnoughException("This password is not long enough and could not be registered.");
            }
            if (newAccount.getUsername().isBlank()) {
                throw new UsernameIsBlankException("The username for this account is blank and could not be registered.");
            }
            if (accountRepository.findByUsername(newAccount.getUsername()).isPresent()) {
                throw new DuplicateUsernameException("The username for this account already exists and could not be registered.");
            }

        return accountRepository.save(newAccount);
    }

    public Account login(String username, String password) throws IncorrectLoginException {
        return accountRepository.findByUsernameAndPassword(username, password).orElseThrow(() -> new IncorrectLoginException("This login is incorrect; login failed."));

    }
}


