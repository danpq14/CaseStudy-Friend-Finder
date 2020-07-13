package com.friend.finder.services.impl;

import com.friend.finder.models.Timeline;
import com.friend.finder.repositories.TimelineRepository;
import com.friend.finder.services.FullService;
import com.friend.finder.services.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TimelineServiceImpl implements TimelineService {
    @Autowired
    private TimelineRepository timelineRepository;
    @Override
    public Iterable<Timeline> findAll() {
        return timelineRepository.findAll();
    }

    @Override
    public Optional<Timeline> findById(Long id) {
        return timelineRepository.findById(id);
    }

    @Override
    public Timeline save(Timeline timeline) {
        return timelineRepository.save(timeline);
    }

    @Override
    public void delete(Long id) {
        timelineRepository.deleteById(id);
    }
}
