package com.friend.finder.repositories;

import com.friend.finder.models.Comment;
import com.friend.finder.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {

    List<Comment> findCommentsByPostOrderByPostTimeDesc(Post post);
}
