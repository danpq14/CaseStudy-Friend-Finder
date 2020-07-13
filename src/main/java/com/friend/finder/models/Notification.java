package com.friend.finder.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Bình luận/Like/DisLike/
    @Column
    private String type;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    //SubString thành mảng, size mảng >3 thì chuyển thành A,B,C + n Người khác đã bình luận/like
    private String names;
}
