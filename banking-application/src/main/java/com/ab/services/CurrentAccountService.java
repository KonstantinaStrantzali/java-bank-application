package com.ab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.entities.CurrentAccount;
import com.ab.repositories.CurrentAccountRepository;


@Service
public class CurrentAccountService {
	
	@Autowired
	private CurrentAccountRepository currentAccountRepository;

	public CurrentAccount createCurrentAccount(CurrentAccount  currentAccount) {
		return this.currentAccountRepository.save(currentAccount);
	}

	public List <CurrentAccount> listCurrentAccounts(int accoundHolderId){
		return this.currentAccountRepository.findAccountsByAccountHolder(accoundHolderId);
	}
	
	public CurrentAccount findCurrentAccountByNumber(String accountNumber){
		return this.currentAccountRepository.findAccountByNumber(accountNumber);
	}
	public int depositMoneyCurrentAccount(double depositMoney, String accountName) {
		return this.currentAccountRepository.depositMoney(depositMoney, accountName);
	}
	public int withdrawMoneyCurrentAccount(double depositMoney, String accountName) {
		return this.currentAccountRepository.withdrawMoney(depositMoney, accountName);
	}
}
