package com.friend.finder.repositories;

import com.friend.finder.models.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
//     Integer countAccountsByUsernameIsNotNull();
     Account findAccountByUsername(String username);

     @Query("select ac from Account ac where ac.username LIKE CONCAT('%',LOWER(?1) ,'%') and ac.id <> ?2")
     List<Account> findAllByUsernameLike(String keyword, Long id);

}
