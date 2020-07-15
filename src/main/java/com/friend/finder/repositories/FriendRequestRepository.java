package com.friend.finder.repositories;

import com.friend.finder.models.FriendRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FriendRequestRepository extends PagingAndSortingRepository<FriendRequest, Long> {
    FriendRequest getAllByReceiveAccountAndStatusIsLike(Long receiveId, String status);
    FriendRequest findByReceiveAccountAndSendAccount(Long receiveId, Long sendId);
}
