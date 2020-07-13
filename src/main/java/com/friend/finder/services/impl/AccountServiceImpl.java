package com.friend.finder.services.impl;

import com.friend.finder.models.*;
import com.friend.finder.repositories.*;
import com.friend.finder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private NewsfeedRepository newsfeedRepository;

    @Autowired
    private TimelineRepository timelineRepository;


    @Override
    public Account findAccountByUserName(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public Account signUp(Account account) throws Exception {

        account.setNewsfeed(newsfeedRepository.save(new Newsfeed()));
        account.setProfile(profileRepository.save(new Profile()));
        account.setTimeline(timelineRepository.save(new Timeline()));
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return   accountRepository.save(account);
    }

    @Override
    public Account login(Account account) {
        UserDetails user = this.loadUserByUsername(account.getUsername());
        account.setPassword(user.getPassword());
        account.setUsername(user.getUsername());
        return account;
    }

    @Override
    public List<Account> search(String keyword, Principal principal) {
        Account account = findAccountByUserName(principal.getName());
        List<Account> accounts = accountRepository.findAllByUsernameLike(keyword, account.getId());
//        if (!accounts.isEmpty()) {
//            account.setFriends(accounts);
//            accountRepository.save(account);
//        }
//
        return accounts;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Boolean checkFriend(Account account, Account account2) {
        List<Account> accounts = account.getFriends();
        for(Account account1 : accounts){
            if(account1.getUsername().equalsIgnoreCase(account2.getUsername())){
                return true;
            }
        }return false;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(account.getUsername(), account.getPassword(), list);
    }

}
