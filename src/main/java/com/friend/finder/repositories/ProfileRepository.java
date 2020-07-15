package com.friend.finder.repositories;

import com.friend.finder.models.Account;
import com.friend.finder.models.Profile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfileRepository extends PagingAndSortingRepository<Profile,Long> {
    Profile getProfileByAccount(Account account);

    List<Profile> findAllByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

    List<Profile> findAllByFirstNameLike(String title);
}
