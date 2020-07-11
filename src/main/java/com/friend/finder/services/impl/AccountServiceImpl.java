package com.friend.finder.services.impl;

import com.friend.finder.models.Account;
import com.friend.finder.repositories.AccountRepository;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.FullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
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
    public Account save(Account account) {
        return accountRepository.save(account);
    }


    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

//    @Override
//    public int countAccountByUserName() {
//        return accountRepository.countAccountByUsername();
//    }

    @Override
    public Account findAccountByUserName(String username) {
        return accountRepository.findAccountByUsername(username);
    }
}
