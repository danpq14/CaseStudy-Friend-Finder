package com.friend.finder.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(min = 6, max = 20)
    private String username;

    @Size(min = 6)
    private String password;

    @Column
    @Email
    private String email;
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "account_roles",
//            joinColumns = @JoinColumn(
//                    name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "role_id", referencedColumnName = "id"))
//    private Collection<Role> roles;

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

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "account_friend",
            joinColumns = {@JoinColumn(name = "account_id")},
            inverseJoinColumns = {@JoinColumn(name = "friend_id")})
    private List<Account> friends;

    @OneToMany(mappedBy = "account")
    private Set<Likes> likes;

    @OneToMany(mappedBy = "account")
    private Set<Dislikes> dislikes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "timeline_id")
    private Timeline timeline;
//    @ManyToMany(mappedBy="friends")
//    private Set<Account> teammates = new HashSet<Account>();
}
