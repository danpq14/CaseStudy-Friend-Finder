package com.friend.finder.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
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

    private Timestamp postTime = new Timestamp(System.currentTimeMillis());

    @ManyToMany(mappedBy = "postSet")
    private Set<Newsfeed> newsfeedSet;

    @OneToMany(mappedBy = "post")
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "images_id")
    private Image images;

}
