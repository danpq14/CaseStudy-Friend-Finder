package com.friend.finder.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "friendRequest")
@Getter
@Setter
public class FriendRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sendAccount;
    private Long receiveAccount;

    private String status;

    private Timestamp timestamp;

    public FriendRequest() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
}
