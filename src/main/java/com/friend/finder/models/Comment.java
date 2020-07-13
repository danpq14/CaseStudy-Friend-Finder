package com.friend.finder.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account account;

    @Column (columnDefinition = "TEXT")
    private String content;

    private Timestamp postTime;

    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinTable(name = "post_comment",
                joinColumns = @JoinColumn(name = "comment_id"),
                inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Post post;

}
