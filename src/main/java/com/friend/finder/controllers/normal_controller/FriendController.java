package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Account;
import com.friend.finder.models.FriendRequest;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FriendController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private FriendRequestService friendRequestService;

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

}
