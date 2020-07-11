package com.friend.finder.services.impl;

import com.friend.finder.models.Image;
import com.friend.finder.repositories.ImageRepository;
import com.friend.finder.services.FullService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ImageServiceImpl implements FullService<Image> {
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public Iterable<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public void save(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void delete(Long id) {
        imageRepository.deleteById(id);
    }
}
