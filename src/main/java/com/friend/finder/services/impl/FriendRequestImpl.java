package com.friend.finder.services.impl;

import com.friend.finder.models.FriendRequest;
import com.friend.finder.repositories.FriendRequestRepository;
import com.friend.finder.services.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FriendRequestImpl implements FriendRequestService {

    @Autowired
    private FriendRequestRepository friendRequestRepository;

    @Override
    public FriendRequest getAllByReceiveAccountAndStatusIsLike(Long receiveId, String status) {
        return friendRequestRepository.getAllByReceiveAccountAndStatusIsLike(receiveId, status);
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
}
