package com.friend.finder.controllers.rest_controller;

import com.friend.finder.models.*;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.FriendRequestService;
import com.friend.finder.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
@RestController
public class FriendRequestController {

    @Autowired
    AccountService accountService;

    @Autowired
    FriendRequestService friendRequestService;

    @Autowired
    PostService postService;

    @PostMapping("/app/add-friend/{id}")
    public ResponseEntity<String> addFriend(@PathVariable String id, Principal principal) {
        Account account = accountService.findAccountByUserName(principal.getName());
        Long receiveAccount = Long.parseLong(id);
        Long sendAccount = account.getId();
        if (!friendRequestService.isFriendRequestExist(receiveAccount, sendAccount)) {
            FriendRequest friendRequest = new FriendRequest();
            friendRequest.setReceiveAccount(receiveAccount);
            friendRequest.setSendAccount(sendAccount);
            friendRequest.setStatus("unchecked");
            friendRequestService.save(friendRequest);
        }
        String message = "Request Was Sent";
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @GetMapping("app/accept-request/{username}")
    public ModelAndView acceptRequest(@PathVariable String username, Principal principal) {
        Account currentAccount = accountService.findAccountByUserName(principal.getName());
        Account accountRequest = accountService.findAccountByUserName(username);
        FriendRequest friendRequest = friendRequestService.findByReceiveAccountAndSendAccount(currentAccount.getId(), accountRequest.getId());
        friendRequest.setStatus("accepted");
        friendRequestService.save(friendRequest);

        List<Account> currentAccountFriends = currentAccount.getFriends();
        List<Account> accountRequestFriends = accountRequest.getFriends();
        currentAccountFriends.add(accountRequest);
        accountRequestFriends.add(currentAccount);
        currentAccount.setFriends(currentAccountFriends);
        accountRequest.setFriends(accountRequestFriends);

        List<Post> postByCurrentAccount = postService.findAllByAccount(currentAccount);
        List<Post> postByRequestAccount = postService.findAllByAccount(accountRequest);

        Newsfeed currentAccountNewsfeed = currentAccount.getNewsfeed();
        Newsfeed accountRequestNewsfeed = accountRequest.getNewsfeed();
        for (Post p : postByCurrentAccount) {
            accountRequestNewsfeed.getPostSet().add(p);
        }
        for (Post p : postByRequestAccount) {
            currentAccountNewsfeed.getPostSet().add(p);
        }

        currentAccount.setNewsfeed(currentAccountNewsfeed);
        accountRequest.setNewsfeed(accountRequestNewsfeed);

        accountService.save(currentAccount);
        accountService.save(accountRequest);

        ModelAndView modelAndView = new ModelAndView("user-profile");
        Profile profile = accountRequest.getProfile();
        modelAndView.addObject("profile", profile);
        modelAndView.addObject("account", accountRequest);
        return modelAndView;
    }

    @GetMapping("app/refuse-request/{username}")
    public ModelAndView refuseRequest(@PathVariable String username, Principal principal) {
        Account currentAccount = accountService.findAccountByUserName(principal.getName());
        Account accountRequest = accountService.findAccountByUserName(username);
        FriendRequest friendRequest = friendRequestService.findByReceiveAccountAndSendAccount(currentAccount.getId(), accountRequest.getId());
        friendRequest.setStatus("refuse");
        friendRequestService.save(friendRequest);

        ModelAndView modelAndView = new ModelAndView("user-profile");
        Profile profile = accountRequest.getProfile();
        modelAndView.addObject("profile", profile);
        modelAndView.addObject("account", accountRequest);
        return modelAndView;
    }
}
