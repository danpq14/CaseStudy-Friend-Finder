package com.friend.finder.services.impl;

import com.friend.finder.models.Newsfeed;
import com.friend.finder.repositories.NewsfeedRepository;
import com.friend.finder.services.FullService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class NewsfeedServiceImpl implements FullService<Newsfeed> {
    @Autowired
    private NewsfeedRepository newsfeedRepository;
    @Override
    public Iterable<Newsfeed> findAll() {
        return newsfeedRepository.findAll();
    }

    @Override
    public Optional<Newsfeed> findById(Long id) {
        return newsfeedRepository.findById(id);
    }

    @Override
    public void save(Newsfeed newsfeed) {
        newsfeedRepository.save(newsfeed);
    }

    @Override
    public void delete(Long id) {
        newsfeedRepository.deleteById(id);
    }
}
