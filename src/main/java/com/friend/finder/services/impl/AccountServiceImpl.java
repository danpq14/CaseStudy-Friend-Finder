package com.friend.finder.services.impl;

import com.friend.finder.models.Account;
import com.friend.finder.repositories.AccountRepository;
import com.friend.finder.services.FullService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AccountServiceImpl implements FullService<Account> {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }


    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
