package com.friend.finder.models;

import lombok.*;

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
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Newsfeed> newsfeedSet;

    @OneToMany(mappedBy = "post")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "post")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Comment> comments;

    @OneToOne(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "images_id")
    private Image images;

}
