package com.friend.finder.services;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface FullService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void delete(Long id);

}