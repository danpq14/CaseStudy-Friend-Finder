package com.friend.finder.services;

import com.friend.finder.models.Account;
import com.friend.finder.models.Newsfeed;
import com.friend.finder.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostService extends FullService<Post> {
    Page<Post> getPostsByNewsfeedSetOrderByPostTimeDesc(Newsfeed newsfeed, Pageable pageable);
    Page<Post> getPostsByAccountOrderByPostTime(Account account,Pageable pageable);

    Page<Post> getPostsByNewsfeedSetOrderByPostTimeDesc(Pageable pageable);
}
