package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ab.entities.AccountHolder;
import com.ab.entities.CurrentAccount;
import com.ab.services.CurrentAccountService;
import com.ab.services.TransactionService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CurrentAccountController {
		
		@Autowired
		private CurrentAccountService currentAccountService;
		
		@Autowired
		private TransactionService transactionService;
		
		@PostMapping("/createCurrentAccount")
		public String createAccount(String accountName, HttpServletRequest request){
		
		HttpSession session = request.getSession(true);
		
		AccountHolder loggedInCustomer = (AccountHolder) session.getAttribute("loggedInCustomer");

		CurrentAccount currentHolder = new CurrentAccount(accountName, loggedInCustomer.getAccountHolderId());
		
		CurrentAccount currentAccount = this.currentAccountService.createCurrentAccount(currentHolder);
		
		session.setAttribute("currentAccount", currentAccount);
		
		return "new_currentAccount";
		}
		
		@GetMapping("/createCurrentAccount")
		public String loginForm() {
			return "new_currentAccount";
		}
		
		
		@GetMapping("/currentAccount")
		public String currentAccount() {
			return "currentAccount";
		}
		
		@GetMapping("/current_accounts")
		public String currentAccounts() {
			return "current_accounts";
		}
				
			
	  @GetMapping("/accounts")
	  public String showAccountsList(HttpServletRequest request){
	  HttpSession session = request.getSession(true);
	  AccountHolder loggedInCustomer = (AccountHolder) session.getAttribute("loggedInCustomer");
	  List <CurrentAccount> listCurrentAccount = currentAccountService.listCurrentAccounts(loggedInCustomer.getAccountHolderId());
	  session.setAttribute("currentAccounts", listCurrentAccount);
				
	  return "current_accounts";
				}
	  
	  @PostMapping("/updateAccounts")
	  public String viewAccount(HttpServletRequest request, String accountNumber){

			
			HttpSession session = request.getSession(true);
			session.setAttribute("accountNumber", accountNumber);

				CurrentAccount currentAccountToView = currentAccountService.findCurrentAccountByNumber(accountNumber);
				session.setAttribute("currentAccountToView", currentAccountToView );
			
			return "currentAccount";
			
	  }
		
		@PostMapping("/depositCurrent")
		
		public String updateBalance(HttpServletRequest request) {
			HttpSession session = request.getSession(true);
		
			String accountNumber = (String) session.getAttribute("accountNumber");
			String depositMoney = request.getParameter("depositMoney");
			Double moneyDep =  Double.parseDouble(depositMoney);
			CurrentAccount currentAccountToView = (CurrentAccount) session.getAttribute("currentAccountToView");
			
			int updateCurrentAccountBalance = currentAccountService.depositMoneyCurrentAccount(moneyDep, currentAccountToView.getAccountName());
			session.setAttribute("loggedInCurrentCustomer", currentAccountToView );
			transactionService.saveTransaction(accountNumber, moneyDep, currentAccountToView.getBalance());
			
			session.setAttribute("loggedInCurrentCustomer", currentAccountToView );
			return "currentAccount";
		}
		
		
		@PostMapping("/withdrawCurrent")
		
		public String withdrawCurrent(HttpServletRequest request) {
			HttpSession session = request.getSession(true);
		
			String accountNumber = (String) session.getAttribute("accountNumber");
			String depositMoney = request.getParameter("withdrawMoney");
			Double moneyDep =  Double.parseDouble(depositMoney);
			CurrentAccount currentAccountToView = (CurrentAccount) session.getAttribute("currentAccountToView");
			int updateAccountBalance = currentAccountService.withdrawMoneyCurrentAccount(moneyDep, currentAccountToView.getAccountName());
			
			transactionService.saveTransaction(currentAccountToView.getAccountNumber(), moneyDep, currentAccountToView.getBalance());
			
			return "currentAccount";
		}
		
		
		
		
}
		

		
		

