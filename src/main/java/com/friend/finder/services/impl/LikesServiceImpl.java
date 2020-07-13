package com.friend.finder.services.impl;

import com.friend.finder.models.Likes;
import com.friend.finder.repositories.LikesRepository;
import com.friend.finder.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikesServiceImpl implements LikesService {
    @Autowired
    private LikesRepository likesRepository;

    @Override
    public Iterable<Likes> findAll() {
        return likesRepository.findAll();
    }

    @Override
    public Optional<Likes> findById(Long id) {
        return likesRepository.findById(id);
    }

    @Override
    public Likes save(Likes likes) {
        return likesRepository.save(likes);
    }

    @Override
    public void delete(Long id) {
        likesRepository.deleteById(id);
    }
}
