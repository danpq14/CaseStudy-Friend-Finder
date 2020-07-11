package com.friend.finder.repositories;

import com.friend.finder.models.Image;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends PagingAndSortingRepository<Image,Long> {
}
