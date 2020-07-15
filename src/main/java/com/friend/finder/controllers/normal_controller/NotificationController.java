package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Account;
import com.friend.finder.models.FriendRequest;
import com.friend.finder.models.FriendRequestToString;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.FriendRequestService;
import com.friend.finder.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NotificationController {

    @Autowired
    AccountService accountService;

    @Autowired
    FriendRequestService friendRequestService;

    @Autowired
    NotificationService notificationService;

    @GetMapping("/notification")
    public ModelAndView notificationPage(Principal principal){
        Account account = accountService.findAccountByUserName(principal.getName());
        List<FriendRequest> friendRequestList =(List) friendRequestService.getAllByReceiveAccountAndStatusIsLike(account.getId(), "unchecked");
        List<FriendRequestToString> friendRequestToStrings = new ArrayList<>();
        for (FriendRequest friendRequest : friendRequestList) {
            friendRequestToStrings.add(new FriendRequestToString(friendRequest));
        }
        ModelAndView modelAndView = new ModelAndView("notification");
        modelAndView.addObject("friendRequesList", friendRequestToStrings);
        modelAndView.addObject("account", account);
        return modelAndView;
    }
}
