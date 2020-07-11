package com.friend.finder.services;

import java.util.Optional;

public interface FullService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save(T t);
    void delete(Long id);
}
