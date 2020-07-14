package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Account;
import com.friend.finder.repositories.AccountRepository;
import com.friend.finder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class FriendController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/app/search-friend")
    public ModelAndView addFriend(@ModelAttribute("username") String username, Principal principal){
        List<Account> resultList = accountService.search(username,principal);
        List<Account> friends = new ArrayList<>();
        List<Account> noneFriends = new ArrayList<>();

        Account currentAccount = accountService.findAccountByUserName(principal.getName());
        ModelAndView modelAndView = new ModelAndView("friends-searching");
        for(Account acc : resultList){
           if(accountService.checkFriend(currentAccount,acc)){
               friends.add(acc);
           }
           else noneFriends.add(acc);
        }
        modelAndView.addObject("account",currentAccount);
        modelAndView.addObject("friends",friends);
        modelAndView.addObject("noneFriends",noneFriends);
        return modelAndView;
    }

    @PostMapping("/app/add-friend/{id}")
    public ModelAndView addFriend(@PathVariable Long id, Principal principal) {
        Account account = accountService.findAccountByUserName(principal.getName());

    }
}
