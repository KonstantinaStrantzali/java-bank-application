package com.ab.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ab.entities.AccountHolder;


@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer> {

	@Query(value = "SELECT * FROM account_holder c where c.username = :username and c.password = :password", nativeQuery=true) 
	AccountHolder findByUsername(@Param("username") String username, @Param("password") String password);


}




