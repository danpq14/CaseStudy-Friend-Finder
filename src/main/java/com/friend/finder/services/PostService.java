package com.friend.finder.services;

import com.friend.finder.models.Post;

import java.util.Optional;

public interface PostService extends FullService<Post> {
    @Override
    Iterable<Post> findAll();

    @Override
    Optional<Post> findById(Long id);

    @Override
    void save(Post post);

    @Override
    void delete(Long id);
}
