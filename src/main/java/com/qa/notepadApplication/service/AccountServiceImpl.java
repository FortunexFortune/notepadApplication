package com.qa.notepadApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.qa.notepadApplication.persistence.domain.Account;
import com.qa.notepadApplication.persistence.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository repo;

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		return repo.save(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Account> getAccount(String userName) {
		// TODO Auto-generated method stub
		return repo.findById(userName);
	}
	
	

	@Override
	public Optional<Account> deleteAccount(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Account> updateAccount(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
