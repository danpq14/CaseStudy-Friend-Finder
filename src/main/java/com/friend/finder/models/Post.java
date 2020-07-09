package com.friend.finder.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "postSet")
    private Set<Newsfeed> newsfeedSet;
}
