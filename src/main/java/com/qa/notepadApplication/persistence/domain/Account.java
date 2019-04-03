package com.qa.notepadApplication.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@Id
	@Column(name="username", unique=true)
	private String userName;
	private String pwd;
	
	public Account() {
		//empty constructor
	}

	public Account(String userName, String pwd) {
		this.userName = userName;
		this.pwd = pwd;
		}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	





}