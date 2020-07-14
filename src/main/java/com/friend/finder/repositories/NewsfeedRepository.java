package com.friend.finder.repositories;

import com.friend.finder.models.Newsfeed;
import com.friend.finder.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsfeedRepository extends PagingAndSortingRepository<Newsfeed,Long> {
    Newsfeed getNewsfeedByAccount(String username);
}
