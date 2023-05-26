package com.ab.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;



@MappedSuperclass
public class BankAccount {
	
	@Id @GeneratedValue
	private int accountId;

	private String accountNumber;

	private String accountName;
	
	private LocalDateTime dateCreated;
	
	
	private int accountHolderId;

	private Double balance = 0.00;


	public BankAccount(String accountName, int accountHolderId) {
		this.accountName = accountName;
		this.accountHolderId = accountHolderId;
		this.dateCreated = LocalDateTime.now();

	
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public int getAccountHolderId() {
		return accountHolderId;
	}
	public void setAccountHolderId(int accountHolderId) {
		this.accountHolderId = accountHolderId;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	

	public void depositMoney(double deposedMoney) {
		double newbalance = this.balance + deposedMoney;
	
			}
	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountName="
				+ accountName + ", dateCreated=" + dateCreated + ", accountHolderId=" + accountHolderId + ", balance="
				+ balance + "]";
	}
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	


}