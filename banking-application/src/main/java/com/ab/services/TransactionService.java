package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.Transaction;
import com.ab.repositories.SavingsAccountRepository;
import com.ab.repositories.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public Transaction saveTransaction(String accountNumber, double amount, double balance) {
		Transaction savedTransactions = new Transaction(accountNumber, amount, balance);
		return this.transactionRepository.save(savedTransactions);
	}
	
	public List <Transaction> displayTransactionList(String accountNumber){
		return this.transactionRepository.findTransactionsByAccountNumber(accountNumber);
	}

	public List<Transaction> loadAllTransaction(){
		return this.transactionRepository.findAll();
	}
	




}
