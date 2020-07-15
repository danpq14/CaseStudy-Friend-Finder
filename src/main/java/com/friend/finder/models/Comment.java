package com.friend.finder.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Account account;

    @Column (columnDefinition = "TEXT")
    private String content;

    private Timestamp postTime = new Timestamp(System.currentTimeMillis());
    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinTable(name = "post_comment",
                joinColumns = @JoinColumn(name = "comment_id"),
                inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Post post;
}
