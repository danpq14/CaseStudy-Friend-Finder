package com.friend.finder.services.impl;

import com.friend.finder.models.Dislikes;
import com.friend.finder.repositories.DislikesRepository;
import com.friend.finder.services.DislikesService;
import com.friend.finder.services.FullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DislikeServiceImpl implements DislikesService {
    @Autowired
    private DislikesRepository dislikesRepository;
    @Override
    public Iterable<Dislikes> findAll() {
        return dislikesRepository.findAll();
    }

    @Override
    public Optional<Dislikes> findById(Long id) {
        return dislikesRepository.findById(id);
    }

    @Override
    public Dislikes save(Dislikes dislikes) {
        return dislikesRepository.save(dislikes);
    }

    @Override
    public void delete(Long id) {
        dislikesRepository.deleteById(id);
    }
}
