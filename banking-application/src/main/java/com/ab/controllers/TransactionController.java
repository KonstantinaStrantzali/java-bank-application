package com.ab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ab.entities.Transaction;
import com.ab.services.TransactionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/view_transactions")
	public String listTransactions(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String accountNumber = (String) session.getAttribute("accountNumber");
		List <Transaction> showTransactionList = transactionService.displayTransactionList(accountNumber);
		System.out.print(showTransactionList);
		  session.setAttribute("showTransactionList", showTransactionList);
			
		return "view_transactions";
	}
	
	

}
