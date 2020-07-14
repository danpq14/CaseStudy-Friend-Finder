package com.friend.finder.services;

import com.friend.finder.models.Account;
import com.friend.finder.models.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
public interface ProfileService extends FullService<Profile> {
    Profile getProfileByAccount(Account account);
}
