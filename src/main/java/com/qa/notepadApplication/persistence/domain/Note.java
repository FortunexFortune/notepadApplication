package com.qa.notepadApplication.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Note {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long noteID;
	private String title;
	private String content;
	private String date;
	private String userName;

	public Note(){
		//empty constructor
	}
	
	public Note(String title, String content, String date) {
		this.title = title;
		this.content= content;
		this.date = date;
	}



	public Long getNoteID() {
		return noteID;
	}

	public void setNoteID(Long noteID) {
		this.noteID = noteID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}