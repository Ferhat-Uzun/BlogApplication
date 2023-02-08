package com.ferhat.BlogApplication.service;

import com.ferhat.BlogApplication.model.Account;
import com.ferhat.BlogApplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account){
        return accountRepository.save(account);
    }
    public Optional<Account> findByEmail(String email){
        return  accountRepository.findByEmail(email);
    }
}
