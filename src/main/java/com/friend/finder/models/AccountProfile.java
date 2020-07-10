package com.friend.finder.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class AccountProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255) default 'No Information' ")
    private String address;

    @Column(columnDefinition = "varchar(255) default 'No Information' ")
    private String interest;

    @Column(columnDefinition = "varchar(255) default 'No Information' ")
    private String language;

    @Column(columnDefinition = "varchar(255) default 'No Information' ")
    private String relation;

    @Column(columnDefinition = "TEXT default 'No Information' ")
    private String information;

    @Column(nullable = false, columnDefinition = "varchar(255) default '' ")
    private String firstName;

    @Column(nullable = false, columnDefinition = "varchar(255) default '' ")
    private String lastName;

    @Column(nullable = false, columnDefinition = "varchar(255) default '' ")
    private String phone;

    @Column(nullable = true)
    private Date birthDay;

    @Column(columnDefinition = "varchar(1000) default 'https://miro.medium.com/max/720/1*W35QUSvGpcLuxPo3SRTH4w.png' ")
    private String avatar;

    private String gender;

    @OneToOne
    private Account account;
}
