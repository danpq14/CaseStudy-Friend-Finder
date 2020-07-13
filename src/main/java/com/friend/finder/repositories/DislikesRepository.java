package com.friend.finder.repositories;

import com.friend.finder.models.Dislikes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DislikesRepository extends PagingAndSortingRepository<Dislikes,Long> {
}
