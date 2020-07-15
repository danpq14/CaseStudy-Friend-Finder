package com.friend.finder.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Account account;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "post")
    private Set<Likes> likes;

    @OneToMany
    private Set<Dislikes> dislikes;

    private Timestamp postTime =new Timestamp(System.currentTimeMillis());

    @ManyToMany(mappedBy = "postSet")
    private Set<Newsfeed> newsfeedSet;

    @OneToMany(mappedBy = "post")
    private Set<Notification> notifications;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;


}
