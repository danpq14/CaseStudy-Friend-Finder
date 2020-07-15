package com.friend.finder.controllers.rest_controller;

import com.friend.finder.models.Account;
import com.friend.finder.models.FriendRequest;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@RestController
public class FriendRequestController {

    @Autowired
    AccountService accountService;

    @Autowired
    FriendRequestService friendRequestService;

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
}
