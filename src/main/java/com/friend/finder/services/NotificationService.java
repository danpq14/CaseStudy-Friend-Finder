package com.friend.finder.services;

import com.friend.finder.models.Notification;

import java.util.Optional;

public interface NotificationService extends FullService<Notification> {
    @Override
    Iterable<Notification> findAll();

    @Override
    Optional<Notification> findById(Long id);

    @Override
    void save(Notification notification);

    @Override
    void delete(Long id);
}
