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
	@Column(name="username")
	private String userName;
	private String pwd;
	

	@OneToMany(fetch = FetchType.EAGER, mappedBy="userName", cascade=CascadeType.ALL)
	private List<Note> notes = new ArrayList<>();
	
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
	

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}




}