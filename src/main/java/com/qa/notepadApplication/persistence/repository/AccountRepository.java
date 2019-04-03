package com.qa.notepadApplication.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.notepadApplication.persistence.domain.Account;

public interface AccountRepository extends  JpaRepository<Account, String> {


}