package com.qa.notepadApplication.util;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(String exception){
        super("userName supplied does not exist. userName: " + exception);
    }
}
