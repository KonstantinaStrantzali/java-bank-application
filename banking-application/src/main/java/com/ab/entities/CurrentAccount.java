package com.ab.entities;
import java.util.Random;


import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Entity;



@Entity
public class CurrentAccount extends BankAccount {
	

	private String accountPrefix = "CUR";
	private String accountNumber;
	private double overdraft = 300;
	
	

	public CurrentAccount () {
		super();
	}
	
	public CurrentAccount (String accountName, int accountHolderId) {
		
		super(accountName, accountHolderId);
		
		   int length = 10;
		      Random random = new Random();
		      StringBuilder sb = new StringBuilder(length);
		      for (int i = 0; i < length; i++) {
		         char c = (char)(random.nextInt(26) + 'A');
		         sb.append(c);
		      }
		      String randomString = sb.toString();
		this.accountNumber = accountPrefix + randomString + Integer.toString(this.getAccountHolderId());

		
}
	

	public String getAccountPrefix() {
		return accountPrefix;
	}

	public void setAccountPrefix(String accountPrefix) {
		this.accountPrefix = accountPrefix;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getOverdarft() {
		return overdraft;
	}

	public void setOverdarft(double overdarft) {
		this.overdraft = overdarft;
	}
	

	@Override
	public String toString() {
		return "CurrentAccount [getAccountId()=" + getAccountId() + ", getAccountNumber()=" + getAccountNumber()
				+ ", getAccountName()=" + getAccountName() + ", getDateCreated()=" + getDateCreated()
				+ ", getAccountHolderId()=" + getAccountHolderId() + ", getBalance()=" + getBalance() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}

