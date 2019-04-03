package com.qa.notepadApplication.service;

import java.util.List;
import java.util.Optional;

import com.qa.notepadApplication.persistence.domain.Account;

public interface  AccountService {
	
    Account addAccount(Account account);
    List<Account> getAllAccounts();
    Optional<Account> getAccount(String userName);
    Optional<Account> deleteAccount(String userName);
    Optional<Account> updateAccount(String userName);
}
