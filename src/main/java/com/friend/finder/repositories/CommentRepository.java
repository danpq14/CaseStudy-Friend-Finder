package com.friend.finder.repositories;

import com.friend.finder.models.Comment;
import com.friend.finder.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {
    @Query(value = "select * from   comment cm\n" +
            "    join post_comment pc on cm.id = pc.comment_id\n" +
            "    join post p on pc.post_id = p.id\n" +
            "where post_id = 4\n" +
            "order by cm.post_time;",nativeQuery = true)
    Iterable<Comment> getCommentByNewsfeedSetOrderByPostTimeDesc();
}
