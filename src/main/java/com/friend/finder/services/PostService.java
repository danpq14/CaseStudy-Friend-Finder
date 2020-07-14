package com.friend.finder.services;

import com.friend.finder.models.Newsfeed;
import com.friend.finder.models.Post;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PostService extends FullService<Post> {
    Page<Post> getPostsByNewsfeedSetOrderByPostTimeDesc(Newsfeed newsfeed);
}
