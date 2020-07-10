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
    private Account account;

    @ManyToOne
    private Post post;

    @Column(columnDefinition = "default = 'false'")
    private String status;
}
