package com.ab.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ab.entities.Transaction;
import com.ab.services.TransactionService;

@RestController
@RequestMapping
public class TransactionControllerRestful {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transactions")
	public List<Transaction> allTransactionDetails(){
		
		return  transactionService.loadAllTransaction();
		
	}

	@GetMapping("/transactions{accountNumber}")
	public List<Transaction> findTransactionByAccountNumber(@PathVariable("accountNumber") String accountNumber){
		
		return transactionService.displayTransactionList(accountNumber);
	}
	    
	}
	

