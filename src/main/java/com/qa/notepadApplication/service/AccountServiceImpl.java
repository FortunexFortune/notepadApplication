package com.qa.notepadApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.notepadApplication.persistence.domain.Account;
import com.qa.notepadApplication.persistence.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository repo;

	@Override
	public Account addAccount(Account account) {
		if(repo.findById(account.getUserName()) != null) {
			return null;
		}
		return repo.save(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	

	@Override
	public String deleteAccount(String userName) {
		if (repo.findById(userName) != null ) {
			repo.deleteById(userName);
			return "{\"message\": \"account has been sucessfully deleted\"}";
		};
		return "{\"message\": \"account was not deleted!!\"}";
	}

	@Override
	public String updateAccount(Account accountToUpdate) {
		Optional<Account> accountInDB = repo.findById(accountToUpdate.getUserName());
		if (accountInDB != null) {
			accountInDB.get().setPwd(accountToUpdate.getPwd());
			repo.save(accountInDB.get());
			return "{\"message\": \"account has been sucessfully updated\"}";
		}
		return "{\"message\": \"account was not updated!!\"}";
		}

	@Override
	public Optional<Account> findAccountByID(String userName) {
		return repo.findById(userName);
	}

}
