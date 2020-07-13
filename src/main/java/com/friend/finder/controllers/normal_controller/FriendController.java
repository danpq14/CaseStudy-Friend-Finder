package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Account;
import com.friend.finder.repositories.AccountRepository;
import com.friend.finder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class FriendController {
    @Autowired
    private AccountService accountService;

    @Autowired
    HttpSession session;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/search-friend")
    public void addFriend(@ModelAttribute("friend") String friend){
        Account account = (Account) session.getAttribute("user");
//        return new ModelAndView("friends", "friends", accountService.search(friend, principal)) ;
        System.out.println(account.getUsername());

    }
}
