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
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private NewsfeedRepository newsfeedRepository;

    @Autowired
    private TimelineRepository timelineRepository;
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
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        account.setNewsfeed(newsfeedRepository.save(new Newsfeed()));
        account.setProfile(profileRepository.save(new Profile()));
        account.setTimeline(timelineRepository.save(new Timeline()));
        return   accountRepository.save(account);
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
//        Account account = findAccountByUserName(principal.getName());
//
//        List<Account> accounts = accountRepository.findAllByUsernameLike(keyword, account.getId());
//        if (!accounts.isEmpty()) {
//            account.setFriends(accounts);
//            accountRepository.save(account);
//        }
//
//        return accounts;
        return null;
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
