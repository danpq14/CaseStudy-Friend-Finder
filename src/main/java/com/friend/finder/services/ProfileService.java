package com.friend.finder.services;

import com.friend.finder.models.Account;
import com.friend.finder.models.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ProfileService extends FullService<Profile> {
    Profile getProfileByAccount(Account account);
    Profile findProfileById(Long id);
    List<Profile> findAllByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
