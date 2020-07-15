package com.friend.finder.services;

import com.friend.finder.models.Newsfeed;
import com.friend.finder.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.parameters.P;

import java.util.Optional;

public interface PostService extends PagingAndSortingRepository<Post, Long> {
        Iterable<Post> findAll();
        Optional<Post> findById(Long id);
        Post save(Post t);
        void delete(Long id);
    Page<Post> getPostsByNewsfeedSetOrderByPostTimeDesc(Newsfeed newsfeed, Pageable pageable);
}
