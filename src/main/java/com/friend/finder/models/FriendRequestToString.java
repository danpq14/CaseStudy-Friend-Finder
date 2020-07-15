package com.friend.finder.models;


import com.friend.finder.services.AccountService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class FriendRequestToString {

    @Autowired
    AccountService accountService;

    private String sendAccountUsername;
    private String string;
    private FriendRequest friendRequest;

    public void setString(Account account) {
        this.string = account.getProfile().getFirstName() + " " + account.getProfile().getLastName() + " has send to you a friend request";
    }
}
