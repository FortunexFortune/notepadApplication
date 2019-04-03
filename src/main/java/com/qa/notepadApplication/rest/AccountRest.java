package com.qa.notepadApplication.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	

}
