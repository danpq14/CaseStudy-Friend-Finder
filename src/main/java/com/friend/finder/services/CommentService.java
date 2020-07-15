package com.friend.finder.services;

import com.friend.finder.models.Comment;
import com.friend.finder.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService extends FullService<Comment> {
    Iterable<Comment> getCommentByNewsfeedSetOrderByPostTimeDesc();

}
