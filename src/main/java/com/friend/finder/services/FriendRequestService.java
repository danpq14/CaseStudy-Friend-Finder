package com.friend.finder.services;

import com.friend.finder.models.FriendRequest;
import com.friend.finder.models.FriendRequestToString;

import java.util.List;

public interface FriendRequestService extends FullService<FriendRequest> {
    List<FriendRequest> getAllByReceiveAccountAndStatusIsLike(Long receiveId, String status);
    boolean isFriendRequestExist(Long receiveId, Long sendId);
    FriendRequestToString addFriendRequestToString(FriendRequest friendRequest);
    FriendRequest findByReceiveAccountAndSendAccount(Long receiveId, Long sendId);
}
