package com.qa.notepadApplication.service;

import java.util.List;
import java.util.Optional;

import com.qa.notepadApplication.persistence.domain.Account;

public interface AccountService {

	Account addAccount(Account account);
	
	Optional<Account> findAccountByID(String userName);

	List<Account> getAllAccounts();

	String deleteAccount(String userName);

	String updateAccount(Account account);
}
