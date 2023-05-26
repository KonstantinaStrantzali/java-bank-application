package com.ab.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AccountHolder {

		@Id @GeneratedValue
		private int accountHolderId;

		private String firstname;

		private String lastname;

		private String username;

		private String password;

		private String email;

	

	public int getAccountHolderId() {
			return accountHolderId;
		}



		public void setAccountHolderId(int accountHolderId) {
			this.accountHolderId = accountHolderId;
		}



		public String getFirstname() {
			return firstname;
		}



		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}



		public String getLastname() {
			return lastname;
		}



		public void setLastname(String lastname) {
			this.lastname = lastname;
		}



		public String getUsername() {
			return username;
		}



		public void setUsername(String username) {
			this.username = username;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



	public AccountHolder() {
		// TODO Auto-generated constructor stub
	}




}
