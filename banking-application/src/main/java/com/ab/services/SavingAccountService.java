package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.SavingAccount;
import com.ab.repositories.SavingsAccountRepository;

@Service
public class SavingAccountService {
	
	@Autowired
	private SavingsAccountRepository savingAccountRepository;
	
	public SavingAccount createSavingsAccount(SavingAccount savingAccount) {
		return this.savingAccountRepository.save(savingAccount);
		
	}
	public List <SavingAccount> displaySavingList (int accountHolderId) {
		return this.savingAccountRepository.showSavingAccountList(accountHolderId);
	}

}
