package com.friend.finder.repositories;

import com.friend.finder.models.Likes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends PagingAndSortingRepository<Likes,Long> {
}
