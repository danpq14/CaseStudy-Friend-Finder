package com.friend.finder.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Newsfeed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "newsfeed")
    private Account account;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "newsfeed_post",
                joinColumns = @JoinColumn(name = "newsfeed_id"),
                inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<Post> postSet;

}
