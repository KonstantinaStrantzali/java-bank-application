package com.ab.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	



	@Id @GeneratedValue
	private int transactionId;

	private String accountNumber;

	private double amount;

	private double balance;

	private LocalDateTime dateOfTransaction;

	
	
	public Transaction(String accountNumber, double amount, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.balance = balance;
		this.dateOfTransaction = LocalDateTime.now();
	}
	public Transaction () {
		super();
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", transactionType="
				 + ", amount=" + amount + ", balance=" + balance + ", dateOfTransaction="
				+ dateOfTransaction + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
