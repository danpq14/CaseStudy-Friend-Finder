package com.friend.finder.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account account;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "post")
    private Set<Likes> likes;

    @OneToMany
    private Set<Dislikes> dislikes;

    private Timestamp postTime;

    @ManyToMany(mappedBy = "postSet")
    private Set<Newsfeed> newsfeedSet;

    @OneToMany(mappedBy = "post")
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

}
