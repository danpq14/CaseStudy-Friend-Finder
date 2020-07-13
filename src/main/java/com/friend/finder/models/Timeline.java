package com.friend.finder.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Timeline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "timeline")
    private Account account;

//    @OneToMany
//    private Set<Post> postSet;

}
