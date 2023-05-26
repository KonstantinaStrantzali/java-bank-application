package com.ab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ab.entities.SavingAccount;


@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingAccount, Integer> {

	@Query(value = "SELECT * FROM saving_account s where s. account_holder_id = :accountHolderId", nativeQuery=true) 
	public List <SavingAccount> showSavingAccountList(@Param("accountHolderId") int accountHolderId);
}
