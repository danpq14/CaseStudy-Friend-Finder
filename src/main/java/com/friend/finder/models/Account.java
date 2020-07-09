package com.friend.finder.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
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
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Date birthDay;

//    @ManyToMany(cascade={CascadeType.ALL})
//    @JoinTable(name="account_friend",
//            joinColumns={@JoinColumn(name="account_id")},
//            inverseJoinColumns={@JoinColumn(name="friend_id")})
//    private Set<Account> friends = new HashSet<Account>();
//
////    @ManyToMany(mappedBy="friends")
////    private Set<Account> teammates = new HashSet<Account>();

}
