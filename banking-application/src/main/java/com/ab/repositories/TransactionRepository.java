package com.ab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ab.entities.CurrentAccount;
import com.ab.entities.SavingAccount;
import com.ab.entities.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Integer> {

	@Query(value = "SELECT * FROM transaction t where t. account_number = :accountNumber", nativeQuery=true) 
	public List <Transaction> findTransactionsByAccountNumber(@Param("accountNumber") String accountNumber);
	
}
