package com.qa.notepadApplication.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.qa.notepadApplication.persistence.domain.Account;
import com.qa.notepadApplication.persistence.repository.AccountRepository;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

class AccountServiceImplTest {
	
	@Mock
	private AccountRepository repo;
	@InjectMocks
	private AccountServiceImpl accountService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

//	@Test
//	void testAddAccount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllAccounts() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteAccount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateAccount() {
//		fail("Not yet implemented");
//	}

	@Test
	void testFindAccountByID() {
		Account account = new Account();
		account.setUserName("fortune");
		account.setPwd("1234");
		Optional<Account>accountOptional = Optional.of(account);
		when(repo.findById(anyString()) ).thenReturn(accountOptional);
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
