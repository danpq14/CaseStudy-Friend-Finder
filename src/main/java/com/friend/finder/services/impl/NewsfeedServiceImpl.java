package com.friend.finder.services.impl;

import com.friend.finder.models.Newsfeed;
import com.friend.finder.repositories.NewsfeedRepository;
import com.friend.finder.services.FullService;
import com.friend.finder.services.NewsfeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class NewsfeedServiceImpl implements NewsfeedService {
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
