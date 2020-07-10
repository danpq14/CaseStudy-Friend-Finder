package com.friend.finder.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    @Column(nullable = false)
    @Email
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "newsfeed_id")
    private Newsfeed newsfeed;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "account_post",
                joinColumns = @JoinColumn(name = "account_id"),
                inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<Post> posts;

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="account_friend",
            joinColumns={@JoinColumn(name="account_id")},
            inverseJoinColumns={@JoinColumn(name="friend_id")})
    private Set<Account> friends = new HashSet<Account>();

    @OneToMany(mappedBy = "account")
    private Set<Likes> likes;

    @OneToMany(mappedBy = "account")
    private Set<Dislikes> dislikes;
//    @ManyToMany(mappedBy="friends")
//    private Set<Account> teammates = new HashSet<Account>();

}
