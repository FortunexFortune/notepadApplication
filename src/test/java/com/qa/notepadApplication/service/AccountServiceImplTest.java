package com.qa.notepadApplication.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.qa.notepadApplication.persistence.domain.Account;
import com.qa.notepadApplication.persistence.repository.AccountRepository;

class AccountServiceImplTest {

	@Mock
	private AccountRepository repo;
	@InjectMocks
	private AccountServiceImpl accountService;

	private static final  Account ACCOUNT1 = new Account("fortune", "1234");
	private static final  Account ACCOUNT2 = new Account("Mike", "1234");
	private static final  Account ACCOUNT3 = new Account("fortune", "new");
	private static final Optional<Account> MOCK_ACCOUNT_OPTIONAL = Optional.of(ACCOUNT1);
	private static final String ACCOUNT_DELETED ="{\"message\": \"account has been sucessfully deleted\"}";
	private static final String ACCOUNT_NOT_DELETED ="{\"message\": \"account was not deleted!!\"}";;
	private static final String ACCOUNT_UPDATED = "{\"message\": \"account has been sucessfully updated\"}";
	private static final String ACCOUNT_NOT_UPDATED = "{\"message\": \"account was not updated!!\"}";

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddAccount() {
		Mockito.when(repo.save(ACCOUNT1)).thenReturn(ACCOUNT1);
		assertEquals(ACCOUNT1, accountService.addAccount(ACCOUNT1));
		Mockito.verify(repo).save(ACCOUNT1);
	}

	@Test
	void testAddAccount_Existing_Username() {
		repo.save(ACCOUNT1);
		Mockito.when(repo.save(ACCOUNT3)).thenReturn(null);		
		assertEquals(null, accountService.addAccount(ACCOUNT3));
		Mockito.verify(repo).save(ACCOUNT3);
	}

	@Test
	void testGetAllAccounts() {
		List <Account> accounts = new ArrayList<>();
		accounts.add(ACCOUNT1);
		accounts.add(ACCOUNT2);
		Mockito.when(repo.findAll()).thenReturn(accounts);
		assertEquals(accounts, accountService.getAllAccounts());
		Mockito.verify(repo).findAll();
	}
	
	@Test
	void testGetAllAccounts_Eempty() {
		List <Account> accounts = new ArrayList<>();
		Mockito.when(repo.findAll()).thenReturn(accounts);
		assertEquals(accounts, accountService.getAllAccounts());
		Mockito.verify(repo).findAll(); 
	}

	@Test
	void testDeleteAccount() {
		Mockito.when(repo.findById("fortune")).thenReturn(MOCK_ACCOUNT_OPTIONAL);
		Mockito.when(repo.findById("travis")).thenReturn(null);
		assertEquals(ACCOUNT_DELETED, accountService.deleteAccount("fortune"));
		assertEquals(ACCOUNT_NOT_DELETED, accountService.deleteAccount("travis"));
		Mockito.verify(repo).findById("fortune");
	}

	@Test
	void testUpdateAccount() {
		Mockito.when(repo.findById(ACCOUNT1.getUserName())).thenReturn(MOCK_ACCOUNT_OPTIONAL);
		Mockito.when(repo.findById(ACCOUNT2.getUserName())).thenReturn(null);
		assertEquals(ACCOUNT_UPDATED, accountService.updateAccount(ACCOUNT1));
		assertEquals(ACCOUNT_NOT_UPDATED, accountService.updateAccount(ACCOUNT2));
		Mockito.verify(repo).findById("fortune");
	}

	@Test
	void testFindAccountByID() {
		Optional<Account> accountOptional = Optional.of(ACCOUNT1);
		when(repo.findById(anyString())).thenReturn(accountOptional);
		Optional<Account> accountinDB = accountService.findAccountByID("fortune");
		assertNotNull(accountinDB);
		assertEquals("fortune", accountinDB.get().getUserName());
	}

	@Test
	void testFindAccountByID_userNameNotFound() {
		when(repo.findById(anyString())).thenReturn(null);
		assertEquals(accountService.findAccountByID("fortune"), null);
	}

}
