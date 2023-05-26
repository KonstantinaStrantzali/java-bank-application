package com.ab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ab.entities.AccountHolder;
import com.ab.entities.CurrentAccount;


@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Integer>{
	
	@Query(value = "SELECT * FROM current_account s where s. account_holder_id = :accountHolderId", nativeQuery=true) 
	public List <CurrentAccount> findAccountsByAccountHolder(@Param("accountHolderId") int accountHolderId);
	
	
	@Query(value = "SELECT * FROM current_account c where c.account_number = :accountNumber", nativeQuery=true) 
	CurrentAccount findAccountByNumber(@Param("accountNumber") String accountNumber);
	
	@Query(value = "UPDATE current_account c SET c.balance = c.balance +:moneyDep WHERE c.account_name = :accountName", nativeQuery=true)
	@Modifying
	@Transactional
	int depositMoney(@Param("moneyDep") double moneyDep, @Param("accountName") String accountName );
	
	@Query(value = "UPDATE current_account c SET c.balance = c.balance -:moneyDep WHERE c.account_name = :accountName", nativeQuery=true)
	@Modifying
	@Transactional
	int withdrawMoney(@Param("moneyDep") double moneyDep, @Param("accountName") String accountName );
}
