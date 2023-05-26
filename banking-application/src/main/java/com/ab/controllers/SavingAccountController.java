package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ab.entities.AccountHolder;
import com.ab.entities.CurrentAccount;
import com.ab.entities.SavingAccount;
import com.ab.services.CurrentAccountService;
import com.ab.services.SavingAccountService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@Controller
public class SavingAccountController {
	
	@Autowired
	private SavingAccountService savingAccountService;
	
	
	@PostMapping("/createSavingsAccount")
	public String createSavingAccount(String accountName, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		
		AccountHolder loggedInUser = (AccountHolder) session.getAttribute("loggedInCustomer");
		SavingAccount account = new SavingAccount(accountName, loggedInUser.getAccountHolderId());
		SavingAccount savingAccount = this.savingAccountService.createSavingsAccount(account);
		
		session.setAttribute("savingAccount", savingAccount);
		
		return "savingAccount";
		}
		
	
	@GetMapping("/saving_accounts")
	public String showSavingAccountList(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		AccountHolder loggedInCustomer = (AccountHolder) session.getAttribute("loggedInCustomer");
		List <SavingAccount> savingAccountList = savingAccountService.displaySavingList(loggedInCustomer.getAccountHolderId());
		session.setAttribute("savingAccountList", savingAccountList);
		System.out.print(savingAccountList);
		
		return "saving_accounts";
		
	}
		
		

}
