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

    @Column (columnDefinition = "TEXT default '' ")
    private String content;

    private Timestamp postTime;
}
