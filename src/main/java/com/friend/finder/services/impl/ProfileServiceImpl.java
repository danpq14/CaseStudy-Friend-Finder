package com.friend.finder.services.impl;

import com.friend.finder.models.Profile;
import com.friend.finder.repositories.ProfileRepository;
import com.friend.finder.services.FullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProfileServiceImpl implements FullService<Profile> {
    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public Iterable<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> findById(Long id) {
        return profileRepository.findById(id);
    }

    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public void delete(Long id) {
        profileRepository.deleteById(id);
    }
}
