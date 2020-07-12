package com.friend.finder.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Role implements GrantedAuthority {
    @Id
    private Long id;
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<Account> accounts;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
