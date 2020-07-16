package com.friend.finder.modelFake;

import com.friend.finder.models.Comment;

import java.util.List;

public class CommentResponse {
    private Long postId;
    private List<CommentFake> comments;

    public CommentResponse() {}

    public CommentResponse(Long postId, List<CommentFake> comments) {
        this.postId = postId;
        this.comments = comments;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public List<CommentFake> getComments() {
        return comments;
    }

    public void setComments(List<CommentFake> comments) {
        this.comments = comments;
    }
}
