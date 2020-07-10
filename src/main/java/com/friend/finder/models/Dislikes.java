package com.friend.finder.models;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Dislikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    private Post post;

    @Column
    private String status;
}
