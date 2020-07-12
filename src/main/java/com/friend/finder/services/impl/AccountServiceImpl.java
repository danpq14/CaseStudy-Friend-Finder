package com.friend.finder.services.impl;

import com.friend.finder.models.Account;
import com.friend.finder.models.Likes;
import com.friend.finder.models.Role;
import com.friend.finder.repositories.AccountRepository;
import com.friend.finder.repositories.RoleRepository;
import com.friend.finder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

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

    @Override
    public Account signUp(Account account) throws Exception {
        Optional<Role> roleOpt = roleRepository.findById(1L);

        if (roleOpt.isPresent()) {
            Role role = roleOpt.get();
            List<Role> roles = new ArrayList<>();
            roles.add(role);
            account.setRoles(roles);
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
        account.setRoles((List<Role>) user.getAuthorities());
        return account;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        List<Role> rolesSet = account.getRoles();
        for (Role r : rolesSet) {
            roles.add(new SimpleGrantedAuthority(r.getRole()));
        }
        User user = new User(account.getUsername(), account.getPassword(), roles);
        return user;
    }
}
