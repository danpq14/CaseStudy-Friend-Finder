package com.friend.finder.services;

import com.friend.finder.models.Comment;
import com.friend.finder.models.Post;

import java.util.List;

public interface CommentService extends FullService<Comment> {

    List<Comment> findCommentsByPost(Post post);
}
