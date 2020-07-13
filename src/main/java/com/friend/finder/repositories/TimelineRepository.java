package com.friend.finder.repositories;

import com.friend.finder.models.Timeline;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimelineRepository  extends PagingAndSortingRepository<Timeline,Long> {
}
