package com.friend.finder.models;


import com.friend.finder.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class FriendRequestToString {

    @Autowired
    AccountService accountService;

    private String sendAccountUsername;
    private String string;
    private FriendRequest friendRequest;

    public FriendRequest getFriendRequest() {
        return friendRequest;
    }

    public void setFriendRequest(FriendRequest friendRequest) {
        this.friendRequest = friendRequest;
    }

    public String getSendAccountUsername() {
        return sendAccountUsername;
    }

    public void setSendAccountUsername(String sendAccountUsername) {
        this.sendAccountUsername = sendAccountUsername;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public FriendRequestToString(FriendRequest friendRequest) {
        this.friendRequest = friendRequest;
        Account sendAccount = accountService.findById(friendRequest.getSendAccount());
        String name = sendAccount.getProfile().getFirstName() + sendAccount.getProfile().getLastName();
        this.sendAccountUsername = sendAccount.getUsername();
        this.string = name + "has send to you a friend request";
    }


}
