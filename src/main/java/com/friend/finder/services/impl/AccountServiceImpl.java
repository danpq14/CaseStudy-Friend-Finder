package com.friend.finder.services.impl;

import com.friend.finder.models.Account;
import com.friend.finder.models.Role;
import com.friend.finder.repositories.AccountRepository;
import com.friend.finder.repositories.RoleRepository;
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
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

//    @Override
//    public int countAccountByUserName() {
//        return accountRepository.countAccountByUsername();
//    }

    @Override
    public Account findAccountByUserName(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public Account signUp(Account account) throws Exception {
        Optional<Role> roleOpt = roleRepository.findById(1L);
        account.setPassword(passwordEncoder.encode(account.getPassword()));

        if (roleOpt.isPresent()) {
            account.setRoles(Arrays.asList(roleOpt.get()));
        } else {
            throw new Exception("Not Found");
        }
        return accountRepository.save(account);
    }

    @Override
    public Account login(Account account) {
        UserDetails user = this.loadUserByUsername(account.getUsername());
        account.setPassword(user.getPassword());
        account.setUsername(user.getUsername());
        roleRepository.findById(1L).ifPresent(role -> account.setRoles(Arrays.asList(role)));
        return account;
    }

    @Override
    @Transactional
    public List<Account> search(String keyword, Principal principal) {
        Account account = findAccountByUserName(principal.getName());

        List<Account> accounts = accountRepository.findAllByUsernameLike(keyword, account.getId());
        if (!accounts.isEmpty()) {
            account.setFriends(accounts);
            accountRepository.save(account);
        }

        return accounts;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(account.getUsername(),
                account.getPassword(),
                mapRolesToAuthorities(account.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
