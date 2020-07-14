package com.friend.finder.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255) default 'No Information' ")
    private String address;

    @Column(columnDefinition = "varchar(255) default 'No Information' ")
    private String interest;

    @Column(columnDefinition = "varchar(255) default 'No Information' ")
    private String job;

    @Column(columnDefinition = "varchar(255) default 'No Information' ")
    private String relation;

    @Column(columnDefinition = "TEXT")
    private String information;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'no' ")
    private String firstName;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'no' ")
    private String lastName;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'no' ")
    private String phone;

    @Column(columnDefinition = "varchar(255) default 'no' ")
    private String birthDay;

    @Column(columnDefinition = "varchar(1000) default 'https://miro.medium.com/max/720/1*W35QUSvGpcLuxPo3SRTH4w.png' ")
    private String avatar;

    @Column(columnDefinition = "varchar(1000) default 'https://www.gocbao.com/wp-content/uploads/2020/04/anh-bia-phong-canh-dep-13.jpg' ")
    private String cover;

    private String gender;

    @OneToOne(mappedBy = "profile")
    private Account account;

    public Profile() {
        this.firstName = "";
        this.lastName = "";
        this.phone = "";
        this.avatar="https://t4.ftcdn.net/jpg/03/32/59/65/240_F_332596535_lAdLhf6KzbW6PWXBWeIFTovTii1drkbT.jpg";
        this.cover="https://www.gocbao.com/wp-content/uploads/2020/04/anh-bia-phong-canh-dep-13.jpg";
        this.firstName = "New";
        this.lastName = "User";
    }
}
