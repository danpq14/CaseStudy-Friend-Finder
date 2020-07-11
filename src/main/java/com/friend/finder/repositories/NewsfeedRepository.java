package com.friend.finder.repositories;

import com.friend.finder.models.Newsfeed;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsfeedRepository extends PagingAndSortingRepository<Newsfeed,Long> {
}
