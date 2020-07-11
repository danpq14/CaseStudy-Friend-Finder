package com.friend.finder.services.impl;

import com.friend.finder.models.Comment;
import com.friend.finder.repositories.CommentRepository;
import com.friend.finder.services.FullService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CommentServiceImpl implements FullService<Comment> {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
