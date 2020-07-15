package com.friend.finder.services.impl;

import com.friend.finder.models.Account;
import com.friend.finder.models.FriendRequest;
import com.friend.finder.models.FriendRequestToString;
import com.friend.finder.repositories.FriendRequestRepository;
import com.friend.finder.services.AccountService;
import com.friend.finder.services.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class FriendRequestImpl implements FriendRequestService {

    @Autowired
    private FriendRequestRepository friendRequestRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public List<FriendRequest> getAllByReceiveAccountAndStatusIsLike(Long receiveId, String status) {
        return (List) friendRequestRepository.getAllByReceiveAccountAndStatusContaining(receiveId, status);
    }

    @Override
    public Iterable<FriendRequest> findAll() {
        return null;
    }

    @Override
    public Optional<FriendRequest> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public FriendRequest save(FriendRequest friendRequest) {
        return friendRequestRepository.save(friendRequest);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean isFriendRequestExist(Long receiveId, Long sendId) {
        FriendRequest friendRequest = friendRequestRepository.findByReceiveAccountAndSendAccount(receiveId, sendId);
        if (friendRequest != null) {
            return true;
        }
        return false;
    }

    @Override
    public FriendRequestToString addFriendRequestToString(FriendRequest friendRequest) {
        FriendRequestToString friendRequestToString = new FriendRequestToString();
        Account account = accountService.findById(friendRequest.getSendAccount());
        friendRequestToString.setFriendRequest(friendRequest);
        friendRequestToString.setSendAccountUsername(account.getUsername());
        friendRequestToString.setString(account);
        return friendRequestToString;
    }
}
