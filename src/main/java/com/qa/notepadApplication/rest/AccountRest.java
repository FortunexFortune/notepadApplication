package com.qa.notepadApplication.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.notepadApplication.persistence.domain.Account;
import com.qa.notepadApplication.service.AccountService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class AccountRest {

	@Autowired
	private AccountService service;

	@GetMapping("${path.getAllAccounts}")
	public List<Account> getAccounts() {
		return service.getAllAccounts();
	}
	
	@GetMapping("${path.findAccountByID}")
	public Optional<Account> findAccountByID(@PathVariable String userName) {
		return service.findAccountByID(userName);
	}

	@PostMapping("${path.createAccount}")
	public Account createAccount(@RequestBody Account account) {
		return service.addAccount(account);
	}
	
	@DeleteMapping("${path.deleteAccount}")
	public String deleteAccount(@PathVariable String userName) {
		return service.deleteAccount(userName);
	}
	
	@PutMapping("${path.updateAccount}")
	public String updateAccount(@RequestBody Account account) {
		return service.updateAccount(account);
	}

}
