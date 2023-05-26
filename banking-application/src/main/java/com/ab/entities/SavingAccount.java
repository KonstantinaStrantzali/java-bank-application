package com.ab.entities;


import java.util.Random;

import jakarta.persistence.Entity;

@Entity
public class SavingAccount extends BankAccount{

		
	
		private String accountPrefix = "SAV";
		private String accountNumber;
		
		public SavingAccount () {
			super();
		}

		public SavingAccount(String accountName, int accountHolderId) {
			
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

		@Override
		public String toString() {
			return "SavingAccount [accountPrefix=" + accountPrefix + ", accountNumber=" + accountNumber
					+ ", getAccountId()=" + getAccountId() + ", getAccountNumber()=" + getAccountNumber()
					+ ", getAccountName()=" + getAccountName() + ", getDateCreated()=" + getDateCreated()
					+ ", getAccountHolderId()=" + getAccountHolderId() + ", getBalance()=" + getBalance()
					+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ "]";
		}

	
		
		

	}
	
	

