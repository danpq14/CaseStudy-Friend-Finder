package com.friend.finder.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Newsfeed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "newsfeed")
    private Account account;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "newsfeed_post",
                joinColumns = @JoinColumn(name = "newsfeed_id"),
                inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<Post> postSet;

}
