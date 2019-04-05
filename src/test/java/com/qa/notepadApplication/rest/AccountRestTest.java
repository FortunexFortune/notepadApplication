package com.qa.notepadApplication.rest;

import static org.junit.Assert.assertEquals;

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
import com.qa.notepadApplication.service.AccountService;

class AccountRestTest {
	
	private static final  Account ACCOUNT1 = new Account("fortune", "1234");
	private static final  Account ACCOUNT2 = new Account("Mike", "1234");
	private static final  Account ACCOUNT3 = new Account("fortune", "new");
	private static final Optional<Account> ACCOUNT_OPTIONAL = Optional.of(ACCOUNT1);
	private static final String ACCOUNT_DELETED ="{\"message\": \"account has been sucessfully deleted\"}";
	private static final String ACCOUNT_NOT_DELETED ="{\"message\": \"account was not deleted!!\"}";
	private static final String ACCOUNT_UPDATED = "{\"message\": \"account has been sucessfully updated\"}";
	private static final String ACCOUNT_NOT_UPDATED = "{\"message\": \"account was not updated!!\"}";

	
	@InjectMocks
	AccountRest accountRest;
	
	@Mock
	AccountService service;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAccounts() {
		List<Account> ACCOUNTS_MOCK = new ArrayList<>();;
		ACCOUNTS_MOCK.add(ACCOUNT1);
		ACCOUNTS_MOCK.add(ACCOUNT2);
		Mockito.when(service.getAllAccounts()).thenReturn(ACCOUNTS_MOCK);
		assertEquals(ACCOUNTS_MOCK, accountRest.getAccounts());
		Mockito.verify(service).getAllAccounts();
	}

	@Test
	void testFindAccountByID() {
		Mockito.when(service.findAccountByID(ACCOUNT1.getUserName())).thenReturn(ACCOUNT_OPTIONAL);
		assertEquals(ACCOUNT_OPTIONAL, accountRest.findAccountByID(ACCOUNT1.getUserName()));
		Mockito.verify(service).findAccountByID(ACCOUNT1.getUserName());
	}

	@Test
	void testCreateAccount() {
		Mockito.when(service.addAccount(ACCOUNT1)).thenReturn(ACCOUNT1);
		assertEquals(ACCOUNT1, accountRest.createAccount(ACCOUNT1));
		Mockito.verify(service).addAccount(ACCOUNT1); 
	}
	
	@Test
	void testCreateAccount_Existing_Username() {
		Mockito.when(service.addAccount(ACCOUNT1)).thenReturn(ACCOUNT1);
		Mockito.when(service.addAccount(ACCOUNT3)).thenReturn(null);
		assertEquals(null, accountRest.createAccount(ACCOUNT3)); 
		Mockito.verify(service).addAccount(ACCOUNT3); 
	}

	@Test
	void testDeleteAccount() {
		Mockito.when(service.deleteAccount(ACCOUNT1.getUserName())).thenReturn(ACCOUNT_DELETED);
		assertEquals(ACCOUNT_DELETED, accountRest.deleteAccount(ACCOUNT1.getUserName())); 
		Mockito.verify(service).deleteAccount(ACCOUNT3.getUserName()); 
		
		Mockito.when(service.deleteAccount("Max")).thenReturn(ACCOUNT_NOT_DELETED);
		assertEquals(ACCOUNT_NOT_DELETED, accountRest.deleteAccount("Max")); 
		Mockito.verify(service).deleteAccount("Max"); 
	}

	@Test
	void testUpdateAccount() {
		Mockito.when(service.updateAccount(ACCOUNT1)).thenReturn(ACCOUNT_UPDATED);
		assertEquals(ACCOUNT_UPDATED, accountRest.updateAccount(ACCOUNT1)); 
		Mockito.verify(service).updateAccount(ACCOUNT1); 
	}

}
