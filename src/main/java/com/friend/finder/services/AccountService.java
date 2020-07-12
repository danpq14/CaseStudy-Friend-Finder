package com.friend.finder.services;

import com.friend.finder.models.Account;

public interface AccountService extends FullService<Account> {

//    int countAccountByUserName();

    Account findAccountByUserName(String username);

    Account signUp(Account account) throws Exception;

    Account login(Account account);
}
