package com.friend.finder.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
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

    @Column(nullable = false, columnDefinition = "varchar(255) default '' ")
    private String firstName;

    @Column(nullable = false, columnDefinition = "varchar(255) default '' ")
    private String lastName;

    @Column(nullable = false, columnDefinition = "varchar(255) default '' ")
    private String phone;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(nullable = true)
    private Date birthDay;

    @Column(columnDefinition = "varchar(1000) default 'https://miro.medium.com/max/720/1*W35QUSvGpcLuxPo3SRTH4w.png' ")
    private String avatar;

    @OneToOne
    private Newsfeed newsfeed;

    private String gender;

    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="account_friend",
            joinColumns={@JoinColumn(name="account_id")},
            inverseJoinColumns={@JoinColumn(name="friend_id")})
    private Set<Account> friends = new HashSet<Account>();

//    @ManyToMany(mappedBy="friends")
//    private Set<Account> teammates = new HashSet<Account>();

}
