package com.friend.finder.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Role {
    @Id
    private Long id;
    private String name;

    public Role() {
    }
}
