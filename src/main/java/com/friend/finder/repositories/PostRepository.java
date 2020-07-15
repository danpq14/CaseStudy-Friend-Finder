package com.friend.finder.repositories;

import com.friend.finder.models.Newsfeed;
import com.friend.finder.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post,Long> {
    @Query(value = "select  * from post order by post_time desc",nativeQuery = true)
    Page<Post> getPostsByNewsfeedSetOrderByPostTimeDesc(Pageable pageable);
}
