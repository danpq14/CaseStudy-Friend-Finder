package com.friend.finder.repositories;

import com.friend.finder.models.Account;
import com.friend.finder.models.Profile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends PagingAndSortingRepository<Profile,Long> {
    Profile getProfileByAccount(Account account);
}
