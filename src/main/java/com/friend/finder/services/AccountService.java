package com.friend.finder.services;

import com.friend.finder.models.Account;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.security.Principal;
import java.util.List;

public interface AccountService extends UserDetailsService {

//    int countAccountByUserName();

    Account findAccountByUserName(String username);

    Account signUp(Account account) throws Exception;

    Account login(Account account);

    List<Account> search(String keyword, Principal principal);
    Account save(Account account);
}
