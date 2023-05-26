package com.ab.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ab.entities.AccountHolder;
import com.ab.repositories.AccountHolderRepository;

@Service
public class AccountHolderService {

	@Autowired
	private AccountHolderRepository accountHolderRepository;
		

		public AccountHolder saveAccountHolder(AccountHolder accountHolder) {

			return this.accountHolderRepository.save(accountHolder);

		}
		
		public AccountHolder loginAccountHolder(String username, String password) {

			return this.accountHolderRepository.findByUsername(username, password);
		}

		public List<AccountHolder> loadAccountHolder(){
			return this.accountHolderRepository.findAll();
		}
		
	
}




	

	
