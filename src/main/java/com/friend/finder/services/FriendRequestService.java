package com.friend.finder.services;

import com.friend.finder.models.FriendRequest;

public interface FriendRequestService extends FullService<FriendRequest> {
    FriendRequest getAllByReceiveAccountAndStatusIsLike(Long receiveId, String status);
}
